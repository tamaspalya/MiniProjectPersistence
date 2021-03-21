package model;

import java.util.ArrayList;
import java.util.List;

public class OrderLine {
	private List<Integer> product_ids;
	private List<Integer> product_amounts;
	
	public OrderLine() {
		product_ids = new ArrayList<Integer>();
		product_amounts = new ArrayList<Integer>();
	}
	
	public OrderLine(ArrayList<Integer> products, ArrayList<Integer> product_amounts) {
		this.product_ids = products;
		this.product_amounts = product_amounts;
	}
	
	public void addProduct(int product_id, int amount) {
		product_ids.add(product_id);
		product_amounts.add(amount);
	}
	
	public List<Integer> getProductIds() {
		return product_ids;
	}
	
	public List<Integer> getProductAmounts() {
		return product_amounts;
	}
	
	public int getProductAmount(int product_id) {
		return product_amounts.get(product_ids.indexOf(product_id));
	}
	
	public void setProductAmount(int product_id, int amount) {
		product_amounts.set(product_ids.indexOf(product_id), amount);
	}

	public int size() {
		return product_ids.size();
	}
	
}
