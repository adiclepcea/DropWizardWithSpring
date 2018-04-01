package clepcea.gestiune.dao;


import clepcea.gestiune.representations.PriceCategory;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface  PriceCategoryDAO extends JpaRepository<PriceCategory, Long>{

}
/*public class PriceCategoryDAO extends AbstractDAO<PriceCategory> {

    @Autowired
    public PriceCategoryDAO(SessionFactory sessionFactory){
        super(sessionFactory);
    }


    @Transactional
    public List<PriceCategory> findAll(){
        return list(namedQuery("clepcea.gestiune.PriceCategory.findAll"));
    }
}
*/
