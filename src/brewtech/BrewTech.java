package brewtech;
public class BrewTech extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public BrewTech() {
        initComponents();
        setTitle("BrewTech");
        setSize(900, 700);
        setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null); // Using null layout for absolute positioning

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 160, 170, 160);

        jTextField1.setBackground(new java.awt.Color(132, 102, 0));
        jTextField1.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Type Here");
        jTextField1.setToolTipText("");
        jTextField1.setCaretColor(new java.awt.Color(102, 102, 255));
        jTextField1.setSelectedTextColor(new java.awt.Color(102, 102, 255));
        jTextField1.addActionListener(this::jTextField1ActionPerformed);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(250, 220, 380, 50);

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 3, 100)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BrewTech");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 40, 660, 170);

        jButton1.setBackground(new java.awt.Color(132, 102, 0));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(242, 242, 242));
        jButton1.setText("DONE");
        getContentPane().add(jButton1);
        jButton1.setBounds(550, 290, 80, 30);

        // Use a relative path or resource path for the image
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/brewtech/pixlr-image-generator-f45d050c-de8e-4d3f-aa3e-af4e349b43ad.png")));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 900, 700);

        jButton1.addActionListener(e -> {
            DrinkTypeFrame drinkTypeFrame = new DrinkTypeFrame();
            drinkTypeFrame.setVisible(true);
        });

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BrewTech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrewTech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrewTech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrewTech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BrewTech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrewTech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrewTech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrewTech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new BrewTech().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}
