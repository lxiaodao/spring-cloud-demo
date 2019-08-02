
/**
 * 
 */
package com.saas.service;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saas.domain.Role;
import com.saas.domain.SaasUser;
import com.saas.repository.RoleRepository;
import com.saas.repository.UserRepository;

/**
 * @author yang
 *
 */
@Service("businessService")
public class BusinessService {
	 @Autowired
	 private UserRepository userRepo;
	 @Autowired
	 private RoleRepository roleRepo;
	 
	 
	 
	
	@Transactional(rollbackFor = Exception.class)
	public SaasUser createUser(boolean isfail) {
		
		SaasUser user=new SaasUser();
		user.setUsername("user"+new Random().nextInt());
		return userRepo.save(user);
		
		
	}
	@Transactional(rollbackFor = Exception.class)
	public Role createRole() {
		
		Role role=new Role();
		role.setName("role_"+new Random().nextInt());
		return roleRepo.save(role);
				
	}
	@Transactional(rollbackFor = Exception.class)
	public SaasUser createUserAndRole() {
		SaasUser owner=new SaasUser();
		owner.setUsername("user_owner");
		
		Role role1=new Role();
		role1.setName("Admin");
		
		Role role2=new Role();
		role2.setName("Technicain");
		
				
		
		List<Role> list=new ArrayList<Role>();
		list.add(role1);
		list.add(role2);
			
		owner.setRoles(list);
		
		return userRepo.save(owner);
	
	}
	

	private void mockThrowException() {
		throw new RuntimeException("This is mock exception.");
	}

}
