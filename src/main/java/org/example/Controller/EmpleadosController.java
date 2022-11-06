package org.example.Controller;

import org.example.Dominio.Empleado;
import org.example.EmpleadoDAO.EmpleadoDao;

import java.util.List;

public class EmpleadosController {
    private final EmpleadoDao empleadoDao;
    public EmpleadosController(){
        empleadoDao = new EmpleadoDao();
    }

    public List<Empleado> empleados(){
        return empleadoDao.empleados();
    }

    public Empleado crearEmpleado(Empleado empleado){
        return  empleadoDao.crearEmpleado(empleado);
    }

    public void actualizarEmpleado(Integer cedula, Empleado empleado){
      if(empleado.getCedula() <= 0){
          System.out.println("La cédula no debe ser un valor inferior o igual a 0");
          return;
      }
      empleadoDao.actualizarEmpleado(cedula,empleado);
    }

    public void eliminarEmpleado(Integer cedula){
        empleadoDao.eliminarEmpleado(cedula);
    }
}
