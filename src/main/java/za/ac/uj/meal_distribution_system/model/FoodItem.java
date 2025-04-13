package za.ac.uj.meal_distribution_system.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.function.Supplier;

@Entity
@Table(name = "food_items")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int quantity;
    private String unit;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // Getters and Setters
}