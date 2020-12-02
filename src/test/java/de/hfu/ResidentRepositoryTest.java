package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentReposotoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;


public class ResidentRepositoryTest {
    @Test
    public void getFilteredTest() {
        Resident filterResident = new Resident();
        ResidentReposotoryStub stub = new ResidentReposotoryStub();
        BaseResidentService service = new BaseResidentService(stub);
        filterResident.setFamilyName("Gunter");
        service.setResidentRepository(stub);
        assertEquals(3, service.getFilteredResidentsList(filterResident).size());

    }

    @Test
    public void getFilteredTestWithWildcard() {
        Resident filterResidentWildCard = new Resident();
        ResidentReposotoryStub stub = new ResidentReposotoryStub();
        BaseResidentService service = new BaseResidentService(stub);
        filterResidentWildCard.setGivenName("Br*");
        service.setResidentRepository(stub);
        assertEquals(1,service.getFilteredResidentsList(filterResidentWildCard).size());
    }

    @Test
    public void getFilteredTwoWildcard() {
        Resident filterResidentWildCard = new Resident();
        ResidentReposotoryStub stub = new ResidentReposotoryStub();
        BaseResidentService service = new BaseResidentService(stub);
        filterResidentWildCard.setGivenName("P*");
        filterResidentWildCard.setStreet("Weg*");
        service.setResidentRepository(stub);
        assertEquals(2,service.getFilteredResidentsList(filterResidentWildCard).size());
    }

    @Test
    public void getUniqueResidentTest() throws ResidentServiceException {
        Resident filterResidentUnique = new Resident();
        filterResidentUnique.setGivenName("Paul");
        Resident expected = new Resident("Paul","Gunter","Straße5","Brandenburg",new Date(1950, 6, 14));
        ResidentReposotoryStub stub = new ResidentReposotoryStub();
        BaseResidentService service = new BaseResidentService(stub);

        service.setResidentRepository(stub);
        Resident filteredUnique = service.getUniqueResident(filterResidentUnique);

        assertEquals(expected.getFamilyName(),filteredUnique.getFamilyName());
    }

}
