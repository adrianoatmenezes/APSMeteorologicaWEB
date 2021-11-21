package DAL;

import Modelo.Cidade;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CidadeDAO {

    private String mensagem;
    Session session = HibernateUtil.getSessionFactory().openSession();

    //Metodo que faz a consulta de EXCLUIR
    public void excluirCidade(Cidade cidade) {
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.delete(cidade);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Cidade excluida com sucesso!";

        } catch (Exception e) {
            this.mensagem = "Erro de gravação no BD";
        }
    }

    //Metodo que faz a consulta de PESQUISAR POR ID
    public Cidade pesquisarCidadePorId(Cidade cidade) {
        this.mensagem = "";
        try {
            Query q = session.createQuery("from Cidade c where c.id = :id");
            q.setParameter("id", cidade.getId());
            cidade = (Cidade) q.list().get(0);
        } catch (Exception e) {
            this.mensagem = "Erro de leitura no BD";
        }
        return cidade;
    }

    //Metodo que faz a consulta de PESQUISAR POR DATA
    public List<Cidade> pesquisarCidadePorData(Cidade cidade) {
        this.mensagem = "";
        List<Cidade> listaCidades = new ArrayList<>();
        try {
            Query q = session.createQuery("from Cidade c where c.data like :data");
            q.setParameter("data", cidade.getData() + "%");
            listaCidades = (List<Cidade>) q.list();
        } catch (Exception e) {
            this.mensagem = "Erro de leitura no BD";
        }
        return listaCidades;
    }

    //Metodo que faz uma consulta geral da tabela
    public List<Cidade> pesquisar(Cidade cidade) {
        this.mensagem = "";
        List<Cidade> listaCidades = new ArrayList<>();
        try {
            Query q = session.createQuery("FROM Cidade");
            listaCidades = (List<Cidade>) q.list();
        } catch (Exception e) {
            this.mensagem = "Erro de leitura no BD";
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
