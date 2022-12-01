package kg.megacom.springEmployee.repositories;

import kg.megacom.springEmployee.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM tb_account a WHERE a.login= ?1", nativeQuery = true)
    Account findByLoginAndPassword(String login);

    @Query(value = "UPDATE tb_account SET counter = counter + 1", nativeQuery = true)
    void updateCounter();

    @Query(value = "SELECT counter FROM tb_account  WHERE login= ?1", nativeQuery = true)
    Integer checkCounter(String login);
}
