package weclaw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import weclaw.domain.ApplicationUser;
import weclaw.repositories.ApplicationUserRepository;;

@Controller
@RequestMapping(path="/user")
public class ApplicationUserController {
	@Autowired
	private ApplicationUserRepository userRepository;

	@RequestMapping(path="/save")
	public String saveApplicationUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email, Model model) {
		ApplicationUser applicationUser = userRepository.findOne(id);
		if( applicationUser == null ) {
			applicationUser = new ApplicationUser();
			applicationUser.setId(id);
		}
		applicationUser.setName(name);
		applicationUser.setEmail(email);
		userRepository.save(applicationUser);

		model.addAttribute("users", userRepository.findAll());
		return "home";
	}

	@RequestMapping(path="/delete")
	public String saveApplicationUser(@RequestParam Long id, Model model) {
		userRepository.delete(id);
		model.addAttribute("users", userRepository.findAll());
		return "home";
	}

}