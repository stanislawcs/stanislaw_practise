package by.overone.it.Service;

import by.overone.it.Entity.User;
import by.overone.it.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private void save(User user){
userRepository.save(user);
    }
    public void save(String email,String password,String firstName,String secondName){
User user = new User();
user.setEmail(email);
user.setPassword(password);
user.setFirstName(firstName);
user.setSecondName(secondName);
save(user);
    }
    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
