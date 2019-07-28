package com.spark.gmao.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RAPPORT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rapport implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idR;
	
	@Column(name = "DESCRIPTION", length = 50, nullable = false)
	private String descriptionR;
	
	@OneToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name ="idM")
	  private Maintenance maintenance;

}
