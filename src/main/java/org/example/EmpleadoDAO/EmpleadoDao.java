package org.example.EmpleadoDAO;

import org.example.Connection.MyPostgresConfiguration;
import org.example.Dominio.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {
    private MyPostgresConfiguration myPostgresConfiguration;

    public EmpleadoDao(){

    }

    public List<Empleado> empleados(){
     List<Empleado> getlAllEmpleados = new ArrayList<>();
        String empleadosSql = "SELECT * FROM empleados";
        try(
                Connection connection = MyPostgresConfiguration.dataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(empleadosSql);
                ResultSet resultSet = preparedStatement.executeQuery();
                ){

            while (resultSet.next()){
                Empleado empleado = new Empleado();
                empleado.setCedula(resultSet.getInt("cedula"));
                empleado.setTipoId(resultSet.getString("tipo_id"));
                empleado.setName(resultSet.getString("nombre"));
                empleado.setLastName(resultSet.getString("apellidos"));
                empleado.setCivilState(resultSet.getString("estado_civil"));
                empleado.setSex(resultSet.getString("sexo").charAt(0));
                empleado.setAddress(resultSet.getString("direccion"));
                empleado.setPhone(resultSet.getString("telefono"));
                empleado.setBornDate(resultSet.getString("fecha_nacimiento"));
                getlAllEmpleados.add(empleado);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getlAllEmpleados;
    }

    public Empleado crearEmpleado(Empleado empleado){
        String crearEmpleadoSql = "INSERT INTO empleados(cedula,tipo_id,nombre,apellidos,estado_civil,\n" +
                "\t\t\tsexo,direccion,telefono,fecha_nacimiento)\n" +
                "\t\t\tVALUES(?,?,?,?,?,?,?,?,?)";
        try(
                Connection connection = MyPostgresConfiguration.dataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(crearEmpleadoSql);

                ){
                preparedStatement.setInt(1,empleado.getCedula());
                preparedStatement.setString(2,empleado.getTipoId());
                preparedStatement.setString(3,empleado.getName());
                preparedStatement.setString(4, empleado.getLastName());
                preparedStatement.setString(5,empleado.getCivilState());
                preparedStatement.setString(6,empleado.getSex().toString());
                preparedStatement.setString(7,empleado.getAddress());
                preparedStatement.setString(8,empleado.getPhone());
                preparedStatement.setString(9,empleado.getBornDate());
                preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return empleado;
    }

    public boolean encuentraUnEmpleado(Integer cedula){
        String encuentraEmpleado = "SELECT * FROM empleados WHERE cedula = ?";
        try(
                Connection connection = MyPostgresConfiguration.dataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(encuentraEmpleado)
                ){
             preparedStatement.setInt(1, cedula);
             ResultSet resultSet = preparedStatement.executeQuery();
             if(resultSet.next()){
                 return true;
             }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void actualizarEmpleado(Integer cedula, Empleado empleado){
        if(!encuentraUnEmpleado(cedula)){
            System.out.println("No se pudo encontrar este empleado con cédula = "+cedula);
            return;
        }
        String actualizarSql = "UPDATE empleados SET cedula = ? , tipo_id = ?, nombre = ?, apellidos = ?, estado_civil = ?, " +
                "sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ? WHERE " +
                "cedula = ?";
        try(
                Connection connection = MyPostgresConfiguration.dataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(actualizarSql);
                ){
              preparedStatement.setInt(1,empleado.getCedula());
              preparedStatement.setString(2,empleado.getTipoId());
              preparedStatement.setString(3,empleado.getName());
              preparedStatement.setString(4, empleado.getLastName());
              preparedStatement.setString(5,empleado.getCivilState());
              preparedStatement.setString(6, empleado.getSex().toString());
              preparedStatement.setString(7, empleado.getAddress());
              preparedStatement.setString(8, empleado.getPhone());
              preparedStatement.setString(9, empleado.getBornDate());
              preparedStatement.setInt(10, cedula);
              preparedStatement.execute();
            System.out.println("Empleado actualizado satisfactoriamente :)");

        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void eliminarEmpleado(Integer cedula){
        if(!encuentraUnEmpleado(cedula)){
            System.out.println("No se pudo encontrar este empleado con cédula = "+cedula);
            return;
        }
        String eliminarSql = "DELETE FROM empleados WHERE cedula = ?";
        try(
                Connection connection = MyPostgresConfiguration.dataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(eliminarSql)
        ){
            preparedStatement.setInt(1,cedula);
            preparedStatement.execute();
            System.out.println("Empleado eliminado satisfactoriamente");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
