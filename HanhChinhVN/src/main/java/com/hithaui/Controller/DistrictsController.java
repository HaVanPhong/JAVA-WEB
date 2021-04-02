package com.hithaui.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hithaui.DAO.Districts;
import com.hithaui.DAO.Provinces;
import com.hithaui.DTO.DistrictsDTO;
import com.hithaui.Exception.Duplicate;
import com.hithaui.Exception.NotFound;
import com.hithaui.Helper.ConvertObject;
import com.hithaui.Repository.DistrictsRepository;
import com.hithaui.Repository.ProvincesRepository;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE})
public class DistrictsController {

	@Autowired
	private DistrictsRepository districtsRepository;

	@Autowired
	private ProvincesRepository provincesRepository;

	@GetMapping
	public ResponseEntity<?> getAllDistrict() {
		List<Districts> list = districtsRepository.findAll();
		if (list.size() == 0) {
			throw new NotFound("danh sách Districts trống");
		}
		return ResponseEntity.status(200).body(list);
	}

	@GetMapping("/{code}")
	public ResponseEntity<?> getDistrictByCode(@PathVariable(name = "code") String code) {
		Districts districts = districtsRepository.findByCode(code);
		if (districts == null) {
			throw new NotFound("Districts's Code was not exists");
		}
		return ResponseEntity.status(200).body(districts);
	}

	@PostMapping
	public ResponseEntity<?> createDistrict(@RequestBody DistrictsDTO districtsDTO) {
		Districts districts1 = districtsRepository.findByCode(districtsDTO.getCode());
		if (districts1 != null) {
			throw new Duplicate("Districts has ready exists");
		}

		Districts districts = new Districts();
		districts = ConvertObject.ConvertDistrictDTOtoDAO(districtsDTO);

		Provinces provinces = provincesRepository.findByCode(districtsDTO.getParent_code());
		if (provinces == null) {
			throw new NotFound("Parent code not exists");
		}
		districts.setPath(districtsDTO.getName() + ", " + provinces.getName());
		districts.setPath_with_type(districts.getName_with_type() + ", " + provinces.getName_with_type());
		districts.setProvinces(provinces);
		Districts districts2 = districtsRepository.save(districts);
		return ResponseEntity.status(201).body(districts2);
	}

	@DeleteMapping("/{codee}")
	public ResponseEntity<?> deleteDistrictsByCode(@PathVariable(name = "codee") String code) {
		Districts districts = districtsRepository.findByCode(code);
		if (districts == null) {
			throw new NotFound("Not found district with code: " + code);
		}
		districtsRepository.delete(districts);
		return ResponseEntity.status(200).build();
	}

	@DeleteMapping("/delete-all-districts")
	public ResponseEntity<?> deleteAll() {
		districtsRepository.deleteAll();
		return ResponseEntity.status(200).build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> editDistrictsByCode(@PathVariable(name = "id") Integer id,
			@RequestBody DistrictsDTO districtsDTO) {
		Optional<Districts> districts1 = districtsRepository.findById(id);
		if (!districts1.isPresent()) {
			throw new NotFound("Id was not found");
		}
		Districts districts= districts1.get();
		
		String name=districtsDTO.getName();
		String slug= ConvertObject.slugify(name);
		String code=districtsDTO.getCode();
		String type=districtsDTO.getType();
		String parentCode=districtsDTO.getParent_code();
		districts.setName(name);
		districts.setType(type);
		districts.setSlug(slug);
		districts.setCode(code);
		if(districtsDTO.getType().compareTo("quan")==0) {
			districts.setName_with_type("Quận "+name);
		}else if (districtsDTO.getType().compareTo("huyen")==0){
			districts.setName_with_type("Huyện "+name);
		}else {
			districts.setName_with_type("Thành Phố "+name);
		}
		districts.setParent_code(parentCode);
		Provinces provinces = provincesRepository.findByCode(districtsDTO.getParent_code());
		if (provinces == null) {
			throw new NotFound("Parent code not exists");
		}
		districts.setPath(districtsDTO.getName() + ", " + provinces.getName());
		districts.setPath_with_type(districts.getName_with_type() + ", " + provinces.getName_with_type());
		districts.setProvinces(provinces);
		Districts districts2 = districtsRepository.save(districts);
		return ResponseEntity.status(201).body(districts2);
		
		
	}

}
