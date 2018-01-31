package org.javacream.training.android.people.model;

import java.util.Set;

/**
 * Created by Administrator on 31.01.2018.
 */

public interface PeopleModel {
    Person create(String lastname, String firstname, Character gender, Integer height);

    void delete(long id);

    Person findById(long id);

    Set<Person> findByLastname(String lastname);

    Set<Person> findMales();

    Set<Person> findFemales();

    void update(Person p);
}
