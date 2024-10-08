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

    /**
    * 根据id获取实体信息
    * @param id
    * @return
    */
    ApiResult<${extTable.resDtoName}> get${entity}ById(@PathVariable("id") Long id);

    /**
    * 分页查询
    * @param query
    * @param pageable
    * @return
    */
    ApiResult<ApiPage<${extTable.resDtoName}>> getPage${entity}(@RequestParam MultiValueMap<String, String> query, Pageable pageable);

    /**
    * 保存实体
    * @param reqDto
    * @return
    */
    ApiResult<${extTable.resDtoName}> save${entity}(@RequestBody ${extTable.reqDtoName} reqDto);

    /**
    * 更新实体
    * @param reqDto
    * @return
    */
    ApiResult<${extTable.resDtoName}> put${entity}(@RequestBody ${extTable.reqDtoName} reqDto);

    /**
    * 删除实体
    * @param id
    * @return
    */
    ApiResult<${extTable.resDtoName}> delete${entity}ById(@PathVariable("id") Long id);
}