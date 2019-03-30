package caht.model;

import java.io.Serializable;

public class Massage implements Serializable{
	private String Receiver;
	private String Sender;
	private String center;
	private String massageTap;
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	
	public String getReceiver() {
		return Receiver;
	}
	public void setReceiver(String receiver) {
		Receiver = receiver;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
	public String getMassageTap() {
		return massageTap;
	}
	public void setMassageTap(String massageTap) {
		this.massageTap = massageTap;
	}
	

}
