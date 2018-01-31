package org.javacream.training.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.javacream.training.android.people.PeopleAppContext;
import org.javacream.training.android.people.PersonAdapter;
import org.javacream.training.android.people.controller.SearchPeopleController;
import org.javacream.training.android.people.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PeopleListActivity extends AppCompatActivity {
    private SearchPeopleController searchPeopleController;
    private ListView peopleStringList;
    private ArrayAdapter<String> adapter;
    private ListView peopleList;
    private PersonAdapter personAdapter;
    private ArrayList<Person> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_list_activity);
        searchPeopleController = PeopleAppContext.searchPeopleController();
        peopleStringList = findViewById(R.id.peopleListViewString);
        peopleList = findViewById(R.id.peopleListViewPerson);
        data = new ArrayList<Person>();
        personAdapter = new PersonAdapter(this,data);
        adapter = new ArrayAdapter<String>(this, R.layout.people_list_string_layout);
        peopleStringList.setAdapter(adapter);
        peopleList.setAdapter(personAdapter);

    }

    public void handleSearchPeopleString(View view) {
        searchPeopleController.search(this);
    }

    public void handleSearchUpdate(String people) {
        Toast.makeText(this, people, Toast.LENGTH_SHORT).show();
    }
    public void handleSearchPeopleAsStringList(View view) {
        searchPeopleController.searchAsStringList(this);
    }
    public void handleSearchPeopleAsStringListUpdate(List<String> people) {
        adapter.clear();
        adapter.addAll(people);
        adapter.notifyDataSetChanged();
    }

    public void handleSearchPeopleAsPersonList(View view) {
        searchPeopleController.searchAsPeopleList(this);
    }
    public void handleSearchPeopleAsPersonListUpdate(List<Person> people) {
        data.clear();
        data.addAll(people);
        personAdapter.notifyDataSetChanged();
        peopleList.setAdapter(personAdapter);
    }
}
