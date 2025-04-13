package za.ac.uj.meal_distribution_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.uj.meal_distribution_system.model.ScanLog;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScanLogRepository extends JpaRepository<ScanLog, Long> {
    Optional<ScanLog> findTopByQrCode_Student_StudentNumberOrderByScannedAtDesc(String studentNumber);
    long countByCampus(String campus);

    List<ScanLog> findTop100ByOrderByScannedAtDesc();
}
