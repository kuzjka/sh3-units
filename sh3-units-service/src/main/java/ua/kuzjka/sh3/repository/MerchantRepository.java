package ua.kuzjka.sh3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kuzjka.sh3.model.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
}
