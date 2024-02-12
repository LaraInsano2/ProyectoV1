/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dilan Lara
 */
public class Grupo {
    
 private int ID_GRUPO;
 private int ID_ESTUDIANTE;
 private String GRUPO;
 private int NUM_GRUPO;
 private String NOMBRE_ESTUDIANTE;
 
 public Grupo(){}

    public Grupo(int ID_GRUPO, int ID_ESTUDIANTE, String GRUPO, int NUM_GRUPO, String NOMBRE_ESTUDIANTE) {
        this.ID_GRUPO = ID_GRUPO;
        this.ID_ESTUDIANTE = ID_ESTUDIANTE;
        this.GRUPO = GRUPO;
        this.NUM_GRUPO = NUM_GRUPO;
        this.NOMBRE_ESTUDIANTE = NOMBRE_ESTUDIANTE;
    }

    public int getID_GRUPO() {
        return ID_GRUPO;
    }

    public void setID_GRUPO(int ID_GRUPO) {
        this.ID_GRUPO = ID_GRUPO;
    }

    public int getID_ESTUDIANTE() {
        return ID_ESTUDIANTE;
    }

    public void setID_ESTUDIANTE(int ID_ESTUDIANTE) {
        this.ID_ESTUDIANTE = ID_ESTUDIANTE;
    }

    public String getGRUPO() {
        return GRUPO;
    }

    public void setGRUPO(String GRUPO) {
        this.GRUPO = GRUPO;
    }

    public int getNUM_GRUPO() {
        return NUM_GRUPO;
    }

    public void setNUM_GRUPO(int NUM_GRUPO) {
        this.NUM_GRUPO = NUM_GRUPO;
    }

    public String getNOMBRE_ESTUDIANTE() {
        return NOMBRE_ESTUDIANTE;
    }

    public void setNOMBRE_ESTUDIANTE(String NOMBRE_ESTUDIANTE) {
        this.NOMBRE_ESTUDIANTE = NOMBRE_ESTUDIANTE;
    }
 
    
}
