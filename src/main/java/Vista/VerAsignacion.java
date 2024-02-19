/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.ConexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dilan Lara
 */
public class VerAsignacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrearAsignacion
     */
      ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    DefaultTableModel modelo;
    public VerAsignacion() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("GRUPO");
        modelo.addColumn("NOMBRE PROYECTO");
        modelo.addColumn("NOMBRE DOCENTE");
        modelo.addColumn("APELLIDO DOCENTE");
        modelo.addColumn("ESTADO DEL PROYECTO");
        modelo.addColumn("FECHA DE INICIO");
        modelo.addColumn("FECHA DE ENTREGA");
        tbAsignacion.setModel(modelo);
        MostrarDatos(0, null);
    }
    
    public void MostrarDatos(int opBuscar, String valor) {
    limpiarTabla();

    String codsql;
    if (opBuscar == 0 && valor == null) {
        codsql = "SELECT GRUPO, NOMBRE_PROYECTO, NOMBRE_DOCENTE, APELLIDO_DOCENTE, ESTADO_TAREA, FECHA_INICIO_TAREA, FECHA_FIN_TAREA FROM Asignacion";
    } else if (opBuscar == 1 && valor != null) {
        codsql = "SELECT GRUPO, NOMBRE_PROYECTO, NOMBRE_DOCENTE, APELLIDO_DOCENTE, ESTADO_TAREA, FECHA_INICIO_TAREA, FECHA_FIN_TAREA FROM Asignacion WHERE NOMBRE_DOCENTE='" + valor + "'";
    } else if (opBuscar == 2 && valor != null) {
        codsql = "SELECT GRUPO, NOMBRE_PROYECTO, NOMBRE_DOCENTE, APELLIDO_DOCENTE, ESTADO_TAREA, FECHA_INICIO_TAREA, FECHA_FIN_TAREA FROM Asignacion WHERE ESTADO_TAREA='" + valor + "'";
    } else {
        codsql = "SELECT GRUPO, NOMBRE_PROYECTO, NOMBRE_DOCENTE, APELLIDO_DOCENTE, ESTADO_TAREA, FECHA_INICIO_TAREA, FECHA_FIN_TAREA FROM Asignacion";
    }

        String[] datos = new String[7];
        try {
            Statement leer = conectado.createStatement();
            ResultSet resultado = leer.executeQuery(codsql);
            while (resultado.next()) {
                datos[0] = resultado.getString(1);
                datos[1] = resultado.getString(2);
                datos[2] = resultado.getString(3);
                datos[3] = resultado.getString(4);
                datos[4] = resultado.getString(5);
                datos[5] = resultado.getString(6);
                datos[6] = resultado.getString(7);

                modelo.addRow(datos);
            }
            tbAsignacion.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showInputDialog(null, "error");
        }
    
        }
    public void ActualizarDatos() {
    int fila = tbAsignacion.getSelectedRow();

    if (fila < 0) {
        JOptionPane.showMessageDialog(rootPane, "Seleccione el registro a modificar antes de presionar el botón");
        return;
    }

 
    String Grupo = tbAsignacion.getValueAt(fila, 0).toString();
    String NombreP = tbAsignacion.getValueAt(fila, 1).toString();
    String NombreD = tbAsignacion.getValueAt(fila, 2).toString();
    String ApellidoD = tbAsignacion.getValueAt(fila, 3).toString();
    String Estado = tbAsignacion.getValueAt(fila, 4).toString();
    String FechaI = tbAsignacion.getValueAt(fila, 5).toString();
    String FechaF = tbAsignacion.getValueAt(fila, 6).toString();
    try {
        PreparedStatement actu = conectado.prepareStatement("UPDATE Asignacion SET GRUPO=?, NOMBRE_PROYECTO=?,NOMBRE_DOCENTE=?,APELLIDO_DOCENTE=?, ESTADO_TAREA=?,FECHA_INICIO_TAREA=?,FECHA_FIN_TAREA =? WHERE ID_ASIGNACION=?");
        actu.setString(1, Grupo);
        actu.setString(2, NombreP);
        actu.setString(3, NombreD);
        actu.setString(4, ApellidoD);
        actu.setString(4, Estado);
        actu.setString(4, FechaI);
        actu.setString(4, FechaF);
       

        int filasActualizadas = actu.executeUpdate();

        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
          
            limpiarTabla();
            // Actualizar la tabla después de actualizar el registro
            MostrarDatos(0, null);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
    }
}
    
    public void eliminarAsignacion() {
    // Verificar si se ha seleccionado una fila en la tabla
    int fila = tbAsignacion.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(rootPane, "Por favor, seleccione una asignación para eliminar.");
        return;
    }
    
    // Obtener el ID de la asignación seleccionada en la fila
    int idAsignacion = Integer.parseInt(tbAsignacion.getValueAt(fila, 0).toString());

    try {
        // Utilizar un parámetro preparado para evitar inyección SQL
        PreparedStatement eliminar = conectado.prepareStatement("DELETE FROM Asignacion WHERE ID_ASIGNACION = ?");
        eliminar.setInt(1, idAsignacion);
        
        // Ejecutar la consulta para eliminar la asignación
        int filasAfectadas = eliminar.executeUpdate();
        
        // Verificar si se eliminó correctamente y actualizar la tabla si es necesario
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(rootPane, "Asignación borrada correctamente.");
            limpiarTabla();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar la asignación.");
        }
    } catch (SQLException | NumberFormatException e) {
        JOptionPane.showMessageDialog(rootPane, "Error al eliminar la asignación. Comunicarse con el Administrador. " + e.getMessage());
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbAsignacion = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        tbAsignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbAsignacion);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ver Por:"));

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar Todos", "Docente Encargado", "Estado Tarea" }));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar Tabla");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addGap(163, 163, 163)
                        .addComponent(btnBuscar)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        ActualizarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        int Buscar=ComboOpcion.getSelectedIndex();
        String valorbus=txtBuscar.getText();
        MostrarDatos(Buscar,valorbus);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarAsignacion();
    }//GEN-LAST:event_btnEliminarActionPerformed

 private void limpiarTabla() {
        // Limpiar el modelo actual de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) tbAsignacion.getModel();
        modeloTabla.setRowCount(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboOpcion;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAsignacion;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
