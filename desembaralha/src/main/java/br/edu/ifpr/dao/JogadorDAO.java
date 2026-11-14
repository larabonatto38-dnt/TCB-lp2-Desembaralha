package br.edu.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.model.entities.Jogador;

public class JogadorDAO {

    // Cadastrar um jogador.
    public void inserir(Jogador jogador) throws SQLException {
        String sql = "INSERT INTO jogador(id_jogador, nome) VALUES (?,?);";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, jogador.getIdJogador());
            stmt.setString(2, jogador.getNome());
            stmt.executeUpdate();
            System.out.println("Jogador inserido com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir jogador :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }

    }

    // Listar os jogadores cadastrados.
    public List<Jogador> consultarTodos() throws SQLException {
        String sql = "SELECT * FROM jogador";
        List<Jogador> jogadores = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Jogador jogador = new Jogador();
                jogador.setIdJogador(rs.getInt("id_jogador"));
                jogador.setNome(rs.getString("nome"));
                jogadores.add(jogador);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar os jogadores :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return jogadores;
    }

    // Consultar um jogador pelo identificador.
    public Jogador consultarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM jogador WHERE id_jogador = ?";
        Jogador jogador = null;
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                jogador = new Jogador();
                jogador.setIdJogador(rs.getInt("id_jogador"));
                jogador.setNome(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar os jogadores por id :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return jogador;
    }

    // Buscar um jogador pelo nome.
    public Jogador consultarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM jogador WHERE nome = ?";
        Jogador jogador = null;
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            while (rs.next()) {
                jogador = new Jogador();
                jogador.setIdJogador(rs.getInt("id_jogador"));
                jogador.setNome(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar os jogadores por nome :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return jogador;
    }
}