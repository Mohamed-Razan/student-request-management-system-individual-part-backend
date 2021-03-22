package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ModuleDiscontinue {

	@EmbeddedId
    private ModuleDiscontinueKey id;
 
    @ManyToOne
    @MapsId("RId")
    @JoinColumn(name = "rid")
    private AlternativeModuleRequest alterModuleRequest;
 
    @ManyToOne
    @MapsId("mcode")
    @JoinColumn(name = "mcode")
    private Module1 module;
 
    private String alterMcode;
    private String offeringSem;    
    private String currentGrade;

	public ModuleDiscontinue(AlternativeModuleRequest alterModuleRequest, Module1 module,
			String alterMcode, String offeringSem, String currentGrade) {
		super();
		this.id = new ModuleDiscontinueKey(alterModuleRequest.getRid(), module.getMcode());
		this.alterModuleRequest = alterModuleRequest;
		this.module = module;
		this.alterMcode = alterMcode;
		this.offeringSem = offeringSem;
		this.currentGrade = currentGrade;
	}

	public ModuleDiscontinue() {
		super();
	}

	public ModuleDiscontinueKey getId() {
		return id;
	}

	public void setId(ModuleDiscontinueKey id) {
		this.id = id;
	}

	public Module1 getModule() {
		return module;
	}

	public void setModule(Module1 module) {
		this.module = module;
	}

	public String getAlterMcode() {
		return alterMcode;
	}

	public void setAlterMcode(String alterMcode) {
		this.alterMcode = alterMcode;
	}

	public String getOfferingSem() {
		return offeringSem;
	}

	public void setOfferingSem(String offeringSem) {
		this.offeringSem = offeringSem;
	}

	public String getCurrentGrade() {
		return currentGrade;
	}

	public void setCurrentGrade(String currentGrade) {
		this.currentGrade = currentGrade;
	}

	
}
