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
import javax.swing.DefaultListModel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Productos extends javax.swing.JFrame {
DefaultListModel Lista= new DefaultListModel();
    public Productos() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("\t\t Algoritmo de productos medios");
    }

 public void generar(String nombre) throws FileNotFoundException, DocumentException{
     if(!(JtexField1.getText().isEmpty() || (JtexField2.getText().isEmpty()) || (cantidad.getText().isEmpty() ))){  
        //FileOutputStream archivo=new FileOutputStream(nombre + ".pdf");
        Document documento=new Document() ;
        PdfWriter.getInstance(documento,new FileOutputStream("D://CopyData//Report//"+nombre+".pdf"));
        documento.open();
        
        Paragraph parrafo=new Paragraph("Metodo productos medios");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        
        documento.add(new Paragraph("Semilla1: "+JtexField1.getText()));
        documento.add(new Paragraph("Semilla2: "+JtexField2.getText()));
        documento.add(new Paragraph("Cantidad: "+cantidad.getText()));
        //documento.add(new Paragraph("Resultado: "+modelo));
        //pdf tabla
        documento.add(Chunk.NEWLINE);
        PdfPTable tabla = new PdfPTable(6);
            tabla.setWidthPercentage(100);
            PdfPCell numero = new PdfPCell(new Phrase("Nº"));
           numero.setBackgroundColor(BaseColor.ORANGE);
           PdfPCell nmnx = new PdfPCell(new Phrase("X"));
           nmnx.setBackgroundColor(BaseColor.ORANGE);
           PdfPCell nmny = new PdfPCell(new Phrase("Y"));
           nmny.setBackgroundColor(BaseColor.ORANGE);
           PdfPCell nmnxi = new PdfPCell(new Phrase("Xi"));
           nmnxi.setBackgroundColor(BaseColor.ORANGE);
           PdfPCell nmnyi = new PdfPCell(new Phrase("Yi"));
           nmnyi.setBackgroundColor(BaseColor.ORANGE);
           PdfPCell nmnri = new PdfPCell(new Phrase("Ri"));
           nmnri.setBackgroundColor(BaseColor.ORANGE);
   
         tabla.addCell(numero);
         tabla.addCell(nmnx);
         tabla.addCell(nmny);
         tabla.addCell(nmnxi);
         tabla.addCell(nmnyi);
         tabla.addCell(nmnri); 
            
    long psm1sm2 = 0;
        int ite,inicio,finial,sm1,sm2;
        String aux,zm1,zm2,it;
        zm1=JtexField1.getText();
        zm2=JtexField2.getText();
        it=cantidad.getText();
        double cont=0;
        if(zm1.length()==0&&zm2.length()==0&&it.length()==0){
            JtexField1.setText("");
            JtexField2.setText("");
            cantidad.setText("");
        }
            sm1=Integer.parseInt(zm1);
            sm2=Integer.parseInt(zm2);
            ite=Integer.parseInt(it);

            if(sm1<=100||sm2<=100){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this,"Las semillas deben tener de 3 a 4 numeros");
                JtexField1.setText("");
                JtexField2.setText("");
                cantidad.setText("");
            }else{
                for(int i=0;i<ite;i++){
               
                        psm1sm2=sm1*sm2;
                        aux=""+psm1sm2;
                        int total=aux.length();//8
                        int media=total/2;//4
                        inicio=(total-media)-2;
                        finial=(total-(media/2));
                        aux= aux.substring(inicio,finial);
                      
                        //Lista.addElement("\n\n("+i+"): X("+i+"): "+sm1+" Y("+i+"): "+sm2+"  Xi: "+psm1sm2+"  Yi: "+aux+"  Ri: 0."+aux);
                        double aux2= Double.parseDouble(aux)/10000;
                        //System.out.println("ri"+aux2);
                        cont+=aux2;
                        //System.out.println("cont"+cont);
                        //jLista.setModel(Lista);
                        tabla.addCell(String.valueOf(i));
                         tabla.addCell(String.valueOf(sm1));
                        tabla.addCell(String.valueOf(sm2));
                        tabla.addCell(String.valueOf(psm1sm2));
                        tabla.addCell(String.valueOf(aux));
                        tabla.addCell(String.valueOf(aux2));
                        sm1=sm2;
                        sm2=Integer.parseInt(aux);
                        
                }
                //lblRi.setText(String.valueOf(cont));
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
    
    public void abrir (String nombre){
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JtexField1 = new javax.swing.JTextField();
        JtexField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLista = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblRi = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        txtZ = new javax.swing.JTextField();
        btnCalculo = new javax.swing.JButton();
        lblLS = new javax.swing.JLabel();
        lblLI = new javax.swing.JLabel();
        lblResul = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("ALGORITMO DE PRODUCTOS MEDIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 47, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("INGRESA LA SEMILLA 1:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("INGRESA LA SEMILLA 2:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        JtexField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JtexField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtexField1KeyTyped(evt);
            }
        });
        jPanel1.add(JtexField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 92, 80, 32));

        JtexField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JtexField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtexField2KeyTyped(evt);
            }
        });
        jPanel1.add(JtexField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 92, 80, 32));

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setText("CALCULAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 359, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 359, 91, -1));

        jLista.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(jLista);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 176, 384, 177));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 114, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel7.setText("CANTIDAD DE NUMEROS A GENERAR:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 145, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proysimu/logoitc (2).jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        cantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadKeyTyped(evt);
            }
        });
        jPanel1.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 136, 87, 34));

        jButton5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton5.setText("ABRIR PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 361, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel9.setText("PRUEBA DE MEDIAS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 388, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel10.setText("Ri:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 430, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel11.setText("r:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 466, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setText("LIMITE INFERIOR:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 507, 110, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel13.setText("LIMITE SUPERIOR:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 539, 110, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel14.setText("RESULTADO:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 486, 85, 32));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel15.setText("Z:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 430, 22, -1));
        jPanel1.add(lblRi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 422, 96, 29));
        jPanel1.add(lblR, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 466, 96, 29));

        txtZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZActionPerformed(evt);
            }
        });
        jPanel1.add(txtZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 422, 100, 32));

        btnCalculo.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        btnCalculo.setText("CALCULAR");
        btnCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 429, -1, -1));
        jPanel1.add(lblLS, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 539, 96, 26));
        jPanel1.add(lblLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 501, 96, 26));
        jPanel1.add(lblResul, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 524, 214, 35));

        jButton3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton3.setText("ATRAS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 362, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoActionPerformed
        //PRUEBA DE MEDIAS
        double ri=Double.parseDouble(lblRi.getText());//sumatoria de ri
        double z= Double.parseDouble(txtZ.getText());//calculo z
        int n=Integer.parseInt(cantidad.getText());//cantidad de numeros o valores en ri

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

    private void txtZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nom=jLabel1.getText();
        try{
            generar(nom);
            if(!JtexField1.getText().isEmpty())
            abrir(nom);
            else
            JOptionPane.showMessageDialog(null," ** Campo nombre vacio\n ** no se encuentra ese archivo con ese nombre","Atencion",2);
        }catch(FileNotFoundException ex){
            Logger.getLogger(MultiplicadorConstante.class.getName()).log(Level.SEVERE,null,ex);
        }catch(DocumentException ex){
            Logger.getLogger(MultiplicadorConstante.class.getName()).log(Level.SEVERE,null,ex);

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyTyped
        char gamma=evt.getKeyChar();
        if(Character.isLetter(gamma)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this,"Escriba la cantidad de numeros a generar: ");
        }
    }//GEN-LAST:event_cantidadKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JtexField1.setText("");
        JtexField2.setText("");
        cantidad.setText("");
        txtZ.setText(null);
        lblRi.setText(null);
        lblR.setText(null);
        lblLI.setText(null);
        lblLS.setText(null);
        lblResul.setText(null);
        int eliminar=jLista.getSelectedIndex();
        Lista.removeAllElements();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        long psm1sm2 = 0;
        int ite,inicio,finial,sm1,sm2;
        String aux,zm1,zm2,it;
        zm1=JtexField1.getText();
        zm2=JtexField2.getText();
        it=cantidad.getText();
        double cont=0;
        if(zm1.length()==0&&zm2.length()==0&&it.length()==0){
            JtexField1.setText("");
            JtexField2.setText("");
            cantidad.setText("");
        }
        try{
            sm1=Integer.parseInt(zm1);
            sm2=Integer.parseInt(zm2);
            ite=Integer.parseInt(it);

            if(sm1<=100||sm2<=100){
                getToolkit().beep();
                JOptionPane.showMessageDialog(this,"Las semillas deben tener de 3 a 4 numeros");
                JtexField1.setText("");
                JtexField2.setText("");
                cantidad.setText("");
            }else{
                for(int i=0;i<ite;i++){
                    try{
                        psm1sm2=sm1*sm2;
                        aux=""+psm1sm2;
                        int total=aux.length();//8
                        int media=total/2;//4
                        inicio=(total-media)-2;
                        finial=(total-(media/2));
                        aux= aux.substring(inicio,finial);
                      
                        Lista.addElement("\n\n("+i+"): X("+i+"): "+sm1+" Y("+i+"): "+sm2+"  Xi: "+psm1sm2+"  Yi: "+aux+"  Ri: 0."+aux);
                        double aux2= Double.parseDouble(aux)/10000;
                        //System.out.println("ri"+aux2);
                        cont+=aux2;
                        //System.out.println("cont"+cont);
                        jLista.setModel(Lista);
                        sm1=sm2;
                        sm2=Integer.parseInt(aux);
                        

                    }catch(java.lang.StringIndexOutOfBoundsException e){
                        JOptionPane.showMessageDialog(this,"El algoritmo se degenera en la semilla ("+i+"): "+psm1sm2);
                        break;
                    }
                }
                lblRi.setText(String.valueOf(cont));
            }

        }catch(java.lang.NumberFormatException e){
            getToolkit().beep();
            JOptionPane.showMessageDialog(this,"Escribe algo");
            JtexField1.setText("");
            JtexField2.setText("");
            cantidad.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JtexField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtexField2KeyTyped
        char beta=evt.getKeyChar();
        if(Character.isLetter(beta)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this,"Escriba la semilla 2: ");
        }
    }//GEN-LAST:event_JtexField2KeyTyped

    private void JtexField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtexField1KeyTyped
        char alfa=evt.getKeyChar();
        if(Character.isLetter(alfa)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this,"Escriba la semilla 1: ");
        }
    }//GEN-LAST:event_JtexField1KeyTyped

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtexField1;
    private javax.swing.JTextField JtexField2;
    private javax.swing.JButton btnCalculo;
    private javax.swing.JTextField cantidad;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jLista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLI;
    private javax.swing.JLabel lblLS;
    private javax.swing.JLabel lblR;
    private javax.swing.JLabel lblResul;
    private javax.swing.JLabel lblRi;
    private javax.swing.JTextField txtZ;
    // End of variables declaration//GEN-END:variables
}
