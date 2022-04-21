package es.sergio.mateos.proyectoxml;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    static public void guardarFicheroXML(Stage stage, ListaPelicula listaPelicula){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialFileName("fichero.xml");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichero XML ",".xml"));
        
            JAXBContext contexto;
                try {
                    File file = fileChooser.showSaveDialog(stage);
                    contexto = JAXBContext.newInstance(ListaPelicula.class);
                    Marshaller marshaller = contexto.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
                    marshaller.marshal(listaPelicula, System.out);
                    marshaller.marshal(listaPelicula, file);
                } catch (JAXBException ex) {
                    System.out.println("Se ha producido un error");
                    ex.printStackTrace();
                }
        
    }
    
    public static ListaPelicula ImportDatosXML(Stage stage) {
           try {
           
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Import XML en");
            File fileListaPeliculas = fileChooser.showOpenDialog(stage);
           
            JAXBContext context = JAXBContext.newInstance( ListaPelicula.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            ListaPelicula listaPeliculaNuevas = new ListaPelicula();
            listaPeliculaNuevas = (ListaPelicula)unmarshaller.unmarshal(fileListaPeliculas);
             
        return listaPeliculaNuevas;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;          
    }
}
