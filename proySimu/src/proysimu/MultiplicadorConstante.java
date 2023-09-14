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
public class MultiplicadorConstante extends javax.swing.JFrame {

    DefaultTableModel modelo;
    public MultiplicadorConstante() {
        initComponents();
        setBounds(700,100,485,820);
    }

     public void generar(String nombre) throws FileNotFoundException, DocumentException{
     if(!(X0.getText().isEmpty() || (a.getText().isEmpty()) || (N.getText().isEmpty() || (n.getText().isEmpty())))){  
        //FileOutputStream archivo=new FileOutputStream(nombre + ".pdf");
        Document documento=new Document() ;
        PdfWriter.getInstance(documento,new FileOutputStream("D://CopyData//Report//"+nombre+".pdf"));
        documento.open();
        
        Paragraph parrafo=new Paragraph("Metodo Multiplicador Constante");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        
        documento.add(new Paragraph("Semilla: "+X0.getText()));
        documento.add(new Paragraph("A: "+a.getText()));
        documento.add(new Paragraph("Cantidad: "+N.getText()));
        documento.add(new Paragraph("Cantidad de Digitos: "+n.getText()));
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
            
        String semilla1 = X0.getText();
        String semilla2 = a.getText();
        
        
        int cant= Integer.parseInt(N.getText());
        int tam1 = semilla1.length();
        int tam2 = semilla2.length();
        n.setText(String.valueOf(tam1));
        int numero1 = Integer.parseInt(semilla1);
        int numero2 = Integer.parseInt(semilla2);
        
        modelo = (DefaultTableModel) this.jTable1.getModel();
        
        for (int i = 0; i < cant; i++) {
            int numero3 = numero1 * numero2;
            String snumero3 = Integer.toString(numero3);
            int tam3 = snumero3.length();
            int primerc = (tam3 - tam1) / 2;

            String snumero4 = snumero3.substring(primerc, primerc + tam1);
            System.out.println(i + ". " + snumero4);
            numero1 = Integer.parseInt(snumero4);

            //Object datos[] = new Object[] {i,snumero4,"0."+snumero4};
            //modelo.addRow(datos);
            tabla.addCell(String.valueOf(i));
            tabla.addCell(snumero4);
            tabla.addCell("0."+snumero4);
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
        a = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        n = new javax.swing.JLabel();
        X0 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        N = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblRi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtZ = new javax.swing.JTextField();
        btnCalculo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        lblLI = new javax.swing.JLabel();
        lblLS = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblResul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setText("MULTIPLICADOR CONSTANTE");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel2.setText("INTRODUZCA LOS DATOS");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel3.setText("SEMILLA:");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel4.setText("A:");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel5.setText("DIGITOS:");

        jButton1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton1.setText("CALCULAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel7.setText("CANTIDAD:");

        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton2.setText("ATRAS");
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton3.setText("NUEVO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proysimu/logoitc (2).jpg"))); // NOI18N

        jButton5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton5.setText("ABRIR PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel8.setText("PRUEBA DE MEDIAS");

        jLabel9.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel9.setText("Ri:");

        jLabel11.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel11.setText("Z:");

        btnCalculo.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        btnCalculo.setText("CALCULAR");
        btnCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel10.setText("r:");

        jLabel12.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel12.setText("LIMITE INFERIOR:");

        jLabel13.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel13.setText("LIMITE SUPERIOR:");

        jLabel14.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel14.setText("RESULTADO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel3)
                            .addGap(12, 12, 12)
                            .addComponent(X0, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(jLabel4)
                            .addGap(12, 12, 12)
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(jLabel5)
                            .addGap(6, 6, 6)
                            .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(58, 58, 58)
                            .addComponent(jLabel7)
                            .addGap(12, 12, 12)
                            .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jButton1)
                            .addGap(29, 29, 29)
                            .addComponent(jButton3)
                            .addGap(27, 27, 27)
                            .addComponent(jButton5)
                            .addGap(21, 21, 21)
                            .addComponent(jButton2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel8))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel9)
                            .addGap(14, 14, 14)
                            .addComponent(lblRi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel11)
                            .addGap(9, 9, 9)
                            .addComponent(txtZ, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnCalculo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel10)
                            .addGap(21, 21, 21)
                            .addComponent(lblR, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGap(11, 11, 11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLI, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(lblLS, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel14))
                                .addComponent(lblResul, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel1)))
                    .addGap(12, 12, 12)
                    .addComponent(jLabel2)
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(X0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))))
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel7))
                        .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton5)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1)
                                .addComponent(jButton3)
                                .addComponent(jButton2))))
                    .addGap(6, 6, 6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jLabel8)
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblRi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtZ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11)
                                .addComponent(btnCalculo))))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel10))
                        .addComponent(lblR, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel12)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel13))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblLI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(lblLS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(6, 6, 6)
                            .addComponent(lblResul, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //System.out.print("Semilla 1: ");
        String semilla1 = X0.getText();

        //System.out.print("Semilla 2: ");
        String semilla2 = a.getText();

        System.out.println("Introduzca la cantidada de numeros a generar: ");
        int cant= Integer.parseInt(N.getText());

        int tam1 = semilla1.length();
        int tam2 = semilla2.length();

        //System.out.println("Dígitos: " + tam1);
        n.setText(String.valueOf(tam1));

        int numero1 = Integer.parseInt(semilla1);
        int numero2 = Integer.parseInt(semilla2);

        modelo = (DefaultTableModel) this.jTable1.getModel();
        double cont=0;
        for (int i = 0; i < cant; i++) {
            int numero3 = numero1 * numero2;
            String snumero3 = Integer.toString(numero3);
            int tam3 = snumero3.length();
            int primerc = (tam3 - tam1) / 2;

            String snumero4 = snumero3.substring(primerc, primerc + tam1);
            System.out.println(i + ". " + snumero4);
            numero1 = Integer.parseInt(snumero4);

            double r= (double)numero1/10000;
            //System.out.println(r);
            cont+=r;

            Object datos[] = new Object[] {i,snumero4,"0."+snumero4};
            modelo.addRow(datos);
        }
        lblRi.setText(String.valueOf(cont));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        X0.setText(null);
        N.setText(null);
        a.setText(null);
        n.setText(null);
        txtZ.setText(null);
        lblRi.setText(null);
        lblR.setText(null);
        lblLI.setText(null);
        lblLS.setText(null);
        lblResul.setText(null);
        modelo.setRowCount(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String nom=jLabel1.getText();
        try{
            generar(nom);
            if(!X0.getText().isEmpty())
            abrir(nom);
            else
            JOptionPane.showMessageDialog(null," ** Campo nombre vacio\n ** no se encuentra ese archivo con ese nombre","Atencion",2);
        }catch(FileNotFoundException ex){
            Logger.getLogger(MultiplicadorConstante.class.getName()).log(Level.SEVERE,null,ex);
        }catch(DocumentException ex){
            Logger.getLogger(MultiplicadorConstante.class.getName()).log(Level.SEVERE,null,ex);

        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoActionPerformed
        //PRUEBA DE MEDIAS
        double ri=Double.parseDouble(lblRi.getText());//sumatoria de ri
        double z= Double.parseDouble(txtZ.getText());//calculo z
        int n=Integer.parseInt(N.getText());//cantidad de numeros o valores en ri

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
            java.util.logging.Logger.getLogger(MultiplicadorConstante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultiplicadorConstante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultiplicadorConstante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultiplicadorConstante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MultiplicadorConstante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField N;
    private javax.swing.JTextField X0;
    private javax.swing.JTextField a;
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
    private javax.swing.JLabel n;
    private javax.swing.JTextField txtZ;
    // End of variables declaration//GEN-END:variables
}
