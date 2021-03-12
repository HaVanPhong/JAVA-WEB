package com.hithaui.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.DAO.Category;
import com.hithaui.DAO.Product;
import com.hithaui.DTO.ProductDTO;
import com.hithaui.Exception.NotFoundException;
import com.hithaui.Repositories.CategoryRepositoty;
import com.hithaui.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE })
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepositoty categoryRepositoty;
	
	@GetMapping
	public ResponseEntity<?> getAllProduct(){
		List<Product> listProducts= productRepository.findAll();	
		if (listProducts.size()==0) {
			throw new NotFoundException("Not found any product");
		}
		return ResponseEntity.status(HttpStatus.OK).body(listProducts); 
	}
	
	@PostMapping
	public ResponseEntity<?> createProduct (@RequestBody ProductDTO productDTO){
		Optional<Category> cateOptional=categoryRepositoty.findById(productDTO.getCategoryId());
		if (!cateOptional.isPresent()) {
			throw new NotFoundException("Not found CATEGORY's id: "+productDTO.getCategoryId()+" to add");
		}
		Product product=new Product();
		
		product.setTitle(productDTO.getTitle());
		
		product.setImageLink(productDTO.getImageLink());
		
		product.setDescription(productDTO.getDescription());
		
		product.setAuthor(productDTO.getAuthor());
		
		product.setPrice(productDTO.getPrice());
		
		product.setNumberOfPage(productDTO.getNumberOfPage());
		
		
		product.setCategory(cateOptional.get());		
		
		
		Product product1 =productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product1);
	}
	
	
	
}
