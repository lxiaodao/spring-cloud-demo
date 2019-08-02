/**
 * 
 */
package com.saas.repository;

import java.util.List;

import javax.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saas.domain.SaasUser;
import com.saas.dto.ProductWithTypeName;
import com.saas.dto.UserMapp;

/**
 * @author yangliu
 *
 */
public interface UserRepository extends JpaRepository<SaasUser, Integer> {
	
	@Query(nativeQuery = true, value ="select user_id as userid,role_id as roleid from user_role where user_id=?1")
	List<UserMapp> findMiddleTable(Integer userid);
	
	
	
}
