package org.javacream.training.android.people.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.javacream.training.android.R;
import org.javacream.training.android.people.PeopleAppContext;
import org.javacream.training.android.people.controller.DeletePeopleController;
import org.javacream.training.android.people.controller.ListPeopleController;
import org.javacream.training.android.people.model.Person;

import java.util.List;

public class ListPeopleActivity extends AppCompatActivity implements ListPeopleController.UpdateCallback, DeletePeopleController.UpdateCallback {

    private ListPeopleController listPeopleController;
    private DeletePeopleController deletePeopleController;
    private PeopleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_list);
        listPeopleController = PeopleAppContext.listPeopleController();
        deletePeopleController = PeopleAppContext.deletePeopleController();
        listPeopleController.listPeople(this);
    }


    @Override
    public void updateListPeople(List<Person> people){
        adapter = new PeopleListAdapter(this, people);
        ((ListView)findViewById(R.id.peopleList)).setAdapter(adapter);
    }

    @Override
    public void updateDeletePerson() {
        adapter.notifyDataSetChanged();
    }

    class PeopleListAdapter extends ArrayAdapter<Person>{
        public PeopleListAdapter(Context context, List<Person> people){
            super(context, 0, people);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Person person = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.people_list_row, parent, false);
            }
            convertView.findViewById(R.id.deletePersonButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(person);
                    deletePeopleController.deletePerson(person.getId(), ListPeopleActivity.this);
                }
            });

            TextView lastname = (TextView) convertView.findViewById(R.id.lastnameInList);
            TextView firstname = (TextView) convertView.findViewById(R.id.firstnameInList);
            lastname.setText(person.getLastname());
            firstname.setText(person.getFirstname());
            return convertView;
        }
    }

}
