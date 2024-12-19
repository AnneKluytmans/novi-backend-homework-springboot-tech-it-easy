package nl.novi.techiteasy.repositories;

import nl.novi.techiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findByBrandIgnoreCase(String brand);
}

