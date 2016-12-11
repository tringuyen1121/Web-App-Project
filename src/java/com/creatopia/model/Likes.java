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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author A
 */
@Entity
@Table(name = "likes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Likes.findAll", query = "SELECT l FROM Likes l")
    , @NamedQuery(name = "Likes.findByLikeID", query = "SELECT l FROM Likes l WHERE l.likeID = :likeID")})
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Like_ID")
    private Integer likeID;
    @JoinColumn(name = "Image_ID", referencedColumnName = "Image_ID")
    @ManyToOne
    private Images imageID;
    @JoinColumn(name = "User_ID", referencedColumnName = "User_ID")
    @ManyToOne
    private Users userID;

    public Likes() {
    }

    public Likes(Integer likeID) {
        this.likeID = likeID;
    }

    public Integer getLikeID() {
        return likeID;
    }

    public void setLikeID(Integer likeID) {
        this.likeID = likeID;
    }

    public Images getImageID() {
        return imageID;
    }

    public void setImageID(Images imageID) {
        this.imageID = imageID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (likeID != null ? likeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Likes)) {
            return false;
        }
        Likes other = (Likes) object;
        if ((this.likeID == null && other.likeID != null) || (this.likeID != null && !this.likeID.equals(other.likeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.creatopia.model.Likes[ likeID=" + likeID + " ]";
    }

}
