package doyenify.analytics.api;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import doyenify.analytics.entities.Analytics;
import doyenify.analytics.services.AnalyticsService;

@RestController
public class analyticsController{
    @Autowired
    private AnalyticsService analyticsService;


    @GetMapping("/analytics/{productNo}")
        public List<Analytics> getAnalytics(@PathVariable Long productNo) {
        return analyticsService.getAnalytics(productNo);
    }

    @GetMapping("/analytics/prices/{productNo}")
    public BigDecimal getOrderPriceAnalytics(@PathVariable Long productNo) {
        return analyticsService.getOrderPriceAnalytics(productNo);
    }
    

    @PostMapping("/analytics")
    public void savedAnalytics(@RequestBody Analytics analytics) {
        
        analyticsService.savedAnalytics(analytics);
    }
    
}

