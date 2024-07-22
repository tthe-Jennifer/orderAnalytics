package doyenify.analytics.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doyenify.analytics.entities.Analytics;
import doyenify.analytics.repository.analyticsRepository;

@Service
public class AnalyticsService {
    @Autowired
    private analyticsRepository analyticsRepository;

    public List<Analytics> getAnalytics(Long productNo) {
        return analyticsRepository.findByProductNo(productNo);
    }


    public BigDecimal getProductPriceByproductNo(Long productNo){
        Analytics priceOfProduct = getAnalytics(productNo).get(0);
        return priceOfProduct.getPrice();
    }

    public BigDecimal getOrderPriceAnalytics(Long productNo ) {
        int sizeOfProduct = getAnalytics(productNo).size();
        BigDecimal priceOfProduct = getProductPriceByproductNo(productNo);
        System.out.println(priceOfProduct);
        BigDecimal totalCost = priceOfProduct.multiply(BigDecimal.valueOf(sizeOfProduct));
        return totalCost;
    }

    public String groupedOrderAnalytics() {
        return "";
    }



    public void savedAnalytics(Analytics analytics) {
        Analytics newAnalytics = new Analytics(
            analytics.getOrderid(),
            analytics.getName(),
            analytics.getPrice(),
            analytics.getProductNo()
        );

        // Stream.of(analytics)
        //     .map(a -> new Analytics(a.getOrderid(), a.getName(), a.getPrice(), a.getProductNo() ))
        //     .findFirst()
        //     .orElseThrow();

        analyticsRepository.saveAndFlush(newAnalytics);
        
    }

}
