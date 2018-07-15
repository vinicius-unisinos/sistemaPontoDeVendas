/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author hugov
 */
public class Conectar {
    
    
     Connection conect = null;

     
     //CONEXAO LOCAL
    public Connection conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/sistema", "root", ""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar!!" + e);
        }
        return conect;
    }   
    
    /*
    //CONEXAO HOSPEDADA
    public Connection conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://mysql427.umbler.com/pontovenda", "hugofreitas", "hospedagem"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar!!" + e);
        }
        return conect;
    }   */
    
}
