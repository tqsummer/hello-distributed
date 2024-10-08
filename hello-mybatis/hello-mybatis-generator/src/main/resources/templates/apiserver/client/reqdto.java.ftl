package ${extPackage.ReqDto};

import lombok.Data;
<#if extTable.superReqDtoClassPackage??>
import ${extTable.superReqDtoClassPackage};
</#if>
<#list allFieldImportPackages as pkg>
import ${pkg};
</#list>

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
<#if extTable.superReqDtoClass??>
public class ${extTable.reqDtoName} extends ${extTable.superReqDtoClass} {
<#else>
public class ${extTable.reqDtoName} {
</#if>
    private static final long serialVersionUID = 1L;

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.commonFields as field>
    <#if field.comment!?length gt 0>
        /**
        * ${field.comment}
        */
    </#if>
    private ${field.propertyType} ${field.propertyName};

</#list>
<#------------  END 字段循环遍历  ---------->
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.comment!?length gt 0>
    /**
     * ${field.comment}
     */
    </#if>
    private ${field.propertyType} ${field.propertyName};

</#list>
<#------------  END 字段循环遍历  ---------->
}