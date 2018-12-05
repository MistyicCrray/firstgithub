package com.springboot.mapper;

import com.springboot.entity.ShoppingCart;
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
public interface ShoppingCartMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table shoppingcart
	 *
	 * @mbggenerated Wed Nov 21 11:12:59 CST 2018
	 */
	@Delete({ "delete from shoppingcart", "where cartid = #{cartid,jdbcType=VARCHAR}" })
	int deleteByPrimaryKey(String cartid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table shoppingcart
	 *
	 * @mbggenerated Wed Nov 21 11:12:59 CST 2018
	 */
	@Insert({ "insert into shoppingcart (cartid, userid, ", "quantity, total, productid, ", "createdate, ischeck)",
			"values (#{cartid,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, ",
			"#{quantity,jdbcType=INTEGER}, #{total,jdbcType=REAL}, #{productid,jdbcType=VARCHAR}, ",
			"#{createdate,jdbcType=TIMESTAMP}, #{ischeck,jdbcType=VARCHAR})" })
	int insert(ShoppingCart record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table shoppingcart
	 *
	 * @mbggenerated Wed Nov 21 11:12:59 CST 2018
	 */
	@Select({ "select", "cartid, userid, quantity, total, productid, createdate, ischeck", "from shoppingcart",
			"where cartid = #{cartid,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "cartid", property = "cartid", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "quantity", property = "quantity", jdbcType = JdbcType.INTEGER),
			@Result(column = "total", property = "total", jdbcType = JdbcType.REAL),
			@Result(column = "productid", property = "productid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createdate", property = "createdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ischeck", property = "ischeck", jdbcType = JdbcType.VARCHAR) })
	ShoppingCart selectByPrimaryKey(String cartid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table shoppingcart
	 *
	 * @mbggenerated Wed Nov 21 11:12:59 CST 2018
	 */
	@Select({ })
	@Results({ @Result(column = "cartid", property = "cartid", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "quantity", property = "quantity", jdbcType = JdbcType.INTEGER),
			@Result(column = "total", property = "total", jdbcType = JdbcType.REAL),
			@Result(column = "productid", property = "productid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createdate", property = "createdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ischeck", property = "ischeck", jdbcType = JdbcType.VARCHAR) })
	List<ShoppingCart> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table shoppingcart
	 *
	 * @mbggenerated Wed Nov 21 11:12:59 CST 2018
	 */
	@Update({ "update shoppingcart", "set userid = #{userid,jdbcType=VARCHAR},",
			"quantity = #{quantity,jdbcType=INTEGER},", "total = #{total,jdbcType=REAL},",
			"productid = #{productid,jdbcType=VARCHAR},", "createdate = #{createdate,jdbcType=TIMESTAMP},",
			"ischeck = #{ischeck,jdbcType=VARCHAR}", "where cartid = #{cartid,jdbcType=VARCHAR}" })
	int updateByPrimaryKey(ShoppingCart record);

	// 连表查询
	@SelectProvider(type = com.springboot.entity.dyna.ShoppingCartDynaProvider.class, method = "selectProvider")
	@Results({ @Result(column = "cartid", property = "cartid", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "quantity", property = "quantity", jdbcType = JdbcType.INTEGER),
			@Result(column = "total", property = "total", jdbcType = JdbcType.REAL),
			@Result(column = "productid", property = "productid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createdate", property = "createdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "ischeck", property = "ischeck", jdbcType = JdbcType.VARCHAR),
			@Result(column = "proid", property = "proid", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
			@Result(column = "price", property = "price", jdbcType = JdbcType.DOUBLE),
			@Result(column = "detail", property = "detail", jdbcType = JdbcType.VARCHAR),
			@Result(column = "createdate", property = "createdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updatedate", property = "updatedate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "createby", property = "createby", jdbcType = JdbcType.VARCHAR),
			@Result(column = "updateby", property = "updateby", jdbcType = JdbcType.VARCHAR),
			@Result(column = "color", property = "color", jdbcType = JdbcType.VARCHAR),
			@Result(column = "img", property = "img", jdbcType = JdbcType.VARCHAR),
			@Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "hits", property = "hits", jdbcType = JdbcType.INTEGER),
			@Result(column = "min_price", property = "minPrice", jdbcType = JdbcType.REAL),
			@Result(column = "faver", property = "faver", jdbcType = JdbcType.INTEGER),
			@Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sellpoint", property = "sellpoint", jdbcType = JdbcType.VARCHAR),
			@Result(column = "max_price", property = "maxPrice", jdbcType = JdbcType.REAL),
			@Result(column = "quality", property = "quality", jdbcType = JdbcType.INTEGER) })
	List<Map<String,Object>> findList(Map<String, Object> map);
	
	// 不连表查询
	@SelectProvider(type = com.springboot.entity.dyna.ShoppingCartDynaProvider.class, method = "selectBySql")
	@Results({ @Result(column = "cartid", property = "cartid", jdbcType = JdbcType.VARCHAR, id = true),
		@Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR),
		@Result(column = "quantity", property = "quantity", jdbcType = JdbcType.INTEGER),
		@Result(column = "total", property = "total", jdbcType = JdbcType.REAL),
		@Result(column = "productid", property = "productid", jdbcType = JdbcType.VARCHAR),
		@Result(column = "createdate", property = "createdate", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "ischeck", property = "ischeck", jdbcType = JdbcType.VARCHAR) })
	List<ShoppingCart> findBySql(Map<String, Object> map);

	@SelectProvider(type = com.springboot.entity.dyna.ShoppingCartDynaProvider.class, method = "updateProvider")
	Integer update(Map<String, Object> map);
}