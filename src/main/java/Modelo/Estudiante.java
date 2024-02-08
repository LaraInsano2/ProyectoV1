/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dilan Lara
 */
public class Estudiante {
 private int ID_ESTUDIANTE;
 private int ID_PERSONA;
 private String NOMBRE_ESTUDIANTE;
 private String APELLIDO_ESTUDIANTE;
 private int CEDULA;
 private String CORREO;
 private String USUARIO;
 private String CLAVE;
 private static int ROL =1;

 
 public Estudiante(){}

    public Estudiante(int ID_ESTUDIANTE, int ID_PERSONA, String NOMBRE_ESTUDIANTE, String APELLIDO_ESTUDIANTE, int CEDULA, String CORREO, String USUARIO, String CLAVE) {
        this.ID_ESTUDIANTE = ID_ESTUDIANTE;
        this.ID_PERSONA = ID_PERSONA;
        this.NOMBRE_ESTUDIANTE = NOMBRE_ESTUDIANTE;
        this.APELLIDO_ESTUDIANTE = APELLIDO_ESTUDIANTE;
        this.CEDULA = CEDULA;
        this.CORREO = CORREO;
        this.USUARIO = USUARIO;
        this.CLAVE = CLAVE;
    }

    public int getID_ESTUDIANTE() {
        return ID_ESTUDIANTE;
    }

    public void setID_ESTUDIANTE(int ID_ESTUDIANTE) {
        this.ID_ESTUDIANTE = ID_ESTUDIANTE;
    }

    public int getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(int ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }

    public String getNOMBRE_ESTUDIANTE() {
        return NOMBRE_ESTUDIANTE;
    }

    public void setNOMBRE_ESTUDIANTE(String NOMBRE_ESTUDIANTE) {
        this.NOMBRE_ESTUDIANTE = NOMBRE_ESTUDIANTE;
    }

    public String getAPELLIDO_ESTUDIANTE() {
        return APELLIDO_ESTUDIANTE;
    }

    public void setAPELLIDO_ESTUDIANTE(String APELLIDO_ESTUDIANTE) {
        this.APELLIDO_ESTUDIANTE = APELLIDO_ESTUDIANTE;
    }

    public int getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(int CEDULA) {
        this.CEDULA = CEDULA;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    public static int getROL() {
        return ROL;
    }

    public static void setROL(int rol) {
        Estudiante.ROL = rol;
    }

   

     

    
}