package com.example.codeseasy.com.firebaseauth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeputadoActivity {
    @SerializedName("cpf")
    @Expose
    private String cpf;
    @SerializedName("dataNascimento")
    @Expose
    private String dataNascimento;
    @SerializedName("escolaridade")
    @Expose
    private String escolaridade;
    @SerializedName("nomeCivil")
    @Expose
    private String nomeCivil;
    @SerializedName("sexo")
    @Expose
    private String sexo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getNomeCivil() {
        return nomeCivil;
    }

    public void setNomeCivil(String nomeCivil) {
        this.nomeCivil = nomeCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Deputado{" +
                "cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", escolaridade='" + escolaridade + '\'' +
                ", nomeCivil='" + nomeCivil + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}