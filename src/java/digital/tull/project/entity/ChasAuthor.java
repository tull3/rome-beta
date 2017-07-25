/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.tull.project.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author will
 */
@Entity
@Table(name = "chas_author")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChasAuthor.findAll", query = "SELECT c FROM ChasAuthor c")
    , @NamedQuery(name = "ChasAuthor.findByIdauthor", query = "SELECT c FROM ChasAuthor c WHERE c.idauthor = :idauthor")
    , @NamedQuery(name = "ChasAuthor.findByName", query = "SELECT c FROM ChasAuthor c WHERE c.name = :name")
    , @NamedQuery(name = "ChasAuthor.findByDescription", query = "SELECT c FROM ChasAuthor c WHERE c.description = :description")
    , @NamedQuery(name = "ChasAuthor.findByProfilePicture", query = "SELECT c FROM ChasAuthor c WHERE c.profilePicture = :profilePicture")})
public class ChasAuthor implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauthor")
    private Integer idauthor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 40000)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "profile_picture")
    private String profilePicture;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorIdauthor")
    private Collection<ChasArticle> chasArticleCollection;

    public ChasAuthor()
    {
    }

    public ChasAuthor(Integer idauthor)
    {
        this.idauthor = idauthor;
    }

    public ChasAuthor(Integer idauthor, String name)
    {
        this.idauthor = idauthor;
        this.name = name;
    }

    public Integer getIdauthor()
    {
        return idauthor;
    }

    public void setIdauthor(Integer idauthor)
    {
        this.idauthor = idauthor;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getProfilePicture()
    {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture)
    {
        this.profilePicture = profilePicture;
    }

    @XmlTransient
    public Collection<ChasArticle> getChasArticleCollection()
    {
        return chasArticleCollection;
    }

    public void setChasArticleCollection(Collection<ChasArticle> chasArticleCollection)
    {
        this.chasArticleCollection = chasArticleCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idauthor != null ? idauthor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChasAuthor)) {
            return false;
        }
        ChasAuthor other = (ChasAuthor) object;
        if ((this.idauthor == null && other.idauthor != null) || (this.idauthor != null && !this.idauthor.equals(other.idauthor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "digital.tull.project.entity.ChasAuthor[ idauthor=" + idauthor + " ]";
    }
    
}
