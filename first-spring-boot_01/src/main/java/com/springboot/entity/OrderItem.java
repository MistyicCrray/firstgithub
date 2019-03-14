package com.springboot.entity;

import java.util.Date;

public class OrderItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.order_id
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.userid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private String userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.sellid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private String sellid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.create_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.status
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.productid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private String productid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.quantity
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.payment
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private double payment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.update_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.address_id
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private String addressId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.confirm_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private Date confirmTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.price
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    private Float price;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.order_id
     *
     * @return the value of t_order_item.order_id
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.order_id
     *
     * @param orderId the value for t_order_item.order_id
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.userid
     *
     * @return the value of t_order_item.userid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.userid
     *
     * @param userid the value for t_order_item.userid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.sellid
     *
     * @return the value of t_order_item.sellid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public String getSellid() {
        return sellid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.sellid
     *
     * @param sellid the value for t_order_item.sellid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setSellid(String sellid) {
        this.sellid = sellid == null ? null : sellid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.create_time
     *
     * @return the value of t_order_item.create_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.create_time
     *
     * @param createTime the value for t_order_item.create_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.status
     *
     * @return the value of t_order_item.status
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.status
     *
     * @param status the value for t_order_item.status
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.productid
     *
     * @return the value of t_order_item.productid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public String getProductid() {
        return productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.productid
     *
     * @param productid the value for t_order_item.productid
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.quantity
     *
     * @return the value of t_order_item.quantity
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.quantity
     *
     * @param quantity the value for t_order_item.quantity
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.payment
     *
     * @return the value of t_order_item.payment
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public double getPayment() {
        return payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.payment
     *
     * @param d the value for t_order_item.payment
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setPayment(double d) {
        this.payment = d;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.update_time
     *
     * @return the value of t_order_item.update_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.update_time
     *
     * @param updateTime the value for t_order_item.update_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.address_id
     *
     * @return the value of t_order_item.address_id
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.address_id
     *
     * @param addressId the value for t_order_item.address_id
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.confirm_time
     *
     * @return the value of t_order_item.confirm_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.confirm_time
     *
     * @param confirmTime the value for t_order_item.confirm_time
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.price
     *
     * @return the value of t_order_item.price
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.price
     *
     * @param price the value for t_order_item.price
     *
     * @mbggenerated Thu Mar 14 09:24:25 CST 2019
     */
    public void setPrice(Float price) {
        this.price = price;
    }
}