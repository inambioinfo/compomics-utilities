package com.compomics.util.gui;

import com.compomics.util.Util;
import com.compomics.util.experiment.biology.aminoacids.AminoAcid;
import com.compomics.util.experiment.biology.aminoacids.sequence.AminoAcidPattern;
import com.compomics.util.parameters.identification.advanced.SequenceMatchingParameters;
import com.google.common.collect.Sets;
import java.awt.Color;
import no.uib.jsparklines.extra.NimbusCheckBoxRenderer;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * This dialog allows the design and test of amino acid patterns. (see class
 * com.compomics.util.experiment.biology.AminoAcidPattern)
 *
 * @author Marc Vaudel
 * @author Harald Barsnes
 */
public class AminoAcidPatternDialog extends javax.swing.JDialog {

    /**
     * Empty default constructor
     */
    public AminoAcidPatternDialog() {
        editable = false;
    }

    /**
     * The pattern displayed.
     */
    private AminoAcidPattern pattern;
    /**
     * A boolean indicating whether the pattern can be edited.
     */
    private final boolean editable;
    /**
     * A boolean indicating whether the used clicked the cancel button.
     */
    private boolean cancel = false;
    /**
     * The pattern design table column header tooltips.
     */
    private ArrayList<String> patternDesignTableToolTips;
    /**
     * The example sequence.
     */
    private final String exampleSequence = "MKFILLWALLNLTVALAFNPDYTVSSTPPYLVYLKSDYLPCAGVLIHPLWVITAAHCNLPKLRVILGVTIPADSNEKHLQVIGYE"
            + "KMIHHPHFSVTSIDHDIMLIKLKTEAELNDYVKLANLPYQTISENTMCSVSTWSYNVCDIYKEPDSLQTVNISVISKPQCRDAYKTYNITENMLCVGIVPGRRQPC"
            + "KEVSAAPAICNGMLQGILSFADGCVLRADVGIYAKIFYYIPWIENVIQNN"; // @TODO: perhaps this should be saved somewhere and reused if the user changes the sequence?

    /**
     * Creates a new AminoAcidPatternDialog.
     *
     * @param parent the parent frame
     * @param pattern the amino acid pattern object
     * @param editable if the pattern is editable or not
     */
    public AminoAcidPatternDialog(java.awt.Frame parent, AminoAcidPattern pattern, boolean editable) {
        super(parent, true);
        if (pattern == null) {
             this.pattern = new AminoAcidPattern();
        } else {
            this.pattern = new AminoAcidPattern(pattern);
        }
        this.editable = editable;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/compomics-utilities.png")));
        setUpGui();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    /**
     * Set up the GUI.
     */
    private void setUpGui() {

        patternDesignScrollPane.getViewport().setOpaque(false);
        patternDesignTable.getTableHeader().setReorderingAllowed(false);

        // correct the color for the upper right corner
        JPanel proteinCorner = new JPanel();
        proteinCorner.setBackground(patternDesignTable.getTableHeader().getBackground());
        patternDesignScrollPane.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, proteinCorner);

        if (!editable) {
            cancelButton.setEnabled(false);
        }

        patternDesignTableToolTips = new ArrayList<>();
        patternDesignTableToolTips.add(null);
        patternDesignTableToolTips.add("Reference Index");
        patternDesignTableToolTips.add("The targeted amino acids");
        patternDesignTableToolTips.add("The excluded amino acids");

        // the index column
        patternDesignTable.getColumn(" ").setMaxWidth(50);
        patternDesignTable.getColumn(" ").setMinWidth(50);
        patternDesignTable.getColumn("Ref").setMaxWidth(30);
        patternDesignTable.getColumn("Ref").setMinWidth(30);

        patternDesignTable.getColumn("Ref").setCellRenderer(new NimbusCheckBoxRenderer());

        patternTestEditorPane.setText(exampleSequence);
        displayPattern();
        repaintTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupJMenu = new javax.swing.JPopupMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        moveUpJMenuItem = new javax.swing.JMenuItem();
        moveDownJMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        deleteSelectedRowJMenuItem = new javax.swing.JMenuItem();
        backgroundPanel = new javax.swing.JPanel();
        patternDesignPanel = new javax.swing.JPanel();
        patternDesignScrollPane = new javax.swing.JScrollPane();
        patternDesignTable = new JTable() {
            protected JTableHeader createDefaultTableHeader() {
                return new JTableHeader(columnModel) {
                    public String getToolTipText(MouseEvent e) {
                        java.awt.Point p = e.getPoint();
                        int index = columnModel.getColumnIndexAtX(p.x);
                        int realIndex = columnModel.getColumn(index).getModelIndex();
                        return (String) patternDesignTableToolTips.get(realIndex);
                    }
                };
            }
        };
        rightClickHelpLabel = new javax.swing.JLabel();
        testPanel = new javax.swing.JPanel();
        patternTestJScrollPane = new javax.swing.JScrollPane();
        patternTestEditorPane = new javax.swing.JEditorPane();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        exampleLabel = new javax.swing.JLabel();

        addJMenuItem.setMnemonic('A');
        addJMenuItem.setText("Add");
        addJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJMenuItemActionPerformed(evt);
            }
        });
        popupJMenu.add(addJMenuItem);
        popupJMenu.add(jSeparator3);

        moveUpJMenuItem.setMnemonic('U');
        moveUpJMenuItem.setText("Move Up");
        moveUpJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpJMenuItemActionPerformed(evt);
            }
        });
        popupJMenu.add(moveUpJMenuItem);

        moveDownJMenuItem.setMnemonic('D');
        moveDownJMenuItem.setText("Move Down");
        moveDownJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownJMenuItemActionPerformed(evt);
            }
        });
        popupJMenu.add(moveDownJMenuItem);
        popupJMenu.add(jSeparator4);

        deleteSelectedRowJMenuItem.setText("Delete");
        deleteSelectedRowJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedRowJMenuItemActionPerformed(evt);
            }
        });
        popupJMenu.add(deleteSelectedRowJMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modification Pattern");

        backgroundPanel.setBackground(new java.awt.Color(230, 230, 230));

        patternDesignPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pattern Design"));
        patternDesignPanel.setOpaque(false);

        patternDesignScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patternDesignScrollPaneMouseClicked(evt);
            }
        });

        patternDesignTable.setModel(new PatternTable());
        patternDesignTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patternDesignTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                patternDesignTableMouseReleased(evt);
            }
        });
        patternDesignTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                patternDesignTableKeyReleased(evt);
            }
        });
        patternDesignScrollPane.setViewportView(patternDesignTable);

        rightClickHelpLabel.setFont(rightClickHelpLabel.getFont().deriveFont((rightClickHelpLabel.getFont().getStyle() | java.awt.Font.ITALIC)));
        rightClickHelpLabel.setText("Right click in the table for options.");

        javax.swing.GroupLayout patternDesignPanelLayout = new javax.swing.GroupLayout(patternDesignPanel);
        patternDesignPanel.setLayout(patternDesignPanelLayout);
        patternDesignPanelLayout.setHorizontalGroup(
            patternDesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patternDesignPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patternDesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patternDesignScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addGroup(patternDesignPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rightClickHelpLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        patternDesignPanelLayout.setVerticalGroup(
            patternDesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patternDesignPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patternDesignScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightClickHelpLabel))
        );

        testPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pattern Test"));
        testPanel.setOpaque(false);

        patternTestEditorPane.setContentType("text/html");
        patternTestEditorPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                patternTestEditorPaneKeyReleased(evt);
            }
        });
        patternTestJScrollPane.setViewportView(patternTestEditorPane);

        javax.swing.GroupLayout testPanelLayout = new javax.swing.GroupLayout(testPanel);
        testPanel.setLayout(testPanelLayout);
        testPanelLayout.setHorizontalGroup(
            testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patternTestJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        testPanelLayout.setVerticalGroup(
            testPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patternTestJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.setPreferredSize(new java.awt.Dimension(65, 23));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        exampleLabel.setText("<html><i>\n<a href>Show Example</a></i>\n</html>");
        exampleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exampleLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exampleLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exampleLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patternDesignPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(exampleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patternDesignPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exampleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        backgroundPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelButton, okButton});

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
     * Validate the input and close the dialog.
     *
     * @param evt
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        boolean valid = validateInput();

        if (valid) {
            dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Close the dialog without saving.
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancel = true;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Change the cursor into a hand cursor.
     *
     * @param evt
     */
    private void exampleLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exampleLabelMouseEntered
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_exampleLabelMouseEntered

    /**
     * Change the cursor back to the default cursor.
     *
     * @param evt
     */
    private void exampleLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exampleLabelMouseExited
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_exampleLabelMouseExited

    /**
     * Open an example pattern.
     *
     * @param evt
     */
    private void exampleLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exampleLabelMouseClicked
        pattern = AminoAcidPattern.getTrypsinExample();
        patternTestEditorPane.setText(exampleSequence);
        displayPattern();
        repaintTable();
    }//GEN-LAST:event_exampleLabelMouseClicked

    /**
     * Move the selected row one row up.
     *
     * @param evt
     */
    private void moveUpJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpJMenuItemActionPerformed
        int selectedRow = patternDesignTable.getSelectedRow();
        int selectedColumn = patternDesignTable.getSelectedColumn();
        pattern.swapRows(selectedRow, selectedRow - 1);
        patternDesignTable.changeSelection(selectedRow - 1, selectedColumn, false, false);
    }//GEN-LAST:event_moveUpJMenuItemActionPerformed

    /**
     * Move the selected row one row down.
     *
     * @param evt
     */
    private void moveDownJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownJMenuItemActionPerformed
        int selectedRow = patternDesignTable.getSelectedRow();
        int selectedColumn = patternDesignTable.getSelectedColumn();
        pattern.swapRows(selectedRow, selectedRow + 1);
        patternDesignTable.changeSelection(selectedRow + 1, selectedColumn, false, false);
    }//GEN-LAST:event_moveDownJMenuItemActionPerformed

    /**
     * Deletes the selected row.
     *
     * @param evt
     */
    private void deleteSelectedRowJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedRowJMenuItemActionPerformed
        int selectedRow = patternDesignTable.getSelectedRow();

        if (selectedRow != -1) {
            pattern.removeAA(selectedRow);
            repaintTable();
            displayPattern();
            validateInput();
        }
    }//GEN-LAST:event_deleteSelectedRowJMenuItemActionPerformed

    /**
     * Adds a new row to the list.
     *
     * @param evt
     */
    private void addJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJMenuItemActionPerformed
        pattern.setTargeted(patternDesignTable.getRowCount(), new ArrayList<>(1));
        repaintTable();
    }//GEN-LAST:event_addJMenuItemActionPerformed

    /**
     * Test the pattern.
     *
     * @param evt
     */
    private void patternDesignTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patternDesignTableKeyReleased
        displayPattern();
    }//GEN-LAST:event_patternDesignTableKeyReleased

    /**
     * Test the pattern.
     *
     * @param evt
     */
    private void patternDesignTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patternDesignTableMouseReleased
        displayPattern();
    }//GEN-LAST:event_patternDesignTableMouseReleased

    /**
     * Show the pop up menu.
     *
     * @param evt
     */
    private void patternDesignTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patternDesignTableMouseClicked
        if (evt.getButton() == 3) {

            int selectedRow = patternDesignTable.rowAtPoint(evt.getPoint());
            int column = patternDesignTable.columnAtPoint(evt.getPoint());

            patternDesignTable.changeSelection(selectedRow, column, false, false);

            moveUpJMenuItem.setEnabled(false);
            moveDownJMenuItem.setEnabled(false);
            deleteSelectedRowJMenuItem.setEnabled(true);

            if (selectedRow > 0) {
                moveUpJMenuItem.setEnabled(true);
            }

            if (selectedRow < patternDesignTable.getRowCount() - 1) {
                moveDownJMenuItem.setEnabled(true);
            }

            popupJMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_patternDesignTableMouseClicked

    /**
     * Show the pop up menu.
     *
     * @param evt
     */
    private void patternDesignScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patternDesignScrollPaneMouseClicked
        if (evt.getButton() == 3) {
            if (patternDesignTable.getSelectedRow() == -1) {
                moveUpJMenuItem.setEnabled(false);
                moveDownJMenuItem.setEnabled(false);
                deleteSelectedRowJMenuItem.setEnabled(false);
            }

            popupJMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_patternDesignScrollPaneMouseClicked

    /**
     * Test the pattern.
     *
     * @param evt
     */
    private void patternTestEditorPaneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patternTestEditorPaneKeyReleased
        displayPattern();
    }//GEN-LAST:event_patternTestEditorPaneKeyReleased

    /**
     * Returns the pattern as edited by the user.
     *
     * @return the pattern as edited by the user
     */
    public AminoAcidPattern getPattern() {
        return pattern;
    }

    /**
     * indicates whether the changes have been canceled
     *
     * @return a boolean indicating whether the changes have been canceled
     */
    public boolean isCanceled() {
        return cancel;
    }

    /**
     * Returns the given list of amino acids as a comma separated String.
     *
     * @param targetedAminoAcids the given list of targeted amino acids
     *
     * @return the given list of amino acids as a comma separated String
     */
    private String getTargetedAAasString(ArrayList<Character> targetedAminoAcids) {
        String result = "";
        if (targetedAminoAcids != null) {
            if (targetedAminoAcids.isEmpty()) {
                for (char aa : AminoAcid.getUniqueAminoAcids()) {
                    if (!result.equals("")) {
                        result += ",";
                    }
                    result += aa;
                }
            }
            for (Character aa : targetedAminoAcids) {
                if (!result.contains(aa + "")) {
                    if (!result.equals("")) {
                        result += ",";
                    }
                    result += aa;
                }
            }
        }
        return result;
    }

    /**
     * Returns the given list of amino acids as a comma separated String.
     *
     * @param targetedAminoAcids the given list of targeted amino acids
     *
     * @return the given list of amino acids as a comma separated String
     */
    private String getExcludedAAasString(ArrayList<Character> targetedAminoAcids) {
        String result = "";
        if (targetedAminoAcids == null || !targetedAminoAcids.isEmpty()) {
            for (char aa : AminoAcid.getUniqueAminoAcids()) {
                if (targetedAminoAcids == null || !targetedAminoAcids.contains(aa)) {
                    if (!result.equals("")) {
                        result += ",";
                    }
                    result += aa;
                }
            }
        }
        return result;
    }

    /**
     * Returns a list of amino acids from a comma separated String.
     *
     * @param aminoAcids the comma separated String
     * @return the corresponding list of amino acids
     */
    private ArrayList<Character> getAAfromString(String aminoAcids) {
        ArrayList<Character> result = new ArrayList<>();
        for (String aa : aminoAcids.split(",")) {
            String input = aa.trim();
            input = input.toUpperCase();
            if (!input.equals("")) {
                for (int i = 0; i < input.length(); i++) {
                    char aaChar = input.charAt(i);
                    AminoAcid aminoAcid = AminoAcid.getAminoAcid(aaChar);
                    if (aminoAcid == null) {
                        throw new IllegalArgumentException("Cannot parse " + aaChar + " into an amino acid");
                    } else {
                        result.add(aaChar);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Tests the pattern on the test text and puts highlights the text every
     * time the pattern is found.
     */
    private void displayPattern() {

        String tempSequence = patternTestEditorPane.getText();
        int caretPosition = patternTestEditorPane.getCaretPosition();

        // remove html tags
        if (tempSequence.contains("<html>")) {
            tempSequence = tempSequence.replaceAll("\\<[^>]*>", "");
        }

        HashSet<Integer> indexes = Arrays.stream(pattern.getIndexes(tempSequence, SequenceMatchingParameters.defaultStringMatching))
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        String result = "";

        for (int i = 0; i < tempSequence.length(); i++) {
            if (indexes.contains(i + 1)) {
                result += "<span style=\"color:#" + Util.color2Hex(Color.WHITE) + ";background:#" + Util.color2Hex(Color.BLUE) + "\">";
            } else {
                result += "<span style=\"color:#" + Util.color2Hex(Color.BLACK) + ";background:#" + Util.color2Hex(Color.WHITE) + "\">";
            }
            result += tempSequence.charAt(i);
            result += "</span>";
        }

        patternTestEditorPane.setText(result);
        patternTestEditorPane.setCaretPosition(caretPosition);
    }

    /**
     * Table model for the pattern table.
     */
    private class PatternTable extends DefaultTableModel {

        @Override
        public int getRowCount() {
            return pattern.length();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return " ";
                case 1:
                    return "Ref";
                case 2:
                    return "Targeted AA";
                case 3:
                    return "Excluded AA";
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
                    return row == pattern.getTarget();
                case 2:
                    return getTargetedAAasString(pattern.getTargetedAA(row));
                case 3:
                    return getExcludedAAasString(pattern.getTargetedAA(row));
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int row, int column) {
            try {
                if (column == 1) {
                    pattern.setTarget(row);
                } else if (column == 2) {
                    ArrayList<Character> aa = getAAfromString(aValue.toString());
                    if (aa.isEmpty()) {
                        pattern.removeAA(row);
                    } else {
                        pattern.setTargeted(row, aa);
                    }
                } else if (column == 3) {
                    ArrayList<Character> aa = getAAfromString(aValue.toString());
                    if (aa.isEmpty()) {
                        pattern.setTargeted(row, aa);
                    } else {
                        pattern.setExcluded(row, aa);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            repaintTable();
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            for (int i = 0; i < getRowCount(); i++) {
                if (getValueAt(i, columnIndex) != null) {
                    return getValueAt(i, columnIndex).getClass();
                }
            }
            return (new Double(0.0)).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return editable && column != 0;
        }
    }

    /**
     * Repaints the table.
     */
    private void repaintTable() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                patternDesignTable.revalidate();
                patternDesignTable.repaint();
            }
        });
    }

    /**
     * Validates the input.
     *
     * @return true if the input is valid.
     */
    private boolean validateInput() {

        // check for empty target
        if (pattern.getAminoAcidsAtTarget().size() < 1) {
            JOptionPane.showMessageDialog(this, "There has to be at least one amino acid for the targeted residue!", "Empty Target", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addJMenuItem;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JMenuItem deleteSelectedRowJMenuItem;
    private javax.swing.JLabel exampleLabel;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem moveDownJMenuItem;
    private javax.swing.JMenuItem moveUpJMenuItem;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel patternDesignPanel;
    private javax.swing.JScrollPane patternDesignScrollPane;
    private javax.swing.JTable patternDesignTable;
    private javax.swing.JEditorPane patternTestEditorPane;
    private javax.swing.JScrollPane patternTestJScrollPane;
    private javax.swing.JPopupMenu popupJMenu;
    private javax.swing.JLabel rightClickHelpLabel;
    private javax.swing.JPanel testPanel;
    // End of variables declaration//GEN-END:variables
}
