package com.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.springboot.entity.Product;

@Mapper
public interface ProductMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table product
	 *
	 * @mbggenerated Fri Mar 01 09:18:56 CST 2019
	 */
	@Delete({ "delete from product", "where proid = #{proid,jdbcType=VARCHAR}" })
	int deleteByPrimaryKey(String proid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table product
	 *
	 * @mbggenerated Fri Mar 01 09:18:56 CST 2019
	 */
	@Insert({ "insert into product (proid, name, ", "category, price, ", "detail, createdate, ",
			"updatedate, createby, ", "updateby, color, ", "img, userid, hits, ", "min_price, faver, status, ",
			"sellpoint, max_price, ", "quality, isNotAuction, ", "increments, currentBidder, ", "bidderId, outTime, ",
			"auctionStatus)", "values (#{proid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
			"#{category,jdbcType=VARCHAR}, #{price,jdbcType=DOUBLE}, ",
			"#{detail,jdbcType=VARCHAR}, #{createdate,jdbcType=TIMESTAMP}, ",
			"#{updatedate,jdbcType=TIMESTAMP}, #{createby,jdbcType=VARCHAR}, ",
			"#{updateby,jdbcType=VARCHAR}, #{color,jdbcType=VARCHAR}, ",
			"#{img,jdbcType=VARCHAR}, #{userid,jdbcType=VARCHAR}, #{hits,jdbcType=INTEGER}, ",
			"#{minPrice,jdbcType=REAL}, #{faver,jdbcType=INTEGER}, #{status,jdbcType=VARCHAR}, ",
			"#{sellpoint,jdbcType=VARCHAR}, #{maxPrice,jdbcType=REAL}, ",
			"#{quality,jdbcType=INTEGER}, #{isnotauction,jdbcType=VARCHAR}, ",
			"#{increments,jdbcType=REAL}, #{currentbidder,jdbcType=VARCHAR}, ",
			"#{bidderid,jdbcType=VARCHAR}, #{outtime,jdbcType=VARCHAR}, ", "#{auctionstatus,jdbcType=VARCHAR})" })
	int insert(Product record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table product
	 *
	 * @mbggenerated Fri Mar 01 09:18:56 CST 2019
	 */
	@Select({ "select", "proid, name, category, price, detail, createdate, updatedate, createby, updateby, ",
			"color, img, userid, hits, min_price, faver, status, sellpoint, max_price, quality, ",
			"isNotAuction, increments, currentBidder, bidderId, outTime, auctionStatus", "from product",
			"where proid = #{proid,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "proid", property = "proid", jdbcType = JdbcType.VARCHAR, id = true),
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
			@Result(column = "quality", property = "quality", jdbcType = JdbcType.INTEGER),
			@Result(column = "isNotAuction", property = "isnotauction", jdbcType = JdbcType.VARCHAR),
			@Result(column = "increments", property = "increments", jdbcType = JdbcType.REAL),
			@Result(column = "currentBidder", property = "currentbidder", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bidderId", property = "bidderid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outTime", property = "outtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "auctionStatus", property = "auctionstatus", jdbcType = JdbcType.VARCHAR) })
	Product selectByPrimaryKey(String proid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table product
	 *
	 * @mbggenerated Fri Mar 01 09:18:56 CST 2019
	 */
	@Select({ "select", "proid, name, category, price, detail, createdate, updatedate, createby, updateby, ",
			"color, img, userid, hits, min_price, faver, status, sellpoint, max_price, quality, ",
			"isNotAuction, increments, currentBidder, bidderId, outTime, auctionStatus", "from product" })
	@Results({ @Result(column = "proid", property = "proid", jdbcType = JdbcType.VARCHAR, id = true),
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
			@Result(column = "quality", property = "quality", jdbcType = JdbcType.INTEGER),
			@Result(column = "isNotAuction", property = "isnotauction", jdbcType = JdbcType.VARCHAR),
			@Result(column = "increments", property = "increments", jdbcType = JdbcType.REAL),
			@Result(column = "currentBidder", property = "currentbidder", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bidderId", property = "bidderid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outTime", property = "outtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "auctionStatus", property = "auctionstatus", jdbcType = JdbcType.VARCHAR) })
	List<Product> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table product
	 *
	 * @mbggenerated Fri Mar 01 09:18:56 CST 2019
	 */
	@Update({ "update product", "set name = #{name,jdbcType=VARCHAR},", "category = #{category,jdbcType=VARCHAR},",
			"price = #{price,jdbcType=DOUBLE},", "detail = #{detail,jdbcType=VARCHAR},",
			"createdate = #{createdate,jdbcType=TIMESTAMP},", "updatedate = #{updatedate,jdbcType=TIMESTAMP},",
			"createby = #{createby,jdbcType=VARCHAR},", "updateby = #{updateby,jdbcType=VARCHAR},",
			"color = #{color,jdbcType=VARCHAR},", "img = #{img,jdbcType=VARCHAR},",
			"userid = #{userid,jdbcType=VARCHAR},", "hits = #{hits,jdbcType=INTEGER},",
			"min_price = #{minPrice,jdbcType=REAL},", "faver = #{faver,jdbcType=INTEGER},",
			"status = #{status,jdbcType=VARCHAR},", "sellpoint = #{sellpoint,jdbcType=VARCHAR},",
			"max_price = #{maxPrice,jdbcType=REAL},", "quality = #{quality,jdbcType=INTEGER},",
			"isNotAuction = #{isnotauction,jdbcType=VARCHAR},", "increments = #{increments,jdbcType=REAL},",
			"currentBidder = #{currentbidder,jdbcType=VARCHAR},", "bidderId = #{bidderid,jdbcType=VARCHAR},",
			"outTime = #{outtime,jdbcType=VARCHAR},", "auctionStatus = #{auctionstatus,jdbcType=VARCHAR}",
			"where proid = #{proid,jdbcType=VARCHAR}" })
	int updateByPrimaryKey(Product record);

	@SelectProvider(type = com.springboot.entity.dyna.ProductDynaProvider.class, method = "selectProvider")
	@Results({ @Result(column = "proid", property = "proid", jdbcType = JdbcType.VARCHAR, id = true),
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
			@Result(column = "quality", property = "quality", jdbcType = JdbcType.INTEGER),
			@Result(column = "isNotAuction", property = "isnotauction", jdbcType = JdbcType.VARCHAR),
			@Result(column = "increments", property = "increments", jdbcType = JdbcType.REAL),
			@Result(column = "currentBidder", property = "currentbidder", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bidderId", property = "bidderid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outTime", property = "outtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "auctionStatus", property = "auctionstatus", jdbcType = JdbcType.VARCHAR) })
	List<Product> findList(Map<String, Object> map);

	@UpdateProvider(type = com.springboot.entity.dyna.ProductDynaProvider.class, method = "updateProvider")
	Integer update(Map<String, Object> map);

	@Results({ @Result(column = "proid", property = "proid", jdbcType = JdbcType.VARCHAR, id = true),
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
			@Result(column = "quality", property = "quality", jdbcType = JdbcType.INTEGER),
			@Result(column = "isNotAuction", property = "isnotauction", jdbcType = JdbcType.VARCHAR),
			@Result(column = "increments", property = "increments", jdbcType = JdbcType.REAL),
			@Result(column = "currentBidder", property = "currentbidder", jdbcType = JdbcType.VARCHAR),
			@Result(column = "bidderId", property = "bidderid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "outTime", property = "outtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "auctionStatus", property = "auctionstatus", jdbcType = JdbcType.VARCHAR) })
	@SelectProvider(type = com.springboot.entity.dyna.ProductDynaProvider.class, method = "searchList")
	List<Product> search(String key);

	@Update({ "update product set img=''", "where proid = #{id,jdbcType=VARCHAR}" })
	int deleImg(String id);

}