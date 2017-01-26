package net.sytes.codeline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

/**
 * @author Dusan Nesic
 * Sample entity class mapped to database table
 */
@Entity
@Table(name="demo")
public class Demo {

	private int primarniKljuc;
	private String demoAtribut;
	private double demoDouble;
	private String demoString;

	@Id
	@GeneratedValue
	@Column(name="primarni_kljuc")
	public int getPrimarniKljuc() {
		return primarniKljuc;
	}

	// @JoinColumn(name = "user_id", referencedColumnName = "user_id")
 	// @ManyToOne(cascade = CascadeType.ALL)
	// public MsUser getUserId() {
	// 	return userId;
	// }

	@Column(name="demo_atribut")
	public String getDemoAtribut() {
		return demoAtribut;
	}

	@Column(name="demo_double")
	public double getDemoDouble() {
		return demoDouble;
	}

	@Column(name="demo_string")
	public String getDemoString() {
		return demoString;
	}

	public void setPrimarniKljuc(int primarniKljuc) {
		this.primarniKljuc = primarniKljuc;
	}

	public void setDemoAtribut(String demoAtribut) {
		this.demoAtribut = demoAtribut;
	}

	public void setDemoDouble(double demoDouble) {
		this.demoDouble = demoDouble;
	}

	public void setDemoString(String demoString) {
		this.demoString = demoString;
	}

	@Override
	public String toString() {
		return "Demo objekat " + primarniKljuc + " " + demoAtribut;
	}

}