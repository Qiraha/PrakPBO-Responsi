/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

/**
 *
 * @author hp
 */
public class inputData extends JFrame implements ActionListener{
    public String no_id, nama, usia;
    public int gaji;
    
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Input Data");
   
    JLabel lNo = new JLabel("ID  ");
        JTextField tfNo = new JTextField();
    JLabel lNama = new JLabel("NAMA  ");
        JTextField tfNama = new JTextField();
    JLabel lUsia= new JLabel("USIA ");
        JTextField tfUsia = new JTextField();
    JLabel lGaji = new JLabel("GAJI ");
        JTextField tfGaji = new JTextField();

    JButton btnEdit = new JButton("Tambah");
    JButton btnLihat = new JButton("Lihat");
    JButton BtnBack = new JButton("Kembali");
    JButton btnReset = new JButton("Reset");
    
    public inputData(){
        window.setLayout(null);
        window.setSize(550,220);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lNama);
        window.add(tfNo);
        window.add(tfNama);
        window.add(tfUsia);
        window.add(tfGaji);
        window.add(lNo);
        window.add(lGaji);
        window.add(lUsia);
        window.add(btnEdit);
        window.add(btnLihat);
        window.add(BtnBack);
        window.add(btnReset);



//LABEL
        lNo.setBounds(5, 35, 120, 20);
        lNama.setBounds(5, 60, 120, 20);
        lUsia.setBounds(5,85,120,20);
        lGaji.setBounds(5,105,120,20);

//TEXTFIELD
        tfNo.setBounds(110, 35, 120, 20);
        tfNama.setBounds(110, 60, 120, 20);
        tfUsia.setBounds(110, 85, 120, 20);
        tfGaji.setBounds(110, 105, 120, 20);


//BUTTON PANEL
        btnEdit.setBounds(250, 35, 90, 20);
        btnLihat.setBounds(250,60,90,20);
        BtnBack.setBounds(1,150,549,40);
        btnReset.setBounds(250,85,90,20);
       
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "INSERT INTO `karyawan`(`id`, `nama`,`usia`,`gaji`) VALUES ('"+getNo()+"','"+getNama()+"','"+getUsia()+"','"+getGaji()+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                window.dispose();
                showData lihat = new showData();
            }
        });
        
        BtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                window.dispose();
                Home home = new Home();
            }
        });
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String res="";
                tfNo.setText(res);
                tfNama.setText(res);
                tfUsia.setText(res);
                tfGaji.setText(res);
            }
        });

    }
    
   public String getNama(){
        return tfNama.getText();
    }

    public String getNo() {
        return tfNo.getText();
    }

    public String getUsia() {
        return tfUsia.getText();
    }

    public String getGaji() {
        return tfGaji.getText();
    }
    
    public void inputDB(){
        
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
