package com.hithaui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@GetMapping("/students")
	public ModelAndView home () {
		ModelAndView modelAndView =new ModelAndView("index");
		List<PersonVIP> listPerson =new ArrayList<PersonVIP>();
		
		listPerson.add( new PersonVIP(43, "Vũ Văn Doan", "AnhDoan@gmail.com", "Nam Định City"));
		listPerson.add( new PersonVIP(75, "Bùi Tất Trung", "AnhTatTrung@gmail.com", "Hà Nội City"));
		listPerson.add( new PersonVIP(46, "Nguyễn Đức Điệp", "AnhDiep@gmail.com", "HaNoi City"));
		listPerson.add( new PersonVIP(49, "Hoàng Duy Khánh", "AnhKhanh@gmail.com", "Hải Phòng City"));
		listPerson.add( new PersonVIP(97, "Cao Thế Thắng", "AnhThang@gmail.com", "Vĩnh Phúc City"));
		modelAndView.addObject("listPerson", listPerson);
		return modelAndView;		
	}
	
	

}
