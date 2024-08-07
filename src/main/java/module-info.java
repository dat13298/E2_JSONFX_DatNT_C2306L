module com.c2306l.myproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.sql;
    requires jbcrypt;
    requires mysql.connector.java;

    opens com.c2306l.myproject to javafx.fxml;
    exports com.c2306l.myproject;
    exports com.c2306l.myproject.Controller;
    opens com.c2306l.myproject.Controller to javafx.fxml;
    opens com.c2306l.myproject.Entity to javafx.base;
}