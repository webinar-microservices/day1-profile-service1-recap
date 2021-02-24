package in.webinar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;


/**
 * http://localhost:8080/user
 */
@RestController
@RequestMapping("/user")
public class UserProfileService {
	
	@Autowired
	private Faker faker;
	
	/**
	 * http://localhost:8080/user/{id}
	 * http://localhost:8080/user/1
	 * http://localhost:8080/user/2
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public User userProfile(@PathVariable int id) {
		
		// Faker faker = new Faker();
		
		String username = faker.name().username();
		String password = faker.crypto().md5();
		String email = faker.internet().emailAddress();
		String mobile = faker.phoneNumber().cellPhone();
		
		User user = new User(id, username, password, email, mobile);
		return user;
	}

}
