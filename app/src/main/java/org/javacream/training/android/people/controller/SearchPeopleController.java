package org.javacream.training.android.people.controller;

import android.os.AsyncTask;

import org.javacream.training.android.PeopleListActivity;
import org.javacream.training.android.SearchPersonActivity;
import org.javacream.training.android.people.model.PeopleListModel;
import org.javacream.training.android.people.model.PeopleModel;
import org.javacream.training.android.people.model.Person;

import java.util.List;

public class SearchPeopleController {
    private PeopleListModel peopleModel;
    public void setPeopleModel(PeopleListModel peopleModel) {
        this.peopleModel = peopleModel;
    }

    public void search(final PeopleListActivity peopleListActivity) {

        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {
                return peopleModel.findPeople();
            }

            @Override
            protected void onPostExecute(String people) {
                peopleListActivity.handleSearchUpdate(people);
            }

        }.execute();
    }
    public void searchAsStringList(final PeopleListActivity peopleListActivity) {

        new AsyncTask<Void, Void, List<String>>(){
            @Override
            protected List<String> doInBackground(Void... voids) {
                return peopleModel.findPeopleListAsStrings();
            }

            @Override
            protected void onPostExecute(List<String> people) {
                peopleListActivity.handleSearchPeopleAsStringListUpdate(people);
            }

        }.execute();
    }

    public void searchAsPeopleList(final PeopleListActivity peopleListActivity) {

        new AsyncTask<Void, Void, List<Person>>(){
            @Override
            protected List<Person> doInBackground(Void... voids) {
                return peopleModel.findPeopleListAsPerson();
            }

            @Override
            protected void onPostExecute(List<Person> people) {
                peopleListActivity.handleSearchPeopleAsPersonListUpdate(people);
            }

        }.execute();
    }

}

