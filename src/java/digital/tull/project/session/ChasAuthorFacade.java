/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital.tull.project.session;

import digital.tull.project.entity.ChasAuthor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author will
 */
@Stateless
public class ChasAuthorFacade extends AbstractFacade<ChasAuthor>
{

    @PersistenceContext(unitName = "Rome-betaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public ChasAuthorFacade()
    {
        super(ChasAuthor.class);
    }
    
}
