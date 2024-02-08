/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dilan Lara
 */
public class Proyectos {
    private int ID_PROYECTO;
    private String NOMBRE_PROYECTO;
    private String DESCRIPCION_PROYECTO;
    private String FECHA_INICIO;
    private String FECHA_FIN;
    
    public Proyectos(){}

    public Proyectos(int ID_PROYECTO,String NOMBRE_PROYECTO, String DESCRIPCION_PROYECTO, String FECHA_INICIO, String FECHA_FIN) {
        this.ID_PROYECTO = ID_PROYECTO;
     
        this.NOMBRE_PROYECTO = NOMBRE_PROYECTO;
        this.DESCRIPCION_PROYECTO = DESCRIPCION_PROYECTO;
        this.FECHA_INICIO = FECHA_INICIO;
        this.FECHA_FIN = FECHA_FIN;
    }

    public int getID_PROYECTO() {
        return ID_PROYECTO;
    }

    public void setID_PROYECTO(int ID_PROYECTO) {
        this.ID_PROYECTO = ID_PROYECTO;
    }

    public String getNOMBRE_PROYECTO() {
        return NOMBRE_PROYECTO;
    }

    public void setNOMBRE_PROYECTO(String NOMBRE_PROYECTO) {
        this.NOMBRE_PROYECTO = NOMBRE_PROYECTO;
    }

    public String getDESCRIPCION_PROYECTO() {
        return DESCRIPCION_PROYECTO;
    }

    public void setDESCRIPCION_PROYECTO(String DESCRIPCION_PROYECTO) {
        this.DESCRIPCION_PROYECTO = DESCRIPCION_PROYECTO;
    }

    public String getFECHA_INICIO() {
        return FECHA_INICIO;
    }

    public void setFECHA_INICIO(String FECHA_INICIO) {
        this.FECHA_INICIO = FECHA_INICIO;
    }

    public String getFECHA_FIN() {
        return FECHA_FIN;
    }

    public void setFECHA_FIN(String FECHA_FIN) {
        this.FECHA_FIN = FECHA_FIN;
    }

    
}
