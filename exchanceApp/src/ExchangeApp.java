

import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.IOException;


public class ExchangeApp extends javax.swing.JFrame {


    public ExchangeApp() {
        initComponents();
        setResizable(false);
    }


    private void initComponents() {

        lblShowTitle = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnHesapla = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        lblShowCurrency = new javax.swing.JLabel();
        lblShowCurTag = new javax.swing.JLabel();
        btnTemizle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Currency Exchange");
        setBackground(new java.awt.Color(51, 0, 102));

        lblShowTitle.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblShowTitle.setText("Currency Exchange");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD", "EUR", "YTL", "GBP","JPY","RUB","QAR","CHF" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD", "EUR", "YTL", "GBP","JPY","RUB","QAR","CHF" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        btnHesapla.setText("Hesapla");
        btnHesapla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        lblShowCurrency.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblShowCurrency.setText("");

        lblShowCurTag.setText("");
        lblShowCurTag.setFont(new java.awt.Font("Segoe UI Black", 1, 18));

        btnTemizle.setText("Temizle");
        btnTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(159, 159, 159)
                                                .addComponent(lblShowTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(84, 84, 84)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnHesapla, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblShowCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblShowCurTag, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnTemizle, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblShowTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblShowCurrency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblShowCurTag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnHesapla)
                                        .addComponent(btnTemizle))
                                .addContainerGap(167, Short.MAX_VALUE))
        );

        pack();
    }


    public double CurrencyConverter(double value) throws IOException {
        ApiConnection connection = new ApiConnection();
        String selectedCur1 = (String) jComboBox2.getSelectedItem();
        String selectedCur2 = (String) jComboBox1.getSelectedItem();
        double num = connection.getCur1Value(selectedCur1);
        double num2 = connection.getCur2Value(selectedCur2);
        double result = num / num2;
        double lastResult = result * value;
        lblShowCurTag.setText(selectedCur2);
        lastResult= Math.floor(lastResult* 100) / 100;
        return lastResult;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1.setText("");
        lblShowCurrency.setText("");
        lblShowCurTag.setText("");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, ParseException {
        try{
        String text = jTextField1.getText();
        String selectedCur1 = (String) jComboBox2.getSelectedItem();
        String selectedCur2 = (String) jComboBox1.getSelectedItem();
        if(selectedCur1.equals(selectedCur2)){
            JOptionPane.showMessageDialog(null,"Aynı Para Birimleri Arasında Dönüşüm Yapılmaz");
        }else {
            double girilen = Double.parseDouble(text);
            double converEt = CurrencyConverter(girilen);
            lblShowCurrency.setText(String.valueOf(converEt));
        }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Lütfen Sayısal Bir Değer Girin");
            lblShowCurTag.setText("");
            lblShowCurrency.setText("");
        }
    }


    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {

    }


    public static void main(String args[]) throws IOException, ParseException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExchangeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExchangeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExchangeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExchangeApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


    }

    private javax.swing.JButton btnHesapla;
    private javax.swing.JButton btnTemizle;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel lblShowTitle;
    private javax.swing.JLabel lblShowCurrency;
    private javax.swing.JLabel lblShowCurTag;
    private javax.swing.JTextField jTextField1;

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExchangeApp().setVisible(true);
            }
        });
    }
}

