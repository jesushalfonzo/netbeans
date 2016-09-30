/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author curso1
 */
public class Example01 extends javax.swing.JFrame {

    public static final int _Lunes = 0;
    public static final int _Martes = 1;
    public static final int _Miercoles = 2;
    public static final int _Jueves = 3;
    public static final int _Viernes = 4;
    public static final int _Sabado = 5;
    public static final int _Domingo = 6;

    public enum Dias {

        Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo
    }

    /**
     * Creates new form Example01
     */
    public Example01() {
        initComponents();
        Constantes01();
        Enums01();
        jbShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                getConstantDay((String) jcCons.getSelectedItem());
                getEnumsDay((String) jcEnums.getSelectedItem());
            }

            private void getConstantDay(String day) {
                switch (day) {
                    case "Lunes":
                        System.out.println("Seleccion: " + _Lunes);
                        break;
                    case "Martes":
                        System.out.println("Seleccion: " + _Martes);
                        break;
                    case "Miercoles":
                        System.out.println("Seleccion: " + _Miercoles);
                        break;
                    case "Jueves":
                        System.out.println("Seleccion: " + _Jueves);
                        break;
                    case "Viernes":
                        System.out.println("Seleccion: " + _Viernes);
                        break;
                    case "Sabado":
                        System.out.println("Seleccion: " + _Sabado);
                        break;
                    case "Domingo":
                        System.out.println("Seleccion: " + _Domingo);
                        break;
                }
            }

            private void getEnumsDay(String string) {
                System.out.println("Seleccion: " + Dias.valueOf(string).ordinal());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcCons = new javax.swing.JComboBox();
        jcEnums = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcConsActionPerformed(evt);
            }
        });

        jLabel1.setText("Constantes");

        jLabel2.setText("ENUMS");

        jbShow.setText("Show");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcEnums, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcCons, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbShow, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcEnums, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jbShow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcConsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcConsActionPerformed

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
            java.util.logging.Logger.getLogger(Example01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Example01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Example01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Example01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Example01().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbShow;
    private javax.swing.JComboBox jcCons;
    private javax.swing.JComboBox jcEnums;
    // End of variables declaration//GEN-END:variables

    public void Constantes01() {
        jcCons.addItem("Lunes");
        jcCons.addItem("Martes");
        jcCons.addItem("Miercoles");
        jcCons.addItem("Jueves");
        jcCons.addItem("Viernes");
        jcCons.addItem("Sabado");
        jcCons.addItem("Domingo");
    }

    public void Enums01() {
        /*
         * Como Dias.values() de vuelve un [] (array) lo puedo recorrer
         * con un ciclo for y guardar el nombre en el combobox.
         */
        for (Dias dia : Dias.values()) {
            jcEnums.addItem(dia.name());
        }
    }
}
