package ManagedBeans;

import Modelo.Cidade;
import Modelo.Controle;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class bgrTabela {

    private int id;
    private String temp;
    private String precip;
    private String umid;
    private String data;
    private String hora;
    private String mensagem;
    private List<Cidade> listaCidades;

    //Metodo que busca todos os dados do banco de dados e insere na tabela
    public String pesquisar() {
        this.mensagem = "";

        Controle controle = new Controle();
        listaCidades = controle.pesquisar();

        if (listaCidades == null || listaCidades.isEmpty()) {
            this.mensagem = "Não existe resposta para está pesquisa";
            this.temp = "";
            this.precip = "";
            this.umid = "";
            this.data = "";
            this.hora = "";
            return null;
        }

        //Insere todos os dados
        if (listaCidades.size() > 1) {
            this.id = listaCidades.get(0).getId();
            this.temp = listaCidades.get(0).getTemp();
            this.precip = listaCidades.get(0).getPrecip();
            this.umid = listaCidades.get(0).getUmid();
            this.data = listaCidades.get(0).getData();
            this.hora = listaCidades.get(0).getHora();
            return null;
        }

        return null;
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

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

}
