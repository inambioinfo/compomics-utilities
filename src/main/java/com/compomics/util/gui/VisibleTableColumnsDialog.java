package com.compomics.util.gui;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.event.MouseEvent;
import no.uib.jsparklines.extra.NimbusCheckBoxRenderer;

/**
 * A dialog that lets the user decide which columns to show/hide in a JTable.
 *
 * @author Harald Barsnes
 */
public class VisibleTableColumnsDialog extends javax.swing.JDialog {

    /**
     * Empty default constructor
     */
    public VisibleTableColumnsDialog() {
    }

    /**
     * The VisibleTableColumnsDialogParent.
     */
    private VisibleTableColumnsDialogParent visibleTableColumnsDialogParent;

    /**
     * Creates a new VisibleTableColumnsDialog.
     *
     * @param dialog the parent dialog
     * @param visibleTableColumnsDialogParent the
     * VisibleTableColumnsDialogParent parent
     * @param modal if the dialog is to be modal or not
     */
    public VisibleTableColumnsDialog(JDialog dialog, VisibleTableColumnsDialogParent visibleTableColumnsDialogParent, boolean modal) {
        super(dialog, modal);
        initComponents();
        this.visibleTableColumnsDialogParent = visibleTableColumnsDialogParent;
        setUpGui();
        setLocationRelativeTo(dialog);
        setVisible(true);
    }

    /**
     * Creates a new VisibleTableColumnsDialog.
     *
     * @param frame the parent frame
     * @param visibleTableColumnsDialogParent the
     * VisibleTableColumnsDialogParent parent
     * @param modal if the dialog is to be modal or not
     */
    public VisibleTableColumnsDialog(JFrame frame, VisibleTableColumnsDialogParent visibleTableColumnsDialogParent, boolean modal) {
        super(frame, modal);
        initComponents();
        this.visibleTableColumnsDialogParent = visibleTableColumnsDialogParent;
        setUpGui();
        setLocationRelativeTo(frame);
        setVisible(true);
    }

    /**
     * Set up the GUI.
     */
    private void setUpGui() {
        TableModel tableModel = visibleTableColumnsDialogParent.getTable().getModel();

        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            ((DefaultTableModel) selectedColumnsTable.getModel()).addRow(new Object[]{
                (i + 1),
                tableModel.getColumnName(i),
                visibleTableColumnsDialogParent.getVisibleColumns().get(i)
            });
        }

        selectedValuesTableScrollPane.getViewport().setOpaque(false);
        selectedColumnsTable.getTableHeader().setReorderingAllowed(false);

        selectedColumnsTable.getColumn(" ").setMaxWidth(50);
        selectedColumnsTable.getColumn(" ").setMinWidth(50);
        selectedColumnsTable.getColumn("  ").setMaxWidth(30);
        selectedColumnsTable.getColumn("  ").setMinWidth(30);
        selectedColumnsTable.getColumn("  ").setCellRenderer(new NimbusCheckBoxRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectJPopupMenu = new javax.swing.JPopupMenu();
        selectAllMenuItem = new javax.swing.JMenuItem();
        deselectAllMenuItem = new javax.swing.JMenuItem();
        backgroundPanel = new javax.swing.JPanel();
        selectedValuesTableScrollPane = new javax.swing.JScrollPane();
        selectedColumnsTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();

        selectAllMenuItem.setText("Select All");
        selectAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllMenuItemActionPerformed(evt);
            }
        });
        selectJPopupMenu.add(selectAllMenuItem);

        deselectAllMenuItem.setText("Deselect All");
        deselectAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselectAllMenuItemActionPerformed(evt);
            }
        });
        selectJPopupMenu.add(deselectAllMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visible Columns");
        setMinimumSize(new java.awt.Dimension(297, 386));

        backgroundPanel.setBackground(new java.awt.Color(230, 230, 230));

        selectedColumnsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ", "Name", "  "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        selectedColumnsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedColumnsTableMouseClicked(evt);
            }
        });
        selectedValuesTableScrollPane.setViewportView(selectedColumnsTable);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectedValuesTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(0, 230, Short.MAX_VALUE)
                        .addComponent(okButton)))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedValuesTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton)
                .addGap(4, 4, 4))
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

    /**
     * Update the list of visible columns.
     *
     * @param evt
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        HashMap<Integer, Boolean> showColumns = new HashMap<>();

        for (int i = 0; i < selectedColumnsTable.getRowCount(); i++) {
            if ((Boolean) selectedColumnsTable.getValueAt(i, selectedColumnsTable.getColumn("  ").getModelIndex())) {
                showColumns.put(i, true);
            } else {
                showColumns.put(i, false);
            }
        }

        ArrayList<TableColumn> allTableColumns = visibleTableColumnsDialogParent.getAllTableColumns();

        // remove all columns
        for (TableColumn allTableColumn : allTableColumns) {
            visibleTableColumnsDialogParent.getTable().removeColumn(allTableColumn);
        }

        // add the ones that are selected
        for (int i = 0; i < allTableColumns.size(); i++) {
            if (showColumns.get(i)) {
                visibleTableColumnsDialogParent.getTable().addColumn(allTableColumns.get(i));
            }
        }

        visibleTableColumnsDialogParent.setVisibleColumns(showColumns);
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Open the select popup menu.
     *
     * @param evt
     */
    private void selectedColumnsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedColumnsTableMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            selectJPopupMenu.show(selectedColumnsTable, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_selectedColumnsTableMouseClicked

    /**
     * Show all columns.
     *
     * @param evt
     */
    private void selectAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllMenuItemActionPerformed
        for (int i = 0; i < selectedColumnsTable.getRowCount(); i++) {
            ((DefaultTableModel) selectedColumnsTable.getModel()).setValueAt(true, i, selectedColumnsTable.getColumn("  ").getModelIndex());
        }
    }//GEN-LAST:event_selectAllMenuItemActionPerformed

    /**
     * Hide all columns.
     *
     * @param evt
     */
    private void deselectAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselectAllMenuItemActionPerformed
        for (int i = 0; i < selectedColumnsTable.getRowCount(); i++) {
            ((DefaultTableModel) selectedColumnsTable.getModel()).setValueAt(false, i, selectedColumnsTable.getColumn("  ").getModelIndex());
        }
    }//GEN-LAST:event_deselectAllMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JMenuItem deselectAllMenuItem;
    private javax.swing.JButton okButton;
    private javax.swing.JMenuItem selectAllMenuItem;
    private javax.swing.JPopupMenu selectJPopupMenu;
    private javax.swing.JTable selectedColumnsTable;
    private javax.swing.JScrollPane selectedValuesTableScrollPane;
    // End of variables declaration//GEN-END:variables
}
