package com.cuentas.demo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cuentas", schema = "microservices")
public class Cuenta {
    @Id
    @Column(name = "nro_cuenta", unique = true)
    private String nroCuenta;
    @Column(name = "id_cliente")
    private Long cliente;
    private int saldo;
    private int CBU;
    private String tipoCuenta;

}
