package springmisc.springmisc.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import springmisc.springmisc.person.entity.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
class PersonManagerImplTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    PersonManager personManager;

    @Autowired
    PersonRepository personRepository;

    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:5.0.10");

    static {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @AfterEach
    void cleanUpDatabase() {
        mongoTemplate.getDb().drop();
    }

    @Test
    @DisplayName("Test PersonRpository findAll")
    void testPersonRepositorySave() {

        personRepository.save(Person.builder()
                .name("Jason")
                .build()
        );
        var a = personManager.findAll();

        assertThat(a.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test MongoTemplate findAll")
    void testMongoTemplateSave() {
        mongoTemplate.save(Person.builder()
                .name("Jason")
                .build()
        );

        mongoTemplate.save(Person.builder()
                .name("Jérôme")
                .build()
        );

        Query query = new Query().addCriteria(Criteria.where("name").regex("^J"));
        List<Person> personList = mongoTemplate.find(query, Person.class);

        assertThat(personList.size()).isEqualTo(2);
    }


}