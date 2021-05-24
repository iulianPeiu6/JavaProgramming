package lab3package;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    public void shouldAddLocation(){
        City iasi = new City("iasi");
        iasi.addLocation(new Restaurant("fenice"));

        Assertions.assertFalse(iasi.getNodes().isEmpty());

        Assertions.assertEquals(1,iasi.getNodes().size());
    }

    @Test
    public void shouldSortLocations(){
        City iasi = new City("iasi");
        iasi.addLocation(new Restaurant("Fenice"));
        iasi.addLocation(new Restaurant("Albatros"));
        iasi.addLocation(new Restaurant("Bizantiq"));

        iasi.printSortedLocation();

        Assertions.assertEquals(3,iasi.getNodes().size());

        Assertions.assertEquals(iasi.getNodes().get(0).getName(),"Fenice");
        Assertions.assertEquals(iasi.getNodes().get(0).getName(),"Fenice");
        Assertions.assertEquals(iasi.getNodes().get(0).getName(),"Fenice");


    }

}