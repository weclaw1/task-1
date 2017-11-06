package weclaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import weclaw.User;
import weclaw.UserRepository;

@Controller
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {

		User newUser = new User();
		newUser.setName(name);
		newUser.setEmail(email);
		userRepository.save(newUser);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}