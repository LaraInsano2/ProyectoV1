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
public final class VerProyecto extends javax.swing.JInternalFrame {
    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = conectar.conectar();
    DefaultTableModel modelo;

    
    /**
     * Creates new form VerProyecto
     */
    public VerProyecto() {
    initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Nro.");
        modelo.addColumn("NOMBRE_PROYECTO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("FECHA INICIO");
        modelo.addColumn("FECHA FINAL");
        TbDatosProyectos.setModel(modelo);
        // Ajusta el tamaño de las columnas
TbDatosProyectos.getColumnModel().getColumn(0).setPreferredWidth(10); // Nro.
TbDatosProyectos.getColumnModel().getColumn(1).setPreferredWidth(75); // NOMBRE_PROYECTO
TbDatosProyectos.getColumnModel().getColumn(2).setPreferredWidth(225); // DESCRIPCION
TbDatosProyectos.getColumnModel().getColumn(3).setPreferredWidth(25); // FECHA INICIO
TbDatosProyectos.getColumnModel().getColumn(4).setPreferredWidth(25); // FECHA FINAL
        MostrarDatos(0, null);
        
    }
   public void MostrarDatos(int opBuscar, String valor) {
    limpiarTabla();

    String codsql;
    if (opBuscar == 0 && valor == null) {
        codsql = "SELECT NOMBRE_PROYECTO, DESCRIPCION_PROYECTO, FECHA_INICIO, FECHA_FIN FROM Proyectos";
    } else if (opBuscar == 1 && valor != null) {
        codsql = "SELECT NOMBRE_PROYECTO, DESCRIPCION_PROYECTO, FECHA_INICIO, FECHA_FIN FROM Proyectos WHERE NOMBRE_PROYECTO='" + valor + "'";
    } else if (opBuscar == 2 && valor != null) {
        codsql = "SELECT NOMBRE_PROYECTO, DESCRIPCION_PROYECTO, FECHA_INICIO, FECHA_FIN FROM Proyectos WHERE DESCRIPCION_PROYECTO='" + valor + "'";
    } else {
        codsql = "SELECT NOMBRE_PROYECTO, DESCRIPCION_PROYECTO, FECHA_INICIO, FECHA_FIN FROM Proyectos";
    }

    String[] datos = new String[5]; // Añadir una columna más para el número de fila
    int numeroFila = 1; // Variable para contar el número de fila
    try {
        Statement leer = conectado.createStatement();
        ResultSet resultado = leer.executeQuery(codsql);
        while (resultado.next()) {
            datos[0] = String.valueOf(numeroFila); // Número de fila
            datos[1] = resultado.getString(1); // NOMBRE_PROYECTO
            datos[2] = resultado.getString(2); // DESCRIPCION_PROYECTO
            datos[3] = resultado.getString(3); // FECHA_INICIO
            datos[4] = resultado.getString(4); // FECHA_FIN
            modelo.addRow(datos);
            numeroFila++; // Incrementar el número de fila
        }
        TbDatosProyectos.setModel(modelo);
    } catch (SQLException e) {
        JOptionPane.showInputDialog(null, "error");
    }
}

  
  public void ActualizarDatos() {
    int fila = TbDatosProyectos.getSelectedRow();

    if (fila < 0) {
        JOptionPane.showMessageDialog(rootPane, "Seleccione el registro a modificar antes de presionar el botón");
        return;
    }

    String Titulo = TbDatosProyectos.getValueAt(fila, 1).toString();
    String Descripcion = TbDatosProyectos.getValueAt(fila, 2).toString();
    String FechaInicio = TbDatosProyectos.getValueAt(fila, 3).toString();
    String FechaFin = TbDatosProyectos.getValueAt(fila, 4).toString();

    try {
        // Obtén el valor de ID_PROYECTO y conviértelo a entero
        int idProyecto = Integer.parseInt(TbDatosProyectos.getValueAt(fila, 0).toString());

        PreparedStatement actu = conectado.prepareStatement("UPDATE Proyectos SET NOMBRE_PROYECTO=?, DESCRIPCION_PROYECTO=?, FECHA_INICIO=?, FECHA_FIN=? WHERE ID_PROYECTO=?");
        actu.setString(1, Titulo);
        actu.setString(2, Descripcion);
        actu.setString(3, FechaInicio);
        actu.setString(4, FechaFin);
        actu.setInt(5, idProyecto);  // Asigna el valor convertido a entero

        int filasActualizadas = actu.executeUpdate();

        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            limpiarTabla();
            // Actualizar la tabla después de actualizar el registro
            MostrarDatos(0, null);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar los datos");
        }
    } catch (SQLException | NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage());
    }
}



    public void eliminarProyecto() {
    // Verificar si se ha seleccionado una fila en la tabla
    int fila = TbDatosProyectos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(rootPane, "Por favor, seleccione un proyecto para eliminar.");
        return;
    }
    
    // Obtener el nombre del proyecto seleccionado en la fila
    String nombreProyecto = TbDatosProyectos.getValueAt(fila, 1).toString();

    try {
        // Utilizar un parámetro preparado para evitar inyección SQL
        PreparedStatement eliminar = conectado.prepareStatement("DELETE FROM Proyectos WHERE NOMBRE_PROYECTO = ?");
        eliminar.setString(1, nombreProyecto);
        
        // Ejecutar la consulta para eliminar el proyecto
        int filasAfectadas = eliminar.executeUpdate();
        
        // Verificar si se eliminó correctamente y actualizar la tabla si es necesario
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(rootPane, "Proyecto eliminado correctamente.");
            limpiarTabla();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar el proyecto.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error al eliminar el proyecto: " + e.getMessage());
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
        TbDatosProyectos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AdmintrarProyectos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        TbDatosProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TbDatosProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbDatosProyectosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbDatosProyectos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Por:"));
        jPanel1.setToolTipText("");
        jPanel1.setName("Buscar Por:"); // NOI18N

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar Todos", "Nombre del Proyecto", "Descripcion" }));
        ComboOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboOpcionActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Limpiar Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(50, 50, 50)))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(654, 654, 654))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(btnEliminar))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TbDatosProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbDatosProyectosMouseClicked
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_TbDatosProyectosMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here
    }//GEN-LAST:event_formInternalFrameActivated

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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
       eliminarProyecto();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboOpcionActionPerformed

   private void limpiarTabla() {
        // Limpiar el modelo actual de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) TbDatosProyectos.getModel();
        modeloTabla.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboOpcion;
    private javax.swing.JTable TbDatosProyectos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables


}
