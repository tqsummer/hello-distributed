package ${package.Controller};


import org.springframework.web.bind.annotation.*;
<#if !restControllerStyle>
import org.springframework.stereotype.Controller;
</#if>
<#if extImportPackages?? && extImportPackages.apiImportPackages??>
<#list extImportPackages.apiImportPackages as apiImportPackage>
import ${apiImportPackage};
</#list>
</#if>
import ${extPackage.Api}.${extTable.apiName};
import ${extPackage.ReqDto}.${extTable.reqDtoName};
import ${extPackage.ResDto}.${extTable.resDtoName};



/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#if kotlin>
class ${table.controllerName} : ${extTable.apiName}()
<#else>
public class ${table.controllerName} implements ${extTable.apiName} {

    @GetMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/{id}")
    public ApiResult<${extTable.resDtoName}> get${entity}ById(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    public ApiResult<ApiPage<${extTable.resDtoName}>> getPage${entity}(@RequestParam MultiValueMap<String, String> query, Pageable pageable){
        return null;
    }

    @PostMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    public ApiResult<ApiPage<${extTable.resDtoName}>> save${entity}(@RequestBody ${extTable.reqDtoName} reqDto){
        return null;
    }

    @PutMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    public ApiResult<ApiPage<${extTable.resDtoName}>> put${entity}(@RequestBody ${extTable.reqDtoName} reqDto){
        return null;
    }

    @DeleteMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/{id}")
    public ApiResult<ApiPage<${extTable.resDtoName}>> delete${entity}ById(@PathVariable("id") Long id){
        return null;
    }
}
</#if>