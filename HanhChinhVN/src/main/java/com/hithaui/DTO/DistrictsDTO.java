package com.hithaui.DTO;

public class DistrictsDTO {
	private String name;

	private String type;

	private String code;

	private String parent_code;

	public DistrictsDTO(String name, String type, String code, String parent_code) {
		super();
		this.name = name;
		this.type = type;
		this.code = code;
		this.parent_code = parent_code;
	}

	public DistrictsDTO() {
		super();
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
