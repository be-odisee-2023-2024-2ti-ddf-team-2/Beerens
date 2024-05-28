module org.example.beerens_autosoort {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires spring.web;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires jakarta.persistence;


    opens org.example.beerens_autosoort to javafx.fxml;
}