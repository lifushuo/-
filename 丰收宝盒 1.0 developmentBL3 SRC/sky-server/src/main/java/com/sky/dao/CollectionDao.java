package com.sky.dao;

import com.sky.entity.Star;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
@Mapper

/**
 * (Collection)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 16:51:38
 */
public interface CollectionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Star queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param star 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Star> queryAllByLimit(Star star, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param star 查询条件
     * @return 总行数
     */
    long count(Star star);

    /**
     * 新增数据
     *
     * @param star 实例对象
     * @return 影响行数
     */
    int insert(Star star);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Collection> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Star> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Collection> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Star> entities);

    /**
     * 修改数据
     *
     * @param star 实例对象
     * @return 影响行数
     */
    int update(Star star);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

