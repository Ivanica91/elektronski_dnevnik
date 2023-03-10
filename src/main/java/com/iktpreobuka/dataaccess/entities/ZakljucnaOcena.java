package com.iktpreobuka.dataaccess.entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ZakljucnaOcena extends Ocena {
		@Id
		@GeneratedValue (strategy = GenerationType.AUTO)
		private long id;
		@Column (name= "Zakljucna_ocena")
		private Integer zakljucnaOcena;

	
		
		
		@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
		@JoinColumn (name= "ucenik_id")
		private Ucenik ucenikZakljucna ;
		
		@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
		@JoinColumn (name= "predmet_id")
		private Predmet zakljucnaPredmet ;
		

		@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
		private List<Ocena> ocenaZakljucivanje = new ArrayList<Ocena>();
		
		
		public ZakljucnaOcena() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ZakljucnaOcena(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste,
				List<Ocena> ocenjivanje, Set<Nastavnik> nastavnici, Ucenik ocenjivanjeUcenika) {
			super(id, ocena, nazivOcene, date, polugodiste, ocenjivanje, nastavnici, ocenjivanjeUcenika);
			// TODO Auto-generated constructor stub
		}


		public ZakljucnaOcena(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste) {
			super(id, ocena, nazivOcene, date, polugodiste);
			// TODO Auto-generated constructor stub
		}
		public ZakljucnaOcena(long id, Integer ocena, NazivOcene nazivOcene, LocalDate date, Polugodiste polugodiste,
				List<Ocena> ocenjivanje) {
			super(id, ocena, nazivOcene, date, polugodiste, ocenjivanje);
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Integer getZakljucnaOcena() {
			return zakljucnaOcena;
		}

		public void setZakljucnaOcena(Integer zakljucnaOcena) {
			this.zakljucnaOcena = zakljucnaOcena;
		}

		public Ucenik getUcenikZakljucna() {
			return ucenikZakljucna;
		}

		public void setUcenikZakljucna(Ucenik ucenikZakljucna) {
			this.ucenikZakljucna = ucenikZakljucna;
		}

		public ZakljucnaOcena(Integer zakljucnaOcena, Ucenik ucenikZakljucna) {
			super();
			this.zakljucnaOcena = zakljucnaOcena;
			this.ucenikZakljucna = ucenikZakljucna;
		}

		public Predmet getZakljucnaPredmet() {
			return zakljucnaPredmet;
		}

		public void setZakljucnaPredmet(Predmet zakljucnaPredmet) {
			this.zakljucnaPredmet = zakljucnaPredmet;
		}

		public ZakljucnaOcena(Integer zakljucnaOcena, Ucenik ucenikZakljucna, Predmet zakljucnaPredmet) {
			super();
			this.zakljucnaOcena = zakljucnaOcena;
			this.ucenikZakljucna = ucenikZakljucna;
			this.zakljucnaPredmet = zakljucnaPredmet;
		}

		public List<Ocena> getOcenaZakljucivanje() {
			return ocenaZakljucivanje;
		}

		public void setOcenaZakljucivanje(List<Ocena> ocenaZakljucivanje) {
			this.ocenaZakljucivanje = ocenaZakljucivanje;
		}

		public ZakljucnaOcena(long id, Integer zakljucnaOcena, Ucenik ucenikZakljucna, Predmet zakljucnaPredmet,
				List<Ocena> ocenaZakljucivanje) {
			super();
			this.id = id;
			this.zakljucnaOcena = zakljucnaOcena;
			this.ucenikZakljucna = ucenikZakljucna;
			this.zakljucnaPredmet = zakljucnaPredmet;
			this.ocenaZakljucivanje = ocenaZakljucivanje;
		}
	
		
}
