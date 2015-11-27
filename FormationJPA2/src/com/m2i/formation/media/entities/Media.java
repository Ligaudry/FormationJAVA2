package com.m2i.formation.media.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the media database table.
 * 
 */
@Entity
@NamedQuery(name="Media.findAll", query="SELECT m FROM Media m")
public class Media implements IEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer category;

	@Temporal(TemporalType.DATE)
	private Date dateSortie;

	private Integer id_Publisher;

	private String isbn;

	private String lang;

	private Integer nbPage;

	private Integer nbTrack;

	private float price;

	private String title;

	private Integer type;

	//bi-directional many-to-many association to Author
	@ManyToMany
	@JoinTable(
		name="mediaauthor"
		, joinColumns={
			@JoinColumn(name="id_Media")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id")
			}
		)
	private List<Author> authors;

	//bi-directional many-to-one association to Page
	@OneToMany(mappedBy="media")
	private List<Page> pages;

	public Media() {
		this.setTitle("les aventures de toto");
		this.setPrice(15);
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Date getDateSortie() {
		return this.dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Integer getId_Publisher() {
		return this.id_Publisher;
	}

	public void setId_Publisher(Integer id_Publisher) {
		this.id_Publisher = id_Publisher;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Integer getNbPage() {
		return this.nbPage;
	}

	public void setNbPage(Integer nbPage) {
		this.nbPage = nbPage;
	}

	public Integer getNbTrack() {
		return this.nbTrack;
	}

	public void setNbTrack(Integer nbTrack) {
		this.nbTrack = nbTrack;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Page> getPages() {
		return this.pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public Page addPage(Page page) {
		getPages().add(page);
		page.setMedia(this);

		return page;
	}

	public Page removePage(Page page) {
		getPages().remove(page);
		page.setMedia(null);

		return page;
	}

	

}