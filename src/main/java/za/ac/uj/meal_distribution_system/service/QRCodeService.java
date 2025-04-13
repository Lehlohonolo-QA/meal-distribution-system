package za.ac.uj.meal_distribution_system.service;

import za.ac.uj.meal_distribution_system.model.QRCode;



public interface QRCodeService {
    QRCode generateQRCode(String studentNumber);
    QRCode getActiveQRCode(String studentNumber);
    QRCode validateQRCode(String code);
}