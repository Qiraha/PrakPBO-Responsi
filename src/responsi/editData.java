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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class editData{
    public String no_id, nama, usia;
    public int gaji;
    int jmlData;
    String data[][] = new String[500][4];
   
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Edit Data");
   
    JLabel lNo = new JLabel("ID  ");
        JTextField tfNo = new JTextField();
    JLabel lNama = new JLabel("NAMA  ");
        JTextField tfNama = new JTextField();
    JLabel lUsia= new JLabel("USIA ");
        JTextField tfUsia = new JTextField();
    JLabel lGaji = new JLabel("GAJI ");
        JTextField tfGaji = new JTextField();
    JLabel lJam = new JLabel("Jam Kerja ");
        JTextField tfJam = new JTextField();
    JButton btnEdit = new JButton("Edit");
    JButton btnLihat = new JButton("Hitung Total Gaji");
    JButton BtnBack = new JButton("Kembali");
    JButton btnReset = new JButton("Reset");
    
    public editData(String num){
         int x = Integer.parseInt(num);
        
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
        window.add(tfJam);
        window.add(lNo);
        window.add(lGaji);
        window.add(lUsia);
        window.add(lJam);
        window.add(btnEdit);
        window.add(btnLihat);
        window.add(BtnBack);
        window.add(btnReset);



//LABEL
        lNo.setBounds(5, 35, 120, 20);
        lNama.setBounds(5, 60, 120, 20);
        lUsia.setBounds(5,85,120,20);
        lGaji.setBounds(5,105,120,20);
        lJam.setBounds(380, 35, 120, 20);

//TEXTFIELD
        tfNo.setBounds(110, 35, 120, 20);
        tfNama.setBounds(110, 60, 120, 20);
        tfUsia.setBounds(110, 85, 120, 20);
        tfGaji.setBounds(110, 105, 120, 20);
        tfJam.setBounds(380, 60, 120, 20);


//BUTTON PANEL
        btnEdit.setBounds(250, 35, 90, 20);
        btnLihat.setBounds(380,85,150,40);
        BtnBack.setBounds(1,150,549,40);
        btnReset.setBounds(250,85,90,20);
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String query = "UPDATE `karyawan` SET `id` = "+getNo()+", `nama` = '"+getNama()+"', `usia` = '"+getUsia()+"', `gaji` = '"+getGaji()+"' WHERE `karyawan`.`id` = "+x+"";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            System.out.println("Edit Berhasil");
            JOptionPane.showMessageDialog(null,"Edit Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        btnLihat.addActionListener(new ActionListener() {
          
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    int tgaji;
                    int tjam;
                    tgaji = Integer.valueOf(getGaji());
                    tjam = Integer.valueOf(getJam());
                    int total = tgaji*tjam;
                
                
                    JOptionPane.showMessageDialog(null,"Data\n"
                        + "ID                         : "+getNo()+"\n"
                        + "Nama                  : "+getNama()+"\n"
                        + "Usia                     : "+getUsia()+"\n"
                        + "Gaji                      : "+getGaji()+"\n"
                        + "Jam Kerja          : "+getJam()+"\n"
                       + "Total Gaji            : "+total+"\n"
                    );
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Masukkan Angka!!!");
                }
                
            }
        });
        BtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                window.dispose();
                showData show = new showData();
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
       
        String query = "SELECT * from karyawan WHERE id = "+x+"";
            
        try {
            int jmlData = 0;
             connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("usia");
                data[jmlData][3] = resultSet.getString("gaji");
                jmlData++; 
            }
            connector.statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
        }
        tfNo.setText(data[0][0]);
        tfNama.setText(data[0][1]);
        tfUsia.setText(data[0][2]);
        tfGaji.setText(data[0][3]);
                

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
    
    public String getJam() {
        return tfJam.getText();
    }
    
    public void inputDB(){
        
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
