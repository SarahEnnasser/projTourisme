package org.trsm.web;


import java.util.List;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.trsm.repository.UserRepository;
import org.trsm.exception.*;


import org.trsm.entities.*;




@RestController
public class UserController {
	private final UserRepository repository;
	UserController(UserRepository repository){
		this.repository=repository;
	}
	
	@GetMapping("/users")
	List<User> all() {
	    return repository.findAll();
	  }
	
	@PostMapping("/users")
	User newEmployee(@RequestBody User newUser) {
		return repository.save(newUser);
	}

	// Single item
	
	@GetMapping("/users/{id}")
	User one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/users/{id}")
	User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(user -> {
				user.setRole(newUser.getRole());
				user.setFirstName(newUser.getFirstName());
				user.setLastName(newUser.getLastName());

				return repository.save(user);
			})
			.orElseGet(() -> {
				newUser.setId(id);
				return repository.save(newUser);
			});
	}

	@DeleteMapping("/users/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}


}
