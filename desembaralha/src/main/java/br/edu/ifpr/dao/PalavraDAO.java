package br.edu.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.model.entities.Palavra;

public class PalavraDAO {

    // Cadastrar uma palavra vinculada a uma categoria.
    public void inserir(Palavra palavra) throws SQLException {
        String sql = "INSERT INTO palavra(id_cat, palavra_Correta, dica1, dica2) VALUES (?,?,?,?);";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, palavra.getIdCat());
            stmt.setString(2, palavra.getPalavraCorreta());
            stmt.setString(3, palavra.getDica1());
            stmt.setString(4, palavra.getDica2());
            stmt.executeUpdate();
            System.out.println("Palavra inserida com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir palavra :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }
    }

    // Listar todas as palavras.
    public List<Palavra> consultarTodas() throws SQLException {
        String sql = "SELECT * FROM palavra";
        List<Palavra> palavras = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Palavra palavra = new Palavra();
                palavra.setIdPalavra(rs.getInt("id_palavra"));
                palavra.setIdCat(rs.getInt("id_cat"));
                palavra.setPalavraCorreta(rs.getString("palavra_Correta"));
                palavra.setDica1(rs.getString("dica1"));
                palavra.setDica2(rs.getString("dica2"));
                palavras.add(palavra);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar todas as palavras :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return palavras;
    }

    // Consultar uma palavra pelo identificador.
    public Palavra consultarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM palavra WHERE id_palavra = ?";
        Palavra palavra = null;
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                palavra = new Palavra();
                palavra.setIdPalavra(rs.getInt("id_palavra"));
                palavra.setIdCat(rs.getInt("id_cat"));
                palavra.setPalavraCorreta(rs.getString("palavra_Correta"));
                palavra.setDica1(rs.getString("dica1"));
                palavra.setDica2(rs.getString("dica2"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar as palavras por id :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return palavra;
    }

    // Listar palavras de determinada categoria.
    public List<Palavra> consultarPorCategoria(int idCategoria) throws SQLException {
        String sql = "SELECT * FROM palavra WHERE id_cat = ?";
        List<Palavra> palavras = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCategoria);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Palavra palavra = new Palavra();
                palavra.setIdPalavra(rs.getInt("id_palavra"));
                palavra.setIdCat(rs.getInt("id_cat"));
                palavra.setPalavraCorreta(rs.getString("palavra_Correta"));
                palavra.setDica1(rs.getString("dica1"));
                palavra.setDica2(rs.getString("dica2"));
                palavras.add(palavra);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar as palavras por categoria :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return palavras;
    }

    // Alterar os dados de uma palavra.
    public void atualizar(Palavra palavra) throws SQLException {
        String sql = "UPDATE palavra SET id_cat = ?, palavra_Correta = ?, dica1 = ?, dica2 = ? WHERE id_palavra = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, palavra.getIdCat());
            stmt.setString(2, palavra.getPalavraCorreta());
            stmt.setString(3, palavra.getDica1());
            stmt.setString(4, palavra.getDica2());
            stmt.setInt(5, palavra.getIdPalavra());
            stmt.executeUpdate();

            System.out.println("Palavra atualizada com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar a palavra :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }
    }

    // Excluir uma palavra.
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM palavra WHERE id_palavra = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Palavra excluida com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir a palavra de id " + id + " :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }
    }

}