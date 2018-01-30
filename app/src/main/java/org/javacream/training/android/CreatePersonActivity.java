package org.javacream.training.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.javacream.training.android.people.PeopleAppContext;
import org.javacream.training.android.people.controller.CreatePersonController;
import org.javacream.training.android.people.model.Person;

public class CreatePersonActivity extends AppCompatActivity {

    private EditText lastnameInput;
    private EditText firstnameInput;
    private EditText genderInput;
    private EditText heightInput;
    private CreatePersonController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_create);
        lastnameInput = findViewById(R.id.lastnameInput);
        firstnameInput = findViewById(R.id.firstnameInput);
        genderInput = findViewById(R.id.genderInput);
        heightInput = findViewById(R.id.heightInput);
        controller = PeopleAppContext.createPersonController();
    }


    public void handleSave(View view) {

        String lastname = lastnameInput.getText().toString();
        String firstname = firstnameInput.getText().toString();
        String gender = genderInput.getText().toString();
        String height = heightInput.getText().toString();
        controller.create(lastname, firstname, gender.charAt(0), Integer.parseInt(height), this);

    }

    public void handleSaveUpdate(Person createdPerson){
        String message = "created person " + createdPerson.toString();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void handleReset(View view) {
        lastnameInput.setText("");
        firstnameInput.setText("");
        genderInput.setText("");
        heightInput.setText("");
    }

}
