package com.sjsu;

import java.util.List;

public class InstanceProperties {

	String name;
	String imageRef;
	String flavorRef;
	List<String> networks;
	public InstanceProperties(String name, String imageRef, String flavorRef, List<String> networks) {
		super();
		this.name = name;
		this.imageRef = imageRef;
		this.flavorRef = flavorRef;
		this.networks = networks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageRef() {
		return imageRef;
	}
	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}
	public String getFlavorRef() {
		return flavorRef;
	}
	public void setFlavorRef(String flavorRef) {
		this.flavorRef = flavorRef;
	}
	public List<String> getNetworks() {
		return networks;
	}
	public void setNetworks(List<String> networks) {
		this.networks = networks;
	}
	
	
}
