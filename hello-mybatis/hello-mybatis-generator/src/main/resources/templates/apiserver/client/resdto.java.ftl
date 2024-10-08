package ${extPackage.ResDto};

import lombok.Data;
<#if extTable.superResDtoClassPackage??>
import ${extTable.superResDtoClassPackage};
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
<#if extTable.superResDtoClass??>
public class ${extTable.resDtoName} extends ${extTable.superResDtoClass} {
<#else>
public class ${extTable.resDtoName} {
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