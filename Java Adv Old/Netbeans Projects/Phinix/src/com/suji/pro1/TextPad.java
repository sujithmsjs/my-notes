package com.suji.pro1;

/**
 * ***
 * IF You are new to Swings, Its Very Hard to understand This Example Only
 * showing for Undo Manager
 */
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class TextPad extends javax.swing.JFrame {

    JFileChooser fileChooser;
    File currentFile;
    private Document editorPaneDoc;
    protected UndoHandler undoHandler = new UndoHandler();
    protected UndoManager undoManager = new UndoManager();
    private RedoAction redoAction = null;
    private UndoAction undoAction = null;

    public TextPad() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        open = new javax.swing.JButton();
        save = new javax.swing.JButton();
        replace = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileChooser = new JFileChooser();
        currentFile = new File("MyText.txt");
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(540, 320));

        toolBar.setRollover(true);

        open.setMnemonic('O');
        open.setText("Open");
        open.setFocusable(false);
        open.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        open.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        toolBar.add(open);

        save.setMnemonic('S');
        save.setText("Save");
        save.setFocusable(false);
        save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        toolBar.add(save);

        replace.setMnemonic('R');
        replace.setText("Replace");
        replace.setFocusable(false);
        replace.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        replace.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        replace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceActionPerformed(evt);
            }
        });
        toolBar.add(replace);

        jButton1.setText("Display");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        toolBar.add(jButton1);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        textArea.setBackground(new java.awt.Color(51, 51, 51));
        // textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        textArea.setForeground(new java.awt.Color(255, 255, 255));
        textArea.setLineWrap(true);
        // textArea.setRows(5);
        editorPaneDoc = textArea.getDocument();
        editorPaneDoc.addUndoableEditListener(undoHandler);

        KeyStroke undoKeyStroke = KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, InputEvent.CTRL_MASK
        );

        KeyStroke redoKeyStroke = KeyStroke.getKeyStroke(
                KeyEvent.VK_Y, InputEvent.CTRL_MASK
        );

        undoAction = new UndoAction();
        textArea.getInputMap().put(undoKeyStroke, "UndoKeyStroke");
        textArea.getActionMap().put("UndoKeyStroke", undoAction);

        redoAction = new RedoAction();
        textArea.getInputMap().put(redoKeyStroke, "RedoKeyStroke");
        textArea.getActionMap().put("RedoKeyStroke", redoAction);
        textArea.setTabSize(6);
        textArea.setText("Demo Entered Text");
        textArea.setWrapStyleWord(true);
        //   textArea.setMinimumSize(new java.awt.Dimension(500, 350));
        //  textArea.setPreferredSize(new java.awt.Dimension(540, 320));
        jScrollPane1.setViewportView(textArea);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "java");
        fileChooser.setFileFilter(filter);
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setCurrentDirectory(currentFile.getParentFile());
        fileChooser.setSelectedFile(currentFile);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void replaceActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {

        int i = fileChooser.showSaveDialog(this);
        
        File f = null;
        if (i == JFileChooser.APPROVE_OPTION) {
            try {
                f = new File(fileChooser.getSelectedFile().getPath());
                if (f.exists()) {
                    if (JOptionPane.showConfirmDialog(this,
                            f.getName() + " file already exists!",
                            "Conform replace",
                            JOptionPane.YES_NO_OPTION) == 0) {
                        writeFile(f);
                    } else {
                        JOptionPane.showMessageDialog(this, "Your file Not Saved");
                    }
                } else {
                    writeFile(f);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void openActionPerformed(java.awt.event.ActionEvent evt) {
        int i = fileChooser.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            textArea.setText("");
            try {

                fileChooser.setCurrentDirectory(currentFile);
                Scanner scan = new Scanner(
                        new FileReader(fileChooser.getSelectedFile().getPath()));
                while (scan.hasNext()) {
                    textArea.append(scan.nextLine() + "\n");
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getStackTrace());
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void writeFile(File f) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(f, false));
        out.write(textArea.getText());
        out.close();
        if (f.exists()) {
            JOptionPane.showMessageDialog(this, "Your file Saved Sucessfully");
        } else {
            JOptionPane.showMessageDialog(this, "Your file Not Created", "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(TextPad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextPad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextPad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextPad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextPad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton open;
    private javax.swing.JButton replace;
    private javax.swing.JButton save;
    private javax.swing.JTextArea textArea;
    private javax.swing.JToolBar toolBar;

    // End of variables declaration                   
    class UndoHandler implements UndoableEditListener {

        public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
            undoAction.update();
            redoAction.update();
        }
    }

    class UndoAction extends AbstractAction {

        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                undoManager.undo();
            } catch (CannotUndoException ee) {
                ee.printStackTrace();
            }
            update();
            redoAction.update();
        }

        protected void update() {
            if (undoManager.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, undoManager.getUndoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Undo");
            }

        }
    }

    class RedoAction extends AbstractAction {

        public RedoAction() {
            super("Redo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                undoManager.redo();
            } catch (CannotRedoException ee) {
                ee.printStackTrace();
            }
            update();
            undoAction.update();
        }

        protected void update() {
            if (undoManager.canRedo()) {
                setEnabled(true);
                putValue(Action.NAME, undoManager.getRedoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }
    }
}