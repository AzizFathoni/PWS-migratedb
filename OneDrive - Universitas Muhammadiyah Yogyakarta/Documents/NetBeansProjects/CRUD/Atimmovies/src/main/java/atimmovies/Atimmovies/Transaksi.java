/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atimmovies.Atimmovies;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "transaksi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaksi.findAll", query = "SELECT t FROM Transaksi t"),
    @NamedQuery(name = "Transaksi.findByIdtransaksi", query = "SELECT t FROM Transaksi t WHERE t.idtransaksi = :idtransaksi"),
    @NamedQuery(name = "Transaksi.findByIdpelanggan", query = "SELECT t FROM Transaksi t WHERE t.idpelanggan = :idpelanggan"),
    @NamedQuery(name = "Transaksi.findByIdcd", query = "SELECT t FROM Transaksi t WHERE t.idcd = :idcd"),
    @NamedQuery(name = "Transaksi.findByTglPinjam", query = "SELECT t FROM Transaksi t WHERE t.tglPinjam = :tglPinjam"),
    @NamedQuery(name = "Transaksi.findByBiaya", query = "SELECT t FROM Transaksi t WHERE t.biaya = :biaya")})
public class Transaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_transaksi")
    private String idtransaksi;
    @Basic(optional = false)
    @Column(name = "Id_pelanggan")
    private String idpelanggan;
    @Basic(optional = false)
    @Column(name = "Id_cd")
    private String idcd;
    @Basic(optional = false)
    @Column(name = "tgl_pinjam")
    @Temporal(TemporalType.DATE)
    private Date tglPinjam;
    @Basic(optional = false)
    @Column(name = "biaya")
    private String biaya;
    @JoinColumn(name = "Id_transaksi", referencedColumnName = "Id_CD", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Dvd dvd;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "transaksi")
    private Pelanggan pelanggan;

    public Transaksi() {
    }

    public Transaksi(String idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public Transaksi(String idtransaksi, String idpelanggan, String idcd, Date tglPinjam, String biaya) {
        this.idtransaksi = idtransaksi;
        this.idpelanggan = idpelanggan;
        this.idcd = idcd;
        this.tglPinjam = tglPinjam;
        this.biaya = biaya;
    }

    public String getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(String idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public String getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(String idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public String getIdcd() {
        return idcd;
    }

    public void setIdcd(String idcd) {
        this.idcd = idcd;
    }

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public String getBiaya() {
        return biaya;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransaksi != null ? idtransaksi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksi)) {
            return false;
        }
        Transaksi other = (Transaksi) object;
        if ((this.idtransaksi == null && other.idtransaksi != null) || (this.idtransaksi != null && !this.idtransaksi.equals(other.idtransaksi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atimmovies.Atimmovies.Transaksi[ idtransaksi=" + idtransaksi + " ]";
    }
    
}
