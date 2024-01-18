package controller;

import model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CuentaService;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;
    @GetMapping("/{idCuenta}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable(name = "idCuenta") Long idCuenta){
        Cuenta cuenta = cuentaService.getCuentaById(idCuenta);
        if(cuenta == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cuenta);
    }

    @PostMapping("")
    public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta){
        cuenta = cuentaService.createCuenta(cuenta);
        if(cuenta == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cuenta);
    }

    @DeleteMapping("")
    public void deleteCuenta(@RequestBody Cuenta cuenta){
        cuentaService.deleteCuenta(cuenta);
    }
}
