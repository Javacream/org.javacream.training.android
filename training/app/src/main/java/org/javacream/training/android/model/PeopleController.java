package org.javacream.training.android.model;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleController {

    public interface FindAllUpdate{
        void accept(List<Person> people);
    }
    private static final String SERVER_ENDPOINT = "http://10.0.2.2:8080/people";
    private void deletePerson(Long id){
        try {
            URL url = new URL(SERVER_ENDPOINT + "/" + id );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("DELETE");
            conn.getResponseCode();
        } catch (Exception e) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updatePerson(Person person) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void create(final String lastname, final String firstname, final Character gender, final Integer height){
            AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    //LÄUFT IM WORKER-THREAD
                    Log.i("CONTROLLER", Thread.currentThread().getName() + " before model execution" + new Date());
                    savePerson(new Person(lastname, firstname, height, gender, 1));
                    Log.i("CONTROLLER", Thread.currentThread().getName() + " after model execution" + new Date());

                    return null;
                }

                @Override
                protected void onPostExecute(Void v) {
                    //LÄUFT IM EVENT DISPATCH THREAD
                    Log.i("CONTROLLER", Thread.currentThread().getName() + " in PostExecution" + new Date());
                }
            };

            task.execute();
        }


    private List<Person> findAll(){
        ArrayList<Person> people = new ArrayList<>();
        try {
            URL url = new URL(SERVER_ENDPOINT);
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
                JSONArray jsonArray = new JSONArray(responseText);
                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    Person p = new Person(object.getString("lastname"), object.getString("firstname"), object.getInt("height"), object.getString("gender").charAt(0), object.getLong("id"));
                    people.add(p);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return people;
    }

    public void findAllAsync(FindAllUpdate update){
        AsyncTask<Void, Void, List<Person>> task = new AsyncTask<Void, Void, List<Person>>() {
            @Override
            protected List<Person> doInBackground(Void... voids) {
                return findAll();
            }

            @Override
            protected void onPostExecute(List<Person> people) {
                update.accept(people);
            }
        };
        task.execute();
    }

    public void deleteAsync(Long id){
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                deletePerson(id);
                return null;
            }

        };
        task.execute();
    }
}
