package service;

import dao.CuentaDao;
import model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaService {
    @Autowired
    private CuentaDao cuentaDao;

    public Cuenta getCuentaById(Long idCuenta) {
      return  cuentaDao.findById(idCuenta).orElse(null);
    }

    @Transactional
    public Cuenta createCuenta(Cuenta cuenta) { return cuentaDao.save(cuenta);
    }

    @Transactional
    public void deleteCuenta(Cuenta cuenta) { cuentaDao.delete(cuenta);
    }
}
