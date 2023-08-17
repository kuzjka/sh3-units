package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.kuzjka.sh3.model.Aircraft;
import ua.kuzjka.sh3.model.AircraftPresence;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface AircraftPresenceRepository extends JpaRepository<AircraftPresence, Integer>, PresenceRepository<Aircraft> {
    @Override
    @Query("select p.aircraft from AircraftPresence p where p.start <= :year and p.end >= :year")
    List<Aircraft> findByYear(@Param("year") int year);

    @Override
    @Query("select p.aircraft from AircraftPresence p where p.nation in :nations")
    List<Aircraft> findByNations(@Param("nations") List<String> nations);

    @Override
    @Query("select p.aircraft from AircraftPresence p where p.start <= :year and p.end >= :year and p.nation in :nations")
    List<Aircraft> findByYearAndNations(@Param("year") int year, @Param("nations") List<String> nations);
}
