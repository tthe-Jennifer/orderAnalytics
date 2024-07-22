package doyenify.analytics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import doyenify.analytics.entities.Analytics;

public interface analyticsRepository extends JpaRepository<Analytics, Long> {

   List<Analytics> findByProductNo(Long productNo);

   Analytics findByOrderId(Long orderId);

   List<Analytics> findByname(String name);


}
