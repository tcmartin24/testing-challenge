package io.ctl.cloud.exercises.testingchallenge.repository;

import io.ctl.cloud.exercises.testingchallenge.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
