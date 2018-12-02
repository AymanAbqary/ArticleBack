package org.ap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String text;
	private String img;
	public Article() {
		super();
	}
	public Article(String nom, String text, String img) {
		super();
		this.nom = nom;
		this.text = text;
		this.img = img;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
