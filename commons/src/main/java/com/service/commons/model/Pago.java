package com.service.pagos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.pagos.validations.IsValidDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagos", schema = "microservices")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @NotNull
    private String beneficiario;

    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor que cero")
    @Digits(integer = 10, fraction = 2, message = "El monto debe tener máximo dos decimales")
    private BigDecimal monto;


    @IsValidDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaPago;

    @NotNull
    private String idCuenta;

    @JoinColumn(name = "id_tipo_pago")
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private TipoPago tipoPago;



}
