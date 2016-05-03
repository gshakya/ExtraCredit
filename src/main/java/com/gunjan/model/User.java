package com.gunjan.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("User")
public class User extends Person {
	
	

}
