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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JOEL ARISMENDI
 */
public class MinimosCuadrados extends javax.swing.JFrame {

    DefaultListModel m1 = new DefaultListModel();
        DefaultListModel m2 = new DefaultListModel();
        DefaultListModel m3 = new DefaultListModel();
        int cant=20;
    public MinimosCuadrados() {
        JOptionPane.showMessageDialog(null, "EL PROGRAMA SOLO ACEPTA 3 A 4 SEMILLAS...!!!");
        initComponents();
        setBounds(600, 200, 598, 660);
    }

    public void generar(String nombre) throws FileNotFoundException, DocumentException{
     if(!(JtexField.getText().isEmpty())){  
        //FileOutputStream archivo=new FileOutputStream(nombre + ".pdf");
        Document documento=new Document() ;
        PdfWriter.getInstance(documento,new FileOutputStream("D://CopyData//Report//"+nombre+".pdf"));
        documento.open();
        
        Paragraph parrafo=new Paragraph("Algoritmo de Minimos Cuadrados");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        
        documento.add(new Paragraph("Semilla: "+JtexField.getText()));
        //documento.add(new Paragraph("Resultado: "+modelo));
        //pdf tabla
        documento.add(Chunk.NEWLINE);
        PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            PdfPCell numero = new PdfPCell(new Phrase("Nº"));
           numero.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell resul1 = new PdfPCell(new Phrase("Valor Xi"));
            resul1.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell resul2 = new PdfPCell(new Phrase("Valor Yi"));
            resul2.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell resul3 = new PdfPCell(new Phrase("Valor Ri"));
            resul3.setBackgroundColor(BaseColor.ORANGE);
            
            tabla.addCell(numero);
            tabla.addCell(resul1);
            tabla.addCell(resul2);
            tabla.addCell(resul3);
            
        //agregamos una nueva variable, para cuando escribamos en nuestro jTexfield
        int semilla = Integer.parseInt(JtexField.getText());
        //inicializamos nuestra variable semilla
        int xn = semilla;
        //creamos nuestra variable y
        int y;
        //hacemos un ciclo for, donde comenzamos en 0, pero que se menor que 5 y esta se sume en 1
        for (int i = 0; i < cant; i++) {
            //multiplicamos para guardar el valor en y
            y = xn * xn;
            String rn = medios(y);
            //convertimos nuestros valores con un parseo   
            xn = Integer.parseInt(rn);
            /*m1.addElement("0." +rn);
            m2.addElement(rn);
            m3.addElement(y);*/
            tabla.addCell(String.valueOf(i));
            tabla.addCell(rn);
            tabla.addCell(String.valueOf(y));
            tabla.addCell("0."+rn);
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
    JOptionPane.showMessageDialog(null,"Debe llenar todos los campos","Atencion",2);}
     
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jLista2 = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLista1 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLista3 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JtexField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLista2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 255, 255), null, null));
        jScrollPane2.setViewportView(jLista2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 235, 128, 143));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proysimu/logoitc (2).jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLista1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 255, 255), null, null));
        jScrollPane3.setViewportView(jLista1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 235, 128, 143));

        jLista3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 255, 255), null, null));
        jScrollPane4.setViewportView(jLista3);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 235, 128, 143));

        jButton1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton1.setText("CALCULAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 404, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel3.setText("VALORES DE XN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 209, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel1.setText("ALGORITMO DE CUADRADOS MEDIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 101, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel4.setText("VALORES DE YN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 209, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel2.setText("ESCRIBE LA SEMILLA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 147, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel5.setText("VALORES DE RN");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 209, -1, -1));

        JtexField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtexFieldActionPerformed(evt);
            }
        });
        getContentPane().add(JtexField, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 133, 156, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel7.setText("Simulacion y modelacion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 32, -1, -1));

        jButton2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        jButton3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton3.setText("VOLVER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 404, -1, -1));

        jButton5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton5.setText("ABRIR PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel10.setText("PRUEBA DE MEDIAS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel11.setText("Ri:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));
        getContentPane().add(lblRi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 100, 27));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel12.setText("Z:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, -1, -1));
        getContentPane().add(txtZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 116, 32));

        btnCalculo.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        btnCalculo.setText("CALCULAR");
        btnCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel13.setText("r:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel14.setText("LIMITE INFERIOR:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel15.setText("LIMITE SUPERIOR:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));
        getContentPane().add(lblR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 103, 24));
        getContentPane().add(lblLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 102, 25));
        getContentPane().add(lblLS, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 96, 29));

        jLabel16.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel16.setText("RESULTADO:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, -1, -1));
        getContentPane().add(lblResul, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 204, 37));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //agregamos una nueva variable, para cuando escribamos en nuestro jTexfield
        int semilla = Integer.parseInt(JtexField.getText());
        //inicializamos nuestra variable semilla
        int xn = semilla;
        //creamos nuestra variable y
        int y;
        double cont=0;
        //hacemos un ciclo for, donde comenzamos en 0, pero que se menor que 5 y esta se sume en 1
        for (int i = 0; i < cant; i++) {
            //multiplicamos para guardar el valor en y
            y = xn * xn;
            String rn = medios(y);
            //convertimos nuestros valores con un parseo
            xn = Integer.parseInt(rn);
            double r= Double.parseDouble(rn)/10000;
            //System.out.println(r);
            cont+=r;
            m1.addElement("0." +rn);
            m2.addElement(rn);
            m3.addElement(y);

        }
        lblRi.setText(String.format("%.4f",cont));
        //mostrmos los resultados dentro de nuestros jList que esta en la interfaz
        jLista1.setModel(m1);
        jLista2.setModel(m2);
        jLista3.setModel(m3);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JtexFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtexFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtexFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JtexField.setText(null);
        txtZ.setText(null);
        m1.clear();
        m2.clear();
        m3.clear();
        lblRi.setText(null);
        lblR.setText(null);
        lblLI.setText(null);
        lblLS.setText(null);
        lblResul.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nom=jLabel1.getText();
        try{
            generar(nom);
            if(!JtexField.getText().isEmpty())
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
        int n=cant;

        double r=ri/n;           // calculo de promedios
        lblR.setText(String.format("%.4f", r));

        double LI=(0.5)-(z*(1/Math.sqrt(12*n)));
        double LS=(0.5)+(z*(1/Math.sqrt(12*n)));
        lblLI.setText(String.format("%.4f", LI));
        lblLS.setText(String.format("%.4f", LS));
        // evaluar si la r esta entre el limite superior y limite inferior
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
            java.util.logging.Logger.getLogger(MinimosCuadrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinimosCuadrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinimosCuadrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinimosCuadrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinimosCuadrados().setVisible(true);
            }
        });
    }
    
     public String medios(int y){
        String ycadena = Integer.toString(y);
        int largo = ycadena.length();
        String xcadena = null;
     
        switch(largo){
            case 8:
                xcadena = ycadena.substring(2,6);
                break;
                
                case 7:
                xcadena = ycadena.substring(1,5);
                break;
                
                case 6:
                xcadena = ycadena.substring(1,5);
                break;
                
                case 5:
                xcadena = ycadena.substring(0,4);
                break;
                
                case 4:
                xcadena = ycadena.substring(0,4);
                break;
        }
        return xcadena;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtexField;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jLista1;
    private javax.swing.JList<String> jLista2;
    private javax.swing.JList<String> jLista3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblLI;
    private javax.swing.JLabel lblLS;
    private javax.swing.JLabel lblR;
    private javax.swing.JLabel lblResul;
    private javax.swing.JLabel lblRi;
    private javax.swing.JTextField txtZ;
    // End of variables declaration//GEN-END:variables
}
