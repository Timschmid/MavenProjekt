package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.easymock.EasyMock.*;


public class ResidentRepositoryTest {

    private Resident filter = new Resident();
    private ResidentReposotoryStub stub = new ResidentReposotoryStub();
    private BaseResidentService service = new BaseResidentService();
    @Test
    public void getFilteredTest() {
        filter.setFamilyName("Gu*");
        service.setResidentRepository(stub);
        assertEquals(3, service.getFilteredResidentsList(filter).size());
    }
    @Test
    public void getFilteredTestWithWildcard() {
        filter.setGivenName("Br*");
        service.setResidentRepository(stub);
        assertEquals(2,service.getFilteredResidentsList(filter).size());
    }

    @Test
    public void getFilteredTwoWildcard() {
        filter.setGivenName("P*");
        filter.setStreet("Weg*");
        service.setResidentRepository(stub);
        assertEquals(2,service.getFilteredResidentsList(filter).size());
    }

    @Test
    public void getUniqueResidentTest() throws ResidentServiceException {
        filter.setGivenName("Paul");
        Resident expected = new Resident("Paul","Gunter","Straße5","Brandenburg",new Date(1950, 6, 14));
        service.setResidentRepository(stub);
        Resident filteredUnique = service.getUniqueResident(filter);
        assertEquals(expected.getFamilyName(),filteredUnique.getFamilyName());
    }

    @Test
    public void getUniqueResidentTestTwoSame() {
        filter.setGivenName("Brigitte");
        service.setResidentRepository(stub);

        try {
            //darf nicht ausgeführt werden, da es mehr Beigittes gibt
            service.getUniqueResident(filter);
            fail();
        }catch (ResidentServiceException exception) {

        }
    }

    @Test
    public void getUniqueResidentMonName() {
        filter.setGivenName("Norbert");
        service.setResidentRepository(stub);
        try {
            //darf nicht ausgeführt werden, da es keinen Norbeert gibt
            service.getUniqueResident(filter);
            fail();
        }catch (ResidentServiceException exception) {

        }
    }

    @Test
    public void getUniqueResidentMokeTest() {
        List<Resident> resutlt = new ArrayList<>();

        resutlt.add(new Resident("Patrick","Gunter","Weg3","Berlin",new Date(1999, 12, 21)));
        resutlt.add(new Resident("Paul","Gunter","Straße5","Brandenburg",new Date(1950, 6, 14)));
        resutlt.add(new Resident("Patrizia","Gunter","Weg4","Bremen",new Date(1999, 12, 21)));

        ResidentRepository repository = createMock(ResidentRepository.class);

        expect(repository.getResidents()).andReturn(resutlt);
        replay(repository);
        service.setResidentRepository(repository);
        filter.setGivenName("P*");
        assertThat(service.getFilteredResidentsList(filter).size(), equalTo(3));
        verify(repository);

    }

}
