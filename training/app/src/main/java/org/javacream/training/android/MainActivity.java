package org.javacream.training.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.javacream.training.android.model.PeopleController;

public class MainActivity extends AppCompatActivity {
    private EditText lastnameInput;
    private EditText firstnameInput;
    private EditText genderInput;
    private EditText heightInput;
    private PeopleController peopleController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastnameInput  = this.findViewById(R.id.lastnameInput);
        firstnameInput  = this.findViewById(R.id.firstnameInput);
        genderInput  = this.findViewById(R.id.genderInput);
        heightInput  = this.findViewById(R.id.heightInput);
        peopleController = new PeopleController();
    }

    public void clear(View view) {
        lastnameInput.setText("");
        firstnameInput.setText("");
        heightInput.setText("");
        genderInput.setText("");

    }
    public void save(View view) {
        String lastname = lastnameInput.getText().toString();
        String firstname = firstnameInput.getText().toString();
        char gender = genderInput.getText().charAt(0);
        int height = Integer.parseInt(heightInput.getText().toString());
        Long id = peopleController.newPerson(lastname, firstname, height, gender);
        peopleController.dump();
        Log.i("training", "saved person " + id);
        Toast.makeText(this, "saved person " + id, Toast.LENGTH_LONG).show();
    }
}