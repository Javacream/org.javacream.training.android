package org.javacream.training.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.javacream.training.android.model.Person;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PeopleListAdapter extends ArrayAdapter<Person> {


    public PeopleListAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Person p = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate( R.layout.person, parent, false);
        }
        TextView firstname = convertView.findViewById(R.id.personFirstname);
        firstname.setText(p.getFirstname());
        TextView lastname = convertView.findViewById(R.id.personLastname);
        lastname.setText(p.getLastname());
        return convertView;
    }
}
