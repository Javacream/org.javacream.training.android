package org.javacream.training.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class PeopleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);
        PeopleListAdapter adapter = new PeopleListAdapter(this, R.layout.person, ApplicationContext.peopleController().findAll());
        ListView listView = findViewById(R.id.peopleList);
        listView.setAdapter(adapter);
    }
}