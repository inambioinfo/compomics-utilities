package com.compomics.software.dialogs;

import com.compomics.util.gui.error_handlers.HelpDialog;
import com.compomics.util.parameters.UtilitiesUserParameters;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A dialog for changing the Java memory setting.
 *
 * @author Marc Vaudel
 * @author Harald Barsnes
 */
public class JavaMemoryDialog extends javax.swing.JDialog {

    /**
     * Empty default constructor
     */
    public JavaMemoryDialog() {
        javaHomeOrMemoryDialogParent = null;
        welcomeDialog = null;
        toolName = "";
    }

    /**
     * Reference to the JavaHomeOrMemoryDialogParent.
     */
    private final JavaHomeOrMemoryDialogParent javaHomeOrMemoryDialogParent;
    /**
     * A reference to the Welcome Dialog.
     */
    private final JDialog welcomeDialog;
    /**
     * The name of the tool, e.g., PeptideShaker.
     */
    private final String toolName;

    /**
     * Creates a new JavaMemoryDialog.
     *
     * @param parent the parent of the dialog
     * @param javaHomeOrMemoryDialogParent reference to the
     * JavaHomeOrMemoryDialogParent
     * @param welcomeDialog reference to the Welcome Dialog, can be null
     * @param toolName the name of the tool, e.g., PeptideShaker
     */
    public JavaMemoryDialog(JFrame parent, JavaHomeOrMemoryDialogParent javaHomeOrMemoryDialogParent, JDialog welcomeDialog, String toolName) {
        super(parent, true);
        this.javaHomeOrMemoryDialogParent = javaHomeOrMemoryDialogParent;
        this.welcomeDialog = welcomeDialog;
        this.toolName = toolName;
        initComponents();

        if (javaHomeOrMemoryDialogParent.getUtilitiesUserParameters() != null) {
            memoryTxt.setText(javaHomeOrMemoryDialogParent.getUtilitiesUserParameters().getMemoryParameter() + "");
        } else {
            memoryTxt.setText("(error)");
        }

        if (parent.isVisible()) {
            setLocationRelativeTo(parent);
        } else {
            setLocationRelativeTo(null);
        }

        setVisible(true);
    }

    /**
     * Validates the input of the user.
     *
     * @return a boolean indicating whether the input of the user is correct
     */
    private boolean validateInput() {
        try {
            Integer value = new Integer(memoryTxt.getText().trim());

            if (value <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Please verify the input for the memory limit. It should "
                        + "be a positive integer, e.g., 2048 for max 2GB of memory.",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            if (value < 10) {
                JOptionPane.showMessageDialog(this,
                        "The memory limit has to be bigger than 800 MB.",
                        "Input Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please verify the input for the memory limit. It should be an integer.",
                    "Input Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (javaHomeOrMemoryDialogParent.getUtilitiesUserParameters() == null) {
            JOptionPane.showMessageDialog(this, "User preferences where not read correctly. Please solve this first.",
                    "File Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        javaOptionsHelpJButton = new javax.swing.JButton();
        memoryLimitLabel = new javax.swing.JLabel();
        memoryTxt = new javax.swing.JTextField();
        mbLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Java Memory Settings");
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(230, 230, 230));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javaOptionsHelpJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/help.GIF"))); // NOI18N
        javaOptionsHelpJButton.setToolTipText("Help");
        javaOptionsHelpJButton.setBorder(null);
        javaOptionsHelpJButton.setBorderPainted(false);
        javaOptionsHelpJButton.setContentAreaFilled(false);
        javaOptionsHelpJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                javaOptionsHelpJButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                javaOptionsHelpJButtonMouseExited(evt);
            }
        });
        javaOptionsHelpJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaOptionsHelpJButtonActionPerformed(evt);
            }
        });

        memoryLimitLabel.setText("Memory Limit");

        memoryTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        memoryTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                memoryTxtKeyReleased(evt);
            }
        });

        mbLabel.setText("MB");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(javaOptionsHelpJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(memoryLimitLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(memoryTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mbLabel)))
                .addContainerGap())
        );

        backgroundPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memoryLimitLabel)
                    .addComponent(memoryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mbLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton)
                        .addComponent(okButton))
                    .addComponent(javaOptionsHelpJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog without saving the changes.
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog and tries to restart the tool with the new settings.
     *
     * @param evt
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (validateInput()) {

            int newValue = new Integer(memoryTxt.getText().trim());

            if (newValue != javaHomeOrMemoryDialogParent.getUtilitiesUserParameters().getMemoryParameter()) {

                int outcome = JOptionPane.showConfirmDialog(this, toolName + " needs to restart in order to take the new settings into account. Restart now?",
                        "Restart Requested", JOptionPane.OK_CANCEL_OPTION);

                if (outcome == JOptionPane.OK_OPTION) {
                    javaHomeOrMemoryDialogParent.getUtilitiesUserParameters().setMemoryParameter(newValue);

                    try {
                        UtilitiesUserParameters.saveUserParameters(javaHomeOrMemoryDialogParent.getUtilitiesUserParameters());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (welcomeDialog != null) {
                        welcomeDialog.setVisible(false);
                    }
                    javaHomeOrMemoryDialogParent.restart();
                }
            }

            dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Change the cursor to a hand cursor.
     *
     * @param evt
     */
    private void javaOptionsHelpJButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_javaOptionsHelpJButtonMouseEntered
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_javaOptionsHelpJButtonMouseEntered

    /**
     * Change the cursor back to the default cursor.
     *
     * @param evt
     */
    private void javaOptionsHelpJButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_javaOptionsHelpJButtonMouseExited
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_javaOptionsHelpJButtonMouseExited

    /**
     * Open the help dialog.
     *
     * @param evt
     */
    private void javaOptionsHelpJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaOptionsHelpJButtonActionPerformed
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        new HelpDialog(this, getClass().getResource("/helpFiles/JavaOptionsDialog.html"),
                Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/help.GIF")),
                Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/help.GIF")),
                "Java Options - Help");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_javaOptionsHelpJButtonActionPerformed

    /**
     * Execute the OK button if the user clicks the Enter key.
     *
     * @param evt
     */
    private void memoryTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memoryTxtKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER
                && memoryTxt.getText().length() > 0) {
            okButtonActionPerformed(null);
        }
    }//GEN-LAST:event_memoryTxtKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton javaOptionsHelpJButton;
    private javax.swing.JLabel mbLabel;
    private javax.swing.JLabel memoryLimitLabel;
    private javax.swing.JTextField memoryTxt;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
