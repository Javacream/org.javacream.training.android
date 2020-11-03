package org.javacream.training.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.javacream.training.android.model.PeopleController;

import java.util.Date;

public class PersonInputActivity extends AppCompatActivity {
    private EditText lastnameInput;
    private EditText firstnameInput;
    private EditText genderInput;
    private EditText heightInput;
    private PeopleController peopleController;
    private boolean debugIsShowing = false;
    private View debugView;
    private TextView debug;
    private LinearLayout debugViewSlot;
    private Button debugButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_input);
        lastnameInput  = this.findViewById(R.id.lastnameInput);
        firstnameInput  = this.findViewById(R.id.firstnameInput);
        genderInput  = this.findViewById(R.id.genderInput);
        heightInput  = this.findViewById(R.id.heightInput);
        peopleController = ApplicationContext.peopleController();
        debugViewSlot = findViewById(R.id.debugViewSlot);
        debugView = getLayoutInflater().inflate(R.layout.debug_layout, null);
        debug = debugView.findViewById(R.id.debugTextView);
        debugButton = findViewById(R.id.debugButton);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void clear(View view) {
        lastnameInput.setText("");
        firstnameInput.setText("");
        heightInput.setText("");
        genderInput.setText("");
        debug.setText("cleared at " + new Date());
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
        debug.setText("saved at " + new Date());
    }

    public void handleDebug(View view) {
        if (!debugIsShowing){
            debugViewSlot.addView(debugView);
            debugButton.setText("Hide Debug");
        }else{
            debugViewSlot.removeAllViews();
            debugButton.setText("Show Debug");
        }
        debugIsShowing = ! debugIsShowing;
    }

    public void goBack(View view) {
        finish();
    }
}