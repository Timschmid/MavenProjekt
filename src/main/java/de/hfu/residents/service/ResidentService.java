package de.hfu.residents.service;

import java.util.List;

import de.hfu.residents.domain.Resident;

//Hier eine änderung

/**
 * @author Stefan Betermieux
 */
public interface ResidentService {

  Resident getUniqueResident(Resident filterResident) throws ResidentServiceException;

  List<Resident> getFilteredResidentsList(Resident filterResident);

}




//Teständerungen
