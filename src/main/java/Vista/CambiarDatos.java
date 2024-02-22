/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


import Controlador.PersonaControlador;
import Modelo.Estudiante;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dilan Lara
 */
public class CambiarDatos extends javax.swing.JFrame {

    /**
     * Creates new form CambiarDatos
     */
    public CambiarDatos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtUsuarioA = new javax.swing.JTextField();
        btnCambiarDatos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dilan Lara\\Documents\\NetBeansProjects\\ProyectoV1\\src\\test\\java\\Imagen\\regresar2.png")); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setText("Regresar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel2.setText("Nueva Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 150, 30));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel3.setText("Nuevos Datos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 190, 30));
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 200, 30));
        jPanel1.add(txtUsuarioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 200, 30));

        btnCambiarDatos.setBackground(new java.awt.Color(51, 51, 255));
        btnCambiarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarDatos.setText("Cambiar Datos");
        btnCambiarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 130, 40));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel4.setText("Usuario Actual:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 130, 30));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel5.setText("Nuevo Usuario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 130, 30));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
            PantallaEstudiante inicioE =new PantallaEstudiante();
        inicioE.setVisible(true);
    // Cerrar la ventana actual
         this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCambiarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarDatosActionPerformed
    // TODO add your handling code here:
    String ActualUsuario = txtUsuarioA.getText();
    String NuevoUsuario = txtUsuario.getText();
    String NuevaClave = txtClave.getText();

  
        Estudiante e1=new Estudiante();
       e1.setUSUARIO(ActualUsuario);
        e1.setUSUARIO(NuevoUsuario);
        e1.setCLAVE(NuevaClave);

        // Actualizar datos del estudiante
      actualizarDatos(ActualUsuario, NuevoUsuario, NuevaClave);
        // Limpiar campos y cerrar ventana actual
        limpiarCampos();
        CambiarDatos.this.dispose();

        // Abrir la nueva ventana
        PantallaEstudiante pe = new PantallaEstudiante();
        pe.setVisible(true);
   
    }//GEN-LAST:event_btnCambiarDatosActionPerformed

 private void actualizarDatos(String ActualUsuario, String NuevoUsuario, String NuevaClave) {
         try {
        // Suponiendo que tienes un objeto PersonaControlador para interactuar con la capa de datos
        PersonaControlador controlador = new PersonaControlador();

        // Llamada al método de actualización con los tres parámetros
        String resultado = controlador.actualizarDatosEstudiante(ActualUsuario, NuevoUsuario, NuevaClave);

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, resultado);

        limpiarCampos();
    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar datos del estudiante: " + e.getMessage());
    }
    }

 private void limpiarCampos() {
       txtUsuarioA.setText("");
       txtUsuario.setText("");
       txtClave.setText("");
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarDatos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuarioA;
    // End of variables declaration//GEN-END:variables

   

   
}
