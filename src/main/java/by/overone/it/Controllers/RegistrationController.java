package by.overone.it.Controllers;

import by.overone.it.Service.PersonService;
import by.overone.it.Validation.Validation;
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
                                  @RequestParam("firstName")String firstName,
                                  @RequestParam("secondName")String secondName,
                                  @RequestParam("repassword")String repassword,
                                  Model model) {
        String message = validation.registrationValidation(email, password,firstName, secondName,repassword);
        if (!message.isEmpty()) {
            model.addAttribute("message", message);
            return "r";
        }
        else {
            personService.save(email,password,firstName,secondName);
            return "Success";
        }
    }

}
