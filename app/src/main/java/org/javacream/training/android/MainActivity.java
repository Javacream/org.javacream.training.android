package org.javacream.training.android;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText lastnameInput;
    private EditText firstnameInput;
    private EditText genderInput;
    private EditText heightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_layout);
        lastnameInput = findViewById(R.id.lastnameInput);
        firstnameInput = findViewById(R.id.firstnameInput);
        genderInput = findViewById(R.id.genderInput);
        heightInput = findViewById(R.id.heightInput);
    }


    public void handleSave(View view) {
        String lastname = lastnameInput.getText().toString();
        String firstname = firstnameInput.getText().toString();
        String gender = genderInput.getText().toString();
        String height = heightInput.getText().toString();
        String message = "saved person, lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender + ", height=" + height;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void handleReset(View view) {
        lastnameInput.setText("");
        firstnameInput.setText("");
        genderInput.setText("");
        heightInput.setText("");
    }
}
