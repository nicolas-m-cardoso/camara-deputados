package com.example.codeseasy.com.firebaseauth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeputadoGeralActivity {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("siglaPartido")
    @Expose
    private String siglaPartido;
    @SerializedName("urlFoto")
    @Expose
    private String urlFoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return " " + id + ": " + nome + " - " + siglaPartido;
    }
}