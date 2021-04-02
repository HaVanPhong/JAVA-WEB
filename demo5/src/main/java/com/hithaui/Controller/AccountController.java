package com.hithaui.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.DTO.AccountDTO;
import com.hithaui.Repositories.AccountRepository;
import com.hithaui.dao.AccountDAO;

@RestController
@RequestMapping("/api/accounts") //router
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
public class AccountController {
	
	@Autowired
	public AccountRepository acountRepository;
	
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam (value = "page", required = false) Integer page){
		if (page!=null) {
//			List<AccountDAO> list =(List<AccountDAO>) acountRepository.findAll(PageRequest.of(page.intValue(), 10));
			Page<AccountDAO> listAccountOfPage = acountRepository.findAll(PageRequest.of(page.intValue(), 10));
			
			List<AccountDAO> list = listAccountOfPage.getContent();
			if (list.size()==0) 
				return ResponseEntity.status(204).build();
			return ResponseEntity.status(200).body(list);
		}
		
		
		List<AccountDAO> list=  acountRepository.findAll();
		if(list.size()==0)
		return ResponseEntity.status(204).build(); 
		return ResponseEntity.status(200).body(list);
	}
	
	//pagination
//	@GetMapping("/page")
//	public ResponseEntity<?> getAccountsByPagination(@RequestParam ("page") Integer page){
////		List<AccountDAO> list =(List<AccountDAO>) acountRepository.findAll(PageRequest.of(page.intValue(), 10));
//		
//		Page<AccountDAO> listAccountOfPage = acountRepository.findAll(PageRequest.of(page.intValue(), 10));
//		
//		List<AccountDAO> list = listAccountOfPage.getContent();
//		
//		return ResponseEntity.status(200).body(list);
//	}

	
	@PostMapping("/post")
	public ResponseEntity<?> Create (@RequestBody AccountDTO accountDTO){
		AccountDAO accountDAO= new AccountDAO();
		
//		AccountDAO accountDAO1= acountRepository.findByUsername(accountDTO.getUserName());
//		if (accountDAO1==null) {
//			Duplicate Exception
//		}
		
		accountDAO.setUserName(accountDTO.getUserName());
		accountDAO.setPassword(accountDTO.getPassword()); 
	
		AccountDAO accountDAO2= acountRepository.save(accountDAO);
		return ResponseEntity.status(200).body(accountDAO2);
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<?> getAccountById(@PathVariable ("accountId") Long accountID){
		java.util.Optional<AccountDAO> accountDAO= acountRepository.findById(accountID);
		return ResponseEntity.status(200).body(accountDAO.get());
	}
	
	@PatchMapping("/{accountId}")
	public ResponseEntity<?> PatchAccountById(@PathVariable ("accountId") Long accountID, @RequestBody AccountDTO accountDTO){
		java.util.Optional<AccountDAO> optional= acountRepository.findById(accountID);
		AccountDAO accountDAO=optional.get();
		accountDAO.setPassword(accountDTO.getPassword());
		
		AccountDAO newAccountDAO=acountRepository.save(accountDAO);
		
		return ResponseEntity.status(200).body(newAccountDAO);
		
	}
	@DeleteMapping("/{accountID}")
	public ResponseEntity<?> deletById (@PathVariable ("accountID") Long accountID ){
		acountRepository.deleteById(accountID);
		return ResponseEntity.status(200).build();
	}
	
	
	
	
}
