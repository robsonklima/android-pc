package br.com.robsonlima.pertoappcliente.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Os {

    @SerializedName("codOS")
    @Expose
    public Integer codOS;

    public Os(Integer codOS) {
        this.codOS = codOS;
    }

    @Override
    public String toString() {
        return this.codOS.toString();
    }
}