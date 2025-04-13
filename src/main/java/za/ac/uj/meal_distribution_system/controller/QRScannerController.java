package za.ac.uj.meal_distribution_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.uj.meal_distribution_system.model.QRCode;
import za.ac.uj.meal_distribution_system.model.ScanLog;
import za.ac.uj.meal_distribution_system.service.QRCodeService;
import za.ac.uj.meal_distribution_system.service.ScanLogService;

@Controller
@RequestMapping("/staff")
public class QRScannerController {

    private final QRCodeService qrCodeService;
    private final ScanLogService scanLogService;

    @Autowired
    public QRScannerController(QRCodeService qrCodeService, ScanLogService scanLogService) {
        this.qrCodeService = qrCodeService;
        this.scanLogService = scanLogService;
    }

    @GetMapping("/scanner")
    public String showScannerPage() {
        return "staff/scanner";
    }

    @PostMapping("/scan")
    public String processQRCode(
            @RequestParam String code,
            @RequestParam String campus,
            Authentication authentication,
            Model model) {

        QRCode qrCode = qrCodeService.validateQRCode(code);
        ScanLog scanLog = scanLogService.logScan(qrCode, authentication.getName(), campus);

        model.addAttribute("scanResult", scanLog);
        model.addAttribute("student", qrCode != null ? qrCode.getStudent() : null);
        model.addAttribute("campus", campus);

        return "staff/scan-result";
    }

    @GetMapping("/scan-history")
    public String viewScanHistory(Model model) {
        model.addAttribute("scans", scanLogService.findAllRecentScans());
        return "staff/scan-history";
    }
}