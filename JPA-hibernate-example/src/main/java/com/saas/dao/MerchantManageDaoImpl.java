/**
 * 
 */
package com.saas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.saas.domain.Product;
import com.saas.domain.ProductType;
import com.saas.domain.SaasUser;
import com.saas.dto.ProductWithTypeName;

/**
 * @author yangliu
 *
 */
@Transactional
@Component("merchantManageDao")
public class MerchantManageDaoImpl implements MerchantManageDao {
	
	@PersistenceContext
    private EntityManager em;
	
	
	

	@Override
	public SaasUser grantAuthority(SaasUser user) {
		em.persist(user);
		return user;
	}

	@Override
	public Product createProductAndType(Product p, ProductType type) {
		em.persist(type);
		p.setProductTypeBean(type);
		em.persist(p);
		return p;
	}

	@Override
	public List<ProductWithTypeName> queryProduct(String prodectName,String typeName) {
		String sql="select p.id as prodectId, p.name as productName,type.id as typeId,type.name as typeName "
				+ " from product p left join product_type type on p.product_type =type.id";
		//Add parameter
		// Can not return Object that is not Entity.
		Query query=em.createNativeQuery(sql, ProductWithTypeName.class);
		//SessionFactory sessionFactory = em.unwrap(SessionFactory.class);
		//sessionFactory.openSession().cre
		return query.getResultList();
	}

	@Override
	public void delete(Class entityclass, Object key) {
		Object one=em.find(entityclass, key);
		if(one!=null) {
			em.remove(one);
		}
	}

}
