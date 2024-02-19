/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;


/**
 *
 * @author Dilan Lara
 */
public class Resultados {
    private int ID_RESULTADO;
    private int ID_PROYECTOS;
    private int ID_GRUPO;
    private String NOMBRE_PROYECTO;
    private String GRUPO;
    private String DESCRIPCION;
    private Date FECHA_RESULTADO;
    
    public Resultados(){}

    public Resultados(int ID_RESULTADO, int ID_PROYECTOS, int ID_GRUPO, String NOMBRE_PROYECTO, String GRUPO, String DESCRIPCION, Date FECHA_RESULTADO) {
        this.ID_RESULTADO = ID_RESULTADO;
        this.ID_PROYECTOS = ID_PROYECTOS;
        this.ID_GRUPO = ID_GRUPO;
        this.NOMBRE_PROYECTO = NOMBRE_PROYECTO;
        this.GRUPO = GRUPO;
        this.DESCRIPCION = DESCRIPCION;
        this.FECHA_RESULTADO = FECHA_RESULTADO;
    }

    public int getID_RESULTADO() {
        return ID_RESULTADO;
    }

    public void setID_RESULTADO(int ID_RESULTADO) {
        this.ID_RESULTADO = ID_RESULTADO;
    }

    public int getID_PROYECTOS() {
        return ID_PROYECTOS;
    }

    public void setID_PROYECTOS(int ID_PROYECTOS) {
        this.ID_PROYECTOS = ID_PROYECTOS;
    }

    public int getID_GRUPO() {
        return ID_GRUPO;
    }

    public void setID_GRUPO(int ID_GRUPO) {
        this.ID_GRUPO = ID_GRUPO;
    }

    public String getNOMBRE_PROYECTO() {
        return NOMBRE_PROYECTO;
    }

    public void setNOMBRE_PROYECTO(String NOMBRE_PROYECTO) {
        this.NOMBRE_PROYECTO = NOMBRE_PROYECTO;
    }

    public String getGRUPO() {
        return GRUPO;
    }

    public void setGRUPO(String GRUPO) {
        this.GRUPO = GRUPO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public Date getFECHA_RESULTADO() {
        return FECHA_RESULTADO;
    }

    public void setFECHA_RESULTADO(Date FECHA_RESULTADO) {
        this.FECHA_RESULTADO = FECHA_RESULTADO;
    }
    
    
}
