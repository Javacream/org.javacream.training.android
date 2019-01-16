package org.javacream.training.android.people.controller;

import android.os.AsyncTask;

import org.javacream.training.android.people.model.PeopleModel;
import org.javacream.training.android.people.model.Person;

public class SearchPersonController {
    private PeopleModel peopleModel;
    public void setPeopleModel(PeopleModel peopleModel) {
        this.peopleModel = peopleModel;
    }

    public void search(final Long id, final UpdateCallback callback) {

        new AsyncTask<Void, Void, Person>(){
            @Override
            protected Person doInBackground(Void... voids) {
                Person p =  peopleModel.findById(id);
                return p;
            }

            @Override
            protected void onPostExecute(Person person) {
                callback.updateSearchPerson(person);
            }

        }.execute();
    }
    public interface UpdateCallback {
        void updateSearchPerson(Person person);
    }
}

