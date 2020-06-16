package mvc.contollers;

import mvc.models.User;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String addUser (
                            @RequestParam("name") String name,
                            @RequestParam("age") int age,
                            @RequestParam("pass") String password,
                            @RequestParam("role") String role) {
        userService.addUser(new User(name,age,password,role));
        return "redirect:/";
    }

/*    @RequestMapping(value = "/")
    public String welcome(Model model) {
*//*        model.addAttribute("User", user); //Note This Line*//*
        return "adminHome";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String welcomeUser(@RequestParam("name") String name, Model model) {
        model.addAttribute("userName", name);
        return "adminHome";
    }*/
}

