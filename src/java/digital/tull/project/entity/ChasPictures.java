/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.tull.project.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author will
 */
@Entity
@Table(name = "chas_pictures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChasPictures.findAll", query = "SELECT c FROM ChasPictures c")
    , @NamedQuery(name = "ChasPictures.findByIdchasPictures", query = "SELECT c FROM ChasPictures c WHERE c.idchasPictures = :idchasPictures")
    , @NamedQuery(name = "ChasPictures.findByPictureName", query = "SELECT c FROM ChasPictures c WHERE c.pictureName = :pictureName")
    , @NamedQuery(name = "ChasPictures.findByPictureDescription", query = "SELECT c FROM ChasPictures c WHERE c.pictureDescription = :pictureDescription")})
public class ChasPictures implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchas_pictures")
    private Integer idchasPictures;
    @Size(max = 45)
    @Column(name = "picture_name")
    private String pictureName;
    @Size(max = 255)
    @Column(name = "picture_description")
    private String pictureDescription;
    @JoinColumn(name = "chas_article_idarticle", referencedColumnName = "idarticle")
    @ManyToOne(optional = false)
    private ChasArticle chasArticleIdarticle;

    public ChasPictures()
    {
    }

    public ChasPictures(Integer idchasPictures)
    {
        this.idchasPictures = idchasPictures;
    }

    public Integer getIdchasPictures()
    {
        return idchasPictures;
    }

    public void setIdchasPictures(Integer idchasPictures)
    {
        this.idchasPictures = idchasPictures;
    }

    public String getPictureName()
    {
        return pictureName;
    }

    public void setPictureName(String pictureName)
    {
        this.pictureName = pictureName;
    }

    public String getPictureDescription()
    {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription)
    {
        this.pictureDescription = pictureDescription;
    }

    public ChasArticle getChasArticleIdarticle()
    {
        return chasArticleIdarticle;
    }

    public void setChasArticleIdarticle(ChasArticle chasArticleIdarticle)
    {
        this.chasArticleIdarticle = chasArticleIdarticle;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idchasPictures != null ? idchasPictures.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChasPictures)) {
            return false;
        }
        ChasPictures other = (ChasPictures) object;
        if ((this.idchasPictures == null && other.idchasPictures != null) || (this.idchasPictures != null && !this.idchasPictures.equals(other.idchasPictures))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "digital.tull.project.entity.ChasPictures[ idchasPictures=" + idchasPictures + " ]";
    }
    
}
