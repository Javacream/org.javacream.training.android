package org.javacream.training.android.model;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class PeopleController {
    private static long counter;
    private Map<Long, Person> people;

    {
        people = new HashMap<>();
    }
    public long newPerson(String lastname, String firstname, int height, char gender){
        counter++;
        Person p = new Person(lastname, firstname, height, gender, counter);
        this.people.put(counter, p);
        return counter;
    }

    public void dump(){
        Log.i("people", this.people.toString());
    }
}
