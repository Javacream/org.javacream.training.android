package org.javacream.training.android.people;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.javacream.training.android.R;
import org.javacream.training.android.people.model.Person;

import java.util.List;

/**
 * Created by Administrator on 31.01.2018.
 */

public class PersonAdapter extends BaseAdapter {

    private final Activity context;


    public PersonAdapter(Activity context, List<Person> people){
        this.context = context;
        this.people = people;
    }
    private List<Person> people;
    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int i) {
        return people.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.people_list_person_layout, null);
        }
        Person person = people.get(i);
        TextView textView = view.findViewById(R.id.peopleListPersonLastname);
        textView.setText(person.getLastname());
        textView = view.findViewById(R.id.peopleListPersonFirstname);
        textView.setText(person.getFirstname());
        return view;
    }
}
