package com.danielme.android.navigationdrawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatosResidentes extends RecyclerView.Adapter<DatosResidentes.ViewHolderDatos> {
    private static clsConexionPG conn = new clsConexionPG();
    ArrayList<Residente> listResidentes;

    public DatosResidentes() {
        try {
            listResidentes = new ArrayList<>();
            // En el stsql se puede agregar cualquier consulta SQL deseada.
            String stsql = "select concat_ws(' ', nombre, ap_mat) as persona, direccion from tbpersona t";
            Connection conec = conn.getConnection();

            Statement st = conec.createStatement();
            ResultSet rs = st.executeQuery(stsql);
            while (rs.next())
            {
                Residente residente = new Residente();
                residente.setNombreResidente(rs.getString (1));
                residente.setDireccionResidente(rs.getString (2));

                listResidentes.add(residente);
                //System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getDate(3));
            }


            //this.listResidentes = listaResidentes;

        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    @NonNull
    @Override
    public DatosResidentes.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.residente_item,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatosResidentes.ViewHolderDatos holder, int position) {

        holder.asignarDatos(listResidentes.get(position));
    }

    @Override
    public int getItemCount() {
        return listResidentes.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombreResidente;
        TextView direccionResidente;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            nombreResidente = itemView.findViewById(R.id.residenteId);
            direccionResidente = itemView.findViewById(R.id.residenteDireccion);
        }

        public void asignarDatos(Residente datos) {
            nombreResidente.setText(datos.getNombreResidente());
            direccionResidente.setText(datos.getDireccionResidente());
        }
    }
}
