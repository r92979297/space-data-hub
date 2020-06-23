package com.fafik.spacedatahub;

import com.fafik.spacedatahub.domain.Mission;
import com.fafik.spacedatahub.domain.MissionRepository;
import com.fafik.spacedatahub.domain.Product;
import com.fafik.spacedatahub.domain.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.fafik.spacedatahub.domain.ImageryType.HYPERSPECTRAL;
import static com.fafik.spacedatahub.domain.ImageryType.MULTISPECTRAL;

@Component
public class Bootstrap implements CommandLineRunner {
    public final MissionRepository missionRepository;
    public final ProductRepository productRepository;
    public Bootstrap(MissionRepository missionRepository, ProductRepository productRepository) {
        this.missionRepository = missionRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Mission mission = new Mission("OLA",MULTISPECTRAL)
                .setMissionDateFrom(LocalDateTime.now().minusYears(2))
                .setMissionDateTo(LocalDateTime.now());
        missionRepository.save(mission);

        Mission mission1 =new Mission("AHIK",HYPERSPECTRAL)
                .setMissionDateFrom(LocalDateTime.now().minusYears(1))
                .setMissionDateTo(LocalDateTime.now().plusYears(5));
        missionRepository.save(mission1);

        productRepository.save( new Product(mission,LocalDateTime.now().minusMonths(3))                       .setPrice(new BigDecimal(10))
                        .setUrl("ABCOla1"));
        productRepository.save( new Product(mission,LocalDateTime.now().minusMonths(2))
                        .setPrice(new BigDecimal(100))
                        .setUrl("ABCOla2"));
        productRepository.save( new Product(mission1,LocalDateTime.now().minusMonths(6))
                        .setPrice(new BigDecimal(110))
                        .setUrl("ABCasdas "));
        productRepository.save( new Product(mission1,LocalDateTime.now().minusMonths(3))
                        .setPrice(new BigDecimal(12.50))
                        .setUrl("ABC asda sd"));
        productRepository.save( new Product(mission1,LocalDateTime.now().minusMonths(1))
                        .setPrice(new BigDecimal(1))
                        .setUrl("ABCas das"));

    }
}
