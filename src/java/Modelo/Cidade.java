/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yan
 */
@Entity
@Table(name = "cidades")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findById", query = "SELECT c FROM Cidade c WHERE c.id = :id")
    , @NamedQuery(name = "Cidade.findByTemp", query = "SELECT c FROM Cidade c WHERE c.temp = :temp")
    , @NamedQuery(name = "Cidade.findByPrecip", query = "SELECT c FROM Cidade c WHERE c.precip = :precip")
    , @NamedQuery(name = "Cidade.findByUmid", query = "SELECT c FROM Cidade c WHERE c.umid = :umid")
    , @NamedQuery(name = "Cidade.findByData", query = "SELECT c FROM Cidade c WHERE c.data = :data")
    , @NamedQuery(name = "Cidade.findByHora", query = "SELECT c FROM Cidade c WHERE c.hora = :hora")
})
public class Cidade implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "temp")
    private String temp;
    @Column(name = "precip")
    private String precip;
    @Column(name = "umid")
    private String umid;
    @Column(name = "data")
    private String data;
    @Column(name = "hora")
    private String hora;

    public Cidade()
    {
    }

    public Cidade(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTemp()
    {
        return temp;
    }

    public void setTemp(String temp)
    {
        this.temp = temp;
    }

    public String getPrecip()
    {
        return precip;
    }

    public void setPrecip(String precip)
    {
        this.precip = precip;
    }

    public String getUmid()
    {
        return umid;
    }

    public void setUmid(String umid)
    {
        this.umid = umid;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade))
        {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Modelo.Cidade[ id=" + id + " ]";
    }
    
}
