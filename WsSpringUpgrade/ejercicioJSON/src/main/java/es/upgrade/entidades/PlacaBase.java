package es.upgrade.entidades;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype")
@Data
public class PlacaBase {
	private String modelo;
    private String marca;
    private int slotsRam;

}
