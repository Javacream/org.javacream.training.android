package org.javacream.training.android.people;

import org.javacream.training.android.people.controller.CreatePersonController;
import org.javacream.training.android.people.model.MapPeopleModel;
import org.javacream.training.android.people.model.PeopleModel;

public class PeopleApplicationContext {

    private static MapPeopleModel peopleModel;

    public static CreatePersonController createPersonController() {
        return createPersonController;
    }

    private static CreatePersonController createPersonController;

    static{
        //Objekte parameterlos erzeugen
        peopleModel = new MapPeopleModel();
        createPersonController = new CreatePersonController();

        //Dependencies injecten = setzen
        createPersonController.setPeopleModel(peopleModel);
    }

    public static PeopleModel peopleModel(){
        return peopleModel;
    }
}
