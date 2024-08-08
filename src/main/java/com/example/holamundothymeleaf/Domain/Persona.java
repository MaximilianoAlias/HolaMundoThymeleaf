package com.example.holamundothymeleaf.Domain;

import lombok.Data;

@Data
/*cuando usamos la etiqueta de @Data de "lombok" esta nos crea automaticamente
* pero de manera no visible, los getters, setters, el constructor, los metodos
* equals, hascode, canequals y toString*/
public class Persona {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;


}
