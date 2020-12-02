package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentReposotoryStub implements ResidentRepository {

    List<Resident> resutlt = new ArrayList<>();

    public ResidentReposotoryStub() {
        super();
        resutlt.add(new Resident("Patrick","Gunter","Weg3","Berlin",new Date(1999, 12, 21)));
        resutlt.add(new Resident("Paul","Gunter","Straße5","Brandenburg",new Date(1950, 6, 14)));
        resutlt.add(new Resident("Patrizia","Gunter","Weg4","Bremen",new Date(1999, 12, 21)));
        resutlt.add(new Resident("Brigitte","Marlokoi","Straße21","Frakfurt",new Date(2001, 3, 21)));
        resutlt.add(new Resident("Brigitte","Sanja","Straße212","Brandenburg",new Date(2001, 3, 21)));
    }

    @Override
    public List<Resident> getResidents() {
        return resutlt;
    }
}
