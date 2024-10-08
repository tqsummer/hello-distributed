package com.study.hello.distributed.mybatis.generator.ext;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.*;
import java.util.stream.Collectors;

public class ExtSysTableInfo {
    public static final String EXT_TYPE_NAME_SERVICE = "service";
    public static final String EXT_TYPE_NAME_SERVICE_IMPL = "serviceImpl";
    public static final String EXT_TYPE_NAME_MAPPER = "mapper";
    public static final String EXT_TYPE_NAME_CONTROLLER = "controller";

    private final String extTypeName;
    private Class<?> superClass;
    private final List<Class<?>> dependencyPackages;

    private ExtSysTableInfo(String extTypeName) {
        this.extTypeName = extTypeName;
        this.dependencyPackages = new ArrayList<>();
    }

    public static ExtSysTableInfo build(String extTypeName) {
        return new ExtSysTableInfo(extTypeName);
    }


    public ExtSysTableInfo superClass(Class<?> superClass) {
        this.superClass = superClass;
        return this;
    }

    public ExtSysTableInfo dependencyPackages(Class<?>... dependencyPackages) {
        this.dependencyPackages.addAll(Arrays.asList(dependencyPackages));
        return this;
    }

    public String getExtTypeName() {
        return extTypeName;
    }


    public Class<?> getSuperClass() {
        return superClass;
    }

    public List<Class<?>> getDependencyPackages() {
        return dependencyPackages;
    }

    public void injection(TableInfo tableInfo, Map<String, Object> objectMap) {

        String extTypeImportPackagesNameKey = extTypeName + ExtTableInfo.EXT_TYPE_IMPORT_PACKAGES_NAME_KEY;
        //noinspection unchecked
        Map<String, Set<String>> extImportPackages = (Map<String, Set<String>>) objectMap.get(ExtTableInfo.EXT_IMPORT_PACKAGES_NAME_KEY);
        if (Objects.isNull(extImportPackages)) {
            extImportPackages = new LinkedHashMap<>();
            objectMap.put(ExtTableInfo.EXT_IMPORT_PACKAGES_NAME_KEY, extImportPackages);
        }
        extImportPackages.put(extTypeImportPackagesNameKey, dependencyPackages.stream().map(Class::getName).collect(Collectors.toSet()));

    }


}
