/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversor2;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Maty
 */
public class Conversor2 extends javax.swing.JFrame {
    
    public Conversor2() {
        initComponents();
        ConvertirBoton.setFocusable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CampoCentimetros = new javax.swing.JTextField();
        CampoPulgadas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ConvertirBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CampoCentimetros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CampoCentimetrosFocusLost(evt);
            }
        });

        CampoPulgadas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CampoPulgadasFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Centímetros");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pulgadas");

        ConvertirBoton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ConvertirBoton.setText("CONVERTIR");
        ConvertirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertirBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(CampoCentimetros, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoPulgadas, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ConvertirBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CampoCentimetros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConvertirBoton)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoPulgadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void ConvertirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertirBotonActionPerformed
        
        String cen = CampoCentimetros.getText();
        String pulg = CampoPulgadas.getText();
        
        double convertidoC = 0, convertidoP = 0;
        
        //Convertir centímetros a pulgadas
        if(!CampoPulgadas.isFocusOwner())//Si el campo pulgadas no tiene el foco
        {
            
            if(cen.isEmpty())//Si el String que extraje de CampoCentimetros esta vacio
            {
                JOptionPane.showMessageDialog(this, "El campo centímetros esta vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;//Muestro un mensaje de error y retorno
            }
            try{
                convertidoC = Double.parseDouble(cen);//Guardo en una variable double la conversion del String a double
            }   
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "El valor "+cen+" no es válido!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;//Si ingrese un valor no numérico en el campo centímetros muestro mensaje de error
            }
            
            convertidoC /= 2.54;//Hago la conversión a pulgadas

            cen = String.format("%.4f",convertidoC);//Convierto mi variable double a String
            
            CampoPulgadas.setText(cen);//Pongo el String convertido en el campo de pulgadas
        }
        //Convertir pulgadas a centímetros
        else if(!CampoCentimetros.isFocusOwner())//Si el campo de centímetros no esta Focuseado
        {
            if(pulg.isEmpty())//Si el campo de pulgadas esta vacio
            {
                JOptionPane.showMessageDialog(this, "El campo pulgadas esta vacio!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;//Muestro el mensaje de error y retorno
            }
            
            try{
                convertidoP = Double.parseDouble(pulg);//Convierto el String de pulgadas a double
            }
            catch(NumberFormatException e){

               JOptionPane.showMessageDialog(this, "El valor "+pulg+" no es válido!", "ERROR", JOptionPane.ERROR_MESSAGE);
               return;//Si ingrese un valor no coherente lo advierto con un mensaje de error
            }
            
            convertidoP *= 2.54;//Convierto a centímetros

            pulg = String.format("%.4f", convertidoP);//Convierto ConvertidoP a String
            
            CampoCentimetros.setText(pulg);//Coloco el String convertido en el campo de centímetros
        }
    }//GEN-LAST:event_ConvertirBotonActionPerformed

    private void CampoCentimetrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoCentimetrosFocusLost
        System.out.println("CampoCentimetros perdio el foco");//Esto lo único que hace es poner un mensaje en consola
                                                              //cuando el campo centímetros pierde el foco no tiene otra utilidad
    }//GEN-LAST:event_CampoCentimetrosFocusLost

    private void CampoPulgadasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoPulgadasFocusLost
        System.out.println("CampoPulgadas perdió el foco");//Esto lo único que hace es poner un mensaje en consola
                                                           //cuando el campo centímetros pierde el foco no tiene otra utilidad
    }//GEN-LAST:event_CampoPulgadasFocusLost

    
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
            java.util.logging.Logger.getLogger(Conversor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conversor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conversor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conversor2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conversor2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoCentimetros;
    private javax.swing.JTextField CampoPulgadas;
    private javax.swing.JButton ConvertirBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
