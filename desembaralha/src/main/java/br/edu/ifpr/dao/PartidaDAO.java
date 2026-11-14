package br.edu.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import br.edu.ifpr.model.entities.Partida;

public class PartidaDAO {

    // Registrar uma nova partida vinculada a um jogador e a uma palavra.
    public void inserir(Partida partida) throws SQLException {
        String sql = "INSERT INTO partida(id_jog, id_pal, dificuldade, data_hora, pontuacao, status) VALUES (?,?,?,?,?,?);";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, partida.getIdJog());
            stmt.setInt(2, partida.getIdPal());
            stmt.setString(3, String.valueOf(partida.getDificuldade()));
            stmt.setTimestamp(4, Timestamp.valueOf(partida.getDataHora()));
            stmt.setInt(5, partida.getPontuacao());
            stmt.setBoolean(6, partida.isEstatus());
            stmt.executeUpdate();
            System.out.println("Partida inserida com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir partida :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }

    }

    // Listar todas as partidas registradas.
    public List<Partida> consultarTodas() throws SQLException {
        String sql = "SELECT * FROM partida";
        List<Partida> partidas = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Partida partida = new Partida();
                partida.setIdPartida(rs.getInt("id_partida"));
                partida.setIdJog(rs.getInt("id_jog"));
                partida.setIdPal(rs.getInt("id_pal"));
                partida.setDificuldade(rs.getString("dificuldade").charAt(0));
                partida.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
                partida.setPontuacao(rs.getInt("pontuacao"));
                partida.setEstatus(rs.getBoolean("status"));
                partidas.add(partida);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar as partidas :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return partidas;
    }

    // Consultar uma partida pelo identificador.
    public Partida consultarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM partida WHERE id_partida = ?";
        Partida partida = null;
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                partida = new Partida();
                partida.setIdPartida(rs.getInt("id_partida"));
                partida.setIdJog(rs.getInt("id_jog"));
                partida.setIdPal(rs.getInt("id_pal"));
                partida.setDificuldade(rs.getString("dificuldade").charAt(0));
                partida.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
                partida.setPontuacao(rs.getInt("pontuacao"));
                partida.setEstatus(rs.getBoolean("status"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar a partida por id :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return partida;
    }

    // Consultar as partidas de determinado jogador.
    public List<Partida> consultarPorJogador(int idJogador) throws SQLException {
        String sql = "SELECT * FROM partida WHERE id_jogador = ?";
        List<Partida> partidas = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idJogador);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Partida partida = new Partida();
                partida.setIdPartida(rs.getInt("id_partida"));
                partida.setIdJog(rs.getInt("id_jog"));
                partida.setIdPal(rs.getInt("id_pal"));
                partida.setDificuldade(rs.getString("dificuldade").charAt(0));
                partida.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
                partida.setPontuacao(rs.getInt("pontuacao"));
                partida.setEstatus(rs.getBoolean("status"));
                partidas.add(partida);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar as partidas por jogador :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return partidas;
    }

    // Atualizar a pontuação da partida.
    public void atualizarPontuacao(int idPartida, int pontuacao) throws SQLException {
        String sql = "UPDATE partida SET pontuacao = ? WHERE id_partida = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, pontuacao);
            stmt.setInt(2, idPartida);
            stmt.executeUpdate();

            System.out.println("Pontuação da partida atualizada com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar a pontuação da partida :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }
    }

    // Atualizar o estado da partida.
    public void atualizarStatus(int idPartida, boolean status) throws SQLException {
        String sql = "UPDATE partida SET status = ? WHERE id_partida = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setBoolean(1, status);
            stmt.setInt(2, idPartida);
            stmt.executeUpdate();

            System.out.println("Status da partida atualizado com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar o status da partida :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }
    }
}