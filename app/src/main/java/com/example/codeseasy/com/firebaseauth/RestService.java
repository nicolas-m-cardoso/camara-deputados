package com.example.codeseasy.com.firebaseauth;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestService {
    @GET("deputados/{id}")
    Call<Dado<DeputadoActivity>> consultarDep(@Path("id") Integer id);

    @GET("partidos/{id}")
    Call<Dado<PartidoActivity>> consultarPart(@Path("id") String id);

    @GET("deputados?")
    Call<DadosActivity<DeputadoGeralActivity>> consultarDepG(@Query("siglaPartido") String sigla);

    @GET("partidos")
    Call<DadosActivity<PartidoGeralActivity>> consultarPartG();
}
