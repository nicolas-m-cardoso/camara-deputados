package com.example.codeseasy.com.firebaseauth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartidoActivity {
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("sigla")
    @Expose
    private String sigla;
    @SerializedName("urlLogo")
    private String logo;
    @SerializedName("status")
    @Expose
    private Status status;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", logo='" + logo + '\'' +
                ", status=" + status +
                '}';
    }
}