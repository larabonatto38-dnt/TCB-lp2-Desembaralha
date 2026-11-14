
package br.edu.ifpr;

import java.sql.SQLException;
import java.time.LocalDateTime;

import br.edu.ifpr.dao.CategoriaDAO;
import br.edu.ifpr.dao.JogadorDAO;
import br.edu.ifpr.dao.PalavraDAO;
import br.edu.ifpr.dao.PartidaDAO;
import br.edu.ifpr.dao.RespostaPartidaDAO;

import br.edu.ifpr.model.entities.Categoria;
import br.edu.ifpr.model.entities.Jogador;
import br.edu.ifpr.model.entities.Palavra;
import br.edu.ifpr.model.entities.Partida;
import br.edu.ifpr.model.entities.RespostaPartida;

public class Main {

    public static void main(String[] args) throws SQLException {

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        JogadorDAO jogadorDAO = new JogadorDAO();
        PalavraDAO palavraDAO = new PalavraDAO();
        PartidaDAO partidaDAO = new PartidaDAO();
        RespostaPartidaDAO respostaDAO = new RespostaPartidaDAO();

        int idCategoria = 9001;
        int idJogador = 9001;

        System.out.println("===== TESTANDO CATEGORIA =====");

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        categoria.setNome("Teste");
        categoria.setDescricao("Categoria de teste");

        categoriaDAO.inserir(categoria);
        System.out.println(categoriaDAO.consultarTodos());

        System.out.println("\n===== TESTANDO JOGADOR =====");

        Jogador jogador = new Jogador();
        jogador.setIdJogador(idJogador);
        jogador.setNome("Jogador Teste");

        jogadorDAO.inserir(jogador);
        System.out.println(jogadorDAO.consultarTodos());
        System.out.println(jogadorDAO.consultarPorId(idJogador));
        System.out.println(jogadorDAO.consultarPorNome("Jogador Teste"));

        System.out.println("\n===== TESTANDO PALAVRA =====");

        Palavra palavra = new Palavra();
        palavra.setIdCat(idCategoria);
        palavra.setPalavraCorreta("COMPUTADOR");
        palavra.setDica1("É um equipamento eletrônico");
        palavra.setDica2("Pode ser usado para programar");

        palavraDAO.inserir(palavra);

        System.out.println(palavraDAO.consultarTodas());
        System.out.println(palavraDAO.consultarPorCategoria(idCategoria));

        Palavra palavraConsultada =
                palavraDAO.consultarPorCategoria(idCategoria).get(0);

        System.out.println("\n===== TESTANDO PARTIDA =====");

        Partida partida = new Partida();
        partida.setIdJog(idJogador);
        partida.setIdPal(palavraConsultada.getIdPalavra());
        partida.setDificuldade('F');
        partida.setDataHora(LocalDateTime.now());
        partida.setPontuacao(100);
        partida.setEstatus(true);

        partidaDAO.inserir(partida);

        System.out.println(partidaDAO.consultarTodas());
        System.out.println(partidaDAO.consultarPorJogador(idJogador));

        Partida partidaConsultada =
                partidaDAO.consultarPorJogador(idJogador).get(0);

        partidaDAO.atualizarPontuacao(
                partidaConsultada.getIdPartida(), 200);

        partidaDAO.atualizarStatus(
                partidaConsultada.getIdPartida(), false);

        System.out.println("\n===== TESTANDO RESPOSTA =====");

        RespostaPartida resposta = new RespostaPartida();
        resposta.setIdPar(partidaConsultada.getIdPartida());
        resposta.setRespostaDigitada("COMPUTADOR");
        resposta.setCorreta(true);

        respostaDAO.inserir(resposta);

        System.out.println(
                respostaDAO.consultarPorPartida(
                        partidaConsultada.getIdPartida()));

        System.out.println("\n===== TESTES FINALIZADOS =====");
    }
}
