package com.springboot.entity;

import java.util.Date;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.order_id
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.userid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private String userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.sellid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private String sellid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.create_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.status
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.productid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private String productid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.quantity
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.payment
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private Double payment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.update_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.address_id
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private String addressId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.confirm_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    private Date confirmTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.order_id
     *
     * @return the value of t_order.order_id
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.order_id
     *
     * @param orderId the value for t_order.order_id
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.userid
     *
     * @return the value of t_order.userid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.userid
     *
     * @param userid the value for t_order.userid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.sellid
     *
     * @return the value of t_order.sellid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public String getSellid() {
        return sellid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.sellid
     *
     * @param sellid the value for t_order.sellid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setSellid(String sellid) {
        this.sellid = sellid == null ? null : sellid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.create_time
     *
     * @return the value of t_order.create_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.create_time
     *
     * @param createTime the value for t_order.create_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.status
     *
     * @return the value of t_order.status
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.status
     *
     * @param status the value for t_order.status
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.productid
     *
     * @return the value of t_order.productid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public String getProductid() {
        return productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.productid
     *
     * @param productid the value for t_order.productid
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.quantity
     *
     * @return the value of t_order.quantity
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.quantity
     *
     * @param quantity the value for t_order.quantity
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.payment
     *
     * @return the value of t_order.payment
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public Double getPayment() {
        return payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.payment
     *
     * @param payment the value for t_order.payment
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setPayment(Double payment) {
        this.payment = payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.update_time
     *
     * @return the value of t_order.update_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.update_time
     *
     * @param updateTime the value for t_order.update_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.address_id
     *
     * @return the value of t_order.address_id
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.address_id
     *
     * @param addressId the value for t_order.address_id
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.confirm_time
     *
     * @return the value of t_order.confirm_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.confirm_time
     *
     * @param confirmTime the value for t_order.confirm_time
     *
     * @mbg.generated Mon Dec 10 17:02:07 CST 2018
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }
}