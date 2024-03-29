/*
 * DialogInformes.java
 *
 * Created on 05-mar-2010, 16:36:14
 */
package es.typ.dialogs;

import es.typ.informes.Informe;
import es.typ.ticket.Ticket;
import es.typ.utils.Log;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Takuya
 */
public class DialogInformes extends javax.swing.JDialog {

    private Ticket ticket = new Ticket();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
    private String fechaInicio = "";
    private String fechaFin = "";

    /** Creates new form DialogInformes */
    public DialogInformes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Informes");
    }

    private boolean comprobarDatos() {
        txtFechaFin.setBackground(Color.white);
        txtFechaInicio.setBackground(Color.white);
        if (txtFechaInicio.getText() == null || txtFechaInicio.getText().equals("")) {
            txtFechaInicio.setBackground(Color.red);
            return false;
        }
        if (txtFechaFin.getText() == null || txtFechaFin.getText().equals("")) {
            txtFechaFin.setBackground(Color.red);
            return false;
        }
        if (!txtFechaInicio.getText().equals("dd-mm-aaaa") && !txtFechaFin.getText().equals("dd-mm-aaaa")) {
            try {
                fechaInicio = sdf.format(sdf2.parse(txtFechaInicio.getText()));
                fechaFin = sdf.format(sdf2.parse(txtFechaFin.getText()));
            } catch (Exception e) {
                e.printStackTrace();
                Log.getInstance().log(e.getMessage());
                return false;
            }
        }
        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    txtFechaInicio = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    txtFechaFin = new javax.swing.JTextField();
    btnEjecutarInforme = new javax.swing.JButton();
    jRadioButton1 = new javax.swing.JRadioButton();
    jRadioButton2 = new javax.swing.JRadioButton();
    jRadioButton3 = new javax.swing.JRadioButton();
    jPanel3 = new javax.swing.JPanel();
    jPanel12 = new javax.swing.JPanel();
    jPanel16 = new javax.swing.JPanel();
    jLabel5 = new javax.swing.JLabel();
    jPanel22 = new javax.swing.JPanel();
    jPanel23 = new javax.swing.JPanel();
    jPanel24 = new javax.swing.JPanel();
    jPanel13 = new javax.swing.JPanel();
    jLabel6 = new javax.swing.JLabel();
    jPanel20 = new javax.swing.JPanel();
    jPanel21 = new javax.swing.JPanel();
    jPanel15 = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    jPanel17 = new javax.swing.JPanel();
    jPanel18 = new javax.swing.JPanel();
    jPanel19 = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jPanel1.setLayout(new java.awt.BorderLayout());

    jLabel1.setText("Fecha inicio");

    txtFechaInicio.setText("dd-mm-aaaa");

    jLabel2.setText("Fecha fin");

    txtFechaFin.setText("dd-mm-aaaa");

    btnEjecutarInforme.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    btnEjecutarInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/TicketEntradaJ2SE/images/check.png"))); // NOI18N
    btnEjecutarInforme.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEjecutarInformeActionPerformed(evt);
      }
    });

    buttonGroup1.add(jRadioButton1);
    jRadioButton1.setText("Informe - Información de entradas");

    buttonGroup1.add(jRadioButton2);
    jRadioButton2.setText("Informe - Fecha y tipo de entrada");

    buttonGroup1.add(jRadioButton3);
    jRadioButton3.setSelected(true);
    jRadioButton3.setText("Informe - Acumulado por tipo ticket");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(180, 180, 180)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jRadioButton1)
              .addComponent(jRadioButton2)
              .addComponent(jRadioButton3)
              .addComponent(btnEjecutarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(138, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(32, 32, 32)
        .addComponent(jRadioButton1)
        .addGap(18, 18, 18)
        .addComponent(jRadioButton2)
        .addGap(18, 18, 18)
        .addComponent(jRadioButton3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        .addComponent(btnEjecutarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

    jPanel12.setBackground(new java.awt.Color(222, 223, 227));
    jPanel12.setLayout(new java.awt.BorderLayout());

    jPanel16.setBackground(new java.awt.Color(45, 76, 121));
    jPanel16.setPreferredSize(new java.awt.Dimension(100, 122));
    jPanel16.setLayout(new java.awt.BorderLayout());

    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/TicketEntradaJ2SE/images/icono.png"))); // NOI18N
    jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    jPanel16.add(jLabel5, java.awt.BorderLayout.WEST);

    jPanel22.setBackground(new java.awt.Color(45, 76, 121));
    jPanel22.setPreferredSize(new java.awt.Dimension(100, 10));

    javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
    jPanel22.setLayout(jPanel22Layout);
    jPanel22Layout.setHorizontalGroup(
      jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );
    jPanel22Layout.setVerticalGroup(
      jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 10, Short.MAX_VALUE)
    );

    jPanel16.add(jPanel22, java.awt.BorderLayout.NORTH);

    jPanel23.setBackground(new java.awt.Color(45, 76, 121));
    jPanel23.setPreferredSize(new java.awt.Dimension(10, 102));

    javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
    jPanel23.setLayout(jPanel23Layout);
    jPanel23Layout.setHorizontalGroup(
      jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 10, Short.MAX_VALUE)
    );
    jPanel23Layout.setVerticalGroup(
      jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 102, Short.MAX_VALUE)
    );

    jPanel16.add(jPanel23, java.awt.BorderLayout.EAST);

    jPanel24.setBackground(new java.awt.Color(45, 76, 121));
    jPanel24.setPreferredSize(new java.awt.Dimension(100, 10));

    javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
    jPanel24.setLayout(jPanel24Layout);
    jPanel24Layout.setHorizontalGroup(
      jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );
    jPanel24Layout.setVerticalGroup(
      jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 10, Short.MAX_VALUE)
    );

    jPanel16.add(jPanel24, java.awt.BorderLayout.SOUTH);

    jPanel12.add(jPanel16, java.awt.BorderLayout.EAST);

    jPanel13.setBackground(new java.awt.Color(45, 76, 121));
    jPanel13.setPreferredSize(new java.awt.Dimension(784, 80));
    jPanel13.setLayout(new java.awt.BorderLayout());

    jLabel6.setBackground(new java.awt.Color(222, 223, 227));
    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(45, 76, 121));
    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel6.setText("Ticket Entradas - Informes");
    jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel6.setOpaque(true);
    jPanel13.add(jLabel6, java.awt.BorderLayout.CENTER);

    jPanel20.setBackground(new java.awt.Color(45, 76, 121));
    jPanel20.setMinimumSize(new java.awt.Dimension(100, 10));
    jPanel20.setPreferredSize(new java.awt.Dimension(623, 10));

    javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
    jPanel20.setLayout(jPanel20Layout);
    jPanel20Layout.setHorizontalGroup(
      jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 436, Short.MAX_VALUE)
    );
    jPanel20Layout.setVerticalGroup(
      jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 10, Short.MAX_VALUE)
    );

    jPanel13.add(jPanel20, java.awt.BorderLayout.PAGE_START);

    jPanel21.setBackground(new java.awt.Color(45, 76, 121));
    jPanel21.setMinimumSize(new java.awt.Dimension(100, 10));
    jPanel21.setPreferredSize(new java.awt.Dimension(623, 10));

    javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
    jPanel21.setLayout(jPanel21Layout);
    jPanel21Layout.setHorizontalGroup(
      jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 436, Short.MAX_VALUE)
    );
    jPanel21Layout.setVerticalGroup(
      jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 10, Short.MAX_VALUE)
    );

    jPanel13.add(jPanel21, java.awt.BorderLayout.SOUTH);

    jPanel12.add(jPanel13, java.awt.BorderLayout.CENTER);

    jPanel15.setBackground(new java.awt.Color(45, 76, 121));
    jPanel15.setPreferredSize(new java.awt.Dimension(100, 122));
    jPanel15.setLayout(new java.awt.BorderLayout());

    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/TicketEntradaJ2SE/images/icono.png"))); // NOI18N
    jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    jPanel15.add(jLabel7, java.awt.BorderLayout.EAST);

    jPanel17.setBackground(new java.awt.Color(45, 76, 121));
    jPanel17.setPreferredSize(new java.awt.Dimension(100, 10));

    javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
    jPanel17.setLayout(jPanel17Layout);
    jPanel17Layout.setHorizontalGroup(
      jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );
    jPanel17Layout.setVerticalGroup(
      jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 10, Short.MAX_VALUE)
    );

    jPanel15.add(jPanel17, java.awt.BorderLayout.NORTH);

    jPanel18.setBackground(new java.awt.Color(45, 76, 121));
    jPanel18.setPreferredSize(new java.awt.Dimension(100, 10));

    javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
    jPanel18.setLayout(jPanel18Layout);
    jPanel18Layout.setHorizontalGroup(
      jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );
    jPanel18Layout.setVerticalGroup(
      jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 10, Short.MAX_VALUE)
    );

    jPanel15.add(jPanel18, java.awt.BorderLayout.SOUTH);

    jPanel19.setBackground(new java.awt.Color(45, 76, 121));
    jPanel19.setPreferredSize(new java.awt.Dimension(10, 102));

    javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
    jPanel19.setLayout(jPanel19Layout);
    jPanel19Layout.setHorizontalGroup(
      jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 10, Short.MAX_VALUE)
    );
    jPanel19Layout.setVerticalGroup(
      jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 102, Short.MAX_VALUE)
    );

    jPanel15.add(jPanel19, java.awt.BorderLayout.LINE_START);

    jPanel12.add(jPanel15, java.awt.BorderLayout.WEST);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 636, Short.MAX_VALUE)
      .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
          .addGap(0, 0, Short.MAX_VALUE)
          .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(0, 0, Short.MAX_VALUE)))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 122, Short.MAX_VALUE)
      .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
          .addGap(0, 0, Short.MAX_VALUE)
          .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(0, 0, Short.MAX_VALUE)))
    );

    jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnEjecutarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarInformeActionPerformed
        if (comprobarDatos()) {
            ArrayList datosAL = new ArrayList();
            String nombreJasper = "";
            if(jRadioButton1.isSelected()){
                datosAL = ticket.getTicketDAO().getAcumuladoTickets(fechaInicio, fechaFin, "");
                nombreJasper = "reporte2.jasper";
            } else if(jRadioButton2.isSelected()){
                datosAL = ticket.getTicketDAO().getAcumuladoTickets(fechaInicio, fechaFin, "");
                nombreJasper = "reporte3.jasper";
            } else if(jRadioButton3.isSelected()){
                datosAL = ticket.getTicketDAO().getAcumuladoPorTipoTickets(fechaInicio, fechaFin, "");
                nombreJasper = "acumuladoPorTipos.jasper";
            }
            
            if (datosAL == null || datosAL.size() == 0) {
                JOptionPane.showMessageDialog(this, "No hay datos para mostrar");
            } else {
                new Informe(nombreJasper, datosAL);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Compruebe los datos insertados");
        }
    }//GEN-LAST:event_btnEjecutarInformeActionPerformed
    /**
     * @param args the command line arguments
    
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    DialogInformes dialog = new DialogInformes(new javax.swing.JFrame(), true);
    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent e) {
    System.exit(0);
    }
    });
    dialog.setVisible(true);
    }
    });
    }*/
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEjecutarInforme;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel12;
  private javax.swing.JPanel jPanel13;
  private javax.swing.JPanel jPanel15;
  private javax.swing.JPanel jPanel16;
  private javax.swing.JPanel jPanel17;
  private javax.swing.JPanel jPanel18;
  private javax.swing.JPanel jPanel19;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel20;
  private javax.swing.JPanel jPanel21;
  private javax.swing.JPanel jPanel22;
  private javax.swing.JPanel jPanel23;
  private javax.swing.JPanel jPanel24;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JRadioButton jRadioButton1;
  private javax.swing.JRadioButton jRadioButton2;
  private javax.swing.JRadioButton jRadioButton3;
  private javax.swing.JTextField txtFechaFin;
  private javax.swing.JTextField txtFechaInicio;
  // End of variables declaration//GEN-END:variables
}
