package com.example.codeseasy.com.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.codeseasy.com.firebaseauth.components.BottomNavigationMenu;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PerfilActivity extends AppCompatActivity {
    private final String URL = "https://dadosabertos.camara.leg.br/api/v2/";
    private Retrofit retrofit;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private String partidoId;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation_menu);
        bottomNavigation.setSelectedItemId(R.id.nav_partidos);
        bottomNavigation.setOnItemSelectedListener(item -> BottomNavigationMenu.listener(this, item));

        extras = getIntent().getExtras();
        partidoId = extras.getString("id");

        retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       consultarPartido();
    }
    public void consultarPartido() {

        RestService restService = retrofit.create(RestService.class);

        Call<Dado<PartidoActivity>> call = restService.consultarPart(partidoId);

        call.enqueue(new Callback<Dado<PartidoActivity>>() {
            @Override
            public void onResponse(Call<Dado<PartidoActivity>> call, Response<Dado<PartidoActivity>> response) {

                if (response.isSuccessful()) {
                    Dado<PartidoActivity> dados = response.body();
                    PartidoActivity partido = dados.getDados();

                    textView1.setText("Nome: "+ partido.getNome());
                    textView2.setText("Sigla: " + partido.getSigla());
                    textView3.setText("Situação: " + partido.getStatus().getSituacao());
                    textView4.setText("Numero de membros: " + partido.getStatus().getTotalMembros());
                    textView5.setText("Numero de posses: " + partido.getStatus().getTotalPosse());

                    Button deputados = findViewById(R.id.button_deputados_do_partido);
                    deputados.setOnClickListener(view -> {
                        Intent intent = new Intent(getApplicationContext(), PartidoDeputadosActivity.class);
                        intent.putExtra("sigla", partido.getSigla());
                        startActivity(intent);
                        finish();
                    });
                }

            }
            @Override
            public void onFailure (Call < Dado <PartidoActivity>> call, Throwable t){

                Toast.makeText(getApplicationContext(), "Erro" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}