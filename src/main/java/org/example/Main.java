package org.example;

import org.example.Controller.EmpleadosController;
import org.example.Dominio.Empleado;

public class Main {
    public static void main(String[] args) {

        EmpleadosController empleadosController = new EmpleadosController();
        //LISTA LOS EMPLEADOS
        /*empleadosController.empleados().forEach(System.out::println);*/

        //CREA LOS EMPLEADOS
        /*Empleado empleado = new Empleado();
        empleado.setCedula(11025895);
        empleado.setTipoId("CC");
        empleado.setName("Andrea");
        empleado.setLastName("Gonzales");
        empleado.setCivilState("Casada");
        empleado.setSex('F');
        empleado.setAddress("CRA 65 # 36 A 88");
        empleado.setPhone("5541298");
        empleado.setBornDate("1989-01-06");
        System.out.println(empleadosController.crearEmpleado(empleado));*/

        //ACTUALIZAR UN EMPLEADO
        /*Empleado empleado = new Empleado();
        empleado.setCedula(11025895);
        empleado.setTipoId("CC");
        empleado.setName("Andrea");
        empleado.setLastName("Gonzales");
        empleado.setCivilState("Viuda");
        empleado.setSex('F');
        empleado.setAddress("CRA 65 # 36 A 88");
        empleado.setPhone("8874120");
        empleado.setBornDate("1989-01-06");
        empleadosController.actualizarEmpleado(11025895, empleado);*/

        /*empleadosController.eliminarEmpleado(10023654);*/
    }
}