package com.qa.stardewproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Villager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int birthDay;

	private String birthSeason;

	private String faveItem;

	private String leastFaveItem;

	public Villager() {
		super();
	}

	public Villager(Long id, String name, int birthDay, String birthSeason, String faveItem, String leastFaveItem) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.birthSeason = birthSeason;
		this.faveItem = faveItem;
		this.leastFaveItem = leastFaveItem;
	}

	public Villager(String name, int birthDay, String birthSeason, String faveItem, String leastFaveItem) {
		super();
		this.name = name;
		this.birthDay = birthDay;
		this.birthSeason = birthSeason;
		this.faveItem = faveItem;
		this.leastFaveItem = leastFaveItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public String getBirthSeason() {
		return birthSeason;
	}

	public void setBirthSeason(String birthSeason) {
		this.birthSeason = birthSeason;
	}

	public String getFaveItem() {
		return faveItem;
	}

	public void setFaveItem(String faveItem) {
		this.faveItem = faveItem;
	}

	public String getLeastFaveItem() {
		return leastFaveItem;
	}

	public void setLeastFaveItem(String leastFaveItem) {
		this.leastFaveItem = leastFaveItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birthDay;
		result = prime * result + ((birthSeason == null) ? 0 : birthSeason.hashCode());
		result = prime * result + ((faveItem == null) ? 0 : faveItem.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((leastFaveItem == null) ? 0 : leastFaveItem.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Villager other = (Villager) obj;
		if (birthDay != other.birthDay)
			return false;
		if (birthSeason == null) {
			if (other.birthSeason != null)
				return false;
		} else if (!birthSeason.equals(other.birthSeason))
			return false;
		if (faveItem == null) {
			if (other.faveItem != null)
				return false;
		} else if (!faveItem.equals(other.faveItem))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leastFaveItem == null) {
			if (other.leastFaveItem != null)
				return false;
		} else if (!leastFaveItem.equals(other.leastFaveItem))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Villager [id=" + id + ", name=" + name + ", birthDay=" + birthDay + ", birthSeason=" + birthSeason
				+ ", faveItem=" + faveItem + ", leastFaveItem=" + leastFaveItem + "]";
	}

}
