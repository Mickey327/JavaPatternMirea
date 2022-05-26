package ru.mirea.task15.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mirea.task15.Market.MarketRepository;
import ru.mirea.task15.Product.ProductRepository;
import ru.mirea.task15.Scheduler.SchedulerService;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

@Service
@ManagedResource
public class DefaultSchedulerService implements SchedulerService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MarketRepository marketRepository;

    @Scheduled(fixedRate = 1800000)
    @ManagedOperation
    public void rewriteFiles() throws URISyntaxException, IOException {
        File directory = new File(getClass().getResource("/EntityInfo").toURI().getPath());
        for (File file:directory.listFiles()){
            if (!file.isDirectory()){
                file.delete();
            }
        }
        File productFile = new File(getClass().getResource("/EntityInfo").getFile() + "/products.txt");
        PrintWriter printWriterProduct = new PrintWriter(productFile);
        System.out.println("Write to product");
        printWriterProduct.write(productRepository.findAll().toString());
        printWriterProduct.flush();
        File marketFile = new File(getClass().getResource("/EntityInfo").getFile() + "/markets.txt");
        PrintWriter printWriterMarket = new PrintWriter(marketFile);
        System.out.println("Write to market");
        printWriterMarket.write(marketRepository.findAll().toString());
        printWriterMarket.flush();

    }
}
