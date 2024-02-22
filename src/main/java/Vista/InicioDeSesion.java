package Vista;
import Controlador.PersonaControlador;
import java.awt.Color;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Dilan Lara
 */
public class InicioDeSesion extends javax.swing.JFrame {

    /**
     * Creates new form InicioDeSesion
     */
    public InicioDeSesion() {
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

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        Btniniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnRegistrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(204, 255, 255));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Bienvenido!!");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 2, 24)); // NOI18N
        jLabel2.setText("INICIO DE SESION");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 200, -1));

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setText("Ingresar Su Usuario");
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 220, 33));

        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setText("contra");
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContraseñaMouseClicked(evt);
            }
        });
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel4.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 220, 30));

        Btniniciar.setBackground(new java.awt.Color(0, 0, 255));
        Btniniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Btniniciar.setForeground(new java.awt.Color(255, 255, 255));
        Btniniciar.setText("Iniciar");
        Btniniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btniniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtniniciarActionPerformed(evt);
            }
        });
        jPanel4.add(Btniniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 100, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Usuario:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 80, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Contraseña:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 110, -1));

        jLabel5.setBackground(new java.awt.Color(153, 204, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("No tiene Cuenta Registrase Aqui:");
        jLabel5.setToolTipText("");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 176, -1));

        BtnRegistrar.setBackground(new java.awt.Color(0, 51, 255));
        BtnRegistrar.setFont(new java.awt.Font("Californian FB", 1, 14)); // NOI18N
        BtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrar.setText("Registrarse");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });
        jPanel4.add(BtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dilan Lara\\Documents\\NetBeansProjects\\ProyectoV1\\src\\test\\java\\Imagen\\Ist.jpg")); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 180, 150));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dilan Lara\\Documents\\NetBeansProjects\\ProyectoV1\\src\\test\\java\\Imagen\\Usua.png")); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 30, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dilan Lara\\Documents\\NetBeansProjects\\ProyectoV1\\src\\test\\java\\Imagen\\Contra.png")); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 30, 30));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 610));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

        jPanel5.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 20));

        jPanel6.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtniniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtniniciarActionPerformed
   // TODO add your handling code here:
   
PersonaControlador pC = new PersonaControlador();
int rol = pC.verificarCredenciales(txtUsuario.getText(), txtContraseña.getText());

switch (rol) {
    case 1: {
        PantallaEstudiante m = new PantallaEstudiante();
        JOptionPane.showMessageDialog(null, "Bienvenido Estudiante :)");
        m.setVisible(true);
        this.dispose();
        break;
    }
    case 0: {
        PantallaDocente m = new PantallaDocente();
        JOptionPane.showMessageDialog(null, "Bienvenido Docente :)");
        m.setVisible(true);
        this.dispose();
        break;
    }
    default:
        JOptionPane.showMessageDialog(null, "Ingrese credenciales válidas");
}

   
    }//GEN-LAST:event_BtniniciarActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
        // Crear una instancia del formulario de registro
        Registro formRegistro = new Registro();
        
        // Hacer visible el formulario de registro
        formRegistro.setVisible(true);
    // Cerrar la ventana actual
    this.dispose();

      
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al abrir el formulario de registro: " + e.getMessage());
    }
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked
        // TODO add your handling code here:
       txtUsuario.setText("");
       txtUsuario.setForeground(Color.black);
     if ("Ingresar su Usuario".equals(txtUsuario.getText())) {
        txtUsuario.setText("");
        txtUsuario.setForeground(Color.black);
    }
    if (String.valueOf(txtContraseña.getPassword()).isEmpty()) {  
        txtContraseña.setText("******");
        txtUsuario.setForeground(Color.gray);
    }    
    }//GEN-LAST:event_txtUsuarioMouseClicked

    private void txtContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMouseClicked
        // TODO add your handling code here:
       txtContraseña.setText("");
       txtContraseña.setForeground(Color.black);
        if( String.valueOf (txtContraseña.getPassword()).equals("******")){ 
        txtContraseña.setText("");
         txtContraseña.setForeground(Color.black);
       }
       if(  txtUsuario.getText().isEmpty()){ 
       txtUsuario.setText("Ingresar su Usuario");
        txtUsuario.setForeground(Color.gray);
       }  
    }//GEN-LAST:event_txtContraseñaMouseClicked

           

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JButton Btniniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    

         private void limpiarCampos() {
    // Código para limpiar los campos del formulario
    // Por ejemplo, asignar cadenas vacías o valores predeterminados a los JTextField, JComboBox, etc.

}
}
