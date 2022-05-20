package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "units_in_stock")
	private short unitsInStcok;
	
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	
	@Column(name = "units_on_order")
	private short unitOnOrder;
	
	@Column(name = "reorder_level")
	private short reorderLevel;
	
	@Column(name = "discontinued")
	private int discontinued;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
	
	

	
	
	
}
