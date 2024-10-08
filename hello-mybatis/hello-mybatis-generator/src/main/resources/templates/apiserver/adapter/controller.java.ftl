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
import ${package.Service}.${table.serviceName};


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

    @Autowired
    private ${table.serviceName} ${propertyNameMap.Service};

    @GetMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/{id}")
    public ApiResult<${extTable.resDtoName}> get${entity}ById(@PathVariable("id") Long id){
        return ApiResult.ok(memberPoService.get(id));
    }

    @GetMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    public ApiResult<ApiPage<${extTable.resDtoName}>> getPage${entity}(@RequestParam MultiValueMap<String, String> query, Pageable pageable){
        return ApiResult.ok(memberPoService.getPage(query, pageable));
    }

    @PostMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    public ApiResult<${extTable.resDtoName}> save${entity}(@RequestBody ${extTable.reqDtoName} reqDto){
        return ApiResult.ok(memberPoService.save(reqDto));
    }

    @PutMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
    public ApiResult<${extTable.resDtoName}> put${entity}(@RequestBody ${extTable.reqDtoName} reqDto){
        return ApiResult.ok(memberPoService.updateAllProps(reqDto));
    }

    @DeleteMapping("/v1<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/{id}")
    public ApiResult<${extTable.resDtoName}> delete${entity}ById(@PathVariable("id") Long id){
        return ApiResult.ok(memberPoService.delete(id));
    }
}
</#if>