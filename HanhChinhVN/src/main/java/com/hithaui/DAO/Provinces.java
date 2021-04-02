package com.hithaui.DAO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;
import org.hibernate.type.TrueFalseType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "provinces")
public class Provinces {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "provinces_id")
	private Integer provincesId;
	
	@Column(name = "name", nullable = false)
	@Nationalized
	private String name;
	
	@Column(name = "slug", nullable = false)
	private String slug;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "name_with_type", nullable = false)
	@Nationalized
	private String name_with_type;
	
	@Column(name = "code", unique = true, nullable = false)
	private String code;
	
	@OneToMany(mappedBy = "provinces", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Districts> districtsList;
	

	public Provinces(String name, String slug, String type, String name_with_type, String code) {
		super();
		this.name = name;
		this.slug = slug;
		this.type = type;
		this.name_with_type = name_with_type;
		this.code = code;
	}

	public Provinces() {
		super();
	}

	public Integer getProvincesId() {
		return provincesId;
	}

	public void setProvincesId(Integer provincesId) {
		this.provincesId = provincesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName_with_type() {
		return name_with_type;
	}

	public void setName_with_type(String name_with_type) {
		this.name_with_type = name_with_type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Districts> getDistrictsList() {
		return districtsList;
	}

	public void setDistrictsList(List<Districts> districtsList) {
		this.districtsList = districtsList;
	}
	
	
	
	
	
}
