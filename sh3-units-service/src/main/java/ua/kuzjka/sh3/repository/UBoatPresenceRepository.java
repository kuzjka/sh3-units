package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.kuzjka.sh3.model.Nation;
import ua.kuzjka.sh3.model.UBoat;
import ua.kuzjka.sh3.model.UBoatPresence;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface UBoatPresenceRepository extends JpaRepository<UBoatPresence, Integer>, PresenceRepository<UBoat> {
    @Override
    @Query("select p.uboat from UBoatPresence p where p.start <= :year and p.end >= :year")
    List<UBoat> findByYear(@Param("year") int year);

    @Override
    @Query("select p.uboat from UBoatPresence p where p.nation.name in :nations")
    List<UBoat> findByNations(@Param("nations") List<String> nations);

    @Override
    @Query("select p.uboat from UBoatPresence p where p.start <= :year and p.end >= :year and p.nation.name in :nations")
    List<UBoat> findByYearAndNations(@Param("year") int year, @Param("nations") List<String> nations);

    void deleteAllByNation(Nation nation);
}
