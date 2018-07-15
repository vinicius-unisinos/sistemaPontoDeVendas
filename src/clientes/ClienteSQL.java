/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import principal.Conectar;
import produtos.Produtos;

/**
 *
 * @author Vinicíus
 */
public class ClienteSQL {

    static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;

    public static void listar() {
        DefaultTableModel modelo = (DefaultTableModel) SelecionarCliente.tabela.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        

        //tring sql = Cliente.LISTAR;

       String sql = "SELECT * FROM clientes";
//            WHERE (id like'" + busca + "%' or nome like'" + busca + "%') "
//                    + " order by nome_pro"

        String dados[] = new String[2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dados[0] = rs.getString("id");
                dados[1] = rs.getString("nome");

                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
