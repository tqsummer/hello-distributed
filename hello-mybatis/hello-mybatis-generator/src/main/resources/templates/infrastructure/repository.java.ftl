package ${package.Parent}.infrastructure.repository;

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ${table.comment!} Repository
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Repository
public class ${entity}Repository {

    @Resource
    private ${table.mapperName} ${table.entityPath}Mapper;

    public ${entity} getById(Long id) {
        return ${table.entityPath}Mapper.selectById(id);
    }

    public List<${entity}> list() {
        return ${table.entityPath}Mapper.selectList(null);
    }

    public boolean save(${entity} ${table.entityPath}) {
        return ${table.entityPath}Mapper.insert(${table.entityPath}) > 0;
    }

    public boolean update(${entity} ${table.entityPath}) {
        return ${table.entityPath}Mapper.updateById(${table.entityPath}) > 0;
    }

    public boolean removeById(Long id) {
        return ${table.entityPath}Mapper.deleteById(id) > 0;
    }
}