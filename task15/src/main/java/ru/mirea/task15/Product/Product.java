package ru.mirea.task15.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import ru.mirea.task15.Market.Market;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @Id
    @SequenceGenerator(name = "products_seq", sequenceName =
            "products_sequence", allocationSize = 1)
    @GeneratedValue(generator = "products_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name="market_id", nullable=false)
    @JsonIgnore
    private Market market;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
