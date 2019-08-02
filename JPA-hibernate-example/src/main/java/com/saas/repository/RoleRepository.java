/**
 * 
 */
package com.saas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.domain.Role;

/**
 * @author yangliu
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
