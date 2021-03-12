package com.hithaui.DTO;

public class CategoryDTO {
	private String name;
	
	private Integer categoryId;
	

	public CategoryDTO(String name, Integer categoryId) {
		this.categoryId=categoryId;
		this.name = name;
	}
	public CategoryDTO() {
	}

	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
