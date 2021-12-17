package com.example.retrofit_sullivana6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondRetrofitActivity extends AppCompatActivity {
    ListView filmText;
    TextView filmTitle;
    TextView filmDesc;
    TextView filmClass;
    TextView filmLength;
    TextView filmPilot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_retrofit);

        getVehicle();
    }


    private void getVehicle() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getVehicle();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> vehicleList = response.body();
                String[] oneVehicle = new String[vehicleList.size()];
                Intent intent = getIntent();
                String title = intent.getStringExtra(MainActivity.FILM_TITLE);

                filmTitle = findViewById(R.id.filmTitle);
                filmDesc = findViewById(R.id.filmDesc);
                filmClass = findViewById(R.id.filmClass);
                filmLength = findViewById(R.id.filmLength);
                filmPilot = findViewById(R.id.filmPilot);

                for (int i = 0; i < vehicleList.size(); i++) {
                    oneVehicle[i] = vehicleList.get(i).getName();
                    if (oneVehicle[i].equals(title)) {
                        filmTitle.setText(title);
                        oneVehicle[i] = vehicleList.get(i).getDesc();
                        filmDesc.setText(new StringBuilder().append("Description: ").append(oneVehicle[i]).toString());
                        oneVehicle[i] = vehicleList.get(i).getVehicleClass();
                        filmClass.setText(new StringBuilder().append("Vehicle Class: ").append(oneVehicle[i]).toString());
                        oneVehicle[i] = vehicleList.get(i).getLength();
                        filmLength.setText(new StringBuilder().append("Length: ").append(oneVehicle[i]).toString());
                        oneVehicle[i] = vehicleList.get(i).getPilot();
                        filmPilot.setText(new StringBuilder().append("Pilot: ").append(oneVehicle[i]).toString());

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }


}