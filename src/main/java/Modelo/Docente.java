/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dilan Lara
 */
public class Docente {
    
private int ID_DOCENTE;
private String NOMBRE_DOCENTE;
private String APELLIDO_DOCENTE;
private String CEDULA;
private String CORREO;
private String USUARIO;
private String CLAVE;
private static int ROL =0;
 
 public Docente(){}

    public Docente(int ID_DOCENTE, String NOMBRE_DOCENTE, String APELLIDO_DOCENTE, String CEDULA, String CORREO, String USUARIO, String CLAVE) {
        this.ID_DOCENTE = ID_DOCENTE;
        this.NOMBRE_DOCENTE = NOMBRE_DOCENTE;
        this.APELLIDO_DOCENTE = APELLIDO_DOCENTE;
        this.CEDULA = CEDULA;
        this.CORREO = CORREO;
        this.USUARIO = USUARIO;
        this.CLAVE = CLAVE;
    }

    public int getID_DOCENTE() {
        return ID_DOCENTE;
    }

    public void setID_DOCENTE(int ID_DOCENTE) {
        this.ID_DOCENTE = ID_DOCENTE;
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

    public String getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(String CEDULA) {
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

    public static void setROL(int ROL) {
        Docente.ROL = ROL;
    }
 
    
}
