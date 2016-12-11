/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author A
 */
@Entity
@Table(name = "images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i")
    , @NamedQuery(name = "Images.findByImageID", query = "SELECT i FROM Images i WHERE i.imageID = :imageID")
    , @NamedQuery(name = "Images.findByImagename", query = "SELECT i FROM Images i WHERE i.imagename = :imagename")
    , @NamedQuery(name = "Images.findByUploaddate", query = "SELECT i FROM Images i WHERE i.uploaddate = :uploaddate")
    , @NamedQuery(name = "Images.findByImageloca", query = "SELECT i FROM Images i WHERE i.imageloca = :imageloca")
    , @NamedQuery(name = "Images.findByNumView", query = "SELECT i FROM Images i WHERE i.numView = :numView")
    , @NamedQuery(name = "Images.findByNumLike", query = "SELECT i FROM Images i WHERE i.numLike = :numLike")
    , @NamedQuery(name = "Images.findByLastEdit", query = "SELECT i FROM Images i WHERE i.lastEdit = :lastEdit")
    , @NamedQuery(name = "Images.findByStatus", query = "SELECT i FROM Images i WHERE i.status = :status")
    , @NamedQuery(name = "Images.findByPath", query = "SELECT i FROM Images i WHERE i.path = :path")
    , @NamedQuery(name = "Images.findByTags", query = "SELECT i FROM Images i WHERE i.tags = :tags")})
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Image_ID")
    private Integer imageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Image_name")
    private String imagename;
    @Lob
    @Size(max = 65535)
    @Column(name = "Image_desc")
    private String imagedesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Upload_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploaddate;
    @Size(max = 255)
    @Column(name = "Image_loca")
    private String imageloca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Num_View")
    private int numView;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Num_Like")
    private int numLike;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Last_Edit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastEdit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Path")
    private String path;
    @Size(max = 255)
    @Column(name = "Tags")
    private String tags;
    @JoinColumn(name = "User_ID", referencedColumnName = "User_ID")
    @ManyToOne(optional = false)
    private int userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageID")
    private Collection<Comments> commentsCollection;
    @OneToMany(mappedBy = "imageID")
    private Collection<Likes> likesCollection;

    public Images() {
    }

    public Images(Integer imageID) {
        this.imageID = imageID;
    }

    public Images(Integer imageID, String imagename, Date uploaddate, int numView, int numLike, Date lastEdit, int status, String path) {
        this.imageID = imageID;
        this.imagename = imagename;
        this.uploaddate = uploaddate;
        this.numView = numView;
        this.numLike = numLike;
        this.lastEdit = lastEdit;
        this.status = status;
        this.path = path;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImagedesc() {
        return imagedesc;
    }

    public void setImagedesc(String imagedesc) {
        this.imagedesc = imagedesc;
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public String getImageloca() {
        return imageloca;
    }

    public void setImageloca(String imageloca) {
        this.imageloca = imageloca;
    }

    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public Date getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Date lastEdit) {
        this.lastEdit = lastEdit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @XmlTransient
    public Collection<Likes> getLikesCollection() {
        return likesCollection;
    }

    public void setLikesCollection(Collection<Likes> likesCollection) {
        this.likesCollection = likesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.imageID == null && other.imageID != null) || (this.imageID != null && !this.imageID.equals(other.imageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.creatopia.model.Images[ imageID=" + imageID + " ]";
    }

}
