package ${package.Service};

import ${extPackage.Po}.${extTable.poName};
import ${superServiceClassPackage};
<#if extImportPackages?? && extImportPackages.serviceImportPackages??>
<#list extImportPackages.serviceImportPackages as pkg>
import ${pkg};
</#list>
</#if>
import ${extPackage.ReqDto}.${extTable.reqDtoName};
import ${extPackage.ResDto}.${extTable.resDtoName};
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${extTable.poName}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${extTable.poName}> {
    /**
    * 根据id获取实体ResDto
    * @param id
    * @return
    */
    ${extTable.resDtoName} get(Long id);

    /**
    * 保存实体
    * @param reqDto
    * @return
    */
    ${extTable.resDtoName} save(${extTable.reqDtoName} reqDto);

    /**
    * 分页查询
    * @param query
    * @param pageable
    * @return
    */
    ApiPage<${extTable.resDtoName}> getPage(MultiValueMap<String, String> query, Pageable pageable);

    /**
    * 更新实体
    * @param reqDto
    * @return
    */
    ${extTable.resDtoName} updateAllProps(${extTable.reqDtoName} reqDto);

    /**
    * 删除实体
    * @param id
    * @return
    */
    ${extTable.resDtoName} delete(Long id);
}
</#if>