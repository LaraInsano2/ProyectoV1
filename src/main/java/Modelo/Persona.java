/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Dilan Lara
 */
public class Persona {
  private int ID_PERSONA;
  private String NOMBRE_PERSONA;
  private String APELLIDO_PERSONA;
  private int CEDULA;
  private String CORREO;
  private String USUARIO;
  private String CLAVE;
  private int ROL_PERSONA; 
    
 public Persona(){} 

    public Persona(int ID_PERSONA, String NOMBRE_PERSONA, String APELLIDO_PERSONA, int CEDULA, String CORREO, String USUARIO, String CLAVE, int ROL_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
        this.NOMBRE_PERSONA = NOMBRE_PERSONA;
        this.APELLIDO_PERSONA = APELLIDO_PERSONA;
        this.CEDULA = CEDULA;
        this.CORREO = CORREO;
        this.USUARIO = USUARIO;
        this.CLAVE = CLAVE;
        this.ROL_PERSONA = ROL_PERSONA;
    }

    public int getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(int ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }

    public String getNOMBRE_PERSONA() {
        return NOMBRE_PERSONA;
    }

    public void setNOMBRE_PERSONA(String NOMBRE_PERSONA) {
        this.NOMBRE_PERSONA = NOMBRE_PERSONA;
    }

    public String getAPELLIDO_PERSONA() {
        return APELLIDO_PERSONA;
    }

    public void setAPELLIDO_PERSONA(String APELLIDO_PERSONA) {
        this.APELLIDO_PERSONA = APELLIDO_PERSONA;
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

    public int getROL_PERSONA() {
        return ROL_PERSONA;
    }

    public void setROL_PERSONA(int ROL_PERSONA) {
        this.ROL_PERSONA = ROL_PERSONA;
    }
 
   
   
}
