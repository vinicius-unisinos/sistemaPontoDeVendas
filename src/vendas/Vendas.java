/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

import java.sql.SQLException;
import principal.GerarCodigos;

/**
 *
 * @author hugov
 */
public class Vendas {
    public static String LISTAR = "SELECT * FROM vendas ORDER BY data_ven";
    
    public static String REGISTRAR = "INSERT INTO vendas(numero_ven, id_cliente, total_ven, data_ven) "
            + "VALUES(?,?,?,?)";
    
    public static String ELIMINAR = "DELETE FROM vendas WHERE numero_ven = ?";
    
    public static String ELIMINAR_TUDO = "DELETE FROM vendas";
    
    private int primaryKey;
    private int idCliente;
    private String total;
    private String data;

    public Vendas(){
        
    }

    public int getPrimaryKey() {
        return primaryKey;
    }
    
    protected int idVenda() throws SQLException{
        GerarCodigos gerar = new GerarCodigos();
        int id = gerar.gerarId("vendas");
        return id;
        
    }
    

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    public void setIdCliente(int id){
        this.idCliente = id;
    }
    
    public int getIdCliente(){
        return this.idCliente;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
