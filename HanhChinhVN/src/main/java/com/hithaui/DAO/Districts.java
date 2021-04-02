package com.hithaui.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

@Entity
@Table(name = "Districts")
public class Districts {
	
	@ManyToOne
	@JoinColumn(name = "provinces_id")
	private Provinces provinces;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="district_Id")
	private Integer districtId;
	
	@Column(name = "name")
	@Nationalized
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "slug")
	private String slug;
	
	@Column(name = "name_with_type")
	@Nationalized
	private String name_with_type;
	
	@Column(name = "path")
	@Nationalized
	private String path;
	
	@Column(name = "path_with_type")
	@Nationalized
	private String path_with_type;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "parent_code")
	private String parent_code;

	public Districts(String name, String type, String slug, String name_with_type, String path,
			String path_with_type, String code, String parent_code) {
		super();
		this.name = name;
		this.type = type;
		this.slug = slug;
		this.name_with_type = name_with_type;
		this.path = path;
		this.path_with_type = path_with_type;
		this.code = code;
		this.parent_code = parent_code;
	}
	public Districts() {
		
	}
	
	
	
	
	public Provinces getProvinces() {
		return provinces;
	}
	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getName_with_type() {
		return name_with_type;
	}
	public void setName_with_type(String name_with_type) {
		this.name_with_type = name_with_type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath_with_type() {
		return path_with_type;
	}
	public void setPath_with_type(String path_with_type) {
		this.path_with_type = path_with_type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	
	
	
	
	

}
