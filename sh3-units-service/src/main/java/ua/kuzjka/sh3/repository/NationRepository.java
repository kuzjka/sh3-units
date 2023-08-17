package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kuzjka.sh3.model.Nation;

import java.util.List;

@Repository
public interface NationRepository extends JpaRepository<Nation, Integer> {
    List<Nation> findAllByOrderByNameAsc();
}
