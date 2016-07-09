/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jess
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdf", query = "SELECT f FROM Factura f WHERE f.idf = :idf"),
    @NamedQuery(name = "Factura.findByNombre", query = "SELECT f FROM Factura f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Factura.findByMail", query = "SELECT f FROM Factura f WHERE f.mail = :mail"),
    @NamedQuery(name = "Factura.findByRuc", query = "SELECT f FROM Factura f WHERE f.ruc = :ruc")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idf")
    private Integer idf;
    @Size(max = 128)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 128)
    @Column(name = "mail")
    private String mail;
    @Size(max = 128)
    @Column(name = "ruc")
    private String ruc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idf")
    private Collection<Detalle> detalleCollection;

    public Factura() {
    }

    public Factura(Integer idf) {
        this.idf = idf;
    }

    public Integer getIdf() {
        return idf;
    }

    public void setIdf(Integer idf) {
        this.idf = idf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @XmlTransient
    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idf != null ? idf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idf == null && other.idf != null) || (this.idf != null && !this.idf.equals(other.idf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Factura[ idf=" + idf + " ]";
    }
    
}
