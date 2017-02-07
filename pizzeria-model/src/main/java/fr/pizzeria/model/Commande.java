package fr.pizzeria.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "id_client")
	private Client clientId;

	@OneToOne
	@JoinColumn(name = "id_livreur")
	private Livreur livreurId;

	@Column(name = "total", nullable = false)
	private BigDecimal total;

	@Enumerated(EnumType.STRING)
	private Statut statut;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;
	
	@ManyToMany
	@JoinTable(name = "commande_entree", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "entree_id", referencedColumnName = "id"))
	private List<Entree> entrees;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizzas;
	
	@ManyToMany
	@JoinTable(name = "commande_boisson", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "boisson_id", referencedColumnName = "id"))
	private List<Boisson> boissons;
	
	@ManyToMany
	@JoinTable(name = "commande_dessert", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "dessert_id", referencedColumnName = "id"))
	private List<Dessert> desserts;
	
	
	public Commande() {
		
	}

	public Commande(Client idClient, Livreur idLivreur, BigDecimal total, Statut statut, Date date,
            List<Pizza> pizzas) {
        super();
        this.clientId = idClient;
        this.livreurId = idLivreur;
        this.total = total;
        this.statut = statut;
        this.date = date;
        this.pizzas = pizzas;
    }

	public Commande(Client idClient, Livreur idLivreur, BigDecimal total, Statut statut, Date date,
			List<Pizza> pizzas, List<Boisson> boissons, List<Dessert> desserts, List<Entree> entrees) {
		super();
		this.clientId = idClient;
		this.livreurId = idLivreur;
		this.total = total;
		this.statut = statut;
		this.date = date;
		this.pizzas = pizzas;
		this.boissons = boissons;
		this.entrees = entrees;
		this.desserts = desserts;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the clientId
	 */
	public Client getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the livreurId
	 */
	public Livreur getLivreurId() {
		return livreurId;
	}

	/**
	 * @param livreurId
	 *            the livreurId to set
	 */
	public void setLivreurId(Livreur livreurId) {
		this.livreurId = livreurId;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the statut
	 */
	public Statut getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the pizzas
	 */
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	/**
	 * @param pizzas
	 *            the pizzas to set
	 */
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public List<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(List<Entree> entrees) {
		this.entrees = entrees;
	}

	public List<Boisson> getBoissons() {
		return boissons;
	}

	public void setBoissons(List<Boisson> boissons) {
		this.boissons = boissons;
	}

	public List<Dessert> getDesserts() {
		return desserts;
	}

	public void setDesserts(List<Dessert> dessert) {
		this.desserts = desserts;
	}
	
	
}
