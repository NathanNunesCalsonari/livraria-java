package com.example;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.data.LivrosDao;
import com.example.model.Livros;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable{

    @FXML TextField txtNomeDoLivro;
    @FXML TextField txtAutorDoLivro;
    @FXML TextField txtAnoDePublicacao;
    @FXML TextField txtGenero;
    @FXML TextField txtValor;

    @FXML TableView<Livros> tabela;

    @FXML TableColumn<Livros, String> colNomeDoLivro;
    @FXML TableColumn<Livros, String> colAutorDoLivro;
    @FXML TableColumn<Livros, Integer> colAnoDePublicacao;
    @FXML TableColumn<Livros, String> colGenero;
    @FXML TableColumn<Livros, BigDecimal> colValor;

    @FXML TextField txtNomeDoAutor;
    @FXML TextField txtIdadeDoAutor;

    @FXML TableView<Autores> tabela2;

    @FXML TableColumn<Autores, String> colNomeDoAutor;
    @FXML TableColumn<Autores, Integer> colIdadeDoAutor;

    @FXML ComboBox<Autores> cbAutores;

    public void adicionarLivro(){
        var livro = new Livros(
            null, 
            txtNomeDoLivro.getText(), 
            txtAutorDoLivro.getText(), 
            Integer.valueOf( txtAnoDePublicacao.getText() ), 
            txtGenero.getText(),
            new BigDecimal(txtValor.getText())
        );

        try{
            LivrosDao.inserir(livro);
            tabela.getItems().add(livro);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void carregarLivro(){
        tabela.getItems().clear();
        try {
            var livros = LivrosDao.buscarTodos();
            livros.forEach(livro -> tabela.getItems().add(livro));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void adicionarAutor(){
        var autor = new Autores(
            null, 
            txtNomeDoAutor.getText(), 
            txtIdadeDoAutor.getText(), 
        );

        try{
            autoresDao.inserir(autor);
            tabela2.getItems().add(autor);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void carregarAutores(){
        tabela2.getItems().clear();
        try {
            var autores = autoresDao.buscarTodos();
            clientes.forEach(autor -> tabela2.getItems().add(cliente));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void mostrarMensagem(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.show();
    }

    public void apagarLivro(){
        var aluno = lista.getSelectionModel().getSelectedItem();
        try {
            dao.apagar(aluno);
        } catch (SQLException e) {
            mostrarMensagem(AlertType.ERROR, "Erro", e.getMessage());
            
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNomeDoLivro.setCellValueFactory(new PropertyValueFactory<>("nomeDoLivro"));
        colAutorDoLivro.setCellValueFactory(new PropertyValueFactory<>("autorDoLivro"));
        colAnoDePublicacao.setCellValueFactory(new PropertyValueFactory<>("anoDePublicacao"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        

        try {
            livrosDao = new LivroDao();
            autoresDao = new AutorDao();
            cbCliente.getItems().addAll(clienteDao.buscarTodos());
        } catch (SQLException e1) {
            mostrarMensagem("Erro", "Erro ao buscar clientes");
            e1.printStackTrace();
        }

        carregarLivro();
        carregarAutores();
    }
}
