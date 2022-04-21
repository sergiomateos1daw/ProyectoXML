package es.sergio.mateos.proyectoxml;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaPelicula {
    private ArrayList<Pelicula> listaPeliculas = new ArrayList();
    
    public ArrayList<Pelicula> getListaPeliculas(){
        return listaPeliculas;
    }
    
    @XmlElement(name = "pelicula")
    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas){
        this.listaPeliculas = listaPeliculas;
    }
    
    
    public void fusionarPeliculas(ListaPelicula listaPeliculaNueva){
        this.getListaPeliculas().addAll(listaPeliculaNueva.getListaPeliculas());
    }
    
}
