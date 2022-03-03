package by.overone.it.controllers;

import by.overone.it.service.PersonService;
import by.overone.it.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private PersonService personService;
    private Validation validation;
    @Autowired
    public LoginController(PersonService personService, Validation validation) {
        this.personService = personService;
        this.validation = validation;
    }



    @GetMapping({"/","/login"})
    public String inputYourData(){
        return "login_page";
    }

    @PostMapping ({"/","/login"})
    public String IsSuccessLogin(@RequestParam("email")String email,
                                 @RequestParam("password")String password,
                                 Model model){
        String message =validation.loginValidation(email,password);
        if(!message.isEmpty()){
            model.addAttribute("message",message);
            return "login_page";
        }
        else{
        return "successful_log";
        }
    }
}
