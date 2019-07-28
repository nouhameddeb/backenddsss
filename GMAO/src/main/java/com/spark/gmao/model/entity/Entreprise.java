package com.spark.gmao.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ENTREPRISE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEntrp;

	@Column(name = "NAME", length = 50, nullable = false)
	 private String nomEntrp;
	
	 @Column(name = "PHONE", length = 50, nullable = false)
	 private String telEntrp;
	 
	 @Column(name = "ADRESS", length = 50, nullable = false)
	 private String adresseEntrp;
	 
	public void setIdEntreprise(long idEntrp) {
		// TODO Auto-generated method stub
	}

}
