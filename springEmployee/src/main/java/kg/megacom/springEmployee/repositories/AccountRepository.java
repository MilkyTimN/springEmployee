package kg.megacom.springEmployee.repositories;

import kg.megacom.springEmployee.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
