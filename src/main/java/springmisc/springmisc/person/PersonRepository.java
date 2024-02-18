package springmisc.springmisc.person;

import org.springframework.data.mongodb.repository.MongoRepository;
import springmisc.springmisc.person.entity.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

}
