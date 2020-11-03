package org.javacream.training.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
        convertView.findViewById(R.id.deletePersonButton).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        remove(p);
                        ApplicationContext.peopleController().deleteAsync(p.getId());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Abort", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        });
        TextView firstname = convertView.findViewById(R.id.personFirstname);
        firstname.setText(p.getFirstname());
        TextView lastname = convertView.findViewById(R.id.personLastname);
        lastname.setText(p.getLastname());
        return convertView;
    }
}
