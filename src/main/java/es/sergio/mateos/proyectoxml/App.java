package es.sergio.mateos.proyectoxml;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    ListaPelicula listaPelicula;
    int peliActual = 0;
    int id = 1;
    ImageView banner;
    ImageView caratula;
    Image caratula0Img;
    Image caratula1Img;
    Image caratula2Img;
    Image caratula3Img;
    Image caratula4Img;
    Image caratula5Img;
    Image caratula6Img;
    Image caratula7Img;
    Image caratula8Img;
    Image caratula9Img;
    Image caratula10Img;
    Image caratula11Img;
    Image caratula12Img;
    
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.TOP_CENTER);
        HBox hBoxBanner = new HBox(20);
        HBox hBoxBotonesArriba = new HBox(20);
        Label labelPeliculas = new Label();
        HBox hBoxBotonesAbajo = new HBox(20);
        HBox hBoxImagenFooter = new HBox(20);
        hBoxBanner.setAlignment(Pos.CENTER);
        hBoxBotonesArriba.setAlignment(Pos.CENTER);
        hBoxBotonesAbajo.setAlignment(Pos.CENTER);
        hBoxImagenFooter.setAlignment(Pos.CENTER);
        var scene = new Scene(root, 640, 480);
        
        ///////// AÑADIMOS EL BANNER ///////////
        Image bannerImg = new Image(getClass().getResourceAsStream("/images/banner.png")); // CARGA LA IMAGEN DE FONDO
        banner = new ImageView(bannerImg);
        root.getChildren().add(banner);
        ////////////////////////////////////////
        
        root.getChildren().add(hBoxBanner);
        root.getChildren().add(hBoxBotonesArriba);
        root.getChildren().add(labelPeliculas);
        root.getChildren().add(hBoxBotonesAbajo);
        root.getChildren().add(hBoxImagenFooter);
        stage.setScene(scene);
        stage.show();
        
        
        
        ///////// AÑADIMOS LA IMAGEN DE BLURAY ///////////
        caratula0Img = new Image(getClass().getResourceAsStream("/images/caratulas/0.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula1Img = new Image(getClass().getResourceAsStream("/images/caratulas/1.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula2Img = new Image(getClass().getResourceAsStream("/images/caratulas/2.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula3Img = new Image(getClass().getResourceAsStream("/images/caratulas/3.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula4Img = new Image(getClass().getResourceAsStream("/images/caratulas/4.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula5Img = new Image(getClass().getResourceAsStream("/images/caratulas/5.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula6Img = new Image(getClass().getResourceAsStream("/images/caratulas/6.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula7Img = new Image(getClass().getResourceAsStream("/images/caratulas/7.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula8Img = new Image(getClass().getResourceAsStream("/images/caratulas/8.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula9Img = new Image(getClass().getResourceAsStream("/images/caratulas/9.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula10Img = new Image(getClass().getResourceAsStream("/images/caratulas/10.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula11Img = new Image(getClass().getResourceAsStream("/images/caratulas/11.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        caratula12Img = new Image(getClass().getResourceAsStream("/images/caratulas/12.jpg")); // CARGA LA IMAGEN DE LA CARATULA 
        
        caratula = new ImageView(caratula1Img);
        hBoxImagenFooter.getChildren().add(caratula);
        ////////////////////////////////////////
        
        Pelicula pelicula1 = new Pelicula("Capitán América: El primer vengador");
        pelicula1.setDirector("Joe Johnston");
        pelicula1.setDuracion(124);
        pelicula1.setFechaEstreno("22/07/2011");
        pelicula1.setPrecio(11.13F);
        pelicula1.setProtagonista("Chris Evans");
        pelicula1.setId(1);
        
        listaPelicula = new ListaPelicula();
        listaPelicula.getListaPeliculas().add(pelicula1);
         
        labelPeliculas.setText(listaPelicula.getListaPeliculas().get(peliActual).toString()); // MOSTAR LA PRIMERA PELICULA EN EL TEXTAREA
        System.out.println("Número de películas en el catálogo: "+listaPelicula.getListaPeliculas().size());
        
        Button buttonExport = new Button("Exportar XML");
        hBoxBotonesArriba.getChildren().add(buttonExport);
        
        buttonExport.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("Has pulsado el botón exportar");
            UtilXML.guardarFicheroXML(stage, listaPelicula);
        });
        
        Button buttonImport = new Button("Importar XML");
        hBoxBotonesArriba.getChildren().add(buttonImport);
        
        buttonImport.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("Has pulsado el botón importar");
            ListaPelicula peliculasImport = UtilXML.ImportDatosXML(stage);
            listaPelicula.fusionarPeliculas(peliculasImport);
        });
        
        Button buttonPrevius = new Button("Película anterior");
        hBoxBotonesAbajo.getChildren().add(buttonPrevius);
        buttonPrevius.setOnAction((t) -> {
           if (peliActual>0){
              peliActual--;
           }
           
           System.out.println("Has pulsado el botón Película anterior");
           System.out.println(peliActual);
           cambioCaratula();
        try {
               labelPeliculas.setText(listaPelicula.getListaPeliculas().get(peliActual).toString());
           } catch (Exception ex){

           }
        });
        
        Button buttonNext = new Button("Siguiente película");
        hBoxBotonesAbajo.getChildren().add(buttonNext);
        buttonNext.setOnAction((t) -> { 
           if (peliActual<listaPelicula.getListaPeliculas().size()-1){
            peliActual++;
           }
           System.out.println("Has pulsado el botón Siguiente película");
           System.out.println(peliActual);
           cambioCaratula();
        try {
               labelPeliculas.setText(listaPelicula.getListaPeliculas().get(peliActual).toString());
           } catch (Exception ex){

           }
        });
        
    }
    
    public void cambioCaratula(){
       id = listaPelicula.getListaPeliculas().get(peliActual).getId();
       switch(id){
            case 1:
               caratula.setImage(caratula1Img);
            break;
            case 2:
               caratula.setImage(caratula2Img);
            break;
            case 3:
               caratula.setImage(caratula3Img);
            break;
            case 4:
               caratula.setImage(caratula4Img);
            break;
            case 5:
               caratula.setImage(caratula5Img);
            break;
            case 6:
               caratula.setImage(caratula6Img);
            break;
            case 7:
               caratula.setImage(caratula7Img);
            break;
            case 8:
               caratula.setImage(caratula8Img);
            break;
            case 9:
               caratula.setImage(caratula9Img);
            break;
            case 10:
               caratula.setImage(caratula10Img);
            break;
            case 11:
               caratula.setImage(caratula11Img);
            break;
            case 12:
               caratula.setImage(caratula12Img);
            break;
            default:
               caratula.setImage(caratula0Img); 
       }
    }

    public static void main(String[] args) {
        launch();
    }

}