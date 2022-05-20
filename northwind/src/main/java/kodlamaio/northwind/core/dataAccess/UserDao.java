package kodlamaio.northwind.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.core.entites.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	
	
	
}
