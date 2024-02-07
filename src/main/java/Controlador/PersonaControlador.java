/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.Persona;
import Vista.InicioDeSesion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author Dilan Lara
 */
public class PersonaControlador {
    private Estudiante estudiante;
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet res;
    
    
    
    public PersonaControlador() {
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante persona) {
        this.estudiante = persona;
    }


 public int verificarCredenciales(String usuario, String clave) {
    int estado = 0;
    try {
        CallableStatement ejecutar = conectado.prepareCall("{call sp_InicioSesion(?, ?, ?)}");
        ejecutar.setString(1, usuario);
        ejecutar.setString(2, clave);
        ejecutar.registerOutParameter(3, Types.INTEGER);
        ejecutar.execute();
        estado = ejecutar.getInt(3);
        ejecutar.close();
        return estado;
    } catch (SQLException e) {
        System.out.println("ERROR BDD" + e);
    }
    return estado;
}



 public void CrearPersona(Persona p1) {
    try {
        String sql = "{call sp_Crearpersona(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement callableStatement = conectado.prepareCall(sql)) {
            callableStatement.setString(1, p1.getNOMBRE_PERSONA());
            callableStatement.setString(2, p1.getAPELLIDO_PERSONA());
            callableStatement.setInt(3, p1.getCEDULA());
            callableStatement.setString(4, p1.getUSUARIO());
            callableStatement.setString(5, p1.getCLAVE());
            callableStatement.setInt(6, p1.getROL_PERSONA());

            int resultado = callableStatement.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Persona Creada con Éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Revise los Datos ingresados");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
    }
}

   
}

   



    
    
    


