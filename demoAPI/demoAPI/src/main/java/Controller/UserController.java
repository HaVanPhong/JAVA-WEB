package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Model.User;
import Model.UserDTO;
import repository.Repository;

@RestController
public class UserController {
	private List<User> users =new ArrayList<User>();
	private Repository repository;
	
	@PostMapping("/users")
	public ResponseEntity<?> create (@RequestBody UserDTO userDTO) {
		User user = new User(userDTO.getName(), userDTO.getAge());
		User user2 = repository.save(user);
		return ResponseEntity.ok().body(user2);
	}
	
	@GetMapping("/users")
	public List<User> getAll(){
		return repository.findAll();
	}
			
}
