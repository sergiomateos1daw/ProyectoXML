package es.sergio.mateos.proyectoxml;

public class Pelicula {
    
    private String titulo;
    private String director;
    private String Protagonista;
    private String fechaEstreno;
    private int duracion;
    private float precioBluRay;
    private int id;
    
    public Pelicula(){
        
    }
    
    public Pelicula(String titulo){
        this.titulo = titulo.toUpperCase();
    }
    
    public Pelicula(String titulo, String director){
        this.titulo = titulo.toUpperCase();
        this.director = director;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo.toUpperCase();
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public String getDirector(){
        return director;
    }
    
    public String getProtagonista(){
        return Protagonista;
    }
    
    public void setProtagonista(String Protagonista){
        this.Protagonista = Protagonista;
    }
    
    public int getDuracion(){
        return duracion;
    }
    
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }
    
    public float getPrecio(){
        return precioBluRay;
    }
    
    public void setPrecio(float precio){
        this.precioBluRay = precio;
    }
    
    public String getFechaEstreno(){
        return fechaEstreno;
    }
    
    public void setFechaEstreno(String fechaEstreno){
        this.fechaEstreno = fechaEstreno;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        String r = "";
        r += "Titulo: " + titulo + "\n";
        r += "Director: " + director + "\n";
        r += "Protagonista principal: " + Protagonista + "\n";
        r += "Fecha de estreno: " + fechaEstreno + "\n";
        r += "Duración: " + duracion + " minutos" +"\n";
        r += "Precio BluRay: " + precioBluRay;
        return r;
    }
}

