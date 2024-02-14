/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dilan Lara
 */
public class Asignacion {
    private int ID_ASIGANCION;
    private String GRUPO;
    private String NOMBRE_PROYECTO;
    private String NOMBRE_DOCENTE;
    private String APELLIDO_DOCENTE;
    private String ESTADO_TAREA;
    private String FECHA_INCIO_TAREA;
    private String FECHA_FIN_TAREA;
    
    public Asignacion(){}

    public Asignacion(int ID_ASIGANCION, String GRUPO, String NOMBRE_PROYECTO, String NOMBRE_DOCENTE, String APELLIDO_DOCENTE, String ESTADO_TAREA, String FECHA_INCIO_TAREA, String FECHA_FIN_TAREA) {
        this.ID_ASIGANCION = ID_ASIGANCION;
        this.GRUPO = GRUPO;
        this.NOMBRE_PROYECTO = NOMBRE_PROYECTO;
        this.NOMBRE_DOCENTE = NOMBRE_DOCENTE;
        this.APELLIDO_DOCENTE = APELLIDO_DOCENTE;
        this.ESTADO_TAREA = ESTADO_TAREA;
        this.FECHA_INCIO_TAREA = FECHA_INCIO_TAREA;
        this.FECHA_FIN_TAREA = FECHA_FIN_TAREA;
    }

    public int getID_ASIGANCION() {
        return ID_ASIGANCION;
    }

    public void setID_ASIGANCION(int ID_ASIGANCION) {
        this.ID_ASIGANCION = ID_ASIGANCION;
    }

    public String getGRUPO() {
        return GRUPO;
    }

    public void setGRUPO(String GRUPO) {
        this.GRUPO = GRUPO;
    }

    public String getNOMBRE_PROYECTO() {
        return NOMBRE_PROYECTO;
    }

    public void setNOMBRE_PROYECTO(String NOMBRE_PROYECTO) {
        this.NOMBRE_PROYECTO = NOMBRE_PROYECTO;
    }

    public String getNOMBRE_DOCENTE() {
        return NOMBRE_DOCENTE;
    }

    public void setNOMBRE_DOCENTE(String NOMBRE_DOCENTE) {
        this.NOMBRE_DOCENTE = NOMBRE_DOCENTE;
    }

    public String getAPELLIDO_DOCENTE() {
        return APELLIDO_DOCENTE;
    }

    public void setAPELLIDO_DOCENTE(String APELLIDO_DOCENTE) {
        this.APELLIDO_DOCENTE = APELLIDO_DOCENTE;
    }

    public String getESTADO_TAREA() {
        return ESTADO_TAREA;
    }

    public void setESTADO_TAREA(String ESTADO_TAREA) {
        this.ESTADO_TAREA = ESTADO_TAREA;
    }

    public String getFECHA_INCIO_TAREA() {
        return FECHA_INCIO_TAREA;
    }

    public void setFECHA_INCIO_TAREA(String FECHA_INCIO_TAREA) {
        this.FECHA_INCIO_TAREA = FECHA_INCIO_TAREA;
    }

    public String getFECHA_FIN_TAREA() {
        return FECHA_FIN_TAREA;
    }

    public void setFECHA_FIN_TAREA(String FECHA_FIN_TAREA) {
        this.FECHA_FIN_TAREA = FECHA_FIN_TAREA;
    }

  
    
    
    
}
