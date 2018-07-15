/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import principal.Conectar;
import principal.GerarNumero;

/**
 *
 * @author hugov
 */
public class VendasSql {
    static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    
    
    public static int registrar(Vendas uc) {
        int rsu = 0;
        String sql = Vendas.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getPrimaryKey());
            ps.setInt(2, uc.getIdCliente());
            ps.setString(3, uc.getTotal());
            ps.setString(4, uc.getData());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminar(String id) {
        int rsu = 0;
        String sql = Vendas.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminaTodos() {
        int rsu = 0;
        String sql = Vendas.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) vendas.FrmVendas.tabela.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Vendas.LISTAR;
        } else {
            sql = "SELECT * FROM vendas WHERE (numero_ven like'" + busca + "%' or data_ven='" + busca + "')"
                    + " ORDER BY data_ven";
        }
        String dados[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dados[0] = rs.getString("numero_ven");
                dados[1] = rs.getString("id_cliente");
                dados[2] = rs.getString("total_ven");
                dados[3] = rs.getString("data_ven");
                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<Vendas> readForDesc(String busca) {

        List<Vendas> produtos = new ArrayList<>();

        String sql = "";
        if (busca.equals("")) {
            sql = Vendas.LISTAR;
        } else {
            sql =("SELECT * FROM produto WHERE descricao LIKE ?");
            /*"SELECT * FROM vendas WHERE (numero_ven like'" + busca + "%' or data_ven='" + busca + "')"
            + " ORDER BY data_ven";*/
        }
        Vendas dados[] = new Vendas[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                
                Vendas produto = new Vendas();

                produto.setData(rs.getString("data_ven"));
                produto.setIdCliente(rs.getInt("id_cliente"));
                produto.setPrimaryKey(rs.getInt("numero_ven"));
                produto.setTotal(rs.getString("total_ven"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasSql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produtos;

    }

    public static void numeros() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(numero_ven) FROM vendas";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                //vendas.FrmCaixa.numFac.setText("00000001");
            } else {
                j = Integer.parseInt(c);
                GerarNumero gen = new GerarNumero();
                gen.gerar(j);
                //vendas.FrmCaixa.numFac.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendasSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void numeros1() {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(numero_venda) FROM vendas";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                //vendas.FrmCaixa.numFac.setText("00000001");
            } else {
                j = Integer.parseInt(c);
                GerarNumero gen = new GerarNumero();
                gen.gerar(j);
               // vendas.FrmCaixa.numFac.setText(gen.serie());

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendasSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
