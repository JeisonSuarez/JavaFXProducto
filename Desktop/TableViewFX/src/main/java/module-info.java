module uni.edu.uni.fcys.programacion2.tableviewfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens uni.edu.uni.fcys.programacion2.tableviewfx to javafx.fxml;
    exports uni.edu.uni.fcys.programacion2.tableviewfx;
    exports uni.edu.uni.fcys.programacion2.tableviewfx.controllers;
    exports uni.edu.uni.fcys.programacion2.tableviewfx.pojo;
    
}
