/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GerarCodigos {

    private int dado;
    private int cont = 1;
    private String num = "";

    public void gerar(int dado) {
        this.dado = dado;

        if ((this.dado >= 1000) || (this.dado < 10000)) {
            int can = cont + this.dado;
            num = "" + can;
        }
        if ((this.dado >= 100) || (this.dado < 1000)) {
            int can = cont + this.dado;
            num = "0" + can;
        }
        if ((this.dado >= 9) || (this.dado < 100)) {
            int can = cont + this.dado;
            num = "00" + can;
        }
        if (this.dado < 9) {
            int can = cont + this.dado;
            num = "000" + can;
        }

    }

    public int gerarId(String tabela) throws SQLException {
        Conectar cc = new Conectar();
        Connection cn = cc.conexao();
        String sql = "SELECT * FROM "+tabela;
        int c = 0;

        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
            c = rs.getInt(1);
            
        }
         System.out.println("MAX ID:"+(c+1));
        return (c+1);
    }

    public String serie() {
        return this.num;
    }
    
    public static void main(String[] args) throws SQLException {
        GerarCodigos n = new GerarCodigos();
        int x;
        x = n.gerarId("vendas");
    }

}


