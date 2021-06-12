package com.example.adaptadores.Adaptadores;

import com.example.adaptadores.R;

import java.util.ArrayList;
import java.util.List;

public class AgenciasItems {
    // declaro el arreglo
    private static final List<agenciasItems> ITEMS = new ArrayList<agenciasItems>();
    //contenido del arreglo
    static {
        addItem(new AgenciasItems.agenciasItems ("1","TaytaIntiTours", R.drawable.age1,"aventura"));
        addItem(new AgenciasItems.agenciasItems("2","MachuppicchuAgency",R.drawable.age3,"aventura"));
        addItem(new AgenciasItems.agenciasItems("3","Amaru", R.drawable.age4,"aventura"));
        addItem(new AgenciasItems.agenciasItems("4","Viajes", R.drawable.age5,"aventura"));
        addItem(new AgenciasItems.agenciasItems("5","ViajesCusco", R.drawable.age3,"aventura"));
    }
    //metodo que contruye el arreglo , metodo principal
    static void addItem(AgenciasItems.agenciasItems item){
        ITEMS.add(item);
    }
    // metodo para agregar objetos
    public static ArrayList<AgenciasItems.agenciasItems> ArregloLista (){
        ArrayList<AgenciasItems.agenciasItems> d = new ArrayList<AgenciasItems.agenciasItems>();
        for(AgenciasItems.agenciasItems obj:ITEMS){
            d.add(obj);
        }
        return d;
    }
    // metodo para traer datos
    public static AgenciasItems.agenciasItems getAgenciasItems(String id){
        for(AgenciasItems.agenciasItems obj:ITEMS){
            if (obj.id.equals(id)){
                return obj;
            }
        }
        return ITEMS.get(1); // busqueda título
    }
    // crear arreglo
    public static class agenciasItems {

        private String id;
        private String titulo;
        private Integer imagen;
        private String tipoTurismo;

        public agenciasItems(String id,String titulo,Integer imagen,String tipoTurismo){
            this.id = id;
            this.titulo = titulo;
            this.imagen = imagen;
            this.tipoTurismo = tipoTurismo;
        }
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Integer getImagen() {
            return imagen;
        }

        public void setImagen(Integer imagen) {
            this.imagen = imagen;
        }

        public String getTipoTurismo() {
            return tipoTurismo;
        }

        public void setTipoTurismo(String tipoTurismo) {
            this.tipoTurismo = tipoTurismo;
        }
    }
}

