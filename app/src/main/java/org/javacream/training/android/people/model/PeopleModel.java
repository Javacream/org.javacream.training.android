package org.javacream.training.android.people.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PeopleModel {
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

    public void delete(long id){
        people.remove(id);
    }

    public Person findById(long id){
        return people.get(id);
    }

    public Set<Person> findByLastname(final String lastname){
        HashSet<Person> result = new HashSet<>();
        for (Person p: people.values()){
            if (p.getLastname().equals(lastname)){
                result.add(p);
            }
        }
        return result;
    }
    public Set<Person> findMales(){
        HashSet<Person> result = new HashSet<>();
        for (Person p: people.values()){
            if (p.getGender().equals('m') || p.getGender().equals('M')){
                result.add(p);
            }
        }
        return result;
    }
    public Set<Person> findFemales(){
        HashSet<Person> result = new HashSet<>();
        for (Person p: people.values()){
            if (p.getGender().equals('f') || p.getGender().equals('F')){
                result.add(p);
            }
        }
        return result;
    }

    public void update(Person p){
        people.put(p.getId(), p);
    }

    public List<Person> findAll(){
        return new ArrayList<>(people.values());
    }

}
