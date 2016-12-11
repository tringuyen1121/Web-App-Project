/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author A
 */
@Entity
@Table(name = "app_params")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppParams.findAll", query = "SELECT a FROM AppParams a")
    , @NamedQuery(name = "AppParams.findByParID", query = "SELECT a FROM AppParams a WHERE a.parID = :parID")
    , @NamedQuery(name = "AppParams.findByParname", query = "SELECT a FROM AppParams a WHERE a.parname = :parname")
    , @NamedQuery(name = "AppParams.findByPartype", query = "SELECT a FROM AppParams a WHERE a.partype = :partype")
    , @NamedQuery(name = "AppParams.findByParcode", query = "SELECT a FROM AppParams a WHERE a.parcode = :parcode")
    , @NamedQuery(name = "AppParams.findByParstatus", query = "SELECT a FROM AppParams a WHERE a.parstatus = :parstatus")
    , @NamedQuery(name = "AppParams.findByParorder", query = "SELECT a FROM AppParams a WHERE a.parorder = :parorder")
    , @NamedQuery(name = "AppParams.findByParcolor", query = "SELECT a FROM AppParams a WHERE a.parcolor = :parcolor")})
public class AppParams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Par_ID")
    private Integer parID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Par_name")
    private String parname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Par_type")
    private String partype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Par_code")
    private int parcode;
    @Lob
    @Size(max = 65535)
    @Column(name = "Par_desc")
    private String pardesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Par_status")
    private int parstatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Par_order")
    private int parorder;
    @Size(max = 255)
    @Column(name = "Par_color")
    private String parcolor;

    public AppParams() {
    }

    public AppParams(Integer parID) {
        this.parID = parID;
    }

    public AppParams(Integer parID, String parname, String partype, int parcode, int parstatus, int parorder) {
        this.parID = parID;
        this.parname = parname;
        this.partype = partype;
        this.parcode = parcode;
        this.parstatus = parstatus;
        this.parorder = parorder;
    }

    public Integer getParID() {
        return parID;
    }

    public void setParID(Integer parID) {
        this.parID = parID;
    }

    public String getParname() {
        return parname;
    }

    public void setParname(String parname) {
        this.parname = parname;
    }

    public String getPartype() {
        return partype;
    }

    public void setPartype(String partype) {
        this.partype = partype;
    }

    public int getParcode() {
        return parcode;
    }

    public void setParcode(int parcode) {
        this.parcode = parcode;
    }

    public String getPardesc() {
        return pardesc;
    }

    public void setPardesc(String pardesc) {
        this.pardesc = pardesc;
    }

    public int getParstatus() {
        return parstatus;
    }

    public void setParstatus(int parstatus) {
        this.parstatus = parstatus;
    }

    public int getParorder() {
        return parorder;
    }

    public void setParorder(int parorder) {
        this.parorder = parorder;
    }

    public String getParcolor() {
        return parcolor;
    }

    public void setParcolor(String parcolor) {
        this.parcolor = parcolor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parID != null ? parID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppParams)) {
            return false;
        }
        AppParams other = (AppParams) object;
        if ((this.parID == null && other.parID != null) || (this.parID != null && !this.parID.equals(other.parID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.creatopia.model.AppParams[ parID=" + parID + " ]";
    }

}
