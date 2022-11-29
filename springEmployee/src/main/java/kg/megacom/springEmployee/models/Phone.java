package kg.megacom.springEmployee.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "phone_number")
    String phoneNumber;

    @OneToMany
    @Column(name = "id_employee")
    Employee employee;
}
