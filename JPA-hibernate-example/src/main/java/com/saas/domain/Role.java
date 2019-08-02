package com.saas.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=20)
	private String name;

	private Integer type;

	@Column(length=200)
	private String url;

	//bi-directional many-to-many association to SaasUser
	@ManyToMany(mappedBy="roles")
	private List<SaasUser> saasUsers;

	public Role() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<SaasUser> getSaasUsers() {
		return this.saasUsers;
	}

	public void setSaasUsers(List<SaasUser> saasUsers) {
		this.saasUsers = saasUsers;
	}

}