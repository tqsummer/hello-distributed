package com.study.hello.distributed.mybatis.generator;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiPage;
import com.study.hello.distributed.mybatis.framework.commons.api.ApiResult;
import com.study.hello.distributed.mybatis.framework.commons.api.dto.AbstractReqDto;
import com.study.hello.distributed.mybatis.framework.commons.api.dto.AbstractResDto;
import com.study.hello.distributed.mybatis.framework.commons.util.ApiUtils;
import com.study.hello.distributed.mybatis.framework.commons.util.JsonUtils;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.mapper.AbstractMapper;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.po.AbstractPo;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.service.IPoService;
import com.study.hello.distributed.mybatis.framework.core.ddd.infrastructure.persistence.service.PoServiceImpl;
import com.study.hello.distributed.mybatis.framework.core.mybatis.util.WrapperUtils;
import com.study.hello.distributed.mybatis.generator.ext.ExtDbColumnType;
import com.study.hello.distributed.mybatis.generator.ext.ExtSysTableInfo;
import com.study.hello.distributed.mybatis.generator.ext.ExtTableField;
import com.study.hello.distributed.mybatis.generator.ext.ExtTableInfo;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.function.Consumer;
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
                .parent("com.study.hello.distributed.mybatis.apiserver")
                .entity("infrastructure.entity")
                .mapper("infrastructure.mapper")
                .xml("mapper")
                .service("infrastructure.service")
                .serviceImpl("infrastructure.service.impl")
                .controller("controller")
                .pathInfo(Collections.singletonMap(OutputFile.xml, mapperOutputDir))
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addInclude("t_member") // 添加您的表名
                .addTablePrefix("t_")
                .entityBuilder()
                .enableLombok()
                .superClass(AbstractPo.class)
                .addSuperEntityColumns("id", "create_time", "create_user_id", "create_user_name", "modify_time", "modify_user_id", "modify_user_name", "version", "deleted")
                .logicDeleteColumnName("deleted")
                .versionColumnName("version")
                .controllerBuilder()
                .enableHyphenStyle()
                .enableRestStyle()
                .mapperBuilder()
                .mapperAnnotation(Mapper.class)
                .superClass(AbstractMapper.class)
                .formatMapperFileName("%sPoMapper")
                .formatXmlFileName("%sPoMapper")
                .serviceBuilder()
                .superServiceClass(IPoService.class)
                .formatServiceFileName("I%sPoService")
                .superServiceImplClass(PoServiceImpl.class)
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
        Consumer<Pair<TableInfo, Map<String, Object>>> propertyNamesConsumer = (pair) -> {
            TableInfo tableInfo = pair.getLeft();
            Map<String, Object> objectMap = pair.getRight();

            String entityName = tableInfo.getEntityName();
            String entityPropertyName = entityName.substring(0, 1).toLowerCase() + entityName.substring(1);
            String serviceName = tableInfo.getServiceImplName();
            String servicePropertyName = serviceName.substring(0, 1).toLowerCase() + serviceName.substring(1);
            servicePropertyName = servicePropertyName.replace("Impl", "");
            String controllerName = tableInfo.getControllerName();
            String controllerPropertyName = controllerName.substring(0, 1).toLowerCase() + controllerName.substring(1);
            String mapperName = tableInfo.getMapperName();
            String mapperPropertyName = mapperName.substring(0, 1).toLowerCase() + mapperName.substring(1);

            //noinspection unchecked
            Map<String, String> propertyNameMap = (Map<String, String>) objectMap.get(ExtTableInfo.EXT_PROPERTY_NAME_MAP_KEY);
            if (propertyNameMap == null) {
                propertyNameMap = new HashMap<>();
                objectMap.put(ExtTableInfo.EXT_PROPERTY_NAME_MAP_KEY, propertyNameMap);
            }
            propertyNameMap.put("Entity", entityPropertyName);
            propertyNameMap.put("Service", servicePropertyName);
            propertyNameMap.put("Controller", controllerPropertyName);
            propertyNameMap.put("Mapper", mapperPropertyName);

        };
        List<ExtSysTableInfo> extSysTableInfos = List.of(
                ExtSysTableInfo.build(ExtSysTableInfo.EXT_TYPE_NAME_SERVICE).dependencyPackages(ApiPage.class),
                ExtSysTableInfo.build(ExtSysTableInfo.EXT_TYPE_NAME_SERVICE_IMPL).dependencyPackages(ApiPage.class, ApiUtils.class, JsonUtils.class, WrapperUtils.class)
        );
        List<ExtTableInfo> extTableInfos = List.of(
                ExtTableInfo.build(ExtTableInfo.EXT_TYPE_NAME_PO).fileName("Po.java").packageName("infrastructure.po").templatePath("/templates/apiserver/infrastructure/po.java.ftl").superClass(AbstractPo.class),
                ExtTableInfo.build(ExtTableInfo.EXT_TYPE_NAME_API).fileName("Api.java").packageName("api").templatePath("/templates/apiserver/client/api.java.ftl").dependencyPackages(ApiResult.class, ApiPage.class, MultiValueMap.class, Pageable.class),
                ExtTableInfo.build(ExtTableInfo.EXT_TYPE_NAME_REQ_DTO).fileName("ReqDto.java").packageName("api.dto.req").templatePath("/templates/apiserver/client/reqdto.java.ftl").superClass(AbstractReqDto.class),
                ExtTableInfo.build(ExtTableInfo.EXT_TYPE_NAME_RES_DTO).fileName("ResDto.java").packageName("api.dto.res").templatePath("/templates/apiserver/client/resdto.java.ftl").superClass(AbstractResDto.class)
        );
        List<ExtTableField> extTableFields = List.of(ExtTableField.build("t_customer", "gender", ExtDbColumnType.Gender).addAnnotation(EnumValue.class, "@EnumValue"));
        InjectionConfig injectionConfig = new InjectionConfig.Builder()
                .beforeOutputFile((TableInfo tableInfo, Map<String, Object> objectMap) -> {
                    propertyNamesConsumer.accept(Pair.of(tableInfo, objectMap));
                    extSysTableInfos.forEach(extSysTableInfo -> {
                        extSysTableInfo.injection(tableInfo, objectMap);
                    });
                    extTableInfos.forEach(extTableInfo -> {
                        extTableInfo.injection(tableInfo, objectMap);
                    });
                    tableInfo.getFields().forEach(tableField -> extTableFields.forEach(extTableField -> extTableField.injection(tableInfo, objectMap, tableField)));

                    Set<String> allFieldImportPackages = tableInfo.getFields().stream().filter(tableField -> tableField.getColumnType() != null && tableField.getColumnType().getPkg() != null).map(tableField -> tableField.getColumnType().getPkg()).collect(Collectors.toCollection(TreeSet::new));
                    allFieldImportPackages.addAll(tableInfo.getCommonFields().stream().filter(tableField -> tableField.getColumnType() != null && tableField.getColumnType().getPkg() != null).map(tableField -> tableField.getColumnType().getPkg()).collect(Collectors.toSet()));
                    objectMap.put("allFieldImportPackages", allFieldImportPackages);

                    System.out.println("TableInfo: " + tableInfo.getName());
                    System.out.println("ObjectMap: " + objectMap);

                })
                .customFile(extTableInfos.stream().map(ExtTableInfo::getCustomFile).toList())
                //.customFile(new CustomFile.Builder().packageName("api").fileName("Api.java").templatePath("/templates/apiserver/client/api.java.ftl").build())
                //.customFile(new CustomFile.Builder().packageName("api.dto").fileName("DTO.java").templatePath("/templates/apiserver/client/dto.java.ftl").build())
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
