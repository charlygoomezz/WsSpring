package es.upgrade.entidades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype")
@Data
public class Ordenador {

    private String nombre;
    private int precio;
    @Autowired
    private Procesador procesador;
    @Autowired
    private PlacaBase placaBase;
    
    private List<Ram> rams = new ArrayList<Ram>();
    @Autowired
    private DiscoDuro discoDuro;
    @Autowired
    private FuenteAlimentacion fuenteAlimentacion;
    @Autowired
    private TarjetaGrafica tarjetaGrafica;
    
    private List<Periferico> perifericos = new ArrayList<Periferico>();

}