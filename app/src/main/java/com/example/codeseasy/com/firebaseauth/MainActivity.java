package com.example.codeseasy.com.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.codeseasy.com.firebaseauth.components.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String URL = "https://dadosabertos.camara.leg.br/api/v2/";
    private Retrofit retrofit;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private DadosActivity<PartidoGeralActivity> dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        list = findViewById(R.id.ListaDePartidos);
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation_menu);
        bottomNavigation.setSelectedItemId(R.id.nav_partidos);
        bottomNavigation.setOnItemSelectedListener(item -> BottomNavigationMenu.listener(this, item));

        retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        consultarPartidoGeral();
    }

    public void consultarPartidoGeral() {

        RestService restService = retrofit.create(RestService.class);

        Call<DadosActivity<PartidoGeralActivity>> call = restService.consultarPartG();

        call.enqueue(new Callback<DadosActivity<PartidoGeralActivity>>() {
            @Override
            public void onResponse(Call<DadosActivity<PartidoGeralActivity>> call, Response<DadosActivity<PartidoGeralActivity>> response) {
                if(response.isSuccessful()){
                    dados = response.body();

                    for(PartidoGeralActivity x : dados.getDados() ){
                        adapter.add(x.getNome());
                    }

                }
            }

            @Override
            public void onFailure(Call<DadosActivity<PartidoGeralActivity>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Erro" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), PerfilActivity.class);
            intent.putExtra("id", dados.getDados().get(position).getId());
            startActivity(intent);
            finish();

        });
    }

}