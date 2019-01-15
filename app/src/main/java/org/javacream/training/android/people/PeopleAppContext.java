package org.javacream.training.android.people;


import org.javacream.training.android.MainActivity;
import org.javacream.training.android.people.controller.CreatePersonController;
import org.javacream.training.android.people.controller.SearchPersonController;
import org.javacream.training.android.people.model.PeopleModel;

public class PeopleAppContext {

    private static CreatePersonController createPersonController;
    private static SearchPersonController searchPersonController;
    private static PeopleModel peopleModel;

    public static void init(MainActivity mainActivity){
        peopleModel = new PeopleModel();
        createPersonController = new CreatePersonController();
        createPersonController.setPeopleModel(peopleModel);
        searchPersonController = new SearchPersonController();
        searchPersonController.setPeopleModel(peopleModel);
    }

    public static CreatePersonController createPersonController(){
        return createPersonController;
    }
    public static SearchPersonController searchPersonController(){
        return searchPersonController;
    }

}
