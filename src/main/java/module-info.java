module es.sergio.mateos.proyectoxml {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.sergio.mateos.proyectoxml;
    opens es.sergio.mateos.proyectoxml to java.xml.bind;
}
