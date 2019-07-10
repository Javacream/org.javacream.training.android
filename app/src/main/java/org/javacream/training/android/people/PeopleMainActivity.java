package org.javacream.training.android.people;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class PeopleMainActivity extends AppCompatActivity {

    private EditText lastnameInput;
    private EditText firstnameInput;
    private EditText genderInput;
    private EditText heightInput;

    {
        //DON'T DO ANYTHING INSIDE AN ACTIVITIES CONSTRUCTOR
        Log.i("Lifecycle", "instance constructor");
        //setContentView(R.layout.person_input); //NEVER DO THAT IN CONSTRUCTORS
        //EditText lastnameInputNull  = this.findViewById(R.id.lastnameInput);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Lifecycle", "onCreate");
        super.onCreate(savedInstanceState);
        EditText lastnameInputNull  = this.findViewById(R.id.lastnameInput);
        setContentView(R.layout.person_input);
        lastnameInput  = this.findViewById(R.id.lastnameInput);
        firstnameInput  = this.findViewById(R.id.firstnameInput);
        genderInput  = this.findViewById(R.id.genderInput);
        heightInput  = this.findViewById(R.id.heightInput);
        lastnameInput.setText("HELLO FROM ACTIVITY");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecycle", "onStart");
    }

    @Override
    protected void onStop() {
        Log.i("Lifecycle", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("Lifecycle", "onDestroy");
        super.onDestroy();
    }

    public void doSave(View view){
        //Beliebige Code-Sequenz
        Log.i("Action", "called doSave");
        String lastname = lastnameInput.getText().toString();
        String firstname = firstnameInput.getText().toString();
        String gender = genderInput.getText().toString();
        String height = heightInput.getText().toString();
        Log.i("Action", "saving lastname=" + lastname + ", firstname=" + firstname + ", height=" + height + ", gender=" + gender);
    }
    public void doClear(View view){
        //Beliebige Code-Sequenz
        Log.i("Action", "called doClear");
        lastnameInput.setText("");
        firstnameInput.setText("");
        genderInput.setText("");
        heightInput.setText("");
    }
}
