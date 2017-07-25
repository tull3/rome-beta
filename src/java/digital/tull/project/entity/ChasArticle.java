/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.tull.project.entity;

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
 * @author will
 */
@Entity
@Table(name = "chas_article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChasArticle.findAll", query = "SELECT c FROM ChasArticle c")
    , @NamedQuery(name = "ChasArticle.findByIdarticle", query = "SELECT c FROM ChasArticle c WHERE c.idarticle = :idarticle")
    , @NamedQuery(name = "ChasArticle.findByArticleTitle", query = "SELECT c FROM ChasArticle c WHERE c.articleTitle = :articleTitle")
    , @NamedQuery(name = "ChasArticle.findByArticleText1", query = "SELECT c FROM ChasArticle c WHERE c.articleText1 = :articleText1")
    , @NamedQuery(name = "ChasArticle.findByArticleText2", query = "SELECT c FROM ChasArticle c WHERE c.articleText2 = :articleText2")
    , @NamedQuery(name = "ChasArticle.findByArticleText3", query = "SELECT c FROM ChasArticle c WHERE c.articleText3 = :articleText3")
    , @NamedQuery(name = "ChasArticle.findByQuoteText", query = "SELECT c FROM ChasArticle c WHERE c.quoteText = :quoteText")
    , @NamedQuery(name = "ChasArticle.findByQuoteSource", query = "SELECT c FROM ChasArticle c WHERE c.quoteSource = :quoteSource")
    , @NamedQuery(name = "ChasArticle.findByArticleDate", query = "SELECT c FROM ChasArticle c WHERE c.articleDate = :articleDate")
    , @NamedQuery(name = "ChasArticle.findByLastUpdate", query = "SELECT c FROM ChasArticle c WHERE c.lastUpdate = :lastUpdate")})
public class ChasArticle implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarticle")
    private Integer idarticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "article_title")
    private String articleTitle;
    @Size(max = 29000)
    @Column(name = "article_text1")
    private String articleText1;
    @Size(max = 15000)
    @Column(name = "article_text2")
    private String articleText2;
    @Size(max = 15000)
    @Column(name = "article_text3")
    private String articleText3;
    @Size(max = 255)
    @Column(name = "quote_text")
    private String quoteText;
    @Size(max = 45)
    @Column(name = "quote_source")
    private String quoteSource;
    @Basic(optional = false)
    @NotNull
    @Column(name = "article_date")
    @Temporal(TemporalType.DATE)
    private Date articleDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chasArticleIdarticle")
    private Collection<ChasPictures> chasPicturesCollection;
    @JoinColumn(name = "author_idauthor", referencedColumnName = "idauthor")
    @ManyToOne(optional = false)
    private ChasAuthor authorIdauthor;

    public ChasArticle()
    {
    }

    public ChasArticle(Integer idarticle)
    {
        this.idarticle = idarticle;
    }

    public ChasArticle(Integer idarticle, String articleTitle, Date articleDate, Date lastUpdate)
    {
        this.idarticle = idarticle;
        this.articleTitle = articleTitle;
        this.articleDate = articleDate;
        this.lastUpdate = lastUpdate;
    }

    public Integer getIdarticle()
    {
        return idarticle;
    }

    public void setIdarticle(Integer idarticle)
    {
        this.idarticle = idarticle;
    }

    public String getArticleTitle()
    {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle)
    {
        this.articleTitle = articleTitle;
    }

    public String getArticleText1()
    {
        return articleText1;
    }

    public void setArticleText1(String articleText1)
    {
        this.articleText1 = articleText1;
    }

    public String getArticleText2()
    {
        return articleText2;
    }

    public void setArticleText2(String articleText2)
    {
        this.articleText2 = articleText2;
    }

    public String getArticleText3()
    {
        return articleText3;
    }

    public void setArticleText3(String articleText3)
    {
        this.articleText3 = articleText3;
    }

    public String getQuoteText()
    {
        return quoteText;
    }

    public void setQuoteText(String quoteText)
    {
        this.quoteText = quoteText;
    }

    public String getQuoteSource()
    {
        return quoteSource;
    }

    public void setQuoteSource(String quoteSource)
    {
        this.quoteSource = quoteSource;
    }

    public Date getArticleDate()
    {
        return articleDate;
    }

    public void setArticleDate(Date articleDate)
    {
        this.articleDate = articleDate;
    }

    public Date getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }

    @XmlTransient
    public Collection<ChasPictures> getChasPicturesCollection()
    {
        return chasPicturesCollection;
    }

    public void setChasPicturesCollection(Collection<ChasPictures> chasPicturesCollection)
    {
        this.chasPicturesCollection = chasPicturesCollection;
    }

    public ChasAuthor getAuthorIdauthor()
    {
        return authorIdauthor;
    }

    public void setAuthorIdauthor(ChasAuthor authorIdauthor)
    {
        this.authorIdauthor = authorIdauthor;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idarticle != null ? idarticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChasArticle)) {
            return false;
        }
        ChasArticle other = (ChasArticle) object;
        if ((this.idarticle == null && other.idarticle != null) || (this.idarticle != null && !this.idarticle.equals(other.idarticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "digital.tull.project.entity.ChasArticle[ idarticle=" + idarticle + " ]";
    }
    
}
