package com.hithaui.DTO;

import javassist.bytecode.analysis.MultiArrayType;

public class ProductDTO {
	
	
	
	private String title;
	
	
	private MultiArrayType imageLink;
	
	
	private  String description;

	private String author;
	

	private Long price;

	private Integer numberOfPage;

	public ProductDTO(String title, MultiArrayType imageLink, String description, String author, Long price,
			Integer numberOfPage) {
		super();
		this.title = title;
		this.imageLink = imageLink;
		this.description = description;
		this.author = author;
		this.price = price;
		this.numberOfPage = numberOfPage;
	}
	
	public ProductDTO() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultiArrayType getImageLink() {
		return imageLink;
	}

	public void setImageLink(MultiArrayType imageLink) {
		this.imageLink = imageLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(Integer numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	
}
