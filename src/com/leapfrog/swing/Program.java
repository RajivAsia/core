/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.swing;

import com.leapfrog.swing.helper.FileHelper;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.FileChooserUI;

/**
 *
 * @author lenovo
 */
public class Program extends JFrame {

    private JTextArea txtNotepad;
    private JTextField txt;
    private JButton btn, btnopen;
    private JFileChooser fileChooser;
    private JScrollPane spNotepad;

    public Program() {
        setTitle("MyWindow");
        setSize(500, 700);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        initComponents();

        setVisible(true);

    }

    private void enabled(boolean Status) {
        txt.setEnabled(Status);
        btn.setEnabled(Status);

    }

    private void initComponents() {
        txt = new JTextField(10);
        txtNotepad = new JTextArea(20, 20);
        spNotepad = new JScrollPane(txtNotepad);
        txt.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                

            }

            @Override
            public void keyReleased(KeyEvent e) {
                enabled(!txtNotepad.getText().equals(""));
//               {   
//                   txt.setEnabled(false);
//                         btn.setEnabled(false );
//                    
//               }
//                     else {              
//              
//                   txt.setEnabled(true);
//                   btn.setEnabled(true);
//                   
//               }

            }

        });

        btn = new JButton("Save");
        btn.addActionListener(new SaveFileListener());
        btn.setEnabled(false);
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               // File file =new File(txt.getText());
//         try{
//                   FileHelper.write(txt.getText(), txtNotepad.getText());
//                   txtNotepad.setText("");
//                   txt.setText("");
//                  enabled(false);
//                    JOptionPane.showMessageDialog(null, "File Saved Succcessfully" );
//        }catch(IOException ioe ){
//                System.out.println(ioe.getMessage());
//        }
//            
//    }
//                
////                     FileWriter writer=new FileWriter(txt.getText());
////                     writer.write(txtNotepad.getText());
////                     writer.close();
//                //file.createNewFile();
//                }catch(IOException ioe){
//                    System.out.println(ioe.getMessage());
//                }
//                //System.out.println(txt.getText());
//            }
//        });
        btnopen = new JButton("Open File");
        btnopen.addActionListener(new OpenFileListener());
        Container container = getContentPane();
        container.add(btn);
        container.add(btnopen);
        container.add(txt);
        //container.add(txtNotepad);
        container.add(spNotepad);
        //enabled(false);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Program p = new Program();

    }

    private class OpenFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    txtNotepad.setText(FileHelper.read(fileChooser.getSelectedFile().getPath()));

                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }

        }
    }

    private class SaveFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                FileHelper.write(txt.getText(), txtNotepad.getText());
                txtNotepad.setText("");
                txt.setText("");

                JOptionPane.showMessageDialog(null, "File Saved Succcessfully");
                enabled(false);
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }

        }
    }
}
