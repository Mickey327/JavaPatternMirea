package ru.mirea.task15.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.task15.CriteriaManager;
import ru.mirea.task15.Market.Market;
import ru.mirea.task15.Market.MarketRepository;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final MarketRepository marketRepository;
    //private final SessionFactory sessionFactory;
    //private Session session;
    //private CriteriaManager<Product> productCriteriaManager;

    /*
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
        log.info("Product Service session created");
        productCriteriaManager = new CriteriaManager<>();
        productCriteriaManager.setBuilder(session.getCriteriaBuilder());
        productCriteriaManager.setCriteriaQuery(productCriteriaManager.getBuilder().createQuery(Product.class));
        productCriteriaManager.setRoot(productCriteriaManager.getCriteriaQuery().from(Product.class));

    }

     */
    /*
    @Transactional
    public void add(Product product, Long marketId) {
        var transaction = session.beginTransaction();

        Market market = session.get(Market.class, marketId);
        market.getProducts().add(product);
        product.setMarket(market);

        session.saveOrUpdate(market);
        session.saveOrUpdate(product);

        transaction.commit();
        log.info("Product added");
    }

    @Transactional
    public void delete(Long id) {
        session.createQuery("DELETE Product where id = :id").setParameter("id",id);
        log.info("Product with id: " + id + " was deleted");
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        log.info("Get all products using HQL");
        return session.createQuery("select p from Product p",
                Product.class).getResultList();
    }
    */

    @Transactional(readOnly = true)
    public List<Product> getAllUsingRepository(){
        log.info("Get all products using JPA repository");
        return productRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Market getMarketByProductId(Long productId){
        log.info("Get market by product id using JPA repository");
        return productRepository.getById(productId).getMarket();
    }
    @Transactional
    public void add(Product product, Long marketId){
        product.setMarket(marketRepository.getById(marketId));
        productRepository.save(product);
    }
    @Transactional
    public List<Product> getByPrice(Double price){
        return productRepository.findByPrice(price);
    }
    @Transactional
    public void delete(Long id){
        productRepository.deleteById(id);
    }
    /*
    @Transactional(readOnly = true)
    public Market getMarketByProduct(Long productId){
        log.info("Get market by product id using HQL");
        return session.createQuery("select p from Product  p where p.id = :id",Product.class)
                .setParameter("id", productId).getSingleResult().getMarket();

    }
     */
/*
    @Transactional(readOnly = true)
    public List<Product> getListByFieldAscendingOrder(String fieldName){
        log.info("Get products in ascending order by " + fieldName + " field");
        return session.createQuery(productCriteriaManager.getCriteriaQuery()
                .select(productCriteriaManager.getRoot())
                .orderBy(productCriteriaManager.getBuilder()
                        .asc(productCriteriaManager.getRoot().get(fieldName)))).getResultList();

    }


    @PreDestroy
    void shutdown(){
        log.info("Close the session");
        sessionFactory.close();
    }

 */


}
