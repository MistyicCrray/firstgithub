package com.springboot.mapper;

import com.springboot.entity.ShoppingCart;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ShoppingCartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Sun Nov 18 20:45:59 CST 2018
     */
    @Delete({
        "delete from shoppingcart",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Sun Nov 18 20:45:59 CST 2018
     */
    @Insert({
        "insert into shoppingcart (id, userid, ",
        "quantity, total, productid, ",
        "ischeck)",
        "values (#{id,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
        "#{quantity,jdbcType=INTEGER}, #{total,jdbcType=REAL}, #{productid,jdbcType=VARCHAR}, ",
        "#{ischeck,jdbcType=VARCHAR})"
    })
    int insert(ShoppingCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Sun Nov 18 20:45:59 CST 2018
     */
    @Select({
        "select",
        "id, userid, quantity, total, productid, ischeck",
        "from shoppingcart",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="productid", property="productid", jdbcType=JdbcType.VARCHAR),
        @Result(column="ischeck", property="ischeck", jdbcType=JdbcType.VARCHAR)
    })
    ShoppingCart selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Sun Nov 18 20:45:59 CST 2018
     */
    @Select({
        "select",
        "id, userid, quantity, total, productid, ischeck",
        "from shoppingcart"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="productid", property="productid", jdbcType=JdbcType.VARCHAR),
        @Result(column="ischeck", property="ischeck", jdbcType=JdbcType.VARCHAR)
    })
    List<ShoppingCart> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shoppingcart
     *
     * @mbg.generated Sun Nov 18 20:45:59 CST 2018
     */
    @Update({
        "update shoppingcart",
        "set userid = #{userid,jdbcType=VARCHAR},",
          "quantity = #{quantity,jdbcType=INTEGER},",
          "total = #{total,jdbcType=REAL},",
          "productid = #{productid,jdbcType=VARCHAR},",
          "ischeck = #{ischeck,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ShoppingCart record);
    
    
}