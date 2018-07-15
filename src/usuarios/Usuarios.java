/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author hugov
 */
public class Usuarios {
    
    public static String LISTAR_US = "SELECT * FROM usuarios ORDER BY nome_us";
    
    public static String REGISTRAR = "INSERT INTO usuarios(codigo_us, nome_us, sexo_us, tipo_us, senha) "
            + "VALUES(?,?,?,?,?)";
    
    public static String ATUALIZAR = "UPDATE usuarios SET "
                + "nome_us=?, "
                + "sexo_us=?, "
                + "tipo_us=?, "
                + "senha=? WHERE codigo_us=?";
    
    public static String ELIMINAR = "DELETE FROM usuarios WHERE codigo_us = ?";
    
    public static String ELIMINAR_TUDO = "DELETE FROM usuarios";
    
    private int primaryKey;
    private String nome;
    private String sexo;
    private String tipouser;
    private String senha;

    public Usuarios(){
        
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipouser() {
        return tipouser;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
