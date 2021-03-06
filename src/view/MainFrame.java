/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package view;

import dao.StockDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Stock;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class MainFrame extends javax.swing.JFrame {

    StockDAO stockDAO;
    Stock stock;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        stock = new Stock();
        stockDAO = new StockDAO();
    }

    /* set rows data for jatble */
    public void setTableData() {
        String column[] = {"StockID", "StockName", "Address", "DateAvailable", "Note"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        stock.getStockData().forEach((stockObj) -> {
            tableModel.addRow(new Object[]{stockObj.getStockID(), stockObj.getStockName(), stockObj.getAddress(), stockObj.getDateAvailable().toString(), stockObj.getNote()});
        });
        stockTable.setModel(tableModel);
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
        stockTable = new javax.swing.JTable();
        insertBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(stockTable);

        insertBtn.setText("Insert to DB");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(insertBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(insertBtn)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* click button to insert all jtable rows to database table */
    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        try {
            List<Stock> listStock = new ArrayList<>();
            DefaultTableModel tableModel = (DefaultTableModel) stockTable.getModel();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                int stockID = (int) tableModel.getValueAt(i, 0);
                String stockName = (String) tableModel.getValueAt(i, 1);
                String address = (String) tableModel.getValueAt(i, 2);
                Date dateAvailable = Date.valueOf((String) tableModel.getValueAt(i, 3));
                String note = (String) tableModel.getValueAt(i, 4);
                Stock stockObj = new Stock(stockID, stockName, address, dateAvailable, note);
                listStock.add(stockObj);
            }
            int rowAffected = stockDAO.updateBatch(listStock);
            JOptionPane.showMessageDialog(this, rowAffected + " rows is inserted successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Insert failed with error : " + e.toString());
        }
    }//GEN-LAST:event_insertBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton insertBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
