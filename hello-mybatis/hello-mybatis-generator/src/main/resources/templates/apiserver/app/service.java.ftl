package ${package.Service};

import ${extPackage.Po}.${extTable.poName};
import ${superServiceClassPackage};

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

}
</#if>