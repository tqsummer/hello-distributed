package com.study.hello.distributed.mybatis.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.Map;

public class CodeGenerator {
    public static void main(String[] args) {
        String projectRoot = System.getProperty("user.dir");

        // 设置生成目录为当前工程的 target/generated 目录
        String generatedPath = projectRoot + "/target/generated";
        String outputDir = generatedPath + "/src/main/java";
        String mapperOutputDir = generatedPath + "/src/main/resources/mapper";

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://192.168.31.3:20041/oauth2_db01",
                "mysql", "12345678")
                .build();


        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .author("fangxiagnqian")
                .outputDir(outputDir)
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.study.hello.distributed.mybatis")
                .entity("domain.entity")
                .mapper("infrastructure.mapper")
                .xml("mapper")
                .service("domain.service")
                .serviceImpl("domain.service.impl")
                .controller("adapter.web")
                .pathInfo(Collections.singletonMap(OutputFile.xml, mapperOutputDir))
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addInclude("oauth2_user", "oauth2_registered_client") // 添加您的表名
                .entityBuilder()
                .enableLombok()
                .controllerBuilder()
                .enableHyphenStyle()
                .enableRestStyle()
                .mapperBuilder()
                .mapperAnnotation(org.apache.ibatis.annotations.Mapper.class)
                .build(); // 调用 build() 方法创建 StrategyConfig 对象

        // 模板配置
        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .entity("/templates/common/entity.java")
                .service("/templates/common/app/service.java")
                .serviceImpl("/templates/common/app/serviceImpl.java")
                .mapper("/templates/common/infrastructure/mapper.java")
                .xml("/templates/common/mapper.xml")
                .controller("/templates/common/adapter/controller.java")
                .build();

        // 注入配置
        InjectionConfig injectionConfig = new InjectionConfig.Builder()
                .beforeOutputFile((TableInfo tableInfo, Map<String, Object> objectMap) -> {
                    System.out.println("TableInfo: " + tableInfo.getName());
                    System.out.println("ObjectMap: " + objectMap);
                })
                .customFile(new CustomFile.Builder().packageName("client.api").fileName("Api.java").templatePath("/templates/common/client/api.java.ftl").build())
                .customFile(new CustomFile.Builder().packageName("client.dto").fileName("DTO.java").templatePath("/templates/common/client/dto.java.ftl").build())
                .customFile(new CustomFile.Builder().packageName("infrastructure.repository").fileName("Repository.java").templatePath("/templates/common/infrastructure/repository.java.ftl").build())
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
