package com.springboot.entity;

public class Collection {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_collection.collectionId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    private String collectionid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_collection.productId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    private String productid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_collection.userId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    private String userid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_collection.collectionId
     *
     * @return the value of t_collection.collectionId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    public String getCollectionid() {
        return collectionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_collection.collectionId
     *
     * @param collectionid the value for t_collection.collectionId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    public void setCollectionid(String collectionid) {
        this.collectionid = collectionid == null ? null : collectionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_collection.productId
     *
     * @return the value of t_collection.productId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    public String getProductid() {
        return productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_collection.productId
     *
     * @param productid the value for t_collection.productId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_collection.userId
     *
     * @return the value of t_collection.userId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_collection.userId
     *
     * @param userid the value for t_collection.userId
     *
     * @mbg.generated Thu Apr 25 16:27:44 CST 2019
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}