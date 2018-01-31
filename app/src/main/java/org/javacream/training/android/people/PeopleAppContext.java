package org.javacream.training.android.people;


import android.content.Context;
import android.util.Log;

import org.javacream.training.android.MainActivity;
import org.javacream.training.android.people.controller.CreatePersonController;
import org.javacream.training.android.people.controller.SearchPeopleController;
import org.javacream.training.android.people.controller.SearchPersonController;
import org.javacream.training.android.people.model.FilePeopleModel;
import org.javacream.training.android.people.model.MapPeopleModel;
import org.javacream.training.android.people.model.PeopleListModel;
import org.javacream.training.android.people.model.PeopleModel;
import org.javacream.training.android.people.model.ServerPeopleModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PeopleAppContext {

    private static CreatePersonController createPersonController;
    private static SearchPersonController searchPersonController;
    private static SearchPeopleController searchPeopleController;
    private static PeopleModel peopleModel;
    private static MainActivity mainActivity;

    public static void init(MainActivity mainActivity){
        PeopleAppContext.mainActivity = mainActivity;
        ServerPeopleModel peopleModelImpl = new ServerPeopleModel();
        PeopleListModel peopleListModel = new PeopleListModel();
        peopleModel = peopleModelImpl;
        createPersonController = new CreatePersonController();
        searchPersonController = new SearchPersonController();
        searchPeopleController = new SearchPeopleController();
        createPersonController.setPeopleModel(peopleModel);
        searchPersonController.setPeopleModel(peopleModel);
        searchPeopleController.setPeopleModel(peopleListModel);
        peopleModelImpl.init();
    }

    public static CreatePersonController createPersonController(){
        return createPersonController;
    }
    public static SearchPersonController searchPersonController(){
        return searchPersonController;
    }
    public static SearchPeopleController searchPeopleController(){
        return searchPeopleController;
    }
    public static FileInputStream fileInputStream(String name) throws FileNotFoundException {
            return mainActivity.openFileInput(name);
    }
    public static FileOutputStream fileOutputStream(String name) throws FileNotFoundException {
        Log.i("TEST", mainActivity.getFilesDir().getAbsolutePath());
            return mainActivity.openFileOutput(name, Context.MODE_PRIVATE);
    }

}
