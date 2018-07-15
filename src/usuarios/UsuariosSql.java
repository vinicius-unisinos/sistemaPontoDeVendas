/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import principal.Conectar;
import principal.GerarCodigos;

/**
 *
 * @author hugov
 */
public class UsuariosSql {

    static Conectar cc = new Conectar();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;

    public static void listarUsuario(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) usuarios.FrmUsuarios.tabelaUsuarios.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Usuarios.LISTAR_US;
        } else {
            sql = "SELECT * FROM usuarios WHERE (codigo_us like'" + busca + "%' or nome_us like'" + busca + "%') "
                    + " order by nome_us";

        }
        String dados[] = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dados[0] = rs.getString("codigo_us");
                dados[1] = rs.getString("nome_us");
                dados[2] = rs.getString("sexo_us");
                dados[3] = rs.getString("tipo_us");
                dados[4] = rs.getString("senha");
                modelo.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int registrarUsuario(Usuarios uc) {
        int rsu = 0;
        String sql = Usuarios.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getPrimaryKey());
            ps.setString(2, uc.getNome());
            ps.setString(3, uc.getSexo());
            ps.setString(4, uc.getTipouser());
            ps.setString(5, uc.getSenha());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

    public static void gerarId(int String) {
        int j;
        int cont = 1;
        String num = "";
        String c = "";
        String SQL = "SELECT MAX(codigo_us) FROM usuarios";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getString(1);
            }

            if (c == null) {
                FrmUsuarios.codigot.setText("1");

            } else {
                char r1 = c.charAt(3);
                char r2 = c.charAt(4);
                char r3 = c.charAt(5);
                char r4 = c.charAt(6);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;
                j = Integer.parseInt(r);
                GerarCodigos gen = new GerarCodigos();
                int id = gen.gerarId("usuarios");

                Object b = new Object();
                b = id;
                b = b.toString();
                System.out.println(b);

                usuarios.FrmUsuarios.codigot.setText(b.toString());

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int atualizarUsuario(Usuarios uc) {
        int rsu = 0;
        String sql = Usuarios.ATUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNome());
            ps.setString(2, uc.getSexo());
            ps.setString(3, uc.getTipouser());
            ps.setString(4, uc.getSenha());
            ps.setInt(5, uc.getPrimaryKey());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }

    public static int eliminarUsuario(String id) {
        int rsu = 0;
        String sql = Usuarios.ELIMINAR;

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
        String sql = Usuarios.ELIMINAR_TUDO;
        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }

}
