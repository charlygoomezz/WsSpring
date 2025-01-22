package configuracion;

import org.springframework.context.annotation.ComponentScan;

//Esto aplica igual que en el XML, es decir busca anotaciones spring en 
//los paquetes que le digamos
@ComponentScan(basePackages ="modelo.entidad")
public class ConfiguracionSpring {

}
