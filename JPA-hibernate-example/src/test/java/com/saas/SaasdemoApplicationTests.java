package com.saas;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.saas.domain.Role;
import com.saas.domain.SaasUser;
import com.saas.dto.UserMapp;
import com.saas.repository.RoleRepository;
import com.saas.repository.UserRepository;
import com.saas.service.BusinessService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaasdemoApplicationTests {
    
	@Autowired
	private BusinessService service;
	
	 @Autowired
	 private UserRepository userRepo;
	 
	 @Autowired
	 private RoleRepository roleRepo;
	 
	 @Before
	 public void init() {
		 
	 }
	 @After
	 public void destory() {
		 
		 userRepo.deleteAll();
		 roleRepo.deleteAll();
	 }
	
	@Test
	//@Transactional
	//@Rollback(true)
	public void test_user_add() {
		
		SaasUser user=service.createUser(false);
		Assert.assertTrue(user.getId()!=null);
		Assert.assertTrue(userRepo.count()==1);
		
		
	}

	@Test
	public void test_mapped_role_and_user() {
		//验证关联操作 saas_user is owner.
		SaasUser owner=new SaasUser();
		owner.setUsername("user_owner");
		userRepo.save(owner);
		
		Role role1=new Role();
		role1.setName("Admin");
				
		
		List<SaasUser> uList=new ArrayList<SaasUser>();
		uList.add(owner);
		
		role1.setSaasUsers(uList);
		roleRepo.save(role1);
		
		
		
		Assert.assertTrue(roleRepo.count()==1);
		Assert.assertTrue(userRepo.count()==1);
		
		//In first core memory but not persistent in database;
		SaasUser newu=userRepo.findById(owner.getId()).get();
		Assert.assertTrue(newu.getRoles()!=null);
		//
		List<UserMapp> mapp=userRepo.findMiddleTable(owner.getId());
		
		Assert.assertTrue(mapp.isEmpty());
		
		
	}
	 @Test(expected=Exception.class)
	public void test_mapped_user_and_role() {
		//验证关联操作 saas_user is owner.
		
		
		Role role1=new Role();
		role1.setName("Admin");
		
		//roleRepo.save(role1);
		
		SaasUser owner=new SaasUser();
		owner.setUsername("user_owner");
		
		List<Role> rlist=new ArrayList<Role>();
		rlist.add(role1);
		owner.setRoles(rlist);
		userRepo.save(owner);
		
		
		
		Assert.assertTrue(roleRepo.count()==1);
		Assert.assertTrue(userRepo.count()==1);
		
		Role new_role=roleRepo.findById(role1.getId()).get();
		
		Assert.assertTrue(new_role.getSaasUsers()!=null);
		
		
		
	}
	@Test	
	public void test_owner_is_user_and_native_query() {
		Role role1=new Role();
		role1.setName("Admin");
		roleRepo.save(role1);
		
		SaasUser owner=new SaasUser();
		owner.setUsername("user_owner2");
		
		List<Role> rlist=new ArrayList<Role>();
		rlist.add(role1);
		owner.setRoles(rlist);
		//
		userRepo.save(owner);
		
		
		Assert.assertTrue(roleRepo.count()==1);
		Assert.assertTrue(userRepo.count()==1);
		
		Role new_role=roleRepo.findById(role1.getId()).get();		
		Assert.assertTrue(new_role.getSaasUsers()!=null);
		// middle table native query
        List<UserMapp> mapp=userRepo.findMiddleTable(owner.getId());		
		Assert.assertTrue(!mapp.isEmpty());//not empty
		Integer userid_db=mapp.get(0).getUserid();
		Assert.assertEquals(userid_db, owner.getId());
		Assert.assertEquals(mapp.get(0).getRoleid(),role1.getId());
		
	}

}
