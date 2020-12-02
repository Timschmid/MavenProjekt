package de.hfu.residents.repository;

import de.hfu.residents.domain.Resident;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentReposotoryStub implements ResidentRepository{

    private  Resident resident1 = new Resident("Patrick","Gunter","Weg3","Berlin",new Date(1999, 12, 21));
    private  Resident resident2 = new Resident("Paul","Gunter","Straße5","Brandenburg",new Date(1950, 6, 14));
    private  Resident resident3 = new Resident("Patrizia","Gunter","Weg4","Bremen",new Date(1999, 12, 21));

    private  Resident resident4 = new Resident("Brigitte","Marlokoi","Straße21","Frakfurt",new Date(2001, 3, 21));
    @Override
    public List<Resident> getResidents() {
        List<Resident> resutlt = new ArrayList<>();
        resutlt.add(resident1);
        resutlt.add(resident2);
        resutlt.add(resident3);
        resutlt.add(resident4);

        return resutlt;
    }
}
