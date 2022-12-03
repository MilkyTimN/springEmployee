package kg.megacom.springEmployee.models;

import kg.megacom.springEmployee.models.enums.AccountStatus;
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
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "login", unique = true)
    String login;
    @Column(name = "password")
    String password;
    @Column(name = "counter")
    Integer counter;
    @Column(name = "status")
    AccountStatus accountStatus;
    @Column(name = "add_date")
    Date addDate;
    @Column(name = "update_date")
    Date updateDate;
}
