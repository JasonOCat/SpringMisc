package springmisc.springmisc.person;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springmisc.springmisc.person.entity.Person;

import java.util.List;

public interface PersonManager {

    @NonNull List<Person> findAll();
}
