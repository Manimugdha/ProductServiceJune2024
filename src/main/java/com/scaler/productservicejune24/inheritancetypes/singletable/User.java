package com.scaler.productservicejune24.inheritancetypes.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "st_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//is there any way to find out what type of user it is? thats why we add type column in the table
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
