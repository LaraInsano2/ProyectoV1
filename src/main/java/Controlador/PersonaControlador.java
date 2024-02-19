/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Asignacion;
import Modelo.Estudiante;
import Modelo.Grupo;
import Modelo.Proyectos;
import Modelo.Resultados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
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
    int rol = -1;  // Inicializar el rol con un valor predeterminado
    try {
        CallableStatement ejecutar = conectado.prepareCall("{call sp_IniciaSesion(?, ?, ?)}");
        ejecutar.setString(1, usuario);
        ejecutar.setString(2, clave);
        ejecutar.registerOutParameter(3, Types.INTEGER);  // Registro del parámetro de salida
        ejecutar.execute();

        // Obtener el rol desde el parámetro de salida
        rol = ejecutar.getInt(3);

        ejecutar.close();
    } catch (SQLException e) {
        System.out.println("ERROR BDD" + e);
    }
    return rol;
}


 public void CrearEstudiante(Estudiante p1) {
    try {
        String sql = "call sp_RegistrarEstudiante(?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement statement = conectado.prepareStatement(sql)) {
            statement.setString(1, p1.getNOMBRE_ESTUDIANTE());
            statement.setString(2, p1.getAPELLIDO_ESTUDIANTE());
            statement.setInt(3, p1.getCEDULA());
            statement.setString(4, p1.getCORREO());
            statement.setString(5, p1.getUSUARIO());
            statement.setString(6, p1.getCLAVE());
            statement.setInt(7, Estudiante.getROL());
            int result = statement.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Estudiante registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Revisar los datos ingresados");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "COMUNICARSE CON EL ADMINISTRADOR DEL SISTEMA");
    }
}

public void CrearProyecto(Proyectos t1) {
    try {
        String sql = "call sp_CrearProyecto(?, ?, ?, ?)";
        try (PreparedStatement statement = conectado.prepareStatement(sql)) {
            statement.setString(1, t1.getNOMBRE_PROYECTO());
            statement.setString(2, t1.getDESCRIPCION_PROYECTO());
            statement.setString(3, t1.getFECHA_INICIO());
            statement.setString(4, t1.getFECHA_FIN());
            
            int result = statement.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Proyecto creado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear el proyecto. Revisar los datos ingresados");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "COMUNICARSE CON EL ADMINISTRADOR DEL SISTEMA");
    }
}

public void eliminarProyecto(int idProyecto) {
    try {
        String sql = "call sp_EliminarProyecto(?)";
        try (PreparedStatement statement = conectado.prepareStatement(sql)) {
            statement.setInt(1, idProyecto);
            boolean resultado = statement.execute();

            // Si el resultado es verdadero, significa que se ejecutó correctamente
            if (resultado) {
                ResultSet rs = statement.getResultSet();
                if (rs.next()) {
                    String mensaje = rs.getString("mensaje");
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento almacenado");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "COMUNICARSE CON EL ADMINISTRADOR DEL SISTEMA");
    }
}

public void CrearGrupo(Grupo grupo) {
    try {
        String sql = "call sp_CrearGrupos(?, ?, ?, ?)";
        try (PreparedStatement statement = conectado.prepareStatement(sql)) {
            statement.setInt(1, grupo.getID_ESTUDIANTE());
            statement.setString(2, grupo.getGRUPO());
            statement.setInt(3, grupo.getNUM_GRUPO());
            statement.setString(4, grupo.getNOMBRE_ESTUDIANTE());

            int result = statement.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Grupo creado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear el grupo. Revisar los datos ingresados");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "COMUNICARSE CON EL ADMINISTRADOR DEL SISTEMA");
    }
}

public void CrearAsignacion(Asignacion a1) {
    try {
        String sql = "INSERT INTO Asignacion (ID_ASIGNACION, GRUPO, NOMBRE_PROYECTO, NOMBRE_DOCENTE, APELLIDO_DOCENTE, ESTADO_TAREA, FECHA_INICIO_TAREA, FECHA_FIN_TAREA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conectado.prepareStatement(sql)) {
            statement.setInt(1, a1.getID_ASIGANCION());
            statement.setString(2, a1.getGRUPO());
            statement.setString(3, a1.getNOMBRE_PROYECTO());
            statement.setString(4, a1.getNOMBRE_DOCENTE());
            statement.setString(5, a1.getAPELLIDO_DOCENTE());
            statement.setString(6, a1.getESTADO_TAREA());
            statement.setString(7, a1.getFECHA_INCIO_TAREA());
            statement.setString(8, a1.getFECHA_FIN_TAREA());
            int result = statement.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Asignacion creado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear Asignacion. Revisar los datos ingresados");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "COMUNICARSE CON EL ADMINISTRADOR DEL SISTEMA");
    }
}

public void InsertarResultado(Resultados r1) {
    java.util.Date fechaUtil = r1.getFECHA_RESULTADO();
    java.sql.Timestamp fechaSql = new java.sql.Timestamp(fechaUtil.getTime());

    try {
        String sql = "CALL sp_InsertarResultado(?, ?, ?, ?)";
        try (PreparedStatement statement = conectado.prepareStatement(sql)) {
            statement.setString(1, r1.getNOMBRE_PROYECTO());
            statement.setString(2, r1.getGRUPO());
            statement.setString(3,r1.getDESCRIPCION());
            statement.setTimestamp(4, fechaSql);

            int result = statement.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Resultado insertado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el resultado. Revisar los datos ingresados");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento almacenado: " + e.getMessage());
    }
}




    public ArrayList<Object[]> VerResultados() {
       
    ArrayList<Object[]> listaResutaldo = new ArrayList<>();
        try {
            String SQL = "CALL MostrarResultados()";
            ejecutar = (PreparedStatement) conectado.prepareCall(SQL);
            ResultSet res = ejecutar.executeQuery();

            while (res.next()) {
                Object[] fila = new Object[8];
                for (int i = 0; i < 8; i++) {
                    fila[i] = res.getObject(i + 1);
                }
                listaResutaldo.add(fila);

            }
            res.close();
            return listaResutaldo;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;

    }
}




   


   



    
    
    


