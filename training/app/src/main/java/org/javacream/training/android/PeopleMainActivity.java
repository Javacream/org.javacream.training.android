package org.javacream.training.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PeopleMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_main);
    }

    public void navPersonInput(View view) {
        Intent intent = new Intent(this, PersonInputActivity.class);
        startActivity(intent);
    }

    public void navPeopleList(View view) {
        Intent intent = new Intent(this, PeopleListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView header = findViewById(R.id.header);
        header.setText(getString(R.string.caption) + "(" + ApplicationContext.peopleController().count() + ")");
    }
}