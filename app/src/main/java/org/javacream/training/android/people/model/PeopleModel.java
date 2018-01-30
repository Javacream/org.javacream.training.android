package org.javacream.training.android.people.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class PeopleModel {
    private HashMap<Long, Person> people;

    private Long counter;
    {
        people = new HashMap<>();
        counter = 0l;
    }

    public Person create(String lastname, String firstname, Character gender, Integer height){
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


}
