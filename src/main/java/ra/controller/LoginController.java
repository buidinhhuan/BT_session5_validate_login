package ra.controller;

 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.User;


import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/")
    public ModelAndView inputForm(){
        return new ModelAndView("index","user",new User());
    }
    @PostMapping("/")
    public String submitForm(@Valid @ModelAttribute User user,BindingResult bindingResult, Model model){
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        } else {
            model.addAttribute("successful", "Register successfully!");
            model.addAttribute("user", user);
            return "result";
        }
    }
}