package com.example.codeseasy.com.firebaseauth.components;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codeseasy.com.firebaseauth.Dado;
import com.example.codeseasy.com.firebaseauth.DeputadoActivity;
import com.example.codeseasy.com.firebaseauth.R;
import com.example.codeseasy.com.firebaseauth.RestService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Bio extends AppCompatActivity {
    private final String URL = "https://dadosabertos.camara.leg.br/api/v2/";
    private Retrofit retrofit;
    private Integer deputadoId;
    private Bundle extras;

    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation_menu);
        bottomNavigation.setSelectedItemId(R.id.nav_partidos);
        bottomNavigation.setOnItemSelectedListener(item -> BottomNavigationMenu.listener(this, item));

        extras = getIntent().getExtras();
        deputadoId = extras.getInt("id");

        retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        consultarDeputado();
    }

    public void consultarDeputado() {

        RestService restService = retrofit.create(RestService.class);

        Call<Dado<DeputadoActivity>> call = restService.consultarDep(deputadoId);

        call.enqueue(new Callback<Dado<DeputadoActivity>>() {
            @Override
            public void onResponse(Call<Dado<DeputadoActivity>> call, Response<Dado<DeputadoActivity>> response) {

                if (response.isSuccessful()) {
                    Dado<DeputadoActivity> dados = response.body();
                    DeputadoActivity deputado= dados.getDados();

                    textView6.setText("Nome: "+ deputado.getNomeCivil());
                    textView7.setText("Cpf: " + deputado.getCpf());
                    textView8.setText("Data de nacimento: " + deputado.getDataNascimento());
                    textView9.setText("Escolaridade: " + deputado.getEscolaridade());
                    textView10.setText("Sexo: " + deputado.getSexo());


                }

            }
            @Override
            public void onFailure (Call < Dado <DeputadoActivity>> call, Throwable t){
                Toast.makeText(getApplicationContext(), "Erro" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}