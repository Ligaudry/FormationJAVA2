package com.m2i.formation.media.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the page database table.
 * 
 */
@Entity
@NamedQuery(name="Page.findAll", query="SELECT p FROM Page p")
public class Page implements IEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Media
	@ManyToOne
	@JoinColumn(name="id_Media")
	private Media media;

	public Page() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}

}