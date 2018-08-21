package io.ctl.cloud.exercises.testingchallenge.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;

@Data
public class Person {
    @Id
    private Long id;
    @NotEmpty(message = "First name must not be blank")
    private String firstName;

    @NotEmpty(message = "Last name must not be blank")
    private String lastName;

//    @Past(message = "Date of birth must be in the past")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dob;

}
