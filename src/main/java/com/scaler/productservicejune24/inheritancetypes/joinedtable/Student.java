package com.scaler.productservicejune24.inheritancetypes.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_students ")//it's optional to put name of the table , automatically it would create the class name only.
@PrimaryKeyJoinColumn(name = "user_id")//its linked to joined table, we have to define the FK value/constraint with the parent class
public class Student extends User{
    private String batch;
}
