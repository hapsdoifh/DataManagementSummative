/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myPackage;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.lang.Math;

/**
 *
 * @author zuhan
 */
public class ChanceGame extends javax.swing.JFrame {

    /**
     * Creates new form ChanceGame
     */
    Graphics2D g2d;
    BufferedImage buffImage;
    int score=0;
    int brdSze = 15;
    int[][] GameBoard = new int[brdSze][brdSze];
    
    
    public ChanceGame() {
        initComponents();
        randomize();
        //g2d = (Graphics2D)jPanel1.getGraphics();
        buffImage = new BufferedImage(jPanel1.getSize().width,jPanel1.getSize().height, BufferedImage.TYPE_INT_BGR);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(100, 100, 250));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        );

        jButton2.setText("Next");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Current Score:");

        jLabel3.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(650, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated
    public void updateGrid(){        
        //this.setPreferredSize(new Dimension(this.getSize().width,this.getSize().height));
        jPanel1.setPreferredSize(new Dimension(this.getContentPane().getWidth(),this.getContentPane().getHeight()-60));
        
        //jPanel1.setSize(new Dimension((int)(this.getSize().width*0.9),(int)(this.getSize().height*0.9)));
        jPanel1.setSize(new Dimension((int)(jPanel1.getPreferredSize().width),(int)(jPanel1.getPreferredSize().height)));

        //buffImage = new BufferedImage((int)(jPanel1.getPreferredSize().width ),(int)(jPanel1.getPreferredSize().height), BufferedImage.TYPE_INT_ARGB);
        buffImage = new BufferedImage((int)(jPanel1.getPreferredSize().width),(int)(jPanel1.getPreferredSize().height), BufferedImage.TYPE_INT_ARGB);
         //g2d = (Graphics2D)jPanel1.getGraphics();
        g2d = (Graphics2D)buffImage.getGraphics();
        int H = (buffImage.getHeight()-10)/brdSze, W = (buffImage.getWidth()-10)/brdSze;
        int incre = H < W ? H : W;
        for(int y = 0; y<brdSze; y++){
            for(int x = 0; x<brdSze; x++){             
                g2d.setStroke(new BasicStroke(4));
                g2d.setColor(new Color(100,100,200)); 
                g2d.drawRect(x*incre, y*incre,incre,incre);    
                g2d.setColor(new Color(0,255,255)); 
                g2d.fillRect(y*incre+2, x*incre+2, incre-4, incre-4);                     
            }           
        }
        System.out.println(jPanel1.getPreferredSize().width);
        jLabel1.setSize(new Dimension(this.getSize().width,this.getSize().height));
        jLabel1.setIcon(new ImageIcon(buffImage));
    }
    
    
    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        updateGrid();
    }//GEN-LAST:event_formFocusGained

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        updateGrid();         
    }//GEN-LAST:event_formComponentResized

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        //updateGrid();
    }//GEN-LAST:event_formMouseReleased

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        Point mouseP = jPanel1.getMousePosition();
        int H = (buffImage.getHeight()-10)/brdSze, W = (buffImage.getWidth()-10)/brdSze;
        int incre = H < W ? H : W;
        for(int row = 0; row <brdSze; row ++){
            for(int col = 0; col < brdSze; col++){
                if(mouseP.y>row*incre && mouseP.y<row*incre+incre && mouseP.x>col*incre && mouseP.x<col*incre+incre){
                    if(GameBoard[row][col] == 4){
                        g2d.setColor(new Color(0,255,0)); 
                        g2d.fillRect(col*incre+2, row*incre+2, incre-4, incre-4);
                    }else if(GameBoard[row][col] == 2){
                        g2d.setColor(new Color(255,0,0)); 
                        g2d.fillRect(col*incre+2, row*incre+2, incre-4, incre-4);
                    }else if(GameBoard[row][col] == 1){
                        g2d.setColor(new Color(0,0,255)); 
                        g2d.fillRect(col*incre+2, row*incre+2, incre-4, incre-4);                             
                    }else{
                        g2d.setColor(new Color(0,0,0)); 
                        g2d.fillRect(col*incre+2, row*incre+2, incre-4, incre-4);                               
                    }
                    score+=GameBoard[row][col];  
                    jLabel2.setText(""+score);
                }
            }
        }
        jLabel1.setIcon(new ImageIcon(buffImage));
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        randomize();
        updateGrid();
    }//GEN-LAST:event_jButton2MouseClicked

    public void randomize(){
        for(int c = 0; c<brdSze; c++){
            for(int r = 0; r<brdSze; r++){
                GameBoard[r][c] = 0;
            }
        }
        
        for(int i = 0; i<(brdSze*brdSze*0.1); i++){
            int y = (int)(brdSze*Math.random());
            int x = (int)(brdSze*Math.random());
            while(GameBoard[y][x] != 0){
                y = (int)(brdSze*Math.random());
                x = (int)(brdSze*Math.random());
            }
            GameBoard[y][x] = 6;
        }        
        for(int i = 0; i<(brdSze*brdSze*0.2); i++){
            int y = (int)(brdSze*Math.random());
            int x = (int)(brdSze*Math.random());
            while(GameBoard[y][x] != 0){
                y = (int)(brdSze*Math.random());
                x = (int)(brdSze*Math.random());
            }
            GameBoard[y][x] = 3;      
        }        
        for(int i = 0; i<(brdSze*brdSze*0.4); i++){
            int y = (int)(brdSze*Math.random());
            int x = (int)(brdSze*Math.random());
            while(GameBoard[y][x] != 0){
                y = (int)(brdSze*Math.random());
                x = (int)(brdSze*Math.random());
            }
            GameBoard[y][x] = 1;
        }
    }
    
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
            java.util.logging.Logger.getLogger(ChanceGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChanceGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChanceGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChanceGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChanceGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
