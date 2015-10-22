package com.compomics.util.gui.parameters;

import com.compomics.util.experiment.biology.NeutralLoss;
import com.compomics.util.experiment.identification.identification_parameters.IdentificationParametersFactory;
import com.compomics.util.experiment.identification.identification_parameters.SearchParameters;
import com.compomics.util.gui.parameters.identification_parameters.IdentificationParametersNameDialog;
import com.compomics.util.gui.parameters.identification_parameters.SearchSettingsDialog;
import com.compomics.util.gui.parameters.identification_parameters.ValidationQCPreferencesDialogParent;
import com.compomics.util.io.ConfigurationFile;
import com.compomics.util.preferences.IdentificationParameters;
import com.compomics.util.preferences.LastSelectedFolder;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * IdentificationParametersSelectionDialog.
 *
 * @author Marc Vaudel
 */
public class IdentificationParametersSelectionDialog extends javax.swing.JDialog {

    /**
     * The parent frame.
     */
    private java.awt.Frame parentFrame;
    /**
     * Boolean indicating whether the user canceled the editing.
     */
    private boolean canceled = false;
    /**
     * The normal icon.
     */
    private Image normalIcon;
    /**
     * The waiting icon.
     */
    private Image waitingIcon;
    /**
     * The last selected folder.
     */
    private LastSelectedFolder lastSelectedFolder;
    /**
     * Boolean indicating whether the parameters can be edited.
     */
    private boolean editable;
    /**
     * The configuration file containing the modification use.
     */
    private ConfigurationFile configurationFile;
    /**
     * The possible neutral losses in a list.
     */
    private ArrayList<NeutralLoss> possibleNeutralLosses;
    /**
     * List of possible reporter ions.
     */
    private ArrayList<Integer> reporterIons;
    /**
     * A parent handling the edition of QC filters.
     */
    private ValidationQCPreferencesDialogParent validationQCPreferencesDialogParent;
    /**
     * The identification parameters factory.
     */
    private IdentificationParametersFactory identificationParametersFactory = IdentificationParametersFactory.getInstance();

    /**
     * Constructor.
     *
     * @param parentFrame the parent frame
     * @param identificationParameters the identification parameters to display
     * @param configurationFile the configuration file containing the PTM usage
     * preferences
     * @param possibleNeutralLosses the possible neutral losses
     * @param reporterIons the possible reporter ions
     * @param normalIcon the normal icon
     * @param waitingIcon the waiting icon
     * @param lastSelectedFolder the last selected folder
     * @param validationQCPreferencesDialogParent a parent handling the edition
     * of QC filters
     * @param editable boolean indicating whether the parameters can be edited
     */
    public IdentificationParametersSelectionDialog(java.awt.Frame parentFrame, ConfigurationFile configurationFile, ArrayList<NeutralLoss> possibleNeutralLosses, ArrayList<Integer> reporterIons, Image normalIcon, Image waitingIcon, LastSelectedFolder lastSelectedFolder, ValidationQCPreferencesDialogParent validationQCPreferencesDialogParent, boolean editable) {
        super(parentFrame, true);

        this.editable = editable;
        this.parentFrame = parentFrame;
        this.normalIcon = normalIcon;
        this.waitingIcon = waitingIcon;
        this.configurationFile = configurationFile;
        this.lastSelectedFolder = lastSelectedFolder;
        this.validationQCPreferencesDialogParent = validationQCPreferencesDialogParent;
        this.reporterIons = reporterIons;
        this.possibleNeutralLosses = possibleNeutralLosses;

        initComponents();
        setUpGui();
        populateGUI();
        if (identificationParametersFactory.getParametersList().isEmpty()) {
            addFromSearchSettings();
            parametersTable.setRowSelectionInterval(0, 0);
            dispose();
        } else {
            setLocationRelativeTo(parentFrame);
            setVisible(true);
        }
    }

    /**
     * Set up the GUI.
     */
    private void setUpGui() {

    }

    /**
     * Populates the GUI using the given identification parameters.
     */
    public void populateGUI() {
        parametersTable.setModel(new ParametersTableModel());
    }

    /**
     * Updates the parameters table.
     */
    public void updateTable() {
        ((DefaultTableModel) parametersTable.getModel()).fireTableDataChanged();
    }

    /**
     * Indicates whether the user canceled the editing.
     *
     * @return a boolean indicating whether the user canceled the editing
     */
    public boolean isCanceled() {
        return canceled;
    }

    /**
     * Returns the selected identification parameters.
     *
     * @return the identification parameters
     */
    public IdentificationParameters getIdentificationParameters() {
        String identificationParametersName = getSelectedParametersName();
        return identificationParametersFactory.getIdentificationParameters(identificationParametersName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parametersPopupMenu = new javax.swing.JPopupMenu();
        addMenu = new javax.swing.JMenu();
        addProtocolMenuItem = new javax.swing.JMenuItem();
        addSearchSettingsMenuItem = new javax.swing.JMenuItem();
        addFile = new javax.swing.JMenuItem();
        addDetailsMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        editProtocolMenuItem = new javax.swing.JMenuItem();
        editSearchSettingsMenuItem = new javax.swing.JMenuItem();
        editDetailsMenuItem = new javax.swing.JMenuItem();
        renameMenuItem = new javax.swing.JMenuItem();
        removeMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        backgroundPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        parametersTableScrollPane = new javax.swing.JScrollPane();
        parametersTable = new javax.swing.JTable();
        helpLbl = new javax.swing.JLabel();

        addMenu.setText("Add");

        addProtocolMenuItem.setText("From Protocol (Beta)");
        addProtocolMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProtocolMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addProtocolMenuItem);

        addSearchSettingsMenuItem.setText("New Search Settings");
        addSearchSettingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSearchSettingsMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addSearchSettingsMenuItem);

        addFile.setText("From Files");
        addFile.setToolTipText("");
        addFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileActionPerformed(evt);
            }
        });
        addMenu.add(addFile);

        addDetailsMenuItem.setText("Advanced");
        addDetailsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDetailsMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(addDetailsMenuItem);

        parametersPopupMenu.add(addMenu);

        editMenu.setText("jMenu1");

        editProtocolMenuItem.setText("Protocol (Beta)");
        editProtocolMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProtocolMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(editProtocolMenuItem);

        editSearchSettingsMenuItem.setText("Search Settings");
        editSearchSettingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSearchSettingsMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(editSearchSettingsMenuItem);

        editDetailsMenuItem.setText("Advanced");
        editDetailsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDetailsMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(editDetailsMenuItem);

        parametersPopupMenu.add(editMenu);

        renameMenuItem.setText("Rename");
        renameMenuItem.setToolTipText("");
        renameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameMenuItemActionPerformed(evt);
            }
        });
        parametersPopupMenu.add(renameMenuItem);

        removeMenuItem.setText("Delete");
        removeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuItemActionPerformed(evt);
            }
        });
        parametersPopupMenu.add(removeMenuItem);

        saveAsMenuItem.setText("Save As File");
        saveAsMenuItem.setToolTipText("");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        parametersPopupMenu.add(saveAsMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Identification Parameters"));
        tablePanel.setOpaque(false);

        parametersTableScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parametersTableScrollPaneMouseReleased(evt);
            }
        });

        parametersTable.setModel(new ParametersTableModel());
        parametersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        parametersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                parametersTableMouseReleased(evt);
            }
        });
        parametersTableScrollPane.setViewportView(parametersTable);

        helpLbl.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        helpLbl.setText("Right-click to add, edit, and remove parameters.");

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parametersTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addComponent(helpLbl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parametersTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(helpLbl)
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
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
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parametersTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parametersTableMouseReleased
        parametersTableClicked(evt, parametersTable);
    }//GEN-LAST:event_parametersTableMouseReleased

    private void parametersTableScrollPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parametersTableScrollPaneMouseReleased
        parametersTableClicked(evt, parametersTableScrollPane);
    }//GEN-LAST:event_parametersTableScrollPaneMouseReleased

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        saveAs(getSelectedParametersName());
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void removeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMenuItemActionPerformed
        remove(getSelectedParametersName());
    }//GEN-LAST:event_removeMenuItemActionPerformed

    private void addProtocolMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProtocolMenuItemActionPerformed
        addFromProtocol();
    }//GEN-LAST:event_addProtocolMenuItemActionPerformed

    private void addSearchSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSearchSettingsMenuItemActionPerformed
        addFromSearchSettings();
    }//GEN-LAST:event_addSearchSettingsMenuItemActionPerformed

    private void addDetailsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDetailsMenuItemActionPerformed
        addAdvanced();
    }//GEN-LAST:event_addDetailsMenuItemActionPerformed

    private void editProtocolMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProtocolMenuItemActionPerformed
        editProtocol(getSelectedParametersName());
    }//GEN-LAST:event_editProtocolMenuItemActionPerformed

    private void editSearchSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSearchSettingsMenuItemActionPerformed
        editSearchSettings(getSelectedParametersName());
    }//GEN-LAST:event_editSearchSettingsMenuItemActionPerformed

    private void editDetailsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDetailsMenuItemActionPerformed
        editAdvanced(getSelectedParametersName());
    }//GEN-LAST:event_editDetailsMenuItemActionPerformed

    private void renameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameMenuItemActionPerformed
        rename(getSelectedParametersName());
    }//GEN-LAST:event_renameMenuItemActionPerformed

    private void addFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileActionPerformed
        addFromFile();
    }//GEN-LAST:event_addFileActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        canceled = true;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addDetailsMenuItem;
    private javax.swing.JMenuItem addFile;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem addProtocolMenuItem;
    private javax.swing.JMenuItem addSearchSettingsMenuItem;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JMenuItem editDetailsMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem editProtocolMenuItem;
    private javax.swing.JMenuItem editSearchSettingsMenuItem;
    private javax.swing.JLabel helpLbl;
    private javax.swing.JButton okButton;
    private javax.swing.JPopupMenu parametersPopupMenu;
    private javax.swing.JTable parametersTable;
    private javax.swing.JScrollPane parametersTableScrollPane;
    private javax.swing.JMenuItem removeMenuItem;
    private javax.swing.JMenuItem renameMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Handles the clicking of the table area.
     *
     * @param evt the click event
     * @param invoker the component in whose space the popup menu is to appear
     */
    private void parametersTableClicked(java.awt.event.MouseEvent evt, Component invoker) {
        if (evt != null && parametersTable.rowAtPoint(evt.getPoint()) != -1) {
            int row = parametersTable.rowAtPoint(evt.getPoint());
            parametersTable.setRowSelectionInterval(row, row);
        }
        if (evt != null && evt.getButton() == MouseEvent.BUTTON3) {
            editMenu.setVisible(parametersTable.getSelectedRow() != -1);
            removeMenuItem.setVisible(parametersTable.getSelectedRow() != -1);
            saveAsMenuItem.setVisible(parametersTable.getSelectedRow() != -1);
            parametersPopupMenu.show(invoker, evt.getX(), evt.getY());
        }
        if (evt != null && evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            editAdvanced(getSelectedParametersName());
        }
    }

    /**
     * Returns the name of the parameters selected in the parameters table.
     *
     * @return the name of the parameters selected in the parameters table
     */
    private String getSelectedParametersName() {
        int row = parametersTable.getSelectedRow();
        if (row < 0 || row >= parametersTable.getRowCount()) {
            return "";
        }
        return parametersTable.getValueAt(row, 1).toString();
    }

    /**
     * Lets the user add parameters from a protocol design.
     */
    private void addFromProtocol() {

    }

    /**
     * Lets the user add parameters from search engines.
     */
    private void addFromSearchSettings() {
        SearchParameters defaultParameters = new SearchParameters();
        SearchSettingsDialog searchSettingsDialog = new SearchSettingsDialog(parentFrame, defaultParameters, normalIcon, waitingIcon, true, true, configurationFile, lastSelectedFolder, editable);
        if (!searchSettingsDialog.isCanceled()) {
            SearchParameters searchParameters = searchSettingsDialog.getSearchParameters();
            IdentificationParameters identificationParameters = IdentificationParameters.getDefaultIdentificationParameters(searchParameters);
            IdentificationParametersNameDialog identificationParametersNameDialog = new IdentificationParametersNameDialog(parentFrame, identificationParameters, editable);
            if (!identificationParametersNameDialog.isCanceled()) {
                identificationParametersNameDialog.updateParameters(identificationParameters);
                try {
                    identificationParametersFactory.addIdentificationParameters(identificationParameters);
                    updateTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "An error occurred while saving the parameters. Please make sure that the tool can write in the user folder or change the Resource Settings.",
                            "Save Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Lets the user add parameters from a file.
     */
    private void addFromFile() {

    }

    /**
     * Lets the user add parameters from scratch.
     */
    private void addAdvanced() {
        IdentificationParameters identificationParameters = new IdentificationParameters();
        IdentificationParametersEditionDialog identificationParametersEditionDialog = new IdentificationParametersEditionDialog(parentFrame, identificationParameters, configurationFile, possibleNeutralLosses, reporterIons, normalIcon, waitingIcon, lastSelectedFolder, validationQCPreferencesDialogParent, editable);
        if (!identificationParametersEditionDialog.isCanceled()) {
            identificationParameters = identificationParametersEditionDialog.getIdentificationParameters();
            try {
                identificationParametersFactory.addIdentificationParameters(identificationParameters);
                updateTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "An error occurred while saving the parameters. Please make sure that the tool can write in the user folder or change the Resource Settings.",
                        "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Lets the user edit parameters from a protocol.
     *
     * @param parametersName the name of the parameters to edit.
     */
    private void editProtocol(String parametersName) {

    }

    /**
     * Lets the user edit parameters from search parameters.
     *
     * @param parametersName the name of the parameters to edit.
     */
    private void editSearchSettings(String parametersName) {

    }

    /**
     * Lets the user edit parameters.
     *
     * @param parametersName the name of the parameters to edit.
     */
    private void editAdvanced(String parametersName) {
        IdentificationParameters identificationParameters = identificationParametersFactory.getIdentificationParameters(parametersName);
        if (identificationParameters == null) {
            JOptionPane.showMessageDialog(this, "An error occurred while reading the parameters.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            IdentificationParametersEditionDialog identificationParametersEditionDialog = new IdentificationParametersEditionDialog(parentFrame, identificationParameters, configurationFile, possibleNeutralLosses, reporterIons, normalIcon, waitingIcon, lastSelectedFolder, validationQCPreferencesDialogParent, editable);
            if (!identificationParametersEditionDialog.isCanceled()) {
                identificationParameters = identificationParametersEditionDialog.getIdentificationParameters();
                try {
                    identificationParametersFactory.addIdentificationParameters(identificationParameters);
                    updateTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "An error occurred while saving the parameters. Please make sure that the tool can write in the user folder or change the Resource Settings.",
                            "Save Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Allows the user to edit the name and description.
     *
     * @param parametersName the name of the parameters to remove
     */
    private void rename(String parametersName) {
        IdentificationParameters identificationParameters = identificationParametersFactory.getIdentificationParameters(parametersName);
        if (identificationParameters == null) {
            JOptionPane.showMessageDialog(this, "An error occurred while reading the parameters.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            IdentificationParametersNameDialog identificationParametersNameDialog = new IdentificationParametersNameDialog(parentFrame, identificationParameters, editable);
            if (!identificationParametersNameDialog.isCanceled()) {
                identificationParametersNameDialog.updateParameters(identificationParameters);
                try {
                    identificationParametersFactory.addIdentificationParameters(identificationParameters);
                    updateTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "An error occurred while saving the parameters. Please make sure that the tool can write in the user folder or change the Resource Settings.",
                            "Save Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Removes the given parameters.
     *
     * @param parametersName the name of the parameters to remove
     */
    private void remove(String parametersName) {
        identificationParametersFactory.removeIdentificationParameters(parametersName);
        updateTable();
    }

    /**
     * Lets the user save the given parameters to a file.
     *
     * @param parametersName the name of the parameters to save
     */
    private void saveAs(String parametersName) {

    }

    /**
     * Table model for the neutral losses table.
     */
    private class ParametersTableModel extends DefaultTableModel {

        /**
         * List of parameters available.
         */
        private ArrayList<String> parametersNames;

        /**
         * constructor.
         */
        public ParametersTableModel() {
        }

        @Override
        public int getRowCount() {
            if (identificationParametersFactory == null) {
                return 0;
            }
            parametersNames = identificationParametersFactory.getParametersList();
            return parametersNames.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return " ";
                case 1:
                    return "Name";
                case 2:
                    return "Description";
                default:
                    return "";
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            switch (column) {
                case 0:
                    return row + 1;
                case 1:
                    String parameterName = parametersNames.get(row);
                    IdentificationParameters identificationParameters = identificationParametersFactory.getIdentificationParameters(parameterName);
                    return identificationParameters.getName();
                case 2:
                    parameterName = parametersNames.get(row);
                    identificationParameters = identificationParametersFactory.getIdentificationParameters(parameterName);
                    return identificationParameters.getDescription();
                default:
                    return "";
            }
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            for (int i = 0; i < getRowCount(); i++) {
                if (getValueAt(i, columnIndex) != null) {
                    return getValueAt(i, columnIndex).getClass();
                }
            }
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    }
}