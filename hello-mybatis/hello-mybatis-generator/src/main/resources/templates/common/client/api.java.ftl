package ${package.Parent}.client.api;

import ${package.Entity}.${entity};
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${table.entityPath}-service")
public interface ${entity}Api {

    @GetMapping("/${table.entityPath}/{id}")
    ${entity} getById(@PathVariable("id") Long id);

    @GetMapping("/${table.entityPath}")
    List<${entity}> list();

    @PostMapping("/${table.entityPath}")
    boolean save(@RequestBody ${entity} ${table.entityPath});

    @PutMapping("/${table.entityPath}")
    boolean update(@RequestBody ${entity} ${table.entityPath});

    @DeleteMapping("/${table.entityPath}/{id}")
    boolean removeById(@PathVariable("id") Long id);
}