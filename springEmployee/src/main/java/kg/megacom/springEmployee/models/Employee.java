package kg.megacom.springEmployee.models;

import kg.megacom.springEmployee.models.enums.EmployeeStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    String name;

    @OneToOne
    @JoinColumn(name = "id_account")
    Account account;

    @OneToOne
    @JoinColumn (name = "id_position")
    Position position;

    @Column(name = "status")
    EmployeeStatus employeeStatus;

    @Column(name = "add_date")
    Date addDate;

    @Column(name = "updated_date")
    Date updatedDate;


}
