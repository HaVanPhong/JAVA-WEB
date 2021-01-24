package com.hithaui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AppController {
	
	@GetMapping("/students")
	public ModelAndView home() {
		ModelAndView modelAndView =new ModelAndView("table");
		List<Integer> listID =new ArrayList<>();
		
		
		List<String> listPerson1 =new ArrayList<String>();
		listPerson1.add("43");
		listPerson1.add("Vũ Văn Doan");
		listPerson1.add("AnhDoanVu@gmail.com");
		listPerson1.add("Nam Định City");
		List<String> listPerson2 =new ArrayList<String>();
		listPerson2.add("75");
		listPerson2.add("Bùi Tất Trung");
		listPerson2.add("AnhTatTrung@gmail.com");
		listPerson2.add("Hà Nội City");
		List<String> listPerson3 =new ArrayList<String>();
		listPerson3.add("46");
		listPerson3.add("Nguyễn Đức Điệp");
		listPerson3.add("AnhDiepDuc@gmail.com");
		listPerson3.add("Hanoi City");
		List<String> listPerson4 =new ArrayList<String>();
		listPerson4.add("49");
		listPerson4.add("Hoàng Duy Khánh");
		listPerson4.add("AnhKhanhDuy@gmail.com");
		listPerson4.add("Hải Phòng City");
		List<String> listPerson5 =new ArrayList<String>();
		listPerson5.add("98");
		listPerson5.add("Cao Thế Thắng");
		listPerson5.add("AnhThang@gmail.com");
		listPerson5.add("Vĩnh Phúc City");
		
		List<String> titleList =new ArrayList<String>();
		titleList.add("ID");
		titleList.add("Name");
		titleList.add("Email");
		titleList.add("Address");
		
		modelAndView.addObject("listPerson1", listPerson1);
		modelAndView.addObject("listPerson2", listPerson2);
		modelAndView.addObject("listPerson3", listPerson3);
		modelAndView.addObject("listPerson4", listPerson4);	
		modelAndView.addObject("listPerson5", listPerson5);	
		modelAndView.addObject("titleList" , titleList);
		
		String str="VIP PRO";
		modelAndView.addObject("std", str);
		
		return modelAndView;		
	}
	

}
