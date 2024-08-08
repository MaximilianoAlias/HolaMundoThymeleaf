package com.example.holamundothymeleaf.Controllers;

import com.example.holamundothymeleaf.Domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControllerInicio {

    /*para acceder a los valores de las variables creadas en el application.properties
    * lo que debo hacer es crear una variable del tipo que se necesite en el application.properties,
    * por ejemplo String y de la siguiente manera -> index.mensaje = "mensajito".
    *  usar la etiqueta @Value() de sprinboot en la clase controller y entre medio de los parentesis
    * tengo que agregar la variable que fue creada en el application.properties, que en nuestro caso
    * fue index.mensaje.*/

    @Value("${index.mensaje}") //variable creada en application.properties
    private String mensaje;

    @GetMapping("/")

    public String inicio(Model model){
        var saludar = "Hola Mundo con Thymeleaf";
        var prueba = "Usando al variable pureba";
        var listaVacia = "La lista se encuentra vacia";

        var persona = new Persona();
        persona.setApellido("Alias");
        persona.setNombre("Maximiliano Damian");
        persona.setEmail("damianalias1991@gmail.com");
        persona.setTelefono("3513499985");

        var persona2 = new Persona();
        persona2.setApellido("Gonzalez");
        persona2.setNombre("Estrella Soledad");
        persona2.setEmail("estregon174@gmail.com");
        persona2.setTelefono("1131561018");

        var persona3 = new Persona();
        persona3.setApellido("Gallardo");
        persona3.setNombre("Luis Yair");
        persona3.setEmail("lgallardo@gmail.com");
        persona3.setTelefono("12345678");

        var persona4 = new Persona();
        persona4.setApellido("Alias");
        persona4.setNombre("Emilia Aracelli");
        persona4.setEmail("emi.ar.alias@gmail.com");
        persona4.setTelefono("35120202091");

       /* List<Persona> personas = new ArrayList<Persona>(); de esta manera es como se crea un arrayList
       * y se agregan los objetos ya creados con el metodo personas.add(persona) y personas.add(persona2)
       * pero hay una manera muchisimo mas sencilla que la vamos a realizar a continuacion: */

        var listaPersonas = Arrays.asList(persona, persona2, persona3, persona4);
       // var listaPersonas = new ArrayList<>();



        log.info("Ejecutando la clase ControllerInicio");

        model.addAttribute("saludar", saludar);
        model.addAttribute("prueba", prueba);
        /*a la variable que cree en el application.properties la tengo
        * que agregar de la misma manera que a las variables locales*/
        model.addAttribute("mensaje", mensaje);
        //model.addAttribute("persona", persona);
        model.addAttribute("listaPersonas", listaPersonas);
        model.addAttribute("listaVacia", listaVacia);

        return "index";
    }
}
