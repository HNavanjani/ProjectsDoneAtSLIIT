/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMS;
import DBConnection.DBConnect;
import SPMS.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class CMS_viewItems extends javax.swing.JInternalFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
//    public String driver = "com.microsoft.jdbc.SQLServerDriver";
//    public String url = "jdbcsqlserver://localhost::24809:databaseName=smsDB";
//    public String user = "adminK";
//    public String pw = "admink";
    
    
    
    public CMS_viewItems() throws ClassNotFoundException, SQLException {
        initComponents();
         conn = DBConnect.connect();
//       Class.forName(driver);
//conn=DriverManager.getConnection(url, user, pw);     
        
        CMS_viewItems();
       // currentDateAndTime();
    }
    
    public void CMS_viewItems() throws ClassNotFoundException{
        
        try{
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * FROM cms_item";
          
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            jTable_searchItem.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(SQLException e ){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    /*public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_searchItem = new javax.swing.JTable();
        VFI_btn_ = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));
        setMaximumSize(new java.awt.Dimension(1324, 800));
        setMinimumSize(new java.awt.Dimension(1324, 800));
        setPreferredSize(new java.awt.Dimension(1324, 800));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Food Item Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(153, 0, 153))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(1240, 448));
        jPanel2.setMinimumSize(new java.awt.Dimension(1240, 448));
        jPanel2.setPreferredSize(new java.awt.Dimension(1240, 448));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setMaximumSize(new java.awt.Dimension(850, 310));
        jPanel3.setMinimumSize(new java.awt.Dimension(850, 310));
        jPanel3.setPreferredSize(new java.awt.Dimension(850, 310));

        jTable_searchItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable_searchItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable_searchItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable_searchItem.setColumnSelectionAllowed(true);
        jTable_searchItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_searchItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_searchItem);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        VFI_btn_.setBackground(new java.awt.Color(0, 0, 102));
        VFI_btn_.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        VFI_btn_.setForeground(new java.awt.Color(255, 255, 255));
        VFI_btn_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_CMS/backTo.png"))); // NOI18N
        VFI_btn_.setText("BACK");
        VFI_btn_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VFI_btn_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VFI_btn_, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VFI_btn_)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 311, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VFI_btn_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VFI_btn_ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_VFI_btn_ActionPerformed

    private void jTable_searchItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_searchItemMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable_searchItemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VFI_btn_;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_searchItem;
    // End of variables declaration//GEN-END:variables
}
