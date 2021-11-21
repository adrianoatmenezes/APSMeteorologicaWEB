package ManagedBeans;

import Modelo.Cidade;
import Modelo.Controle;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class bgrPEE {

    private int id;
    private String temp;
    private String precip;
    private String umid;
    private String data;
    private String hora;
    private String mensagem;
    private List<Cidade> listaCidades;

    //Metodo que insere os dados que são pesquisados por DATA
    public String pesquisarPData() {
        this.mensagem = "";

        Controle controle = new Controle();
        listaCidades = controle.pesquisarCidadePorData(this.data);

        if (listaCidades == null || listaCidades.isEmpty()) {
            this.mensagem = "Não existe resposta para está pesquisa";
            this.temp = "";
            this.precip = "";
            this.umid = "";
            this.data = "";
            this.hora = "";
            return null;
        }

        if (listaCidades.size() < 0) {
            return "/paginas/pee.xhtml";
        }

        //Insere todos os dados
        if (listaCidades.size() == 1) {
            this.id = listaCidades.get(0).getId();
            this.temp = listaCidades.get(0).getTemp();
            this.precip = listaCidades.get(0).getPrecip();
            this.umid = listaCidades.get(0).getUmid();
            this.data = listaCidades.get(0).getData();
            this.hora = listaCidades.get(0).getHora();
        }
        
        //Envia para a pagina de uma tabela e preenche a tabela.
        if (listaCidades.size() > 1) {
            return "/paginas/respostaPesquisaPorData.xhtml";
        }

        return null;
    }

    //Metodo que insere os dados que foram pesquisados por ID
    public Cidade pesquisarId() {
        this.mensagem = "";

        Controle controle = new Controle();

        Cidade cidade = controle.pesquisarCidadePorId(String.valueOf(this.id));

        this.mensagem = controle.getMensagem();

        if (controle.getMensagem().equals("")) {
            this.temp = cidade.getTemp();
            this.precip = cidade.getPrecip();
            this.umid = cidade.getUmid();
            this.data = cidade.getData();
            this.hora = cidade.getHora();
        } else {
            this.temp = "";
            this.precip = "";
            this.umid = "";
            this.data = "";
            this.hora = "";
            controle.getMensagem();
        }

        return null;
    }
    
    //Metodo que remove os dados que forem selecionados por ID
    public void remover() {
        this.mensagem = "";
        Controle controle = new Controle();
        controle.excluirCidade(String.valueOf(this.id));
        this.id = 0;
        this.temp = "";
        this.precip = "";
        this.umid = "";
        this.data = "";
        this.hora = "";
        controle.getMensagem();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }

    public String getUmid() {
        return umid;
    }

    public void setUmid(String umid) {
        this.umid = umid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<Cidade> getListaCidade() {
        return listaCidades;
    }

    public void setListaCidade(List<Cidade> listaCidade) {
        this.listaCidades = listaCidade;
    }

}
