package ua.kuzjka.sh3.repository;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PresenceRepository<T> {
    List<T> findByYear(@Param("year") int year);

    List<T> findByNations(@Param("nations") List<String> nations);

    List<T> findByYearAndNations(@Param("year") int year, @Param("nations") List<String> nations);
}
