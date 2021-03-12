package com.hithaui.DAO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Products")
public class Product {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "title")
	@Nationalized
	private String title;
	
	@Column(name = "image_link", unique = true)
	private String imageLink;
	
	@Column(name = "Desciption")
	private  String description;
	
	@Column(name ="author")
	private String author;
	
	@Column(name = "Price")
	private Long price;
	
	@Column(name = "total_page")
	private Integer numberOfPage;
	
	//------------------------------
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;
	
	@CreationTimestamp
	private Timestamp createAt;
	@UpdateTimestamp
	private Timestamp updateAt;
	
	
//	private  Integer categoryId;
//	
//	
//	
//
//	public Integer getCategoryId() {
//		return categoryId;
//	}
//	public void setCategoryId(Integer categoryId) {
//		this.categoryId = categoryId;
//	}
	public Product(Integer productId, String title, String imageLink, String description, String author, Long price,
			Integer numberOfPage, Timestamp createAt, Timestamp updateAt) {
		
		this.productId = productId;
		this.title = title;
		this.imageLink = imageLink;
		this.description = description;
		this.author = author;
		this.price = price;
		this.numberOfPage = numberOfPage;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	public Product () {
		
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
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
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public Timestamp getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
	
	
	

}
