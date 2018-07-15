/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.sql.SQLException;
import principal.GerarCodigos;

/**
 *
 * @author Vinicíus
 */
public class Cliente {
    private int id;
    private String nome;
    public static String LISTAR = "SELECT * FROM clientes";

    public Cliente(String nome) throws SQLException {
        GerarCodigos gerar = new GerarCodigos();
        int idGerado = gerar.gerarId("clientes");
        this.id = idGerado;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    
    
    
}
