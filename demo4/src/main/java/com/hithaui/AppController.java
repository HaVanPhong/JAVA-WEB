package com.hithaui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.AstFalse;

@RestController
public class AppController {
	
	List<Person> list =new ArrayList<Person>();
	
	
	@Value("${url.abcc}")	
	public String url;
	
	@GetMapping("/")
	public String home() {
		System.out.println(url);
		return "Hello world";
	}
	
	@GetMapping("/{id}")
	public String homeString (@PathVariable (name ="id") String id) {
		System.out.println(id);
		return "abc";
	}
	
	@GetMapping("/users")
	public List<Person> persons(@RequestParam (name ="ten", required = false) String nameSearch, 
			@RequestParam (name ="age", required=true) Integer ageSearch){
		System.out.println(nameSearch);
		List<Person> lista =new ArrayList<Person>();
//		list.add(new Person("Phong", 20));
//		list.add(new Person("Sao", 21));
//		list.add(new Person("Hung", 20));
//		list.add(new Person("Trang", 20));
//		
		if (nameSearch!=null) {
			List<Person> list2 =new ArrayList<Person>();
			for (int i=0; i<list.size(); i++) {
				if (nameSearch.toLowerCase().contains(list.get(i).getNameString().toLowerCase()) && ageSearch==list.get(i).getAgeInteger() )
					list2.add(list.get(i));
			}
			if (list2.size()>0)
			return list2;
		}
		if (lista.size()==0) {
			throw new NotFoundException("Khoong cos dữ liệu đâu");
		}
		return lista;
	}
	@GetMapping("/user")
	public List<Person> persons(){
		list.add(new Person("Phong", 20));
		list.add(new Person("Sao", 21));
		list.add(new Person("Hung", 20));
		list.add(new Person("Trang", 20));
		
		return list;
	}
	
	@PostMapping("/users/create")
	public Person  create (@RequestBody(required = false) Person person) {
		System.out.println(person.getNameString());
		System.out.println(person.getAgeInteger());
		list.add(person);
		return person;
	}
	
}
