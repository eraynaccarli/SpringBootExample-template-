package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.entites.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;

public interface UserService {
	
	Result add(User user);
	
	Result delete(Integer userId);
	
	DataResult<List<User>> getAll();
	
	DataResult<User> findByEmail(String email);
	

	
	
}
