package org.javacream.training.android.model;

import org.junit.Assert;
import org.junit.Test;

public class PeopleControllerTest {

    @Test public void testPeopleController(){
        PeopleController pc = new PeopleController();
        pc.create("Muster", "Mann", 'f', 199);

    }
}

