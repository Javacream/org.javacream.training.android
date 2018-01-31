package org.javacream.training.android.people.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PeopleListModel {

    public String findPeople(){
        try {
            URL url = new URL("http://10.28.4.1:8080/people");
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
                return responseText;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return "Not found";
    }

    public List<String> findPeopleListAsStrings(){
        ArrayList<String> people = new ArrayList<>();
        try {
            URL url = new URL("http://10.28.4.1:8080/people");
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
                    Person p = new Person();
                    p.setId(object.getLong("id"));
                    p.setLastname(object.getString("lastname"));
                    p.setFirstname(object.getString("firstname"));
                    p.setGender(object.getString("gender").charAt(0));
                    p.setHeight(object.getInt("height"));
                    people.add(p.getLastname());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return people;
    }
    public List<Person> findPeopleListAsPerson(){
        ArrayList<Person> people = new ArrayList<>();
        try {
            URL url = new URL("http://10.28.4.1:8080/people");
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
                    Person p = new Person();
                    p.setId(object.getLong("id"));
                    p.setLastname(object.getString("lastname"));
                    p.setFirstname(object.getString("firstname"));
                    p.setGender(object.getString("gender").charAt(0));
                    p.setHeight(object.getInt("height"));
                    people.add(p);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return people;
    }

}
