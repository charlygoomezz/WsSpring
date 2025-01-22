package es.upgrade.entidades;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype")
@Data
public class FuenteAlimentacion {
	private String marca;
    private String modelo;
    private int potencia;
}
