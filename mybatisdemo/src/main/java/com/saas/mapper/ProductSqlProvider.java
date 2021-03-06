package com.saas.mapper;

import com.saas.domain.Product;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Thu Aug 01 11:10:53 CST 2019
     */
    public String insertSelective(Product record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getProductType() != null) {
            sql.VALUES("product_type", "#{productType,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getRetailPrice() != null) {
            sql.VALUES("retail_price", "#{retailPrice,jdbcType=NUMERIC}");
        }
        
        if (record.getCostPrice() != null) {
            sql.VALUES("cost_price", "#{costPrice,jdbcType=NUMERIC}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Thu Aug 01 11:10:53 CST 2019
     */
    public String updateByPrimaryKeySelective(Product record) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        if (record.getProductType() != null) {
            sql.SET("product_type = #{productType,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getRetailPrice() != null) {
            sql.SET("retail_price = #{retailPrice,jdbcType=NUMERIC}");
        }
        
        if (record.getCostPrice() != null) {
            sql.SET("cost_price = #{costPrice,jdbcType=NUMERIC}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}