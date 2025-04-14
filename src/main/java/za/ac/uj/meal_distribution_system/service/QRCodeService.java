package za.ac.uj.meal_distribution_system.service;

import org.springframework.stereotype.Service;
import za.ac.uj.meal_distribution_system.model.QRCode;


@Service
public interface QRCodeService {
    QRCode generateQRCode(String studentNumber);
    QRCode getActiveQRCode(String studentNumber);
    QRCode validateQRCode(String code);
}