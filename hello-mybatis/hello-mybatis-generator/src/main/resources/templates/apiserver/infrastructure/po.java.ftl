package ${extPackage.Po};

<#list table.importPackages as pkg>
<#--noinspection FtlLanguageInspection-->
    <#if
    !pkg?contains("Serializable")
    >
import ${pkg};
    </#if>
</#list>

<#if fieldAnnotationImportPackages??>
<#list fieldAnnotationImportPackages as pkg>
import ${pkg};
</#list>
</#if>
<#if springdoc>
import io.swagger.v3.oas.annotations.media.Schema;
<#elseif swagger>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Getter;
import lombok.Setter;
<#if chainModel>
import lombok.experimental.Accessors;
</#if>
</#if>

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if entityLombokModel>
@Getter
@Setter
    <#if chainModel>
@Accessors(chain = true)
    </#if>
</#if>
<#if table.convert>
@TableName("${schemaName}${table.name}")
</#if>
<#if springdoc>
@Schema(name = "${extTable.poName}", description = "${table.comment!}")
<#elseif swagger>
@ApiModel(value = "${extTable.poName}对象", description = "${table.comment!}")
</#if>
<#if extTable.superPoClass??>
public class ${extTable.poName} extends ${extTable.superPoClass}<#if activeRecord><${extTable.poName}></#if> {
<#elseif activeRecord>
public class ${extTable.poName} extends Model<${extTable.poName}> {
<#elseif entitySerialVersionUID>
public class ${extTable.poName} implements Serializable {
<#else>
public class ${extTable.poName} {
</#if>
<#if entitySerialVersionUID>

    private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>

    <#if field.comment!?length gt 0>
        <#if springdoc>
    @Schema(description = "${field.comment}")
        <#elseif swagger>
    @ApiModelProperty("${field.comment}")
        <#else>
    /**
     * ${field.comment}
     */
        </#if>
    </#if>
    <#if field.keyFlag>
        <#-- 主键 -->
        <#if field.keyIdentityFlag>
    @TableId(value = "${field.annotationColumnName}", type = IdType.AUTO)
        <#elseif idType??>
    @TableId(value = "${field.annotationColumnName}", type = IdType.${idType})
        <#elseif field.convert>
    @TableId("${field.annotationColumnName}")
        </#if>
        <#-- 普通字段 -->
    <#elseif field.fill??>
    <#-- -----   存在字段填充设置   ----->
        <#if field.convert>
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.${field.fill})
        <#else>
    @TableField(fill = FieldFill.${field.fill})
        </#if>
    <#elseif field.convert>
    @TableField("${field.annotationColumnName}")
    </#if>
    <#-- 乐观锁注解 -->
    <#if field.versionField>
    @Version
    </#if>
    <#-- 逻辑删除注解 -->
    <#if field.logicDeleteField>
    @TableLogic
    </#if>
    <#if field.customMap?? && field.customMap.fieldAnnotationValues??>
    <#list field.customMap.fieldAnnotationValues as fieldAnnotation>
    ${fieldAnnotation}
    </#list>
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
}