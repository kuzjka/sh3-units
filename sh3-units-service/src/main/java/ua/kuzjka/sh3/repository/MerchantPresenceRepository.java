package ua.kuzjka.sh3.repository;

import org.springframework.stereotype.Repository;
import ua.kuzjka.sh3.model.Merchant;
import ua.kuzjka.sh3.model.MerchantPresence;

@Repository
public interface MerchantPresenceRepository extends PresenceRepository<Merchant, MerchantPresence> {
}
