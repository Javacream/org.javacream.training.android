package org.javacream.training.android.people.model;

import org.javacream.training.android.people.PeopleAppContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class FilePeopleModel implements PeopleModel {

    private static final String FILE_NAME= "people.dat";
    private HashMap<Long, Person> people;

    private Long counter;

    public void init(){
        people = new HashMap<>();
        try {
            FileInputStream fis = PeopleAppContext.fileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            people = (HashMap<Long, Person>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        counter = 0l;
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
        savePeople();
        return person;
    }

    @Override
    public void delete(long id){
        people.remove(id);
        savePeople();

    }

    @Override
    public Person findById(long id){
        return people.get(id);
    }

    @Override
    public Set<Person> findByLastname(final String lastname){
        HashSet<Person> result = new HashSet<>();
        for (Person p: people.values()){
            if (p.getLastname().equals(lastname)){
                result.add(p);
            }
        }
        return result;
    }
    @Override
    public Set<Person> findMales(){
        HashSet<Person> result = new HashSet<>();
        for (Person p: people.values()){
            if (p.getGender().equals('m') || p.getGender().equals('M')){
                result.add(p);
            }
        }
        return result;
    }
    @Override
    public Set<Person> findFemales(){
        HashSet<Person> result = new HashSet<>();
        for (Person p: people.values()){
            if (p.getGender().equals('f') || p.getGender().equals('F')){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public void update(Person p){
        people.put(p.getId(), p);
        savePeople();
    }


    private void savePeople(){
        try {
            FileOutputStream out = PeopleAppContext.fileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(people);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
