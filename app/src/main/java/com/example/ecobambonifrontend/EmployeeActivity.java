package com.example.ecobambonifrontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecobambonifrontend.data.model.Container;
import com.example.ecobambonifrontend.ui.DialogInfoFragment;
import com.example.ecobambonifrontend.ui.containers.RVContainersAdapterAdmin;
import com.example.ecobambonifrontend.ui.containers.RVContainersAdapterEmployee;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    private TextView textView;
    List<Container> containers;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        recyclerView = (RecyclerView) findViewById(R.id.containers_view_employee);
        containers = new ArrayList<>();

        initializeData(containers);

        textView = (TextView)findViewById(R.id.employee_header);

        AsyncLoader myTask = new AsyncLoader();
        myTask.execute();


    }

    private  void initializeData(List<Container> containersList){

    }

    public void onClick(View v){
        TextView id = findViewById(R.id.container_id_employee);
        DialogInfoFragment dialog = new DialogInfoFragment(id.getText().toString(), "qwerty");
        dialog.show(getSupportFragmentManager(),"custom");

    }

    public void onHelpClick(View v){
        Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
        startActivity(intent);
    }

    private Container findContainerByID(int id){
        return null;
    }

    class AsyncLoader extends AsyncTask<String, String, String> {

        String answerHTTP;

        String server = "https://aqueous-temple-82187.herokuapp.com/api/boxes";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpClient httpClient = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet(server);
            HttpPost httpPost = new HttpPost(server);// Registration через тело запроса
            httpPost.setHeader("id", "123");
            httpPost.setHeader("login", "DENIS");
            httpPost.setHeader("password", "QWERTY");
            httpPost.setHeader("name", "DENIS");
            httpPost.setHeader("role", "1");
            try {
                HttpResponse response = httpClient.execute(httpGet);
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    answerHTTP = EntityUtils.toString(entity);
                }

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            containers = new ArrayList<>();
            try {
                //JSONObject jsonObject = new JSONObject(answerHTTP);
                JSONArray jsonArray = new JSONArray(answerHTTP);
                //JSONArray names = jsonObject.names();
                //JSONArray values = jsonObject.getJSONArray(String.valueOf(names));
                int id;
                String location;
                String address;
                int fullness;
                String owner;
                for (int i = 0 ; i < jsonArray.length(); i++){
                    JSONObject row = jsonArray.getJSONObject(i);
                    id = row.getInt("id");
                    location = row.getString("location");
                    address = row.getString("address");
                    fullness = row.getInt("fullness");
                    owner = row.getString("owner");



                    Container bufCont  = new Container();
                    bufCont.setID(id);
                    bufCont.setAddress(address);
                    bufCont.setOwner(owner);
                    bufCont.setLocation(location);
                    bufCont.setFullness(fullness);

                    containers.add(new Container(id, location,address, fullness, owner));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.wtf("LOG", containers.toString());
            for (Container c: containers) {
                Log.wtf("LOG", c.getAddress());

            }
            Log.wtf("LOG", answerHTTP);
            recyclerView = (RecyclerView) findViewById(R.id.containers_view_employee);
            int lol = 1;
            RVContainersAdapterEmployee rvContainersAdapterEmployee = new RVContainersAdapterEmployee(getApplicationContext(), containers, lol);
            recyclerView.setAdapter(rvContainersAdapterEmployee);
        }
    }
}


