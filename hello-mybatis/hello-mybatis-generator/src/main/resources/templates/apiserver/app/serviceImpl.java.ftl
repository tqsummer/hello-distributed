package ${package.ServiceImpl};

import org.springframework.stereotype.Service;
import ${extPackage.Po}.${extTable.poName};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import ${extPackage.ReqDto}.${extTable.reqDtoName};
import ${extPackage.ResDto}.${extTable.resDtoName};
<#if extImportPackages?? && extImportPackages.serviceImplImportPackages??>
<#list extImportPackages.serviceImplImportPackages as pkg>
import ${pkg};
</#list>
</#if>
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.function.Function;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${extTable.poName}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${extTable.poName}> implements ${table.serviceName} {
    @Autowired
    private ${table.mapperName} ${propertyNameMap.Mapper};

    @Override
    public ${extTable.resDtoName} get(Long id) {
        ${extTable.poName} updatePo = getById(id);
        return JsonUtils.convertValue(updatePo, ${extTable.resDtoName}.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${extTable.resDtoName} save(${extTable.reqDtoName} reqDto) {
        ${extTable.poName} po = JsonUtils.convertValue(reqDto, ${extTable.poName}.class);
        save(po);
        ${extTable.poName} updatePo = getById(po.getId());
        return JsonUtils.convertValue(updatePo, ${extTable.resDtoName}.class);
    }

    @Override
    public ApiPage<${extTable.resDtoName}> getPage(MultiValueMap<String, String> query, Pageable pageable) {
        Page<${extTable.poName}> page = WrapperUtils.toPage(pageable);
        IPage<${extTable.poName}> iPage = ${propertyNameMap.Mapper}.selectPage(page, null);
        Function<${extTable.poName}, ${extTable.resDtoName}> function = po -> JsonUtils.convertValue(po, ${extTable.resDtoName}.class);
        return ApiPage.to(iPage, function);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${extTable.resDtoName} updateAllProps(${extTable.reqDtoName} reqDto) {
        ApiUtils.notNull(reqDto.getId());
        ${extTable.poName} updatePo = JsonUtils.convertValue(reqDto, ${extTable.poName}.class);
        ${propertyNameMap.Mapper}.updateById(updatePo);
        return JsonUtils.convertValue(updatePo, ${extTable.resDtoName}.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${extTable.resDtoName} delete(Long id) {
        ApiUtils.notNull(id);
        ${extTable.poName} po = getById(id);
        ${propertyNameMap.Mapper}.deleteById(po);
        return JsonUtils.convertValue(po, ${extTable.resDtoName}.class);
    }
}
</#if>