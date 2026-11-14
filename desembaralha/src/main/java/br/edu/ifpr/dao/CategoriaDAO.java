package br.edu.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.model.entities.Categoria;

public class CategoriaDAO {

    // Cadastrar uma categoria.
    public void inserir(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria(id_categoria,nome, descricao) VALUES (?,?,?);";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.setString(2, categoria.getNome());
            stmt.setString(3, categoria.getDescricao());
            stmt.executeUpdate();
            System.out.println("Categoria inserida com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir categoria :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }

    }

    // Listar todas as categorias.
    public List<Categoria> consultarTodos() throws SQLException {
        String sql = "SELECT * FROM categoria";
        List<Categoria> categorias = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar as categorias :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return categorias;
    }

    // Consultar uma categoria pelo identificador.
    public Categoria consultarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        Categoria categoria = null;
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            stmt.setInt(1, id);
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar as categorias por id :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return categoria;
    }

    // Alterar a categoria.
    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE PRODUTO SET nome = ?, descricao = ? WHERE id_categoria = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.setInt(3, categoria.getIdCategoria());
            stmt.executeUpdate();

            System.out.println("Categoria atualizada com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar a categoria :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }
    }

    // Excluir uma categoria.
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Categoria excluida com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir a categoria de id " + id+ " :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }
    }
}