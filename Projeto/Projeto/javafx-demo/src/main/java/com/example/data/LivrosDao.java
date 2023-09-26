package com.example.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Livros;

public class LivrosDao {

    static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    static final String USER = "rm552537";
    static final String PASS = "280305";

    public static void inserir(Livros livros) throws SQLException {
        var conexao = DriverManager.getConnection(URL, USER, PASS);

        var sql = "INSERT INTO biblioteca (nomeDoLivro, autorDoLivro, anoDePublicacao, genero, valor) VALUES (?, ?, ?, ?, ?) ";
        var comando = conexao.prepareStatement(sql);
        comando.setString(1,livros.getNomeDoLivro());
        comando.setString(2, livros.getAutorDoLivro());
        comando.setInt(3, livros.getAnoDePublicacao());
        comando.setString(4, livros.getGenero());
        comando.setBigDecimal(5, livros.getValor());
        comando.executeUpdate();

        conexao.close();

    }

    public static List<Livros> buscarTodos() throws SQLException{
        var lista = new ArrayList<Livros>();

        var conexao = DriverManager.getConnection(URL, USER, PASS);
        var comando = conexao.prepareStatement("SELECT * FROM biblioteca");
        var resultado = comando.executeQuery();

        while(resultado.next()){
            lista.add (new Livros(
                resultado.getLong("id"), 
                resultado.getString("nomeDoAutor"), 
                resultado.getString("autorDoLivro"), 
                resultado.getInt("anoDePublicacao"), 
                resultado.getString("genero"),
                resultado.getBigDecimal("valor")
            ));
        }

        conexao.close();
        return lista;
    }

    public void apagar(Livros livro) throws SQLException {
        var con = DriverManager.getConnection(URL, USER, PASS);
        var stm = con.prepareStatement("DELETE FROM biblioteca WHERE valor=?");
        stm.setInt(1, livro.getValor() );
        stm.executeUpdate();
        con.close();
    }   
    



}
