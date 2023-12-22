package com.example.codeseasy.com.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codeseasy.com.firebaseauth.components.Bio;
import com.example.codeseasy.com.firebaseauth.components.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PartidoDeputadosActivity extends AppCompatActivity {
    private final String URL = "https://dadosabertos.camara.leg.br/api/v2/";
    private Retrofit retrofit;
    private DadosActivity<DeputadoGeralActivity> dados;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private String partidoSigla;
    private Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_deputados);

        list = findViewById(R.id.ListaDeDeputados);
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation_menu);
        bottomNavigation.setSelectedItemId(R.id.nav_partidos);
        bottomNavigation.setOnItemSelectedListener(item -> BottomNavigationMenu.listener(this, item));

        retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        extras = getIntent().getExtras();
        partidoSigla = extras.getString("sigla");

        consultarDeputadoGeral();
    }

    public void consultarDeputadoGeral() {

        RestService restService = retrofit.create(RestService.class);
        Log.d("String dos erros","deu merda");
                Call<DadosActivity<DeputadoGeralActivity>> call = restService.consultarDepG(partidoSigla);

        call.enqueue(new Callback<DadosActivity<DeputadoGeralActivity>>() {

            @Override
            public void onResponse(Call<DadosActivity<DeputadoGeralActivity>> call, Response<DadosActivity<DeputadoGeralActivity>> response) {
                if (response.isSuccessful()) {
                    dados = response.body();

                    for (DeputadoGeralActivity x : dados.getDados()) {
                        adapter.add(x.getNome());
                    }

                }
            }

            @Override
            public void onFailure(Call<DadosActivity<DeputadoGeralActivity>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Erro" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), Bio.class);
            intent.putExtra("id", dados.getDados().get(position).getId());
            startActivity(intent);
            finish();

        });
    }
}