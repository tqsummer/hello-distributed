package $${extPackage.Api};

import org.springframework.web.bind.annotation.*;
<#if extImportPackages?? && extImportPackages.apiImportPackages??>
<#list extImportPackages.apiImportPackages as apiImportPackage>
import ${apiImportPackage};
</#list>
</#if>
import ${extPackage.ReqDto}.${extTable.reqDtoName};
import ${extPackage.ResDto}.${extTable.resDtoName};

public interface ${extTable.apiName} {

    @GetMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/{id}")
    ApiResult<${extTable.resDtoName}> get${entity}ById(@PathVariable("id") Long id);

    @GetMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    ApiResult<ApiPage<${extTable.resDtoName}>> getPage${entity}(@RequestParam MultiValueMap<String, String> query, Pageable pageable);

    @PostMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    ApiResult<ApiPage<${extTable.resDtoName}>> save${entity}(@RequestBody ${extTable.reqDtoName} reqDto);

    @PutMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    ApiResult<ApiPage<${extTable.resDtoName}>> put${entity}(@RequestBody ${extTable.reqDtoName} reqDto);

    @DeleteMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/{id}")
    ApiResult<ApiPage<${extTable.resDtoName}>> delete${entity}ById(@PathVariable("id") Long id);
}