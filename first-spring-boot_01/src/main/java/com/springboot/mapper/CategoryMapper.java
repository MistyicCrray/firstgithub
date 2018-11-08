package com.springboot.mapper;

import com.springboot.entity.Category;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Nov 06 14:26:28 CST 2018
     */
    @Delete({
        "delete from category",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Nov 06 14:26:28 CST 2018
     */
    @Insert({
        "insert into category (id, parentid, ",
        "name, type)",
        "values (#{id,jdbcType=VARCHAR}, #{parentid,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR})"
    })
    int insert(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Nov 06 14:26:28 CST 2018
     */
    @Select({
        "select",
        "id, parentid, name, type",
        "from category",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR)
    })
    Category selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Nov 06 14:26:28 CST 2018
     */
    @Select({
        "select",
        "id, parentid, name, type",
        "from category"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR)
    })
    List<Category> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Tue Nov 06 14:26:28 CST 2018
     */
    @Update({
        "update category",
        "set parentid = #{parentid,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Category record);
    
    @SelectProvider(type = com.springboot.entity.dyna.CategoryDynaProvider.class, method = "selectProvider")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR)
    })
    List<Category> findList(Map<String, Object> map);
    
    @SelectProvider(type = com.springboot.entity.dyna.CategoryDynaProvider.class, method = "updateProvider")
    int update(Map<String, Object> map);
}