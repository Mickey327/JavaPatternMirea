package ru.mirea.task15.Market;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.task15.CriteriaManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketService {
    private final MarketRepository marketRepository;
    //private final SessionFactory sessionFactory;
    //private Session session;
    //private CriteriaManager<Market> marketCriteriaManager;


    /*
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
        log.info("Market Service session created");
        marketCriteriaManager = new CriteriaManager<>();
        marketCriteriaManager.setBuilder(session.getCriteriaBuilder());
        marketCriteriaManager.setCriteriaQuery(marketCriteriaManager.getBuilder().createQuery(Market.class));
        marketCriteriaManager.setRoot(marketCriteriaManager.getCriteriaQuery().from(Market.class));


    }
    */

    /*
    @Transactional
    public void add(Market market) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(market);
        transaction.commit();
        log.info("Market added");
    }
    */

    /*
    @Transactional
    public void delete(Long id) {
        session.createQuery("DELETE Market where id = :id").setParameter("id",id);
        log.info("Market with id: " + id + " was deleted");
    }
    */

    /*
    @Transactional(readOnly = true)
    public List<Market> getAll() {
        log.info("Get all markets using HQL");
        return session.createQuery("select m from Market m",
                Market.class).getResultList();
    }
    */
    @Transactional
    public void add(Market market){
        marketRepository.save(market);
    }
    public void delete(Long marketId){
        marketRepository.deleteById(marketId);
    }
    @Transactional(readOnly = true)
    public List<Market> getAllUsingRepository(){
        log.info("Get all markets using JPA repository");
        return marketRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Market getMarketById(Long marketId){
        log.info("Get market by id using JPA repository");
        return marketRepository.getById(marketId);
    }
    /*
    @Transactional(readOnly = true)
    public List<Market> getListByFieldAscendingOrder(String fieldName){
        log.info("Get markets in ascending order by " + fieldName + " field");
        return session.createQuery(marketCriteriaManager.getCriteriaQuery()
                .select(marketCriteriaManager.getRoot())
                .orderBy(marketCriteriaManager.getBuilder()
                        .asc(marketCriteriaManager.getRoot().get(fieldName)))).getResultList();

    }
    */

    /*
    @PreDestroy
    void shutdown(){
        log.info("Close the session");
        sessionFactory.close();
    }
    */

}
