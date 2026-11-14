package br.edu.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.model.entities.RespostaPartida;

public class RespostaPartidaDAO {

    // Registrar uma resposta vinculada a uma partida.
    public void inserir(RespostaPartida resposta) throws SQLException {
        String sql = "INSERT INTO resposta_partida(id_par, resposta_digitada, correta) VALUES (?,?,?);";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, resposta.getIdPar());
            stmt.setString(2, resposta.getRespostaDigitada());
            stmt.setBoolean(3, resposta.isCorreta());
            stmt.executeUpdate();
            System.out.println("Resposta inserida com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir resposta :( " + ex.getMessage());

        } finally {
            stmt.close();
            conexao.close();
        }

    }

    // Listar as respostas de determinada partida.
    public List<RespostaPartida> consultarPorPartida(int idPartida) throws SQLException {
        String sql = "SELECT * FROM resposta_partida WHERE id_par = ?";
        List<RespostaPartida> respostas = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPartida);
            rs = stmt.executeQuery();

            while (rs.next()) {
                RespostaPartida resposta = new RespostaPartida();
                resposta.setIdResposta(rs.getInt("id_resposta"));
                resposta.setIdPar(rs.getInt("id_par"));
                resposta.setRespostaDigitada(rs.getString("resposta_digitada"));
                resposta.setCorreta(rs.getBoolean("correta"));
                respostas.add(resposta);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar as respostas da partida :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return respostas;
    }

    // Consultar uma resposta pelo identificador.
    public RespostaPartida consultarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM resposta_par WHERE id_resposta = ?";
        RespostaPartida resposta = null;
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                resposta = new RespostaPartida();
                resposta.setIdResposta(rs.getInt("id_resposta"));
                resposta.setIdPar(rs.getInt("id_par"));
                resposta.setRespostaDigitada(rs.getString("resposta_digitada"));
                resposta.setCorreta(rs.getBoolean("correta"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar a resposta por id :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return resposta;
    }

    // Listar todas as respostas registradas.
    public List<RespostaPartida> consultarTodas() throws SQLException {
        String sql = "SELECT * FROM resposta_partida";
        List<RespostaPartida> respostas = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                RespostaPartida resposta = new RespostaPartida();
                resposta.setIdResposta(rs.getInt("id_resposta"));
                resposta.setIdPar(rs.getInt("id_par"));
                resposta.setRespostaDigitada(rs.getString("resposta_digitada"));
                resposta.setCorreta(rs.getBoolean("correta"));
                respostas.add(resposta);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar as respostas :( " + ex.getMessage());
        } finally {
            rs.close();
            stmt.close();
            conexao.close();
        }
        return respostas;
    }

    // Excluir todas as respostas vinculadas a uma partida.
    public void excluirPorPartida(int idPartida) throws SQLException {
        String sql = "DELETE FROM resposta_partida WHERE id_par = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPartida);
            stmt.executeUpdate();
            System.out.println("Respostas da partida excluídas!");

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir as respostas da partida: " + idPartida + " :( " + ex.getMessage());
        }finally {
            if (stmt != null)
                stmt.close();
            if (conexao != null)
                conexao.close();
        }
    }
}