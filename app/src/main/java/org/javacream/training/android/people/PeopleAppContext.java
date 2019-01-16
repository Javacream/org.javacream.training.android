package org.javacream.training.android.people;


import org.javacream.training.android.people.controller.DeletePeopleController;
import org.javacream.training.android.people.controller.ListPeopleController;
import org.javacream.training.android.people.model.PeopleModel;
import org.javacream.training.android.people.model.ServerPeopleModel;
import org.javacream.training.android.people.view.MainActivity;
import org.javacream.training.android.people.controller.CreatePersonController;
import org.javacream.training.android.people.controller.SearchPersonController;
import org.javacream.training.android.people.model.MapPeopleModel;

public class PeopleAppContext {

    private static CreatePersonController createPersonController;
    private static SearchPersonController searchPersonController;
    private static ListPeopleController listPeopleController;
    private static DeletePeopleController deletePeopleController;
    private static ServerPeopleModel peopleModel;

    public static void init(MainActivity mainActivity){
        peopleModel = new ServerPeopleModel();
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
}
