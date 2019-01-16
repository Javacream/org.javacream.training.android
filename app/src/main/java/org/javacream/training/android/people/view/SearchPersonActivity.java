package org.javacream.training.android.people.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.javacream.training.android.R;
import org.javacream.training.android.people.PeopleAppContext;
import org.javacream.training.android.people.controller.SearchPersonController;
import org.javacream.training.android.people.model.Person;

public class SearchPersonActivity extends AppCompatActivity implements SearchPersonController.UpdateCallback {
    private EditText idInput;
    private TextView foundPersonOutput;
    private SearchPersonController searchPersonController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_search);
        idInput = findViewById(R.id.idInput);
        foundPersonOutput = findViewById(R.id.foundPersonOutputLabel);
        searchPersonController = PeopleAppContext.searchPersonController();
    }

    public void handleSearch(View view) {
        Long id = Long.parseLong(idInput.getText().toString());
        searchPersonController.search(id, this);
    }
    public void updateSearchPerson(Person found) {
        if (found != null) {
            foundPersonOutput.setText(found.toString());
        }
        else{
            foundPersonOutput.setText("Not found");
        }
    }
}
