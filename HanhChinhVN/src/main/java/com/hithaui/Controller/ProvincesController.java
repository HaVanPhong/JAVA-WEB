package com.hithaui.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.DAO.Provinces;
import com.hithaui.DTO.ProvincesDTO;
import com.hithaui.Exception.Duplicate;
import com.hithaui.Exception.NotFound;
import com.hithaui.Helper.ConvertObject;
import com.hithaui.Repository.ProvincesRepository;

@RestController
@RequestMapping("/api/provinces")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.DELETE, RequestMethod.POST})
public class ProvincesController {
	@Autowired
	private ProvincesRepository provincesRepository;
	
	@GetMapping
	public ResponseEntity<?> getAllProvinces(){
		List<Provinces> list=provincesRepository.findAll();
		if (list.size()==0)
			throw new NotFound("danh sách tỉnh trống");
		return ResponseEntity.status(200).body(list);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllProvinces(@PathVariable (name = "id") Integer id){
		Optional<Provinces> province=provincesRepository.findById(id.intValue());
		if (!province.isPresent())
			throw new NotFound("Không tìm thấy tình có id là: "+id);
		return ResponseEntity.status(200).body(province.get());
	}
	
	@GetMapping("/code/{provinces_code}")
	public ResponseEntity<?> getProvincesByCode(@PathVariable (name = "provinces_code") String code){
		Provinces prOptional=provincesRepository.findByCode(code);
		if (prOptional==null)
			throw new NotFound("Không tìm thấy tỉnh có code: "+code);
		return ResponseEntity.status(200).body(prOptional);
	}
	@GetMapping("/{code}/districts")
	public ResponseEntity<?> GetProvincesByCodeWithAllDistricts(@PathVariable (name = "code") String code){
		Provinces provinces=provincesRepository.findByCode(code);
		return ResponseEntity.status(200).body(provinces.getDistrictsList());
	}
	
	@PostMapping
	public ResponseEntity<?> createProvinces(@RequestBody ProvincesDTO provincesDTO){
		Provinces provinces =provincesRepository.findByCode(provincesDTO.getCode());
		if(provinces!=null)
			throw new Duplicate("mã Code: "+provincesDTO.getCode()+" đã tồn tại");     
		Provinces provinces2=ConvertObject.ConvertProvinceDTOtoDAO(provincesDTO);
		Provinces provinces3=provincesRepository.save(provinces2);
		return ResponseEntity.status(201).body(provinces3);
	}
	@PostMapping("/province-collection")
	public ResponseEntity<?> createProvinces(@RequestBody List<ProvincesDTO> provincesDTOs) {
		List<Provinces> provinces=new LinkedList<Provinces>();
		
		int size=provincesDTOs.size();
		for (int i=0; i<size; i++) {
			Provinces provinces2=new Provinces();
			provinces2= ConvertObject.ConvertProvinceDTOtoDAO(provincesDTOs.get(i));
			provinces.add(provinces2);
		}
		List<Provinces> provinces2 = provincesRepository.saveAll(provinces);
		return ResponseEntity.status(201).body(provinces2);
	}
	
	@DeleteMapping ("/{code}")
	public ResponseEntity<?> deleteProvinces(@PathVariable(name = "code") String code){
		Provinces provinces =provincesRepository.findByCode(code);
		if(provinces==null)
			throw new NotFound("Không tìm thấy tỉnh có code: "+code+" để xóa");
		provincesRepository.delete(provinces);
		return ResponseEntity.status(200).build();
	}
	@DeleteMapping("/delete-all-provinces")
	public ResponseEntity<?> deleteAllProvinces(){
		provincesRepository.deleteAll();
		return ResponseEntity.status(HttpStatus.OK.value()).build();
	}
//	
//	@PatchMapping("/{code}")
//	public ResponseEntity<?> editProvinces(@RequestBody ProvincesDTO provincesDTO){
//		Provinces provinces=provincesRepository.findByCode(provincesDTO.getCode());
//		if (provinces==null)
//			throw new NotFound("Không tìm thấy code: "+provincesDTO.getCode()+" để sửa");
//		provinces.setName(provincesDTO.getName());
//		provinces.set
//	}
//	
	
	
	
	
}
