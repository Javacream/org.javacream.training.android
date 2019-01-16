package org.javacream.training.android.people.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MapPeopleModel implements PeopleModel {
    private HashMap<Long, Person> people;

    private Long counter;
    {
        final long CREATE_PEOPLE_NUMBER = 5;
        people = new HashMap<>();
        for (long i = 0; i < CREATE_PEOPLE_NUMBER; i++){
            Person p = new Person();
            p.setId(i);
            p.setLastname("Muster" + i);
            p.setFirstname("Mann" + i);
            p.setGender('X');
            p.setHeight(170 + (int)i);
            people.put(i, p);
        }
        counter = CREATE_PEOPLE_NUMBER;
    }

    @Override
    public Person create(String lastname, String firstname, Character gender, Integer height){
        //Simulation einer lang-dauernden Aktion
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Person person = new Person(counter++, lastname, firstname, gender, height);
        people.put(person.getId(), person);
        return person;
    }

    @Override
    public void delete(long id){
        people.remove(id);
    }

    @Override
    public Person findById(long id){
        return people.get(id);
    }

    @Override
    public void update(Person p){
        people.put(p.getId(), p);
    }

    @Override
    public List<Person> findAll(){
        return new ArrayList<>(people.values());
    }

}
