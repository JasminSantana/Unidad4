package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="bills")
public class Bill implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_bill;
	@Temporal(TemporalType.DATE)
	@Column (name="delivery_date")
	private Date deliveryDate;
	@Column (name="client_code", length=5)
	private String clientCode;
	private int amount;
	@Column (length=40)
	private String observation;
	private boolean delivered;
	public Bill( Date deliveryDate, String clientCode, int amount, String observation, boolean delivered) {
		super();
		
		this.deliveryDate = deliveryDate;
		this.clientCode = clientCode;
		this.amount = amount;
		this.observation = observation;
		this.delivered = delivered;
	}
	public Bill() {
		this(new Date(),"",0,"",false);
	}
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	@Override
	public String toString() {
		return "Bill [id_bill=" + id_bill + ", deliveryDate=" + deliveryDate + ", clientCode=" + clientCode
				+ ", amount=" + amount + ", observation=" + observation + ", delivered=" + delivered + "]";
	}
	
	
	

}
