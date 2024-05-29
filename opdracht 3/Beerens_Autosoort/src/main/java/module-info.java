module org.example.beerens_autosoort {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    requires spring.web;
    requires spring.data.jpa;
    requires java.sql;
    requires jakarta.persistence;

    // Open de pakketten voor reflectie door Spring
    opens org.example.beerens_autosoort to spring.core, spring.beans, spring.context, spring.data.jpa;
    opens org.example.beerens_autosoort.controller to spring.core, spring.beans, spring.context;
    opens org.example.beerens_autosoort.dao to spring.core, spring.beans, spring.context;
    opens org.example.beerens_autosoort.domain to spring.core, spring.beans, spring.context;
    opens org.example.beerens_autosoort.service to spring.core, spring.beans, spring.context;
}
