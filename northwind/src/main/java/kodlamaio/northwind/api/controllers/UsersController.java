package kodlamaio.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entites.User;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Integer userId){
		return ResponseEntity.ok(this.userService.delete(userId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.userService.getAll());
	}
	
	
	@PostMapping("/findByEmail")
	public ResponseEntity<?> findByEmail(@RequestParam String email){
		return ResponseEntity.ok(this.userService.findByEmail(email));
	}
	
	//Sistemde bir hata olursa 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) // bu method default olarak Bad request dönsün
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){ // bu methodları(exceptions) cagır 
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) { // hataları foreach ile dön 
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage()); // listeye ekle 
		}
		
		// validationError ları ErrorDataResult a çeviriyoruz
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation Errors");
		return errors;
	
	}
	
	
}
