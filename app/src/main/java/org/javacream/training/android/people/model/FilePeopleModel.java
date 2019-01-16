package org.javacream.training.android.people.model;

import org.javacream.training.android.people.PeopleAppContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilePeopleModel implements PeopleModel {

    private static final String FILE_NAME= "people.dat";
    private HashMap<Long, Person> people;

    private Long counter;

    public FilePeopleModel(){
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
    public void update(Person p){
        people.put(p.getId(), p);
        savePeople();
    }

    @Override
    public List<Person> findAll(){
        return new ArrayList<>(people.values());
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