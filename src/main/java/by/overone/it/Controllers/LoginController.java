package by.overone.it.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping({"/","/login"})
    public String inputYourData(){
        return "login_page";
    }
    @PostMapping("/login")
    public String checkYourData(@RequestParam("email") String email,
                                @RequestParam("password")String password,
                                Model model){

        return "Successful_log";
    }
}
