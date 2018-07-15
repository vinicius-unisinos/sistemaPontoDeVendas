/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import principal.Conectar;

/**
 *
 * @author Vinicíus
 */
public class RelatorioCliente {

    public void relatorio(String busca) {
        PreparedStatement stmt = null;

        try {

            Conectar cc = new Conectar();
            Connection cn = cc.conexao();
            stmt = cn.prepareStatement("SELECT * FROM clientes WHERE nome = ?");
            stmt.setString(1, busca);
            ResultSet rs = stmt.executeQuery();

            JRResultSetDataSource jr = new JRResultSetDataSource(rs);
            JasperPrint jasperPrint = JasperFillManager.fillReport("relatorioClien.jasper", new HashMap<>(), jr);
            JasperViewer.viewReport(jasperPrint);

        } catch (SQLException | JRException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
