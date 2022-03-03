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
public class RegistrationController {
  private PersonService personService;
  private Validation validation;
    @Autowired
    public RegistrationController(PersonService personService, Validation validation) {
        this.personService = personService;
        this.validation = validation;
    }

    @GetMapping("/registration")
    public String checkYourData(){
        return "r";
    }
    @PostMapping("/registration")
    public String checkForSuccess(@RequestParam("email")String email,
                                  @RequestParam("password") String password,
                                  @RequestParam("repassword")String repassword,
                                  @RequestParam("firstname")String firstName,
                                  @RequestParam("secondname")String secondName,
                                  Model model) {
        String message = validation.registrationValidation(email, password,repassword,firstName, secondName);
        if (!message.isEmpty()) {
            model.addAttribute("message", message);
            return "r";
        }
        else {
            personService.save(email,password,firstName,secondName);
            return "success";
        }
    }

}
