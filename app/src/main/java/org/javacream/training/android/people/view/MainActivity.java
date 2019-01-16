package org.javacream.training.android.people.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.javacream.training.android.R;
import org.javacream.training.android.people.PeopleAppContext;

public class MainActivity extends AppCompatActivity {
    public void gotoSearchPerson(View view) {
        Intent intent = new Intent(this, SearchPersonActivity.class);
        startActivity(intent);
    }
    public void gotoWebView(View view) {
        Intent intent = new Intent(this, WebViewActivity.class);
        startActivity(intent);
    }


    public void gotoCreatePerson(View view) {
        Intent intent = new Intent(this, CreatePersonActivity.class);
        startActivity(intent);
    }
    public void gotoPeopleList(View view) {
        Intent intent = new Intent(this, ListPeopleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_layout);
        PeopleAppContext.init(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
