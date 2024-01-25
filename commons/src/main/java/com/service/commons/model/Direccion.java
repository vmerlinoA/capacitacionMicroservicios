package com.service.usuarios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "direcciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue
    private Long idDireccion;
    private String pais;
    private String provincia;
    private String ciudad;
    private String codPostal;
    private String nro;
    private String piso;
    private String depto;
    @JoinColumn(name = "idUsuario")
    @ManyToOne
    private Usuario idUsuario;
}
