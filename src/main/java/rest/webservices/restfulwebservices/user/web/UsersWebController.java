package rest.webservices.restfulwebservices.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rest.webservices.restfulwebservices.user.User;
import rest.webservices.restfulwebservices.user.jpa.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/web/users")
public class UsersWebController {
    private final UserRepository userRepository;

    public UsersWebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String retrieveAllUsers(Model model) {
        final List<User> allUsers = userRepository.findAll();
        model.addAttribute("usersList", allUsers);

        return "all-users";
    }
}
