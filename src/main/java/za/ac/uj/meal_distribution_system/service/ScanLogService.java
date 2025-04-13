package za.ac.uj.meal_distribution_system.service;

import za.ac.uj.meal_distribution_system.model.QRCode;
import za.ac.uj.meal_distribution_system.model.ScanLog;

import java.util.List;

public interface ScanLogService {
    ScanLog logScan(QRCode qrCode, String staffUsername, String campus);
    ScanLog findLatestScanByStudent(String studentNumber);
    long countScansByCampus(String campus);

    List<ScanLog> findAllRecentScans();
}