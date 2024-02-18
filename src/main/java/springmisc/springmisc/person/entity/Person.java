package springmisc.springmisc.person.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Person {

    private @NonNull String name;

    @JsonCreator
    @PersistenceCreator
    @Jacksonized
    @Builder
    public Person(@NonNull String name) {
        this.name = name;
    }
}
