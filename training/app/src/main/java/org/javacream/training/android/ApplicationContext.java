package org.javacream.training.android;

import org.javacream.training.android.model.PeopleController;

public class ApplicationContext {
    private static PeopleController peopleController;
    static
    {
        peopleController = new PeopleController();
    }

    public static PeopleController peopleController(){
        return peopleController;
    }
}
