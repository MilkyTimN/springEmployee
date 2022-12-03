package kg.megacom.springEmployee.models;

import kg.megacom.springEmployee.models.enums.AccountStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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





}
