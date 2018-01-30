package org.javacream.training.android;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class JavaCollectionsDemoTest {

    @Test public void simple(){
        String result = "Hugo";
        assertEquals("Hugo", result);
    }
    @Test public void demoJavaList(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Hugo");
        names.add("Emil");
        names.add("Otto");
        names.add("Hugo");
        assertEquals(4, names.size());
        assertEquals("Hugo", names.get(0));
        assertEquals("Otto", names.get(2));
        System.out.println(names);

        names.remove(1);
        assertEquals(3, names.size());

        for (String name: names){
            System.out.println("Name:" + name);
        }
    }
    @Test public void demoJavaSet(){
        HashSet<String> names = new HashSet<>();
        names.add("Hugo");
        names.add("Emil");
        names.add("Otto");
        names.add("Hugo");
        assertEquals(3, names.size());
        System.out.println(names);

        names.remove("Emil");
        assertEquals(2, names.size());

        for (String name: names){
            System.out.println("Name:" + name);
        }
    }

    @Test public void testJavaMap(){
        HashMap<Long, String> names = new HashMap<>();
        names.put(1l, "Hugo");
        names.put(42l, "Emil");
        names.put(4711l, "Otto");
        assertEquals(3, names.size());
        assertEquals("Hugo", names.get(1l));
        assertEquals("Otto", names.get(4711l));
        assertNull(names.get(123l));
        names.remove(42l);
        assertEquals(2, names.size());
        for (Long key: names.keySet()){
            System.out.println("Key:" + key);
        }
        for (String name: names.values()){
            System.out.println("Name:" + name);
        }


    }
}
