package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.kuzjka.sh3.model.Merchant;
import ua.kuzjka.sh3.model.MerchantPresence;
import ua.kuzjka.sh3.model.Nation;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface MerchantPresenceRepository extends JpaRepository<MerchantPresence, Integer>, PresenceRepository<Merchant> {
    @Override
    @Query("select p.merchant from MerchantPresence p where p.start <= :year and p.end >= :year")
    List<Merchant> findByYear(@Param("year") int year);

    @Override
    @Query("select p.merchant from MerchantPresence p where p.nation.name in :nations")
    List<Merchant> findByNations(@Param("nations") List<String> nations);

    @Override
    @Query("select p.merchant from MerchantPresence p where p.start <= :year and p.end >= :year and p.nation.name in :nations")
    List<Merchant> findByYearAndNations(@Param("year") int year, @Param("nations") List<String> nations);

    void deleteAllByNation(Nation nation);
}
