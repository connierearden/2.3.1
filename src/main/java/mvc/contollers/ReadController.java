package mvc.contollers;

import mvc.models.User;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("users", list);
        return "adminHome";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String delete(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "redirect:/";
    }

    @RequestMapping(value = "/update/{id}/{name}/{age}/{pass}", method = RequestMethod.GET)
    public String redirectToUpdate (@PathVariable Long id,
                                    @PathVariable String name,
                                    @PathVariable int age,
                                    @PathVariable String pass,
                                    Model model) {
        //User user = userService.getUserById(userId); - org.springframework.web.util.NestedServletException:
        // Request processing failed; nested exception is org.hibernate.LazyInitializationException
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("password", pass);
        model.addAttribute("role", "role");
        return "update";
    }

    @RequestMapping(value = "/update/{id}/{name}/{age}/{pass}", method = RequestMethod.POST)
    public String update (@PathVariable Long id,
                          @PathVariable String name,
                          @PathVariable int age,
                          @PathVariable String pass) {
        userService.updateUser(id,name,age,pass,"role");
        return "adminHome";
    }
}
