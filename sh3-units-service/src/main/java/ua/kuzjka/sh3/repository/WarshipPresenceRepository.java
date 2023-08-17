package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.kuzjka.sh3.model.Warship;
import ua.kuzjka.sh3.model.WarshipPresence;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface WarshipPresenceRepository extends JpaRepository<WarshipPresence, Integer>, PresenceRepository<Warship> {
    @Override
    @Query("select p.warship from WarshipPresence p where p.start <= :year and p.end >= :year")
    List<Warship> findByYear(@Param("year") int year);

    @Override
    @Query("select p.warship from WarshipPresence p where p.nation in :nations")
    List<Warship> findByNations(@Param("nations") List<String> nations);

    @Override
    @Query("select p.warship from WarshipPresence p where p.start <= :year and p.end >= :year and p.nation in :nations")
    List<Warship> findByYearAndNations(@Param("year") int year, @Param("nations") List<String> nations);
}
