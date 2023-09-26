package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Autores;

public class AutoresDao {

    private Connection conexao;

    public ClienteDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public static void inserir(Autores autores) throws SQLException {
        var conexao = DriverManager.getConnection(URL, USER, PASS);

        var sql = "INSERT INTO autor (nomeDoAutor, idadeDoAutor) VALUES (?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1, autores.getNomeDoAutor());
        comando.setInt(2,autores.getIdadeDoAutor());
        comando.executeUpdate();

        conexao.close();

    }

    public static List<Autores> buscarTodos() throws SQLException{
        var lista = new ArrayList<Autores>();

        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var comando = conexao.prepareStatement("SELECT * FROM autor");
        var resultado = comando.executeQuery();

        while(resultado.next()){
            lista.add (new Autores(
                resultado.getLong("id"), 
                resultado.getString("nomeDoAutor"), 
                resultado.getInt("idadeDoAutor")
            ));
        }

        conexao.close();
        return lista;
    }

    


}
    
}
