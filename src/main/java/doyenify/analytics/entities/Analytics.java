package doyenify.analytics.entities;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name="analytics")

public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long orderId;
    private String name;
    private BigDecimal price;
    private Long productNo;

    public Analytics(Long orderId, String name, BigDecimal price, Long productNo) {
        this.orderId = orderId;
        this.name = name;
        this.productNo = productNo;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getProductNo() {
        return productNo;
    }
    public Long getOrderid() {
        return orderId;
    }

    public void setOrderid(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }

    public Analytics() {
    }
}
