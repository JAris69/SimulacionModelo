/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proysimu;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class noLineal extends javax.swing.JFrame {

   DefaultTableModel modelo;
    public noLineal() {
        initComponents();
        setBounds(700,200,545,815);
    }

     public void generar(String nombre) throws FileNotFoundException, DocumentException{
     if(!(seed.getText().isEmpty() || (txtA.getText().isEmpty()) || (txtC.getText().isEmpty() || (txtM.getText().isEmpty()) || (txtN.getText().isEmpty()) || (txtB.getText().isEmpty())))){  
        //FileOutputStream archivo=new FileOutputStream(nombre + ".pdf");
        Document documento=new Document() ;
        PdfWriter.getInstance(documento,new FileOutputStream("D://CopyData//Report//"+nombre+".pdf"));
        documento.open();
        
        Paragraph parrafo=new Paragraph("Algoritmo Congruencial No Lineal");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        
        documento.add(new Paragraph("Semilla: "+seed.getText()));
        documento.add(new Paragraph("A: "+txtA.getText()));
        documento.add(new Paragraph("B: "+txtB.getText()));
        documento.add(new Paragraph("C: "+txtC.getText()));
        documento.add(new Paragraph("M: "+txtM.getText()));
        documento.add(new Paragraph("Cantidad: "+txtN.getText()));
        //documento.add(new Paragraph("Resultado: "+modelo));
        //pdf tabla
        documento.add(Chunk.NEWLINE);
        PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            PdfPCell numero = new PdfPCell(new Phrase("Nº"));
           numero.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell resul = new PdfPCell(new Phrase("Valor Xi"));
            resul.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell resul2 = new PdfPCell(new Phrase("Valor Ri"));
            resul2.setBackgroundColor(BaseColor.ORANGE);
            
            tabla.addCell(numero);
            tabla.addCell(resul);  
            tabla.addCell(resul2);
            
        int semilla = Integer.parseInt(seed.getText());
        int m = Integer.parseInt(txtM.getText());
        //(int) Math.pow(2, 31 - 1);
        //System.out.print("Escriba A: ");
        int a = Integer.parseInt(txtA.getText());
        //System.out.print("Escriba B: ");
        int b = Integer.parseInt(txtB.getText());
        //System.out.print("Escriba C: ");
        int c = Integer.parseInt(txtC.getText());

        int X = semilla;
        int cant = Integer.parseInt(txtN.getText());
        modelo = (DefaultTableModel) this.jTable1.getModel();
        for (int i = 0; i < cant; i++) {
            X = (a * (int) Math.pow(X, 2) + b * X + c) % m;
            System.out.println(X);
            double r = (double) X/m;
            //Object datos[] = new Object[] {i,X};
            //modelo.addRow(datos);
            tabla.addCell(String.valueOf(i));
            tabla.addCell(String.valueOf(X));
            tabla.addCell(String.valueOf(r));
            
        }     
            documento.add(Chunk.NEWLINE);
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Sumatoria de Ri: "+lblRi.getText()));
            documento.add(new Paragraph("Z: "+txtZ.getText()));
            documento.add(new Paragraph("Promedio r: "+lblR.getText()));
            documento.add(new Paragraph("Limite superior: "+lblLS.getText()));
            documento.add(new Paragraph("Limite inferior: "+lblLI.getText()));
            documento.add(new Paragraph("Resultado: "+lblResul.getText()));
            documento.add(Chunk.NEWLINE);
        documento.close();
        JOptionPane.showMessageDialog(null,"Archivo PDF creado correctamente","Informacion",1);
    
    }else{
    JOptionPane.showMessageDialog(null,"Debe llenar todos los campos","Atencion",2);
}
    }
    
    public void abrir(String nombre){
        try{
            File path= new File("D://CopyData//Report//"+nombre+".pdf");
            Desktop.getDesktop().open(path);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Atencion", 2);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        seed = new javax.swing.JTextField();
        txtA = new javax.swing.JTextField();
        txtC = new javax.swing.JTextField();
        txtN = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtM = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblRi = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtZ = new javax.swing.JTextField();
        btnCalculo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        lblLI = new javax.swing.JLabel();
        lblLS = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblResul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setText("METODO CONGRUENCIAL NO LINEAL");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setText("SEMILLA:");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setText("A:");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel4.setText("C:");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel5.setText("CANTIDAD:");

        jButton1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton1.setText("CALCULAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Valor Xi", "Valor Ri"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel6.setText("M:");

        jButton3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton3.setText("VOLVER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel7.setText("INTRODUZCA LOS DATOS");

        jLabel8.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel8.setText("B:");

        jButton5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton5.setText("ABRIR PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proysimu/logoitc (2).jpg"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel10.setText("PRUEBA DE MEDIAS");

        jLabel11.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel11.setText("Ri:");

        jLabel12.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel12.setText("Z:");

        btnCalculo.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        btnCalculo.setText("CALCULAR");
        btnCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel13.setText("r:");

        jLabel14.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel14.setText("LIMITE INFERIOR:");

        jLabel15.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel15.setText("LIMITE SUPERIOR:");

        jLabel16.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel16.setText("RESULTADO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel7))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel2)
                            .addGap(3, 3, 3)
                            .addComponent(seed, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)
                            .addComponent(jLabel3)
                            .addGap(7, 7, 7)
                            .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(jLabel8)
                            .addGap(8, 8, 8)
                            .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel4)
                            .addGap(7, 7, 7)
                            .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13)
                            .addComponent(jLabel5)
                            .addGap(2, 2, 2)
                            .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jLabel6)
                            .addGap(5, 5, 5)
                            .addComponent(txtM, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jButton1)
                            .addGap(22, 22, 22)
                            .addComponent(jButton2)
                            .addGap(26, 26, 26)
                            .addComponent(jButton5)
                            .addGap(25, 25, 25)
                            .addComponent(jButton3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel10))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel11)
                            .addGap(4, 4, 4)
                            .addComponent(lblRi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel12)
                            .addGap(9, 9, 9)
                            .addComponent(txtZ, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(btnCalculo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(lblLI, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(lblR, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel13))
                            .addGap(8, 8, 8)
                            .addComponent(jLabel16))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel15)
                            .addGap(11, 11, 11)
                            .addComponent(lblLS, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(lblResul, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 11, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jLabel1)))
                    .addGap(19, 19, 19)
                    .addComponent(jLabel7)
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(seed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton5)
                        .addComponent(jButton3))
                    .addGap(29, 29, 29)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jLabel10)
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblRi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtZ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCalculo)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12))))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel14))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(lblLI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblR, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel16)))
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel15))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(lblLS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblResul, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //System.out.print("Escriba Semilla: ");
        int semilla = Integer.parseInt(seed.getText());
        int m = Integer.parseInt(txtM.getText());
        //(int) Math.pow(2, 31 - 1);
        //System.out.print("Escriba A: ");
        int a = Integer.parseInt(txtA.getText());

        //System.out.print("Escriba B: ");
        int b = Integer.parseInt(txtB.getText());

        System.out.print("Escriba C: ");
        int c = Integer.parseInt(txtC.getText());

        int X = semilla;
        double cont=0;
        int cant = Integer.parseInt(txtN.getText());
        modelo = (DefaultTableModel) this.jTable1.getModel();
        for (int i = 0; i < cant; i++) {
            X = (a * (int) Math.pow(X, 2) + b * X + c) % m;
            System.out.println(X);
            double r = (double) X/m;
            Object datos[] = new Object[] {i,X,r};
            modelo.addRow(datos);
            cont+=r;
        }
        lblRi.setText(String.valueOf(cont));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtM.setText(null);
        txtA.setText(null);
        txtC.setText(null);
        txtN.setText(null);
        seed.setText(null);
        txtB.setText(null);
        txtZ.setText(null);
        lblRi.setText(null);
        lblR.setText(null);
        lblLI.setText(null);
        lblLS.setText(null);
        lblResul.setText(null);
        modelo.setRowCount(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nom=jLabel1.getText();
        try{
            generar(nom);
            if(!seed.getText().isEmpty())
            abrir(nom);
            else
            JOptionPane.showMessageDialog(null," ** Campo nombre vacio\n ** no se encuentra ese archivo con ese nombre","Atencion",2);
        }catch(FileNotFoundException ex){
            Logger.getLogger(noLineal.class.getName()).log(Level.SEVERE,null,ex);
        }catch(DocumentException ex){
            Logger.getLogger(noLineal.class.getName()).log(Level.SEVERE,null,ex);

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoActionPerformed
        double ri=Double.parseDouble(lblRi.getText());
        double z= Double.parseDouble(txtZ.getText());
        int n=Integer.parseInt(txtN.getText());

        double r=ri/n;
        lblR.setText(String.format("%.4f", r));

        double LI=(0.5)-(z*(1/Math.sqrt(12*n)));
        double LS=(0.5)+(z*(1/Math.sqrt(12*n)));
        lblLI.setText(String.format("%.4f", LI));
        lblLS.setText(String.format("%.4f", LS));

        if(r<LS && r>LI){
            lblResul.setText("La hipotesis se acepta");
        }else{
            lblResul.setText("La hipotesis no se acepta");
        }
    }//GEN-LAST:event_btnCalculoActionPerformed

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
            java.util.logging.Logger.getLogger(noLineal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(noLineal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(noLineal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(noLineal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new noLineal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblLI;
    private javax.swing.JLabel lblLS;
    private javax.swing.JLabel lblR;
    private javax.swing.JLabel lblResul;
    private javax.swing.JLabel lblRi;
    private javax.swing.JTextField seed;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtM;
    private javax.swing.JTextField txtN;
    private javax.swing.JTextField txtZ;
    // End of variables declaration//GEN-END:variables
}
