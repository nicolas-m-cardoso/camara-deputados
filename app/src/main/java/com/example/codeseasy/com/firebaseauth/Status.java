package com.example.codeseasy.com.firebaseauth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("situacao")
    @Expose
    private String situacao;
    @SerializedName("totalMembros")
    @Expose
    private String totalMembros;
    @SerializedName("totalPosse")
    @Expose
    private String totalPosse;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTotalMembros() {
        return totalMembros;
    }

    public void setTotalMembros(String totalMembros) {
        this.totalMembros = totalMembros;
    }

    public String getTotalPosse() {
        return totalPosse;
    }

    public void setTotalPosse(String totalPosse) {
        this.totalPosse = totalPosse;
    }

    @Override
    public String toString() {
        return "Status{" +
                "situacao='" + situacao + '\'' +
                ", totalMembros='" + totalMembros + '\'' +
                ", totalPosse='" + totalPosse + '\'' +
                '}';
    }
}