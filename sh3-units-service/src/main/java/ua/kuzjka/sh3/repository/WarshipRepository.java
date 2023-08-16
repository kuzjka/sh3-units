package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kuzjka.sh3.model.Warship;

@Repository
public interface WarshipRepository extends JpaRepository<Warship, Integer> {
}
