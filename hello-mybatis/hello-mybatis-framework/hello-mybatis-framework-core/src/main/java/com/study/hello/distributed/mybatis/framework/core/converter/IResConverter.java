package com.study.hello.distributed.mybatis.framework.core.converter;

import java.util.List;

/**
 * 响应对象转换器（基于 mapstruct 编译期执行生成对应代码）
 *
 * @param <AggVo>
 * @param <ResDto>
 * @param <Entity>
 * @param <Po>
 * @author Cao Yuebing
 */
public interface IResConverter<AggVo, ResDto, Entity, Po> {

    /**
     * 将 AggVo 转换为 ResDto，丢弃扩展字段
     *
     * @param aggVo
     * @return
     */
    ResDto agg2dto(AggVo aggVo);

    /**
     * 将 ResDto 转换为 AggVo
     *
     * @param dto
     * @return
     */
    AggVo dto2agg(ResDto dto);

    /**
     * 将 ResDto 转换为 Po
     *
     * @param dto
     * @return
     */
    Po dto2po(ResDto dto);

    /**
     * 将 ResDto 转换为 Entity
     *
     * @param dto
     * @return
     */
    Entity dto2entity(ResDto dto);

    /**
     * 将 Po 转换为 ResDto
     *
     * @param po
     * @return
     */
    ResDto po2dto(Po po);

    /**
     * 将 Po 转换为 Entity
     *
     * @param po
     * @return
     */
    Entity po2entity(Po po);

    /**
     * 将 Entity 转换为 ResDto
     *
     * @param entity
     * @return
     */
    ResDto entity2dto(Entity entity);

    /**
     * 将 Entity 转换为 Po
     *
     * @param entity
     * @return
     */
    Po entity2po(Entity entity);

    /**
     * 将 AggVo 列表 转换为 ResDto 列表
     *
     * @param aggList
     * @return
     */
    List<ResDto> agg2dtoList(List<AggVo> aggList);

    /**
     * 将 ResDto 列表 转换为 AggVo 列表
     *
     * @param dtoList
     * @return
     */
    List<AggVo> dto2aggList(List<ResDto> dtoList);

    /**
     * 将 ResDto 列表 转换为 Po 列表
     *
     * @param dtoList
     * @return
     */
    List<Po> dto2poList(List<ResDto> dtoList);

    /**
     * 将 ResDto 列表 转换为 Entity 列表
     *
     * @param dtoList
     * @return
     */
    List<Entity> dto2entityList(List<ResDto> dtoList);

    /**
     * 将 Po 列表 转换为 ResDto 列表
     *
     * @param poList
     * @return
     */
    List<ResDto> po2dtoList(List<Po> poList);

    /**
     * 将 Po 列表 转换为 Entity 列表
     *
     * @param poList
     * @return
     */
    List<Entity> po2entityList(List<Po> poList);

    /**
     * 将 Entity 列表 转换为 ResDto 列表
     *
     * @param entityList
     * @return
     */
    List<ResDto> entity2dtoList(List<Entity> entityList);

    /**
     * 将 Entity 列表 转换为 Po 列表
     *
     * @param entityList
     * @return
     */
    List<Po> entity2poList(List<Entity> entityList);

}
