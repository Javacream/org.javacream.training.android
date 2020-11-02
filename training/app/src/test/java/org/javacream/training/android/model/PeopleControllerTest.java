package org.javacream.training.android.model;

import org.junit.Assert;
import org.junit.Test;

public class PeopleControllerTest {

    @Test public void testPeopleController(){
        PeopleController pc = new PeopleController();
        Long id = pc.newPerson("Muster", "Mann", 199, 'f');
        Assert.assertNotNull(id);

    }
}

