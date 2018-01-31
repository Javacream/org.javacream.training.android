package org.javacream.training.android.people.model;

import android.util.Log;

import org.javacream.training.android.people.PeopleAppContext;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class ServerPeopleModel implements PeopleModel {

    private static final String SERVER_ENDPOINT= "http://10.28.4.1:8080/people";
    public void init(){
    }

    @Override
    public Person create(String lastname, String firstname, Character gender, Integer height){
        //Simulation einer lang-dauernden Aktion
        Person person = new Person(0, lastname, firstname, gender, height);
        savePerson(person);
        return person;
    }

    @Override
    public void delete(long id){
        deletePerson(id);

    }

    @Override
    public Person findById(long id){
        try {
            URL url = new URL(SERVER_ENDPOINT + "/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Reading response from input Stream
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String output;
                StringBuffer response = new StringBuffer();

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();

                String responseText = response.toString();
                JSONObject jsonObject = new JSONObject(responseText);
                Person found = new Person();
                found.setId(jsonObject.getLong("id"));
                found.setLastname(jsonObject.getString("lastname"));
                found.setFirstname(jsonObject.getString("firstname"));
                found.setHeight(jsonObject.getInt("height"));
                found.setGender(jsonObject.getString("gender").charAt(0));
                return found;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Set<Person> findByLastname(final String lastname){
        HashSet<Person> result = new HashSet<>();
        return result;
    }
    @Override
    public Set<Person> findMales(){
        HashSet<Person> result = new HashSet<>();
        return result;
    }
    @Override
    public Set<Person> findFemales(){
        HashSet<Person> result = new HashSet<>();
        return result;
    }

    @Override
    public void update(Person p){
        updatePerson(p);
    }


    private void deletePerson(Long id){
        try {
        URL url = new URL(SERVER_ENDPOINT + "/" + id );
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(15000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("DELETE");
        conn.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void savePerson(Person person){
        JSONObject object = new JSONObject();
        try {
            object.put("lastname", person.getLastname());
            object.put("firstname", person.getFirstname());
            object.put("gender", person.getGender());
            object.put("height", person.getHeight());
            //object.put("id", person.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String personJson = object.toString();
        try {
            URL url = new URL(SERVER_ENDPOINT);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
            outputStreamWriter.write(personJson);
            outputStreamWriter.flush();
            int responseCode = conn.getResponseCode();
            Log.i("TEST", "ResponseCode=" + responseCode);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updatePerson(Person person){
        JSONObject object = new JSONObject();
        try {
            object.put("lastname", person.getLastname());
            object.put("firstname", person.getFirstname());
            object.put("gender", person.getGender());
            object.put("height", person.getHeight());
            object.put("id", person.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String personJson = object.toString();
        try {
            URL url = new URL(SERVER_ENDPOINT);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
            outputStreamWriter.write(personJson);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            int responseCode = conn.getResponseCode();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
