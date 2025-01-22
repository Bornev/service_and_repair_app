package gb.example.service_and_repair_app.inspection_service.repository;

import gb.example.service_and_repair_app.inspection_service.model.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, Long> {
}