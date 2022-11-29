package kg.megacom.springEmployee.repositories;

import kg.megacom.springEmployee.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
