package info.deal.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="system")
public class System {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="system_name")
	private String systemName;
	
	@Column(name="description_of_system")
	private String descriptionOfSystem;
	
	@Column(name="description_of_technology")
	private String descriptionOfTechnology;
	
	@Column(name="system_owner")
	private String systemOwner;
	
//	@OneToOne(mappedBy = "deal")
//	private Deal deal;
	
	public System() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getDescriptionOfSystem() {
		return descriptionOfSystem;
	}

	public void setDescriptionOfSystem(String descriptionOfSystem) {
		this.descriptionOfSystem = descriptionOfSystem;
	}

	public String getDescriptionOfTechnology() {
		return descriptionOfTechnology;
	}

	public void setDescriptionOfTechnology(String descriptionOfTechnology) {
		this.descriptionOfTechnology = descriptionOfTechnology;
	}

	public String getSystemOwner() {
		return systemOwner;
	}

	public void setSystemOwner(String systemOwner) {
		this.systemOwner = systemOwner;
	}

	@Override
	public String toString() {
		return "System [id=" + id + ", systemName=" + systemName + ", descriptionOfSystem=" + descriptionOfSystem
				+ ", descriptionOfTechnology=" + descriptionOfTechnology + ", systemOwner=" + systemOwner + "]";
	}

	
}
