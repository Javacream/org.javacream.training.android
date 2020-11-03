package org.javacream.training.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.javacream.training.android.model.PeopleController;
import org.javacream.training.android.model.Person;

import java.util.List;

public class PeopleListActivity extends AppCompatActivity implements PeopleController.FindAllUpdate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);
        ApplicationContext.peopleController().findAllAsync(this);
    }


    @Override
    public void accept(List<Person> people) {
        PeopleListAdapter adapter = new PeopleListAdapter(this, R.layout.person, people);
        ListView listView = findViewById(R.id.peopleList);
        listView.setAdapter(adapter);

    }
}