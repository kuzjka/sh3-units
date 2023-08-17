package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.kuzjka.sh3.model.Presence;

import java.util.List;

public interface PresenceRepository<T, P extends Presence<T>> extends JpaRepository<P, Integer> {
    @Query("select p.unit from #{#entityName} p where p.start <= :year and p.end >= :year")
    List<T> findByYear(@Param("year") int year);

    @Query("select p.unit from #{#entityName} p where p.nation in :nations")
    List<T> findByNations(@Param("nations") List<String> nations);

    @Query("select p.unit from #{#entityName} p where p.start <= :year and p.end >= :year and p.nation in :nations")
    List<T> findByYearAndNations(@Param("year") int year, @Param("nations") List<String> nations);
}
