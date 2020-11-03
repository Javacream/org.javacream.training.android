package org.javacream.training.android.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleController {
    private static long counter;
    private Map<Long, Person> people;

    {
        people = new HashMap<>();
        for (int i = 100; i < 103; i++){
            people.put((long) i, new Person("last" + i, "first" + i, i, 'd', i));
        }
    }

    public long newPerson(String lastname, String firstname, int height, char gender) {
        counter++;
        Person p = new Person(lastname, firstname, height, gender, counter);
        this.people.put(counter, p);
        return counter;
    }
    public List<Person> findAll(){
        return new ArrayList<>(people.values());
    }
    public int count(){
        return people.size();
    }
}
