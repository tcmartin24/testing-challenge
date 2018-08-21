package io.ctl.cloud.exercises.testingchallenge;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ctl.cloud.exercises.testingchallenge.model.Person;
import io.ctl.cloud.exercises.testingchallenge.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestingChallengeApplicationTests {

//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private WebTestClient client;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PersonService personService;


    @Autowired
    private TestingChallengeApplication application;

    @Test
    public void lastNameCanNotBeBlank() throws Exception {

        Person person = new Person();
        person.setFirstName("Terry");

        HttpEntity<Person> entity = new HttpEntity<>(person);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/people", HttpMethod.POST, entity, String.class);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        JsonNode jsonNode = new ObjectMapper().readTree(response.getBody());
        assertThat(jsonNode.at("/errors").size()).as("There should only be 1 error").isEqualTo(1);
        assertThat(jsonNode.at("/errors/0/defaultMessage").asText()).as("Last name not blank error should exist").isEqualTo("Last name must not be blank");

    }

    @Test
    public void canSetDate() throws Exception {
        Person person = new Person();
        person.setFirstName("Terry");
        person.setLastName("Martin");
//        person.setDob(ZonedDateTime.of(1974, Month.SEPTEMBER, 23, 10, 30, 0, 0, ZoneId.from(TemporalAccessor.)));

        HttpEntity<Person> entity = new HttpEntity<>(person);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/people", HttpMethod.POST, entity, String.class);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        JsonNode jsonNode = new ObjectMapper().readTree(response.getBody());
        assertThat(jsonNode.at("/errors").size()).as("There should only be 1 error").isEqualTo(1);
        assertThat(jsonNode.at("/errors/0/defaultMessage").asText()).as("Last name not blank error should exist").isEqualTo("Last name must not be blank");

    }

}
