package by.overone.it.validation;

import by.overone.it.entity.Person;
import by.overone.it.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validation {
    @Autowired
    PersonService personService;

    public String registrationValidation(String email, String password,String repassword, String firstName, String secondName) {
        Person person = new Person();
        String message = "";
        if (personService.getPersonByEmail(email) != null) {
            message = " User is already EXIST";
        }

      else if (!password.equals(repassword)) {
            message = "Passwords are different";
        }
    else if (firstName == null || secondName == null) {
            message = "Your names are empty";
        }
return message;
    }
    public String loginValidation(String email,String password){
        String message = "";
        Person person = personService.getPersonByEmail(email);
        if(person == null)
            message="Incorrect email";
else if(!person.getPassword().equals(password))
    message = "Incorrect password";
        return message;
    }
}
