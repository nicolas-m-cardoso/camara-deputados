package com.example.codeseasy.com.firebaseauth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Dado<T> {

    public Dado() {
    }

    @SerializedName("dados")
    @Expose
    private T dado;

    public T getDados() {
        return dado;
    }

    public void setDados(T dado) {
        this.dado = dado;
    }

    @Override
    public String toString() {
        return "Dado{" +
                "dado=" + dado +
                '}';
    }
}
