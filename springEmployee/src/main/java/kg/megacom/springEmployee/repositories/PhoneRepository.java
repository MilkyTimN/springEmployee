package kg.megacom.springEmployee.repositories;

import kg.megacom.springEmployee.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
