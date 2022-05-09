import Clases.Conversor;
import Clases.ConversorCentimetro;
import Clases.ConversorKilometro;
import Clases.ConversorMetro;
import Clases.ConversorPulgada;
import Excepciones.NumeroInvalidoExcepcion;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class ConversorUI extends javax.swing.JFrame {
    boolean EsPrimerCampo = false; 
    
    public ConversorUI() {
        initComponents();
        setSize(420, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Conversor");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CBMedidas = new javax.swing.JComboBox<>();
        TFMedida1 = new javax.swing.JTextField();
        TFMedida2 = new javax.swing.JTextField();
        BtnConvertir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        CBMedidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilometro / Metro", "Centimetro / Pulgada", "Kilometro / Centimetro", "Metro / Centimetro", "Pulgada / Kilometro" }));

        TFMedida1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFMedida1FocusLost(evt);
            }
        });
        TFMedida1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFMedida1KeyPressed(evt);
            }
        });

        TFMedida2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFMedida2FocusLost(evt);
            }
        });
        TFMedida2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFMedida2KeyPressed(evt);
            }
        });

        BtnConvertir.setLabel("Convertir");
        BtnConvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConvertirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CBMedidas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TFMedida1)
                    .addComponent(TFMedida2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnConvertir)
                .addContainerGap(384, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(CBMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(TFMedida1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TFMedida2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(BtnConvertir)))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConvertirActionPerformed
        String input;
        if (EsPrimerCampo) {
            input = TFMedida1.getText().trim().replace(",","."); 
        }
        else
        {
            input = TFMedida2.getText().trim().replace(",",".");
        }
        Double valor;
        try {
            valor = Double.valueOf(input);
        } 
        catch (NumberFormatException e) {
            JOptionPane.
                    showMessageDialog(this, "Ingrese un valor numérico", 
                            "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int posicion = CBMedidas.getSelectedIndex()+1;
        try {
            double resultado = convertir(valor,posicion);
            if(EsPrimerCampo){
                TFMedida2.setText(String.format("%.10f", resultado));
            }
            else
            {
                TFMedida1.setText(String.format("%.10f", resultado));
            }
        } catch (NumeroInvalidoExcepcion ex) {
            JOptionPane.
                    showMessageDialog(this, "Error en la conversion", 
                            "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnConvertirActionPerformed
    private double convertir(double valor, int posicion) throws NumeroInvalidoExcepcion{
        Conversor conversor = null;    
        if(EsPrimerCampo){
            switch (posicion) {
                case 1,3 -> conversor = new ConversorKilometro(valor);
                case 2 -> conversor = new ConversorCentimetro(valor);
                case 4 -> conversor = new ConversorMetro(valor);
                case 5 -> conversor = new ConversorPulgada(valor);
            }
        }
        else
        {
            switch (posicion) {
                case 1 -> conversor = new ConversorMetro(valor);
                case 2 -> conversor = new ConversorPulgada(valor);
                case 3,4 -> conversor = new ConversorCentimetro(valor);
                case 5 -> conversor = new ConversorKilometro(valor);
            }
        }
        return conversor.ConvertirValor(posicion);
    }
    private void TFMedida1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFMedida1FocusLost
        EsPrimerCampo = true;
    }//GEN-LAST:event_TFMedida1FocusLost

    private void TFMedida2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFMedida2FocusLost
        EsPrimerCampo = false;
    }//GEN-LAST:event_TFMedida2FocusLost

    private void TFMedida1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFMedida1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            EsPrimerCampo = true;
            BtnConvertir.doClick();
        }
    }//GEN-LAST:event_TFMedida1KeyPressed

    private void TFMedida2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFMedida2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            EsPrimerCampo = false;
            BtnConvertir.doClick();
        }
    }//GEN-LAST:event_TFMedida2KeyPressed

    public static void main(String args[]) {  
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConversorUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConvertir;
    private javax.swing.JComboBox<String> CBMedidas;
    private javax.swing.JTextField TFMedida1;
    private javax.swing.JTextField TFMedida2;
    // End of variables declaration//GEN-END:variables
}
