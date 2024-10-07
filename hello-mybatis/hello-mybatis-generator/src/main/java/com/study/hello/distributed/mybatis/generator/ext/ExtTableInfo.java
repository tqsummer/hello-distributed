package com.study.hello.distributed.mybatis.generator.ext;

import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ExtTableInfo {
    public static final String EXT_TYPE_NAME_PO = "po";
    private String extTypeName;
    private String packageName;
    private String fileName;
    private String templatePath;
    private Class<?> superClass;

    private ExtTableInfo(String extTypeName) {
        this.extTypeName = extTypeName;
    }

    public static ExtTableInfo build(String extTypeName) {
        return new ExtTableInfo(extTypeName);
    }


    public ExtTableInfo packageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public ExtTableInfo fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public ExtTableInfo templatePath(String templatePath) {
        this.templatePath = templatePath;
        return this;
    }

    public ExtTableInfo superClass(Class<?> superClass) {
        this.superClass = superClass;
        return this;
    }

    public String getExtTypeName() {
        return extTypeName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public Class<?> getSuperClass() {
        return superClass;
    }

    public void injection(TableInfo tableInfo, Map<String, Object> objectMap) {
        String camelExtTypeName = extTypeName.substring(0, 1).toUpperCase() + extTypeName.substring(1);

        //noinspection unchecked
        String parentPackage = ((Map<String, String>) objectMap.get("package")).get("Parent");
        String modulePackageName = parentPackage + "." + packageName;
        //noinspection unchecked
        Map<String, String> extPackage = (Map<String, String>) objectMap.get("extPackage");
        if (Objects.isNull(extPackage)) {
            extPackage = new LinkedHashMap<>();
            objectMap.put("extPackage", extPackage);
        }
        extPackage.put(camelExtTypeName, modulePackageName);

        //noinspection unchecked
        Map<String, String> extTable = (Map<String, String>) objectMap.get("extTable");
        if (Objects.isNull(extTable)) {
            extTable = new LinkedHashMap<>();
            objectMap.put("extTable", extTable);
        }
        extTable.put(extTypeName + "Name", tableInfo.getEntityName() + camelExtTypeName);
        if (Objects.nonNull(superClass)) {
            extTable.put("super" + camelExtTypeName + "Class", superClass.getSimpleName());
            extTable.put("super" + camelExtTypeName + "ClassPackage", superClass.getName());

        }
    }

    public CustomFile getCustomFile() {
        return new CustomFile.Builder().packageName(this.packageName).fileName(this.fileName).templatePath(this.templatePath).build();
    }

}
