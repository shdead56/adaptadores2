package com.example.adaptadores.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adaptadores.R;

import java.util.ArrayList;

public abstract class Adpagencia extends BaseAdapter implements Filterable {

    // declarando variables para usarlo
    Context context; //almacenar card view
    ArrayList<AgenciasItems.agenciasItems> mdatos; //(llamar datos) el array que se creo en la otra calse , se usa con nombre mdatos
    LayoutInflater inflater; //es un fragmente remplzable dentro del activity de manera dinamica
    Adpagencia.CustomerFilter filtro; //filtra
    ArrayList<AgenciasItems.agenciasItems> filtroList; // (filtar datos)

    //constructor para llamar datos
    public Adpagencia(Context context, ArrayList<AgenciasItems.agenciasItems> datos){
        this.context = context;
        this.mdatos = datos;
        this.filtroList = datos;
    }
    //metodos creados del FILTERABLE x defecto en Android
    @Override
    public int getCount() { // CONTEO , que nos dara la dimension del arreglo
        return mdatos.size();//recuperando la cantidad de elmentos del arreglo
    }
    @Override
    public Object getItem(int posicion) {//poscion del elemnto dentro del arrgelo , en funcion al objeto
        return mdatos.get(posicion);// llmar a la posicion del elemento
    }
    @Override
    public long getItemId(int posicion) { // posicion y busqueda
        return mdatos.indexOf(getItem(posicion)); // se guardara la posicion , buscara la poscion del elmento
    }
    @Override
    // metodo que obtener la imagen y texto y lo reemplaza , dentro del card view
    public View getView(int posicion , View view, ViewGroup parent) {
        TextView txtTtitulo;
        ImageView imgdestino;

        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // inflador dentro del layout

        if (view == null){
            view = inflater.inflate(R.layout.cardview,parent,false);
        }
        txtTtitulo = view.findViewById(R.id.txtTituloDestino);
        imgdestino = view.findViewById(R.id.imgDestino);

        //asignar y capturar
        txtTtitulo.setText(mdatos.get(posicion).getTitulo());
        imgdestino.setImageResource(mdatos.get(posicion).getImagen());
        return view;
    }
    @Override
    public Filter getFilter() {
        if(filtro ==  null){
            filtro = new CustomerFilter(); //filtro del cliente
        }
        return filtro;
    }
    private class CustomerFilter extends  Filter{
        @Override
        protected Filter.FilterResults performFiltering(CharSequence constraint) {

            Filter.FilterResults resulst = new Filter.FilterResults();
            if(constraint != null && constraint.length()>0){
                //pasamos a mayusculas
                constraint = constraint.toString().toUpperCase();

                ArrayList<AgenciasItems.agenciasItems> filtro = new ArrayList<AgenciasItems.agenciasItems>();

                for(Integer i = 0; i<filtroList.size(); i++){
                    if(filtroList.get(i).getTitulo().toUpperCase().contains(constraint)){
                        AgenciasItems.agenciasItems
                                c= new AgenciasItems.agenciasItems(
                                filtroList.get(i).getId(),
                                filtroList.get(i).getTitulo(),
                                filtroList.get(i).getImagen(),
                                filtroList.get(i).getTipoTurismo());

                        filtro.add(c);
                    }
                }
                resulst.count= filtro.size();
                resulst.values = filtro;
            }else{
                resulst.count= filtroList.size();
                resulst.values = filtroList;
            }

            return resulst;
        }

        @Override
        protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
            mdatos = (ArrayList<AgenciasItems.agenciasItems>) results.values;
            notifyDataSetChanged();

        }
    }
}

