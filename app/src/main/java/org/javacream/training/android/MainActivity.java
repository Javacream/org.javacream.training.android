package org.javacream.training.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.javacream.training.android.people.PeopleAppContext;

public class MainActivity extends AppCompatActivity {
    public void gotoSearchPerson(View view) {
        Intent intent = new Intent(this, SearchPersonActivity.class);
        startActivity(intent);
    }

    public void gotoCreatePerson(View view) {
        Intent intent = new Intent(this, CreatePersonActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_layout);
        PeopleAppContext.init(this);
    }


    public void gotoListPerson(View view) {
        Intent intent = new Intent(this, PeopleListActivity.class);
        startActivity(intent);
    }
}
