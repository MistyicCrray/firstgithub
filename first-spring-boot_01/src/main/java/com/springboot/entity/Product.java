package com.springboot.entity;

import java.util.Date;

public class Product {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.proid
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String proid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.name
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.category
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Double price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.detail
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String detail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.createdate
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Date createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.updatedate
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Date updatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.createby
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String createby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.updateby
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String updateby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.color
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String color;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.img
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String img;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.userid
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.hits
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Integer hits;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.min_price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Float minPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.faver
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Integer faver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.status
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.sellpoint
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String sellpoint;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.max_price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Float maxPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.quality
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Integer quality;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.isNotAuction
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String isnotauction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.increments
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private Float increments;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.currentBidder
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String currentbidder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.bidderId
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String bidderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.outTime
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String outtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.auctionStatus
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    private String auctionstatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.proid
     *
     * @return the value of t_product.proid
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getProid() {
        return proid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.proid
     *
     * @param proid the value for t_product.proid
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.name
     *
     * @return the value of t_product.name
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.name
     *
     * @param name the value for t_product.name
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.category
     *
     * @return the value of t_product.category
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.category
     *
     * @param category the value for t_product.category
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.price
     *
     * @return the value of t_product.price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.price
     *
     * @param price the value for t_product.price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.detail
     *
     * @return the value of t_product.detail
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.detail
     *
     * @param detail the value for t_product.detail
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.createdate
     *
     * @return the value of t_product.createdate
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.createdate
     *
     * @param createdate the value for t_product.createdate
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.updatedate
     *
     * @return the value of t_product.updatedate
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.updatedate
     *
     * @param updatedate the value for t_product.updatedate
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.createby
     *
     * @return the value of t_product.createby
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.createby
     *
     * @param createby the value for t_product.createby
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.updateby
     *
     * @return the value of t_product.updateby
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getUpdateby() {
        return updateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.updateby
     *
     * @param updateby the value for t_product.updateby
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.color
     *
     * @return the value of t_product.color
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getColor() {
        return color;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.color
     *
     * @param color the value for t_product.color
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.img
     *
     * @return the value of t_product.img
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.img
     *
     * @param img the value for t_product.img
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.userid
     *
     * @return the value of t_product.userid
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.userid
     *
     * @param userid the value for t_product.userid
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.hits
     *
     * @return the value of t_product.hits
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Integer getHits() {
        return hits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.hits
     *
     * @param hits the value for t_product.hits
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setHits(Integer hits) {
        this.hits = hits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.min_price
     *
     * @return the value of t_product.min_price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Float getMinPrice() {
        return minPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.min_price
     *
     * @param minPrice the value for t_product.min_price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.faver
     *
     * @return the value of t_product.faver
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Integer getFaver() {
        return faver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.faver
     *
     * @param faver the value for t_product.faver
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setFaver(Integer faver) {
        this.faver = faver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.status
     *
     * @return the value of t_product.status
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.status
     *
     * @param status the value for t_product.status
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.sellpoint
     *
     * @return the value of t_product.sellpoint
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getSellpoint() {
        return sellpoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.sellpoint
     *
     * @param sellpoint the value for t_product.sellpoint
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setSellpoint(String sellpoint) {
        this.sellpoint = sellpoint == null ? null : sellpoint.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.max_price
     *
     * @return the value of t_product.max_price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Float getMaxPrice() {
        return maxPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.max_price
     *
     * @param maxPrice the value for t_product.max_price
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.quality
     *
     * @return the value of t_product.quality
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Integer getQuality() {
        return quality;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.quality
     *
     * @param quality the value for t_product.quality
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.isNotAuction
     *
     * @return the value of t_product.isNotAuction
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getIsnotauction() {
        return isnotauction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.isNotAuction
     *
     * @param isnotauction the value for t_product.isNotAuction
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setIsnotauction(String isnotauction) {
        this.isnotauction = isnotauction == null ? null : isnotauction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.increments
     *
     * @return the value of t_product.increments
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public Float getIncrements() {
        return increments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.increments
     *
     * @param increments the value for t_product.increments
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setIncrements(Float increments) {
        this.increments = increments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.currentBidder
     *
     * @return the value of t_product.currentBidder
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getCurrentbidder() {
        return currentbidder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.currentBidder
     *
     * @param currentbidder the value for t_product.currentBidder
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setCurrentbidder(String currentbidder) {
        this.currentbidder = currentbidder == null ? null : currentbidder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.bidderId
     *
     * @return the value of t_product.bidderId
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getBidderid() {
        return bidderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.bidderId
     *
     * @param bidderid the value for t_product.bidderId
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setBidderid(String bidderid) {
        this.bidderid = bidderid == null ? null : bidderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.outTime
     *
     * @return the value of t_product.outTime
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getOuttime() {
        return outtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.outTime
     *
     * @param outtime the value for t_product.outTime
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setOuttime(String outtime) {
        this.outtime = outtime == null ? null : outtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.auctionStatus
     *
     * @return the value of t_product.auctionStatus
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public String getAuctionstatus() {
        return auctionstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.auctionStatus
     *
     * @param auctionstatus the value for t_product.auctionStatus
     *
     * @mbggenerated Thu Mar 14 09:08:27 CST 2019
     */
    public void setAuctionstatus(String auctionstatus) {
        this.auctionstatus = auctionstatus == null ? null : auctionstatus.trim();
    }
}