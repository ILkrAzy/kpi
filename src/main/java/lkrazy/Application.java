package lkrazy;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lkrazy.pojo.User;
import lkrazy.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		System.out.println("DataSource = " + dataSource);
		User user = new User("ddlanh", "ddlanh", "ddlanh@tma.com.vn", "Lanh", "Dang", 1);
		userRepository.save(user);
		List<User> users = (List<User>) userRepository.findAll();
		System.out.println(users);
	}
}
