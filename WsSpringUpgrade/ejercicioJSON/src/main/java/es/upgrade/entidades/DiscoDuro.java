package es.upgrade.entidades;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype")
@Data
public class DiscoDuro {
	private String marca;
    private String tipo;
    private String capacidad;
}
