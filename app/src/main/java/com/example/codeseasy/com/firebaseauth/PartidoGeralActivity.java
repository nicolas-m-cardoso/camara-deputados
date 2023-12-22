package com.example.codeseasy.com.firebaseauth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PartidoGeralActivity {

    public PartidoGeralActivity() {
    }

    public PartidoGeralActivity(String id, String nome, String sigla, String uri) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.uri = uri;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("sigla")
    @Expose
    private String sigla;
    @SerializedName("uri")
    @Expose
    private String uri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "PartidoGeral{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}