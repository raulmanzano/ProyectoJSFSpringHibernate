package com.journaldev.springhibernate.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
//import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//import org.hibernate.annotations.NamedQuery;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@Table(name="cuenta")
@ManagedBean(name="cuenta")


@NamedQueries({
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c"),
@NamedQuery(name = "Cuenta_getByIdPerson",query = "select c from Cuenta c where id_person = :id_person")})


public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String numerocuenta;
	private Person person;

	public Cuenta() {
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(length=2147483647)
	public String getNumerocuenta() {
		return this.numerocuenta;
	}

	public void setNumerocuenta(String numerocuenta) {
		this.numerocuenta = numerocuenta;
	}


	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="id_person")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}