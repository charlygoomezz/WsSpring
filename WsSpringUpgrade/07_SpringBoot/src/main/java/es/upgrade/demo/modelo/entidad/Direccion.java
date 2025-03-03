package es.upgrade.demo.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Para trabajar con las librerias lombok, tenemos que meter
 * en el pom las librerias y además instalar el plugin
 * 
 */

@Component
@Scope("protoype")
@Data
public class Direccion {
	private String tipoVia;
	private String nombreVia;
	private String pais;
}
