package com.project.onlinefooddelivery.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Category_Tb")

public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private int catId;
	
	@NotNull(message="categoryName should be mandatory")
	private String categoryName;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int catId, String categoryName) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
	}
	
	
	
	

}
