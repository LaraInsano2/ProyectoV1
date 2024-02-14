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
    private int ID_RESULTADOS;
    private int ID_PROYECTOS;
    private String DESCRIPCION;
    private Date FECHA_RESULTADO;
    
    public Resultados(){}

    public Resultados(int ID_RESULTADOS, int ID_PROYECTOS, String DESCRIPCION, Date FECHA_RESULTADO) {
        this.ID_RESULTADOS = ID_RESULTADOS;
        this.ID_PROYECTOS = ID_PROYECTOS;
        this.DESCRIPCION = DESCRIPCION;
        this.FECHA_RESULTADO = FECHA_RESULTADO;
    }

    public int getID_RESULTADOS() {
        return ID_RESULTADOS;
    }

    public void setID_RESULTADOS(int ID_RESULTADOS) {
        this.ID_RESULTADOS = ID_RESULTADOS;
    }

    public int getID_PROYECTOS() {
        return ID_PROYECTOS;
    }

    public void setID_PROYECTOS(int ID_PROYECTOS) {
        this.ID_PROYECTOS = ID_PROYECTOS;
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
