package com.danielme.android.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.CallableStatement;
import java.sql.Types;

public class LoginActivity extends AppCompatActivity {
    private static clsConexionPG conn = new clsConexionPG();

    EditText usuario, pass;
    Button iniciaSesion;

    VariablesGlobales vg = new VariablesGlobales().getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //se crean los valores de los inputs
        usuario = findViewById(R.id.txtusuario);
        pass = findViewById(R.id.txtPassword);
        iniciaSesion = findViewById(R.id.btnlogin);

        iniciaSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    IniciarSesion(usuario.getText().toString(),pass.getText().toString());
                }
            }
        );

    }

    public void IniciarSesion(String user, String pass){
        try{
//            System.out.println("ejecutando paquete..");
            String strProcedureCall = "{CALL zp7tkm70x5jzlltc.pa_logueo_android(?,?,?,?,?,?,?,?)}";
            CallableStatement cstm = conn.getConnection().prepareCall(strProcedureCall);

            cstm.setString(1,user);
            cstm.setString(2,pass);
            cstm.registerOutParameter(3, Types.VARCHAR);
            cstm.registerOutParameter(4, Types.VARCHAR);
            cstm.registerOutParameter(5, Types.VARCHAR);
            cstm.registerOutParameter(6, Types.VARCHAR);
            cstm.registerOutParameter(7, Types.VARCHAR);
            cstm.registerOutParameter(8, Types.VARCHAR);

            cstm.executeUpdate();
            System.out.println("ejecutando paquete 2");

            String idUser = cstm.getString(3);
            String nombreCompleto = cstm.getString(4);
            String edad = cstm.getString(5);
            String mail = cstm.getString(6);
            String direccion = cstm.getString(7);
            String msj = cstm.getString(8);
            //String msj = "OK";

            if (msj.equals("OK")){
                vg.set_idUser(idUser);
                vg.set_nombreCompleto(nombreCompleto);
                vg.set_edad(edad);
                vg.set_direccion(direccion);
                vg.set_mail(mail);

                //abrimos el activity menu
                Intent menu = new Intent(this, HomeActivity.class);
                menu.putExtra("usuario", user);
                startActivity(menu);

            }else{
                Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}