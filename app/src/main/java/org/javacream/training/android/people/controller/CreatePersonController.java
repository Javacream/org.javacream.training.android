package org.javacream.training.android.people.controller;

import android.os.AsyncTask;

import org.javacream.training.android.MainActivity;
import org.javacream.training.android.people.model.PeopleModel;
import org.javacream.training.android.people.model.Person;


public class CreatePersonController {
    private PeopleModel peopleModel;
    private MainActivity mainActivity;
    public void setPeopleModel(PeopleModel peopleModel) {
        this.peopleModel = peopleModel;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void create(final String lastname, final String firstname, final Character gender, final Integer height) {

        new AsyncTask<Void, Void, Person>(){
            @Override
            protected Person doInBackground(Void... voids) {
                Person p =  peopleModel.create(lastname, firstname, gender, height);
                return p;
            }

            @Override
            protected void onPostExecute(Person person) {
                mainActivity.handleSaveUpdate(person);
            }

        }.execute();
    }


}

