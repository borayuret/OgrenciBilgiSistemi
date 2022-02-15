package tr.gov.ua.obs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.ua.obs.entity.Ogrenci;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {
}
