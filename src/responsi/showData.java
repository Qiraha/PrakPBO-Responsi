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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp
 */
public class showData extends JFrame implements ActionListener{
    public String no_mk, nama_mk, kelas, nip;
    int jmlData;
    String data[][] = new String[500][4];
    
    Connector connector = new Connector();    
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Data Karyawan");
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","Nama","Usia","Gaji"}; //membuat kolom dgn array tipe object;
    JButton BtnBack = new JButton("Kembali");
    
     JLabel lNo = new JLabel("ID  ");
        JTextField tfNo = new JTextField();
    JButton edit = new JButton("Edit");
    
    public showData(){
        window.setLayout(null);
        window.setSize(550,600);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        try{
            int jmlData = 0; 
            String query = "Select * from `karyawan`";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("usia");
                data[jmlData][3] = resultSet.getString("gaji");
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        
        tabel = new JTable(data,namaKolom); 
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 35, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        BtnBack.addActionListener(this);
        window.add(BtnBack);
        window.add(tfNo);
        window.add(lNo);
        window.add(edit);
        
        lNo.setBounds(50, 350, 120, 20);
        tfNo.setBounds(110, 350, 120, 20);
        edit.setBounds(250, 350, 90, 20);
        BtnBack.setBounds(1,520,549,40);
        
        
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        BtnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                window.dispose();
                Home home = new Home();
            }
        });
        
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int re = 0;
                try{
                    re=0;
                editData edit = new editData(getNo());
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Masukkan Angka!!!");
                    re=1;
                }
                if(re!=1)
                    window.dispose();
                
            }
        });
    }

    
    
    
    public String getNo() {
        return tfNo.getText();
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}


