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
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "account_name")
    String accountName;
}
