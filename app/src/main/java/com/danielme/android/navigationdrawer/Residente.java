package com.danielme.android.navigationdrawer;

import java.io.Serializable;

public class Residente implements Serializable {
    private String nombreResidente;
    private String direccionResidente;

    public Residente() {
    }

    public Residente(String nombreResidente, String direccionResidente) {
        this.nombreResidente = nombreResidente;
        this.direccionResidente = direccionResidente;
    }

    public String getNombreResidente() {
        return nombreResidente;
    }

    public void setNombreResidente(String nombreResidente) {
        this.nombreResidente = nombreResidente;
    }

    public String getDireccionResidente() {
        return direccionResidente;
    }

    public void setDireccionResidente(String direccionResidente) {
        this.direccionResidente = direccionResidente;
    }
}
