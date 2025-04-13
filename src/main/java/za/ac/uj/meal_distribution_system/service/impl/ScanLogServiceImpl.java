package za.ac.uj.meal_distribution_system.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.uj.meal_distribution_system.model.QRCode;
import za.ac.uj.meal_distribution_system.model.ScanLog;
import za.ac.uj.meal_distribution_system.model.User;
import za.ac.uj.meal_distribution_system.repository.ScanLogRepository;
import za.ac.uj.meal_distribution_system.repository.UserRepository;
import za.ac.uj.meal_distribution_system.service.ScanLogService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ScanLogServiceImpl implements ScanLogService {

    private final ScanLogRepository scanLogRepository;
    private final UserRepository userRepository;

    @Autowired
    public ScanLogServiceImpl(ScanLogRepository scanLogRepository, UserRepository userRepository) {
        this.scanLogRepository = scanLogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ScanLog logScan(QRCode qrCode, String staffUsername, String campus) {
        User staff = userRepository.findByEmail(staffUsername)
                .orElseThrow(() -> new IllegalArgumentException("Staff user not found"));

        ScanLog scanLog = new ScanLog();
        scanLog.setQrCode(qrCode);
        scanLog.setStaff(staff);
        scanLog.setCampus(campus);
        scanLog.setScannedAt(LocalDateTime.now());
        scanLog.setValid(qrCode != null && !qrCode.isUsed());

        if (qrCode != null) {
            qrCode.setUsed(true);
        }

        return scanLogRepository.save(scanLog);
    }

    @Override
    public ScanLog findLatestScanByStudent(String studentNumber) {
        return scanLogRepository.findTopByQrCode_Student_StudentNumberOrderByScannedAtDesc(studentNumber)
                .orElse(null);
    }

    @Override
    public long countScansByCampus(String campus) {
        return scanLogRepository.countByCampus(campus);
    }

    @Override
    public List<ScanLog> findAllRecentScans() {
        return scanLogRepository.findTop100ByOrderByScannedAtDesc();
    }
}
