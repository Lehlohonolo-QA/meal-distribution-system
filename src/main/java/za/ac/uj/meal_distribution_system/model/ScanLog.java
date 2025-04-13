package za.ac.uj.meal_distribution_system.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "scan_logs")
@Getter
@Setter
public class ScanLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "qr_code_id")
    private QRCode qrCode;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private User staff;

    @Column(nullable = false)
    private String campus;

    @Column(nullable = false)
    private boolean valid;

    @Column(name = "scanned_at", nullable = false)
    private LocalDateTime scannedAt;

    // Additional getters/setters if not using Lombok
    // (Only needed if you're not using @Getter/@Setter annotations)
}