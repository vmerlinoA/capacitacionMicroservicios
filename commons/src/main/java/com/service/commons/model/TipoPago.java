package com.service.pagos.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipospago")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPago;
    private String descripcion;
}
