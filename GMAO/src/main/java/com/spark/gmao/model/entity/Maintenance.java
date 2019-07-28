package com.spark.gmao.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MAINTENANCE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_MAINTENANCE", discriminatorType = DiscriminatorType.STRING)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idM;
	
	@Column(name = "DATE_DEBUT", length = 50)
	private Date datedebut;
	
	@Column(name = "DATE_FIN", length = 50)
	private Date datefin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="idConsultant")
	   private Consultant consultant;
	
	@OneToMany(mappedBy = "maintenance", fetch = FetchType.LAZY)
	   private Set<Piece> pieces;
	
	@ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name ="idDiagnostic")
	   private Diagnostic diagnostic;
	
	@OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name ="idFactureInterne")
	  private FactureInterne factureInterne;
	
	@OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name ="idRapport")
	  private Rapport rapport;

}
