package org.javacream.training.android.people;


import android.content.Context;

import org.javacream.training.android.people.controller.DeletePeopleController;
import org.javacream.training.android.people.controller.ListPeopleController;
import org.javacream.training.android.people.model.FilePeopleModel;
import org.javacream.training.android.people.model.PeopleModel;
import org.javacream.training.android.people.controller.CreatePersonController;
import org.javacream.training.android.people.controller.SearchPersonController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PeopleAppContext {

    private static CreatePersonController createPersonController;
    private static SearchPersonController searchPersonController;
    private static ListPeopleController listPeopleController;
    private static DeletePeopleController deletePeopleController;
    private static FilePeopleModel peopleModel;
    private static Context androidContext;
    public static void init(Context androidContext){

        PeopleAppContext.androidContext = androidContext;
        peopleModel = new FilePeopleModel();
        createPersonController = new CreatePersonController();
        searchPersonController = new SearchPersonController();
        listPeopleController = new ListPeopleController();
        deletePeopleController = new DeletePeopleController();

        searchPersonController.setPeopleModel(peopleModel);
        createPersonController.setPeopleModel(peopleModel);
        listPeopleController.setPeopleModel(peopleModel);
        deletePeopleController.setPeopleModel(peopleModel);

    }

    public static CreatePersonController createPersonController(){
        return createPersonController;
    }
    public static SearchPersonController searchPersonController(){
        return searchPersonController;
    }
    public static PeopleModel peopleModel(){
        return peopleModel;
    }

    public static ListPeopleController listPeopleController() { return listPeopleController;}

    public static DeletePeopleController deletePeopleController() {
        return deletePeopleController;
    }

    public static FileInputStream fileInputStream(String name) throws FileNotFoundException {
        return androidContext.openFileInput(name);
    }
    public static FileOutputStream fileOutputStream(String name) throws FileNotFoundException {
        return androidContext.openFileOutput(name, Context.MODE_PRIVATE);
    }
}
