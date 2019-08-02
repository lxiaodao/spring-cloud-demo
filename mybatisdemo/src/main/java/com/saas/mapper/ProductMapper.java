package com.saas.mapper;

import com.saas.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface ProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Thu Aug 01 11:10:53 CST 2019
     */
    @Delete({
        "delete from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

   
    @Insert({
        "insert into product (product_type, ",
        "name, retail_price, ",
        "cost_price, create_time)",
        "values (#{productType,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{retailPrice,jdbcType=NUMERIC}, ",
        "#{costPrice,jdbcType=NUMERIC}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Product record);
    
    @Select({
        "insert into product (product_type, ",
        "name, retail_price, ",
        "cost_price, create_time)",
        "values (#{productType,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{retailPrice,jdbcType=NUMERIC}, ",
        "#{costPrice,jdbcType=NUMERIC}, #{createTime,jdbcType=TIMESTAMP}) RETURNING id"
    })
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    Integer insertAndReturnKey(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Thu Aug 01 11:10:53 CST 2019
     */
    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Thu Aug 01 11:10:53 CST 2019
     */
    @Select({
        "select",
        "id, product_type, name, retail_price, cost_price, create_time",
        "from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_type", property="productType", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="retail_price", property="retailPrice", jdbcType=JdbcType.NUMERIC),
        @Result(column="cost_price", property="costPrice", jdbcType=JdbcType.NUMERIC),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Product selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Thu Aug 01 11:10:53 CST 2019
     */
    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Thu Aug 01 11:10:53 CST 2019
     */
    @Update({
        "update product",
        "set product_type = #{productType,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "retail_price = #{retailPrice,jdbcType=NUMERIC},",
          "cost_price = #{costPrice,jdbcType=NUMERIC},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}