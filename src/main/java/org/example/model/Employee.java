package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "employee")
public class Employee {
    @Id
    public Integer id;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "middle_name")
    public String middleName;
    @Column(name = "last_name")
    public String lastName;
    public String email;
    public Long phone;
    public Integer pin;
    public Long balance;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", pin=" + pin +
                ", balance=" + balance +
                '}';
    }
}
