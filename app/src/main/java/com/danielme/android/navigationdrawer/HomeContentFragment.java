package com.danielme.android.navigationdrawer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeContentFragment extends Fragment {

  private static final String TEXT = "text";
  VariablesGlobales vg = new VariablesGlobales().getInstance();
  TextView _id, _nombrecompleto, _edad, _mail, _direccion;
  RecyclerView recyclerResidentes;
  ArrayList<String> listResidentes;

  public static HomeContentFragment newInstance(String text) {
    HomeContentFragment frag = new HomeContentFragment();

    Bundle args = new Bundle();
    args.putString(TEXT, text);
    frag.setArguments(args);

    return frag;
  }

  @SuppressLint("MissingInflatedId")
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
          Bundle savedInstanceState) {
    //View layout = inflater.inflate(R.layout.home_fragment, container, false);
    View layout = inflater.inflate(R.layout.home_fragment, container, false);

    if (getArguments() != null) {
      switch (getArguments().getString(TEXT)){
        case "Residentes":{
          layout = inflater.inflate(R.layout.fragment_residentes, container, false);
          listResidentes = new ArrayList<>();
          recyclerResidentes = layout.findViewById(R.id.recyclerId);
          recyclerResidentes.setLayoutManager(new LinearLayoutManager(getContext()));
          llenarLista();
          DatosResidentes adapter = new DatosResidentes();
          recyclerResidentes.setAdapter(adapter);
          break;
        }
        case "Pagos":{
          System.out.println("Usted eligió la opcion Pagos.");
          break;
        }
        case "Mensajes":{
          System.out.println("Usted eligió la opcion Mensajes.");
          break;
        }
      }//cierra SWITCH

    }else{
      ((TextView) layout.findViewById(R.id.text)).setText("Seleccione una opcion del menu.");
    }

     /*if (getArguments() != null) {
        ((TextView) layout.findViewById(R.id.text)).setText(getArguments().getString(TEXT));
      }

    _nombrecompleto = layout.findViewById(R.id.nombreComp);
    _edad = layout.findViewById(R.id.edad);
    _direccion = layout.findViewById(R.id.direccion);
    _mail = layout.findViewById(R.id.mail);

    if (!vg.get_idUser().equals("0")){
      _nombrecompleto.setText(vg.get_idUser() + " - " + vg.get_nombreCompleto());
      _edad.setText(vg.get_edad());
      _direccion.setText(vg.get_direccion());
      _mail.setText(vg.get_mail());
    }*/

    return layout;
  }

  private void llenarLista() {
    listResidentes.add("Epigmenio");
    listResidentes.add("Antonio");
  }
}

