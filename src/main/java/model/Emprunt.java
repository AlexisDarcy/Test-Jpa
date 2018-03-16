/**
 * 
 */
package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alexis Darcy
 *
 */
@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
	
	/**id : int*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**dateDebut : LocalDateTime*/
	@Column(name = "DATE_DEBUT")
	private LocalDateTime dateDebut;
	/**dateFin : LocalDateTime*/
	@Column(name = "DATE_FIN")
	private LocalDateTime dateFin;
	/**delai : int*/
	@Column(name = "DELAI")
	private int delai;
	/**client : Client*/
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	/**livres : List<Livre>*/
	@ManyToMany
	@JoinTable(name="COMPO", 
		joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"))
	private List<Livre> livres;

	/** Constructeur
	 * 
	 */
	public Emprunt() {
		
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the dateDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Getter
	 * @return the dateFin
	 */
	public LocalDateTime getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/** Setter
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	/** Getter
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/** Setter
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/** Getter
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
	}

	/** Setter
	 * @param livres the livres to set
	 */
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ ", client=" + client + "]";
	}

}
