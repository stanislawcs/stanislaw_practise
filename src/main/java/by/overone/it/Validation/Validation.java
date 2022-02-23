package by.overone.it.Validation;

import by.overone.it.Entity.User;
import by.overone.it.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validation {
    @Autowired
    private UserService userService;

    public String LoginValidation(String email, String password) {
        String message = "";
        User user = new User();
        user = userService.getUserByEmail(email);
        if (user == null)
            message = "Not found this email";
        else if (!user.getPassword().equals(password))
            message = "Incorrect password";
        return message;
    }

    public String RegistrationValidation(String email, String password, String firstName, String secondName,String repassword) {
        String message = "";
        if (userService.getUserByEmail(email) != null)
            message = "Email already exist";
        else if (!password.equals(repassword)){
            message = "password mismatched";
             if(firstName==null||secondName==null)
                message="First and second name cannot be empty";
        }
        return message;
    }


}
