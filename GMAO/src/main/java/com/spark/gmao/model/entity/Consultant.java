package com.spark.gmao.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONSULTANT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultant implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConsultant;
	
	@Column(name = "CIN", length = 50, nullable = false)
	private String cin;
	
	@Column(name = "NAME", length = 50, nullable = false)
	 private String nom;
	
	 @Column(name = "PRENOM", length = 50, nullable = false)
	 private String prenom;
	 
	 @Column(name = "PHONE", length = 50, nullable = false)
	 private Integer telephone;
	 
	 @Column(name = "ADRESS", length = 50, nullable = false)
	 private String adresse;
	 
	 @Column(name = "E_MAIL", length = 50, nullable = false)
	 private String email;
	 
	 @OneToMany(mappedBy = "consultant", fetch = FetchType.LAZY)
	   private Set<Diagnostic> diagnostics;
	 
	 @OneToMany(mappedBy = "consultant", fetch = FetchType.LAZY)
	   private Set<Maintenance> maintenances;
}
