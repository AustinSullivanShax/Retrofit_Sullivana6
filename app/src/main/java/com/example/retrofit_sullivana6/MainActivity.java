package com.example.retrofit_sullivana6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String FILM_TITLE = MainActivity.class.getName();
    public String item;
    ListView superListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superListView = findViewById(R.id.superListView);

        getRecipe();
    }

    private void getRecipe() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getVehicle();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> vehicleList = response.body();
                String[] oneVehicle = new String[vehicleList.size()];

                for (int i = 0; i < vehicleList.size(); i++) {
                    oneVehicle[i] = vehicleList.get(i).getName();
                }

                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneVehicle));
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
        superListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) superListView.getItemAtPosition(i);
                Intent intent = new Intent(view.getContext(), SecondRetrofitActivity.class);
                intent.putExtra(FILM_TITLE, item);
                startActivity(intent);
            }
        });


    };



}