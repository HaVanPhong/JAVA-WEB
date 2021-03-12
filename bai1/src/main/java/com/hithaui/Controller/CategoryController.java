package com.hithaui.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.DAO.Category;
import com.hithaui.DTO.CategoryDTO;
import com.hithaui.Exception.NotFoundException;
import com.hithaui.Repositories.CategoryRepositoty;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepositoty categoryRepository;
	

	@GetMapping
	public ResponseEntity<?> getAllCategories(){
		List<Category> list = categoryRepository.findAll();
		if (list.size()==0) {
			throw new NotFoundException("Không có dữ liệu");
		}			
		return ResponseEntity.status(200).body(list);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
		Optional<Category> cateOptional = categoryRepository.findById(id);
		if (!cateOptional.isPresent()) {
			throw new NotFoundException("Not found student by studentId " + id);
		}
		return ResponseEntity.status(HttpStatus.OK).body(cateOptional.get().getListProduct());
	}
	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
		
		Category oldcategory= categoryRepository.findByName(categoryDTO.getName());
		if (oldcategory!=null ) {
			throw new NotFoundException("Tên này đã tồn tại");
		}
				
		
		Category category=new Category();
		category.setName(categoryDTO.getName());	

		Category newCategory= categoryRepository.save(category);
		return ResponseEntity.status(201).body(newCategory);
	}
	
	
	//delete by type param
	@DeleteMapping
	public ResponseEntity<?> deleteById(@RequestParam(name = "id") Integer id){
		Optional<Category> cateOptional= categoryRepository.findById(id);
		if (cateOptional.isPresent()) {
			categoryRepository.deleteById(id);
			return ResponseEntity.status(200).build();
		}
		throw new NotFoundException("Không tồn tại id yêu cầu");
	}
	
//	delete by url
	@DeleteMapping("/{ctgid}")
	public ResponseEntity<?> delateCategory(@PathVariable(name = "ctgid") Integer id){
		Optional<Category> catOptional=categoryRepository.findById(id);
		if (catOptional.isPresent()) {
			categoryRepository.deleteById(id);
			return ResponseEntity.status(200).build();
		}
		throw new NotFoundException("id was not found");
	}
	
	//edit by url
	@PutMapping("/{id}")
	public ResponseEntity<?> putCategory (@PathVariable (name = "id") Integer id, @RequestBody CategoryDTO categoryDTO){
		Optional<Category> cateOptional = categoryRepository.findById(id);
		if (!cateOptional.isPresent()) {
			throw new NotFoundException("Not found id: "+id+" of category to edit");
		}
		Category category=cateOptional.get();
		if (categoryDTO.getName()!=null)
			category.setName(categoryDTO.getName());
		Category category2= categoryRepository.save(category);
		return ResponseEntity.status(200).body(category2); 
			
	}
	
	
	
	
}
