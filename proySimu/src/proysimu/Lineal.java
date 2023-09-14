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

/**
 *
 * @author JOEL ARISMENDI
 */
public class Lineal extends javax.swing.JFrame {

   DefaultTableModel modelo;
    public Lineal() {
        initComponents();
         setBounds(700,100,530,870);
    }

   public void generar(String nombre) throws FileNotFoundException, DocumentException{
     if(!(seed.getText().isEmpty() || (txtA.getText().isEmpty()) || (txtC.getText().isEmpty() || (txtM.getText().isEmpty()) || (txtN.getText().isEmpty())))){  
        //FileOutputStream archivo=new FileOutputStream(nombre + ".pdf");
        Document documento=new Document() ;
        PdfWriter.getInstance(documento,new FileOutputStream("D://CopyData//Report//"+nombre+".pdf"));
        documento.open();
        
        Paragraph parrafo=new Paragraph("Algoritmo Congruencial Lineal");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        
        documento.add(new Paragraph("Semilla: "+seed.getText()));
        documento.add(new Paragraph("A: "+txtA.getText()));
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
            PdfPCell rn = new PdfPCell(new Phrase("Valor Ri"));
            rn.setBackgroundColor(BaseColor.ORANGE);
            
            tabla.addCell(numero);
            tabla.addCell(resul);  
             tabla.addCell(rn);  
            
        int semilla = Integer.parseInt(seed.getText());
        int m = Integer.parseInt(txtM.getText());
//(int) Math.pow(2, 31 - 1);
        //System.out.print("Escriba A: ");
        int a = Integer.parseInt(txtA.getText());

        //System.out.print("Escriba B: ");
        //int b = scanner.nextInt();

        System.out.print("Escriba C: ");
        int c = Integer.parseInt(txtC.getText());

        int X = semilla;
        int cant = Integer.parseInt(txtN.getText());
        modelo = (DefaultTableModel) this.jTable1.getModel();
        
        for (int i = 0; i < cant; i++) {
            X = ((a * X) + c) % m;
            double r = (double) X/m;
            System.out.println(r);
            //Object datos[] = new Object[] {i,X,r};
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
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblRi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtZ = new javax.swing.JTextField();
        btnCalculo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        lblLI = new javax.swing.JLabel();
        lblLS = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblResul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setText("METODO CONGRUENCIAL LINEAL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setText("SEMILLA:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setText("A:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel4.setText("C:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel5.setText("CANTIDAD:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        getContentPane().add(seed, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 107, -1));
        getContentPane().add(txtA, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 118, -1));
        getContentPane().add(txtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 117, -1));
        getContentPane().add(txtN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 122, -1));

        jButton1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton1.setText("CALCULAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jButton2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Valor Xi", "Valor Ri"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 490, 300));

        jLabel6.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel6.setText("M:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));
        getContentPane().add(txtM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 119, -1));

        jButton3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton3.setText("VOLVER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel7.setText("INTRODUZCA LOS DATOS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jButton5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton5.setText("ABRIR PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proysimu/logoitc (2).jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel9.setText("PRUEBA DE MEDIAS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel10.setText("Ri:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));
        getContentPane().add(lblRi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 100, 27));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel11.setText("Z:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, -1, -1));
        getContentPane().add(txtZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 116, 32));

        btnCalculo.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        btnCalculo.setText("CALCULAR");
        btnCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 590, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel12.setText("r:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel13.setText("LIMITE INFERIOR:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel14.setText("LIMITE SUPERIOR:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, -1, -1));
        getContentPane().add(lblR, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 103, 24));
        getContentPane().add(lblLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 650, 102, 25));
        getContentPane().add(lblLS, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 680, 96, 29));

        jLabel15.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel15.setText("RESULTADO:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 650, -1, -1));
        getContentPane().add(lblResul, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 204, 37));

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
        //int b = scanner.nextInt();

        //System.out.print("Escriba C: ");
        int c = Integer.parseInt(txtC.getText());

        int X = semilla;
        int cant = Integer.parseInt(txtN.getText());
        double cont=0;
        modelo = (DefaultTableModel) this.jTable1.getModel();
        for (int i = 0; i < cant; i++) {
            X = ((a * X) + c) % m;
            double r = (double) X/m;
            System.out.println(r);
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
            Logger.getLogger(Lineal.class.getName()).log(Level.SEVERE,null,ex);
        }catch(DocumentException ex){
            Logger.getLogger(Lineal.class.getName()).log(Level.SEVERE,null,ex);

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoActionPerformed
        //PRUEBA DE MEDIAS
        double ri= (double) Double.parseDouble(lblRi.getText());//sumatoria de ri
        double z= Double.parseDouble(txtZ.getText());//calculo z
        int n=Integer.parseInt(txtN.getText());//cantidad de numeros o valores en ri

        double r=ri/n; //calculo de promedios
        lblR.setText(String.format("%.4f", r));//impresion en interfaz de calculo de promedios

        double LI=(0.5)-(z*(1/Math.sqrt(12*n)));//calculo del limite inferios
        double LS=(0.5)+(z*(1/Math.sqrt(12*n)));//calculo del limite superior
        lblLI.setText(String.format("%.4f", LI));//impresion en la interfaz
        lblLS.setText(String.format("%.4f", LS));//impresion en la interfaz
        //evaluar si r esta entre el Limite superior y Limite inferior
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
            java.util.logging.Logger.getLogger(Lineal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lineal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lineal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lineal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lineal().setVisible(true);
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
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtM;
    private javax.swing.JTextField txtN;
    private javax.swing.JTextField txtZ;
    // End of variables declaration//GEN-END:variables
}
