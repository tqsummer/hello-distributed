package ${package.Mapper};

import ${extPackage.Po}.${extTable.poName};
import ${superMapperClassPackage};
<#if mapperAnnotation>
import org.apache.ibatis.annotations.Mapper;
</#if>

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if mapperAnnotation>
@Mapper
</#if>
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${extTable.poName}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${extTable.poName}> {

}
</#if>