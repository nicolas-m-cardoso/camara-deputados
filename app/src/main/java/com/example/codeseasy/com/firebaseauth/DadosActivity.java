package com.example.codeseasy.com.firebaseauth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DadosActivity<T> {

    public DadosActivity() {
    }

    @SerializedName("dados")
    @Expose
    private List<T> dados;

    public List<T> getDados() {
        return dados;
    }

    public void setDados(List<T> dados) {
        this.dados = dados;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "dados=" + dados +
                '}';
    }
}
