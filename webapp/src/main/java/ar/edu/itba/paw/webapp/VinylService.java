package ar.edu.itba.paw.webapp;

import java.util.*;

public class VinylService {
    public List<Vinyl> listAll() {
        Calendar c = Calendar.getInstance();
        c.set(1973, Calendar.MARCH, 1);
        return Arrays.asList(
                new Vinyl("Dark Side of the Moon","Pink Floyd","/images/defaultVinyl.jpg",45.0,c.getTime()),
                new Vinyl("Thriller","Michael Jackson","/images/defaultVinyl.jpg",38.0,new Date()),
                new Vinyl("Dark Side of the Moon","Pink Floyd","/images/defaultVinyl.jpg",45.0,c.getTime()),
                new Vinyl("Dark Side of the Moon","Pink Floyd","/images/defaultVinyl.jpg",45.0,c.getTime()),
                new Vinyl("Dark Side of the Moon","Pink Floyd","/images/defaultVinyl.jpg",45.0,c.getTime()),
                new Vinyl("Dark Side of the Moon","Pink Floyd","/images/defaultVinyl.jpg",45.0,c.getTime()),
                new Vinyl("Dark Side of the Moon","Pink Floyd","/images/defaultVinyl.jpg",45.0,c.getTime())
        );
    }
}
