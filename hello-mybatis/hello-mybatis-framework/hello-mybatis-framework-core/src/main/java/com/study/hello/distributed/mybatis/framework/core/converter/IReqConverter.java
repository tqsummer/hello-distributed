package com.study.hello.distributed.mybatis.framework.core.converter;

import java.util.List;

/**
 * 请求对象转换器（基于 mapstruct 编译期执行生成对应代码）
 *
 * @param <SaveReqDto>
 * @param <PatchReqDto>
 * @param <PutReqDto>
 * @param <Entity>
 * @param <Po>
 * @author Cao Yuebing
 */
public interface IReqConverter<SaveReqDto, PatchReqDto, PutReqDto, Entity, Po> {

    /**
     * 将 SaveReqDto 转换为 Entity
     *
     * @param dto
     * @return
     */
    Entity save2entity(SaveReqDto dto);

    /**
     * 将 SaveReqDto 转换为 Po
     *
     * @param dto
     * @return
     */
    Po save2po(SaveReqDto dto);

    /**
     * 将 PatchReqDto 转换为 Entity
     *
     * @param dto
     * @return
     */
    Entity patch2entity(PatchReqDto dto);

    /**
     * 将 PatchReqDto 转换为 Po
     *
     * @param dto
     * @return
     */
    Po patch2po(PatchReqDto dto);

    /**
     * 将 PutReqDto 转换为 Entity
     *
     * @param dto
     * @return
     */
    Entity put2entity(PutReqDto dto);

    /**
     * 将 PutReqDto 转换为 Po
     *
     * @param dto
     * @return
     */
    Po put2po(PutReqDto dto);

    /**
     * 将 Entity 转换为 Po
     *
     * @param entity
     * @return
     */
    Po entity2po(Entity entity);

    /**
     * 将 Po 转换为 Entity
     *
     * @param po
     * @return
     */
    Entity po2entity(Po po);

    /**
     * 将 SaveReqDto 列表 转换为 Entity 列表
     *
     * @param dtoList
     * @return
     */
    List<Entity> save2entityList(List<SaveReqDto> dtoList);

    /**
     * 将 SaveReqDto 列表 转换为 Po 列表
     *
     * @param dtoList
     * @return
     */
    List<Po> save2poList(List<SaveReqDto> dtoList);

    /**
     * 将 PatchReqDto 列表 转换为 Entity 列表
     *
     * @param dtoList
     * @return
     */
    List<Entity> patch2entityList(List<PatchReqDto> dtoList);

    /**
     * 将 PatchReqDto 列表 转换为 Po 列表
     *
     * @param dtoList
     * @return
     */
    List<Po> patch2poList(List<PatchReqDto> dtoList);

    /**
     * 将 PutReqDto 列表 转换为 Entity 列表
     *
     * @param dtoList
     * @return
     */
    List<Entity> put2entityList(List<PutReqDto> dtoList);

    /**
     * 将 PutReqDto 列表 转换为 Po 列表
     *
     * @param dtoList
     * @return
     */
    List<Po> put2poList(List<PutReqDto> dtoList);

    /**
     * 将 Entity 列表 转换为 Po 列表
     *
     * @param entityList
     * @return
     */
    List<Po> entity2poList(List<Entity> entityList);

    /**
     * 将 Po 列表 转换为 Entity 列表
     *
     * @param poList
     * @return
     */
    List<Entity> po2entityList(List<Po> poList);

}
