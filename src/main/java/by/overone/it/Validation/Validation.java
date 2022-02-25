package by.overone.it.Validation;

import by.overone.it.Entity.Person;
import by.overone.it.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validation {
    @Autowired
    PersonService personService;

    public String registrationValidation(String email, String password, String firstName, String secondName,String repassword) {
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
