package com.scaler.productservicejune24.inheritancetypes.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    //what common attribute we need in userclass
    @Id   // this annotation is for identifying the PK
    private Long id;
    private String name;
    private String email;

}
