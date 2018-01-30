package org.javacream.training.android.people.controller;

import org.javacream.training.android.people.model.PeopleModel;
import org.javacream.training.android.people.model.Person;


public class CreatePersonController {
    private PeopleModel peopleModel;

    public void setPeopleModel(PeopleModel peopleModel) {
        this.peopleModel = peopleModel;
    }

    public Person create(String lastname, String firstname, Character gender, Integer height) {
        return peopleModel.create(lastname, firstname, gender, height);
    }
}

