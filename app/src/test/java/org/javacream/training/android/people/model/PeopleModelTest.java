package org.javacream.training.android.people.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PeopleModelTest {

    private MapPeopleModel peopleModel;

    @Before public void init(){
        peopleModel = new MapPeopleModel();
        for (int i=  0; i < 11; i++){
            Character gender;
            if (i % 2 == 0){
                gender = 'm';
            }else{
                gender = 'f';
            }
            peopleModel.create("ln" + i, "fn" + i, gender, i + 170);
        }
    }
    @Test public void testCreatePerson(){
        String lastname = "E";
        String firstname = "W";
        Character gender = 'f';
        Integer height = 177;
        Person p = peopleModel.create(lastname,firstname,gender,height);
        assertEquals(lastname, p.getLastname());
        assertEquals(firstname, p.getFirstname());
        assertEquals(gender, p.getGender());
        assertEquals(height, p.getHeight());
    }
    @Test public void testDeletePerson(){
        Person p = peopleModel.findById(1l);
        assertNotNull(p);
        peopleModel.delete(1l);
        p = peopleModel.findById(1l);
        assertNull(p);
    }
    @Test public void testFindPerson(){
        Person p = peopleModel.findById(1l);
        assertNotNull(p);
    }
    @Test public void testFindMales(){
        assertTrue(peopleModel.findMales().size() == 6);
    }
    @Test public void testFindFemales(){
        assertTrue(peopleModel.findFemales().size() == 5);
    }
}
