package com.study.hello.distributed.mybatis.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.po.AbstractPo;
import com.study.hello.distributed.mybatis.generator.ext.ExtTableInfo;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiServerCodeGenerator {
    public static void main(String[] args) {
        String projectRoot = System.getProperty("user.dir");

        // 设置生成目录为当前工程的 target/generated 目录
        String generatedPath = projectRoot + "/target/generated";
        String outputDir = generatedPath + "/src/main/java";
        String mapperOutputDir = generatedPath + "/src/main/resources/mapper";

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://192.168.31.3:20041/ljz_grky_dev",
                "mysql", "12345678")
                .build();


        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .author("fangxiagnqian")
                .outputDir(outputDir)
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.study.hello.distributed.mybatis.uc.apiserver")
                .entity("infrastructure.entity")
                .mapper("infrastructure.mapper")
                .xml("mapper")
                .service("infrastructure.service")
                .serviceImpl("infrastructure.service.impl")
                .controller("adapter.web")
                .pathInfo(Collections.singletonMap(OutputFile.xml, mapperOutputDir))
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addInclude("^t_.*") // 添加您的表名
                .addTablePrefix("t_")
                .entityBuilder()
                .enableLombok()
                .superClass(AbstractPo.class)
                .addSuperEntityColumns("id", "create_time", "create_user_id", "create_user_name", "modify_time", "modify_user_id", "modify_user_name", "version", "deleted")
                .controllerBuilder()
                .enableHyphenStyle()
                .enableRestStyle()
                .mapperBuilder()
                .mapperAnnotation(org.apache.ibatis.annotations.Mapper.class)
                .formatMapperFileName("%sPoMapper")
                .formatXmlFileName("%sPoMapper")
                .serviceBuilder()
                .formatServiceFileName("I%sPoService")
                .formatServiceImplFileName("%sPoServiceImpl")
                .build(); // 调用 build() 方法创建 StrategyConfig 对象

        // 模板配置
        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .entity("/templates/apiserver/entity.java")
                .service("/templates/apiserver/app/service.java")
                .serviceImpl("/templates/apiserver/app/serviceImpl.java")
                .mapper("/templates/apiserver/infrastructure/mapper.java")
                .xml("/templates/apiserver/mapper.xml")
                .controller("/templates/apiserver/adapter/controller.java")
                .build();

        // 注入配置
        List<ExtTableInfo> extTableInfos = List.of(ExtTableInfo.build(ExtTableInfo.EXT_TYPE_NAME_PO).fileName("Po.java").packageName("infrastructure.po").templatePath("/templates/apiserver/infrastructure/po.java.ftl").superClass(AbstractPo.class));

        InjectionConfig injectionConfig = new InjectionConfig.Builder()
                .beforeOutputFile((TableInfo tableInfo, Map<String, Object> objectMap) -> {
                    extTableInfos.forEach(extTableInfo -> {
                        extTableInfo.injection(tableInfo, objectMap);
                    });
                    System.out.println("TableInfo: " + tableInfo.getName());
                    System.out.println("ObjectMap: " + objectMap);

                })
                .customFile(extTableInfos.stream().map(ExtTableInfo::getCustomFile).toList())
                .customFile(new CustomFile.Builder().packageName("client.api").fileName("Api.java").templatePath("/templates/apiserver/client/api.java.ftl").build())
                .customFile(new CustomFile.Builder().packageName("client.dto").fileName("DTO.java").templatePath("/templates/apiserver/client/dto.java.ftl").build())
                //.customFile(new CustomFile.Builder().packageName("infrastructure.repository").fileName("Repository.java").templatePath("/templates/apiserver/infrastructure/repository.java.ftl").build())
                .build();

        // 创建代码生成器实例并执行
        new AutoGenerator(dataSourceConfig)
                .global(globalConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig)
                .template(templateConfig)
                .injection(injectionConfig)
                .execute(new FreemarkerTemplateEngine());
    }
}
