package com.shop.domains;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sections")
public class Section {
	
	@Id
	@Column(name="id")
	@Access(value=AccessType.FIELD)
	private int id;
	
	@Column (name = "section")
	private String section;
	
	@Column (name = "link")
	private String link;

	public Section (String section, String link){
		this.section = section;
		this.link = link;
	}
	
	public Section (String section, String link, int id){
		this.section = section;
		this.link = link;
		this.id = id;
	}
	
	public Section (){		
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getId() {
		return id;
	}	
}
