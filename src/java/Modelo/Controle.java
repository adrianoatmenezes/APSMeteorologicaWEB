package Modelo;

import DAL.CidadeDAO;
import java.util.ArrayList;
import java.util.List;

public class Controle {

    private String mensagem;
    
    //Metodo que faz a função de EXCLUIR.
    public Cidade excluirCidade(String numeroId) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarIdCidade(numeroId);
        Cidade cidade = new Cidade();
        if (validacao.getMensagem().equals("")) {
            cidade.setId(validacao.getId());
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.excluirCidade(cidade);
            this.mensagem = cidadeDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }
        
        return cidade;
    }

    //Metodo que faz a função de PESQUISAR POR ID.
    public Cidade pesquisarCidadePorId(String numeroId) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarIdCidade(numeroId);
        Cidade cidade = new Cidade();
        if (validacao.getMensagem().equals("")) {
            cidade.setId(validacao.getId());
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidade = cidadeDAO.pesquisarCidadePorId(cidade);
            this.mensagem = cidadeDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }
        return cidade;
    }

    //Metodo que faz a função de PESQUISAR POR DATA.
    public List<Cidade> pesquisarCidadePorData(String data) {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDataCidade(data);
        Cidade cidade = new Cidade();
        List<Cidade> listaCidades = new ArrayList<>();
        if (validacao.getMensagem().equals("")) {
            cidade.setData(data);
            CidadeDAO cidadeDAO = new CidadeDAO();
            listaCidades = cidadeDAO.pesquisarCidadePorData(cidade);
            this.mensagem = cidadeDAO.getMensagem();
        } else {
            this.mensagem = validacao.getMensagem();
        }
        return listaCidades;
    }
    
    //Metodo que faz a função de PESQUISAR tudo que está na tabela.
    public List<Cidade> pesquisar() {
        this.mensagem = "";
        Cidade cidade = new Cidade();
        List<Cidade> listaCidades = new ArrayList<>();
        if (getMensagem().equals("")) {
            CidadeDAO cidadeDAO = new CidadeDAO();
            listaCidades = cidadeDAO.pesquisar(cidade);
            this.mensagem = cidadeDAO.getMensagem();
        } else {
            this.mensagem = getMensagem();
        }
        return listaCidades;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
