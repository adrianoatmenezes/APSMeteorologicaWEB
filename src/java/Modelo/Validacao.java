package Modelo;

import java.util.List;

public class Validacao 
{
    private String mensagem;
    private int id; //inicialmente int
    
    //Valida os dados como VALIDAR ID, DATA e HORARIO.
    public void validarDadosCidade(List<String> dadosCidade)
    {
        this.mensagem = "";
        this.validarIdCidade(dadosCidade.get(0)); //ID
        if (dadosCidade.get(4).length() < 10) //Data
            this.mensagem += "Data inválida \n";
        if (dadosCidade.get(5).length() < 5) //Hora
            this.mensagem += "Horário inválida \n";
    }
    
    //Metodo que ele valida o ID
    public void validarIdCidade(String numeroId)
    {
        this.mensagem = "";
        try
        {
            this.id = Integer.parseInt(numeroId); //ID
        }
        catch (Exception e)
        {
            this.mensagem += "ID inválido \n";
        }
    }
    
    //Metodo que ele valida a DATA
    public void validarDataCidade(String data)
    {
        this.mensagem = "";
        if (data.length() != 10) //Data
        {
            this.mensagem += "Digite uma data Válida \n";
        }
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public Integer getId()
    {
        return id;
    }
}
