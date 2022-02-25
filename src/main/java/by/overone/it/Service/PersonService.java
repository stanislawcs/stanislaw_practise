package by.overone.it.Service;

import by.overone.it.Entity.Person;
import by.overone.it.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
@Autowired
    PersonRepository personRepository;

private void save(Person person){
personRepository.save(person);
}
public void save(String email,String password,String firstName,String secondName){
Person person = new Person();
person.setEmail(email);
person.setPassword(password);
person.setFirstName(firstName);
person.setSecondName(secondName);
save(person);
}
public Person getPersonByEmail(String email){
return personRepository.findPersonByEmail(email);
}


}
