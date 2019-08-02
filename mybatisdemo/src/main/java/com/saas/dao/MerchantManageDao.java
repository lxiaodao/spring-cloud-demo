/**
 * 
 */
package com.saas.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.saas.domain.Product;
import com.saas.domain.ProductType;

import com.saas.dto.ProductWithTypeName;

/**
 * 
 * merchart busine
 * @author yangliu
 *
 */
@Mapper
public interface MerchantManageDao {
	//Batch 操作参考
	/*
	 * @Insert({"<script>",
	 * "insert into  user_master (first_name,last_name) values ",
	 * "<foreach collection='userList' item='user' index='index' open='(' separator = '),(' close=')' >#{user.first_name},#{user.last_name}</foreach>"
	 * , "</script>"}) int insertUserList(@Param("userList") List<UserNew>
	 * userList);
	 */
	
	  @Select({ "<script>"
	  +"select p.id as prodectId, p.name as productName,type.id as typeId,type.name as typeName "
	  +"from product p left join product_type type on p.product_type =type.id "
	  +"where 1=1"
	  +"<if test='pname != null'> AND p.name=#{pname} </if> "
	  +"<if test='tname != null'> AND type.name=#{tname} </if>"
	  +"</script>" 
	  }) 
	public List<ProductWithTypeName> queryProductAnnotation(@Param("pname")String
	  productName,@Param("tname") String typeName);
	 
	@SelectProvider(type=MerchantManageDaoSqlProvider.class,method="queryProductProvider")
	public List<ProductWithTypeName> queryProduct(String productName,String typeName);
}
