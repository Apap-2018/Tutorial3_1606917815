package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService{
	private List<PilotModel> archivePilot;
	
	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);
	}
	
	@Override
	public List<PilotModel> getPilotList(){
		return archivePilot;
	}
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		PilotModel pilots = null;
		for (PilotModel plt : archivePilot) {
			if(plt.getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
				pilots = plt;
				break;
			}
		}
		return pilots;
	}
	
	@Override
	public PilotModel getPilotDetailById(String id) {
		PilotModel pilots = null;
		for (PilotModel plt : archivePilot) {
			if(plt!=null) {
				if(plt.getId().equals(id)) {
					pilots = plt;
					break;
				}
			}
			
		}
		return pilots;
	}

}
