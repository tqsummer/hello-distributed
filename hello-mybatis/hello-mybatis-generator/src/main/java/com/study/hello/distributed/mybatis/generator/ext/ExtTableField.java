package com.study.hello.distributed.mybatis.generator.ext;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

import java.lang.annotation.Annotation;
import java.util.*;

public class ExtTableField {
    private static final String FIELD_ANNOTATION_IMPORT_PACKAGES = "fieldAnnotationImportPackages";
    private static final String FIELD_ANNOTATION_VALUES = "fieldAnnotationValues";

    private String tableName;
    private String columnName;
    private IColumnType columnType;
    private List<Class<? extends Annotation>> annotationImportPackages;
    private List<String> annotationValues;

    private ExtTableField(String tableName, String columnName, IColumnType columnType) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.columnType = columnType;
        this.annotationImportPackages = new ArrayList<>();
        this.annotationValues = new ArrayList<>();
    }

    public static ExtTableField build(String tableName, String columnName, IColumnType columnType) {
        return new ExtTableField(tableName, columnName, columnType);
    }

    public ExtTableField addAnnotation(Class<? extends Annotation> annotationImportPackage, String annotationValue) {
        this.annotationImportPackages.add(annotationImportPackage);
        this.annotationValues.add(annotationValue);
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public IColumnType getColumnType() {
        return columnType;
    }

    public List<Class<? extends Annotation>> getAnnotationImportPackages() {
        return annotationImportPackages;
    }

    public List<String> getAnnotationValues() {
        return annotationValues;
    }

    private boolean match(String tableName, String columnName) {
        if ("*".equals(this.tableName)) {
            return this.columnName.equals(columnName);
        }
        return this.tableName.equals(tableName) && this.columnName.equals(columnName);
    }

    public void injection(TableInfo tableInfo, Map<String, Object> objectMap, TableField tableField) {
        if (!match(tableInfo.getName(), tableField.getColumnName())) {
            return;
        }

        // 添加导入包
        tableInfo.getImportPackages().add(this.columnType.getPkg());

        // 添加注解包
        //noinspection unchecked
        Set<String> fieldAnnotationImportPackages = (Set<String>) objectMap.get(FIELD_ANNOTATION_IMPORT_PACKAGES);
        if (fieldAnnotationImportPackages == null) {
            fieldAnnotationImportPackages = new TreeSet<>();
            objectMap.put(FIELD_ANNOTATION_IMPORT_PACKAGES, fieldAnnotationImportPackages);
        }
        Map<String, Object> customMap = tableField.getCustomMap();
        if (customMap == null) {
            customMap = new HashMap<>();
            tableField.setCustomMap(customMap);
        }
        
        // 添加注解值
        //noinspection unchecked
        Set<String> fieldAnnotationValues = (Set<String>) customMap.get(FIELD_ANNOTATION_VALUES);
        if (fieldAnnotationValues == null) {
            fieldAnnotationValues = new TreeSet<>();
            customMap.put(FIELD_ANNOTATION_VALUES, fieldAnnotationValues);
        }

        fieldAnnotationImportPackages.addAll(annotationImportPackages.stream().map(Class::getName).toList());
        fieldAnnotationValues.addAll(annotationValues);
    }
}
