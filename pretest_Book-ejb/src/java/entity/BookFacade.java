package entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {
    @PersistenceContext(unitName = "pretest_Book-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }

    @Override
    public List<Book> findByPrice(int from, int to) {
        Query q = em.createQuery("SELECT b FROM Book b WHERE b.price >= :from AND b.price <=:to");
        q.setParameter("from", from);
        q.setParameter("to", to);
        List<Book> lsBook = q.getResultList();
        return lsBook;
        
    }

}
