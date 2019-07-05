package com.eksad.latihanrest.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@DiscriminatorValue("Cashier")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class Cashier extends Person {

	private String shift;
}
