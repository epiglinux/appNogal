package com.danielme.android.navigationdrawer;

public class VariablesGlobales {
    private static VariablesGlobales instance;

    private static String _idUser = "0";
    private static String _nombreCompleto = "";
    private static String _edad = "";
    private static String _direccion = "";
    private static String _mail = "";

    public String get_direccion() { return _direccion;  }

    public String get_idUser() {
        return _idUser;
    }

    public void set_idUser(String _idUser) {
        this._idUser = _idUser;
    }

    public String get_nombreCompleto() {
        return _nombreCompleto;
    }

    public void set_nombreCompleto(String _nombreCompleto) {
        this._nombreCompleto = _nombreCompleto;
    }

    public String get_edad() {
        return _edad;
    }

    public void set_edad(String _edad) {
        this._edad = _edad;
    }

    public void set_direccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String get_mail() {
        return _mail;
    }

    public void set_mail(String _mail) {
        this._mail = _mail;
    }

    public synchronized VariablesGlobales getInstance(){
        if(instance == null){
            instance = new VariablesGlobales();
        }
        return instance;
    }
}
