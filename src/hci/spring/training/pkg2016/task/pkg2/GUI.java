package hci.spring.training.pkg2016.task.pkg2;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class GUI extends javax.swing.JFrame {

	ImageGUI GrayScaleIMG = new ImageGUI();
	ImageGUI OriginalIMG = new ImageGUI();
	ImageGUI BrightSpotsIMG = new ImageGUI();
	ImageGUI MostBrightSpotIMG = new ImageGUI();

	GreyIMG ImageProssessing;

	/**
	 * Creates new form GUII
	 */
	public GUI() {
		initComponents();
		//this.getContentPane().setBackground(Color.WHITE);
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileButton = new javax.swing.JButton();
        FilePath = new java.awt.TextField();
        label2 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        Tab_2 = new javax.swing.JTabbedPane();
        tabOriginalImageIMG = OriginalIMG;
        tabGrayScaleIMG = GrayScaleIMG;
        tabBrightPointsIMG = BrightSpotsIMG;
        tabBrightSpotIMG = MostBrightSpotIMG;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.white);

        FileButton.setText("Load");
        FileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileButtonActionPerformed(evt);
            }
        });

        FilePath.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FilePath.setText("C:\\");
            FilePath.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    FilePathActionPerformed(evt);
                }
            });

            label2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            label2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            label2.setText("File Path");

            jButton1.setText("Generate");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            Tab_2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
            Tab_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

            tabOriginalImageIMG.setBackground(new java.awt.Color(255, 255, 255));

            javax.swing.GroupLayout tabOriginalImageIMGLayout = new javax.swing.GroupLayout(tabOriginalImageIMG);
            tabOriginalImageIMG.setLayout(tabOriginalImageIMGLayout);
            tabOriginalImageIMGLayout.setHorizontalGroup(
                tabOriginalImageIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 792, Short.MAX_VALUE)
            );
            tabOriginalImageIMGLayout.setVerticalGroup(
                tabOriginalImageIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 613, Short.MAX_VALUE)
            );

            Tab_2.addTab("  Original Image ", tabOriginalImageIMG);

            tabGrayScaleIMG.setBackground(new java.awt.Color(255, 255, 255));

            javax.swing.GroupLayout tabGrayScaleIMGLayout = new javax.swing.GroupLayout(tabGrayScaleIMG);
            tabGrayScaleIMG.setLayout(tabGrayScaleIMGLayout);
            tabGrayScaleIMGLayout.setHorizontalGroup(
                tabGrayScaleIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 792, Short.MAX_VALUE)
            );
            tabGrayScaleIMGLayout.setVerticalGroup(
                tabGrayScaleIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 613, Short.MAX_VALUE)
            );

            Tab_2.addTab("  Gray Scale  ", tabGrayScaleIMG);

            tabBrightPointsIMG.setBackground(new java.awt.Color(255, 255, 255));

            javax.swing.GroupLayout tabBrightPointsIMGLayout = new javax.swing.GroupLayout(tabBrightPointsIMG);
            tabBrightPointsIMG.setLayout(tabBrightPointsIMGLayout);
            tabBrightPointsIMGLayout.setHorizontalGroup(
                tabBrightPointsIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 792, Short.MAX_VALUE)
            );
            tabBrightPointsIMGLayout.setVerticalGroup(
                tabBrightPointsIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 613, Short.MAX_VALUE)
            );

            Tab_2.addTab("  Bright Points  ", tabBrightPointsIMG);

            tabBrightSpotIMG.setBackground(new java.awt.Color(255, 255, 255));

            javax.swing.GroupLayout tabBrightSpotIMGLayout = new javax.swing.GroupLayout(tabBrightSpotIMG);
            tabBrightSpotIMG.setLayout(tabBrightSpotIMGLayout);
            tabBrightSpotIMGLayout.setHorizontalGroup(
                tabBrightSpotIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 792, Short.MAX_VALUE)
            );
            tabBrightSpotIMGLayout.setVerticalGroup(
                tabBrightSpotIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 613, Short.MAX_VALUE)
            );

            Tab_2.addTab("  Brightest Spot  ", tabBrightSpotIMG);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(FileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(FilePath, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Tab_2, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                            .addContainerGap())))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Tab_2, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FilePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

   private void FileButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FileButtonActionPerformed
   {//GEN-HEADEREND:event_FileButtonActionPerformed
	   // TODO add your handling code here:
	   JFileChooser browse = new JFileChooser();
	   browse.setDialogTitle("Browse");
	   browse.setRequestFocusEnabled(rootPaneCheckingEnabled);

	   browse.setCurrentDirectory(new File("."));
	   FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
	   browse.setFileFilter(filter);
	   if (browse.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		   if (browse.getSelectedFile().toString() == null) {
			   JOptionPane.showMessageDialog(null, "can't load the image", "Error", JOptionPane.ERROR_MESSAGE);
		   } else {
			   FilePath.setText(browse.getSelectedFile().toString());
		   }
	   }

   }//GEN-LAST:event_FileButtonActionPerformed

   private void FilePathActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FilePathActionPerformed
   {//GEN-HEADEREND:event_FilePathActionPerformed
	   // TODO add your handling code here:
   }//GEN-LAST:event_FilePathActionPerformed

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
   {//GEN-HEADEREND:event_jButton1ActionPerformed
	   // TODO add your handling code here:
	   long startTime = System.currentTimeMillis();
	   try {
		   ImageProssessing = new GreyIMG(FilePath.getText());
		   /*ImageToGrayScale I = new ImageToGrayScale();	I.GetInput("2.jpg");I.turnToGrayScale();*/   //Magdi's GreyScale Method
		   OriginalIMG.setImage(FilePath.getText());
		   GrayScaleIMG.setImage("GrayImage.jpg");
		   BrightSpotsIMG.setImage("BrightSpots.jpg");
		   MostBrightSpotIMG.setImage("MostBriSpotIMG.jpg");
	   } catch (Exception ex) {
		   JOptionPane.showMessageDialog(null, "Can't load the image \n Make sure you have selected a valid location \n\n" + ex.toString(), "Error : can't load the image", JOptionPane.ERROR_MESSAGE);
	   }
	   System.out.println(System.currentTimeMillis() - startTime);
						   }//GEN-LAST:event_jButton1ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) throws IOException {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FileButton;
    private java.awt.TextField FilePath;
    private javax.swing.JTabbedPane Tab_2;
    private javax.swing.JButton jButton1;
    private java.awt.Label label2;
    private javax.swing.JPanel tabBrightPointsIMG;
    private javax.swing.JPanel tabBrightSpotIMG;
    private javax.swing.JPanel tabGrayScaleIMG;
    private javax.swing.JPanel tabOriginalImageIMG;
    // End of variables declaration//GEN-END:variables
}
