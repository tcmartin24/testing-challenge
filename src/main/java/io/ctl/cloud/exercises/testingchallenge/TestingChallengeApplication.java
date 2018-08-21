package io.ctl.cloud.exercises.testingchallenge;

import io.ctl.cloud.exercises.testingchallenge.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestingChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingChallengeApplication.class, args);
    }

    @RequestMapping(path="people", method = RequestMethod.POST)
    public Person createPerson(
            @Validated
            @RequestBody Person person) {
        return person;
    }
}
