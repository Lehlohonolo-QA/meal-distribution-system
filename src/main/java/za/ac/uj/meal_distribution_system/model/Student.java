package za.ac.uj.meal_distribution_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @Column(name = "student_number", unique = true, nullable = false)
    private String studentNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String gender;

    @Column(name = "student_type")
    private String studentType; // First-Year, Postgraduate, International, etc.

    private boolean approved = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "next_meal_date")
    private Date nextMealDate;

    // Additional methods if needed
    public String getFullName() {
        return firstName + " " + lastName;
    }
}