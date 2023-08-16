package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kuzjka.sh3.model.UBoat;

@Repository
public interface UBoatRepository extends JpaRepository<UBoat, Integer> {
}
