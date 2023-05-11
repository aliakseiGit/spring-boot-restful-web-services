package rest.webservices.restfulwebservices.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rest.webservices.restfulwebservices.user.User;
import rest.webservices.restfulwebservices.user.jpa.UserRepository;

import java.util.List;

@Controller
public class UserWebController {
    private final UserRepository userRepository;

    public UserWebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/web/users")
    public String retrieveAllUsers(Model model) {
        final List<User> allUsers = userRepository.findAll();
        allUsers.forEach(System.out::println);
        model.addAttribute("usersList", allUsers);

        return "all-users";
    }
}
