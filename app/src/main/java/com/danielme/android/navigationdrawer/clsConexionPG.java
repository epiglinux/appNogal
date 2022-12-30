package com.danielme.android.navigationdrawer;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class clsConexionPG {
    Connection connection = null;

    public Connection getConnection() {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("com.mysql.jdbc.Driver").newInstance ();

            //mysql://bteydfyxqju332no:v589fuak8mv8vq2z@cwe1u6tjijexv3r6.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/zp7tkm70x5jzlltc
            connection = DriverManager.getConnection("jdbc:mysql://cwe1u6tjijexv3r6.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/zp7tkm70x5jzlltc?characterEncoding=latin1&useConfigs=maxPerformance&sslmode=require","bteydfyxqju332no","v589fuak8mv8vq2z");
            //connection = DriverManager.getConnection("jdbc:postgresql://ec2-18-211-236-255.compute-1.amazonaws.com:5432/d8guranqf0fmj9?sslmode=require","ddrkkuidowpvvo","8716a60f7a2ce603303926a5c49b8076daaec0e257503924fb9d3d0fb35e8c9c");
            System.out.println("Conectado..");
        }catch (Exception er){
            System.err.println("este es un error");
        };
        return connection;
    }

    //cerramos la conexion de la base de datos
    protected void cerrarConexion(Connection conn)throws Exception {
        conn.close();
    }
}
