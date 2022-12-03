package kg.megacom.springEmployee.repositories;

import kg.megacom.springEmployee.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM tb_account a WHERE a.login =?1", nativeQuery = true)
    Account findByLogin(String login);
}
