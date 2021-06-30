/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author hp
 */
public class Home extends JFrame implements ActionListener{
     JFrame window = new JFrame("JDBC");
     
    JLabel lnama = new JLabel("Nama Lengkap");
    final JTextField fnama = new JTextField(10);
    
     JButton show = new JButton("Tampilkan Data");
     JButton tambah = new JButton("Tambah Data");
     
     
     public Home(){
        window.setLayout(null);
        window.setSize(300,250);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
      
        show.addActionListener(this);
        tambah.addActionListener(this);
         window.add(show);
         window.add(tambah);
         
         show.setBounds(1,1,300,100);
         tambah.setBounds(1,100,300,100);
         
         
         window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==show){
            window.dispose();
            window.setVisible(false);
            new showData().setVisible(true);
        }
        if(e.getSource()==tambah){
            window.dispose();
            new inputData().setVisible(true);
        }
    }

}
