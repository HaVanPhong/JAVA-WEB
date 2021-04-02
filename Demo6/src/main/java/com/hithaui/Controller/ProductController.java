package com.hithaui.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hithaui.DAO.Product;
import com.hithaui.Repository.ProductRepository;

@RestController
@RequestMapping("api/product")
@CrossOrigin(methods = { RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET, RequestMethod.PATCH,
		RequestMethod.PUT })
public class ProductController {
	
	@Autowired 
	private Cloudinary cloudinary;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<?> getAllProduct (){
		List<Product> prList = productRepository.findAll();	
		return ResponseEntity.status(200).body(prList);
	}

	@PostMapping
	public ResponseEntity<?> createProduct (@RequestParam("title") String title, @RequestParam("imageLink") MultipartFile imageLink
			) throws IOException{
		
		//lưu vào cloudinary
		Map<?, ?> map= cloudinary.uploader().upload(imageLink.getBytes(), ObjectUtils.emptyMap());
		
		//xóa 
//		Map<?, ?> map2= cloudinary.uploader().destroy("arsjfsk", ObjectUtils.emptyMap());
		System.out.println(map.get("secure_url"));
		
		return null;
	}
}
