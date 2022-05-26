package ru.mirea.task15.Market;

import lombok.Getter;
import lombok.Setter;
import ru.mirea.task15.Product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "markets")
@Getter
@Setter
public class Market {
    @Id
    @SequenceGenerator(name = "markets_seq", sequenceName =
            "markets_sequence", allocationSize = 1)
    @GeneratedValue(generator = "markets_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "market")
    private List<Product> products;

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
