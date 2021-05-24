package lab3package;

import interfaces.Visitable;

import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static City getACity(){
        City iasi = new City("Iasi");

        Hotel unirea = new Hotel("Unirea");
        unirea.setRank(4);

        Museum reginaMaria = new Museum("Regina Maria");
        reginaMaria.setOpeningTime(LocalTime.of(8,0));
        reginaMaria.setClosingTime(LocalTime.of(20,0));
        reginaMaria.setCost(unirea,20);

        Church treiIerarhi = new Church("Trei Ierarhi");
        treiIerarhi.setOpeningTime(LocalTime.of(7,0));
        treiIerarhi.setClosingTime(LocalTime.of(13,0));

        Church catedrala = new Church("Catedrala");
        catedrala.setOpeningTime(LocalTime.of(7,0));
        catedrala.setClosingTime(LocalTime.of(13,0));

        Restaurant oscar = new Restaurant("Oscar");
        oscar.setRank(5);
        oscar.setCost(treiIerarhi,7);

        Restaurant fenice = new Restaurant("Fenice");
        fenice.setRank(5);
        fenice.setCost(oscar,25);
        fenice.setCost(treiIerarhi,100);

        //iasi.addLocation(catedrala);
        iasi.addLocation(unirea);
        iasi.addLocation(reginaMaria);
        iasi.addLocation(treiIerarhi);
        iasi.addLocation(oscar);
        iasi.addLocation(fenice);
        iasi.addLocation(new Restaurant("Albatros"));


        return iasi;
    }

    private static void runCompulsorytest(){

        City iasi = getACity();

        System.out.print(iasi);

    }

    private static void runOptionaltest(){

        City iasi = getACity();

        System.out.print("\n");
        iasi.printSortedLocation();

        TravelPlan travelPlan = new TravelPlan(iasi);

        System.out.print("\n\nshortest path between " + iasi.getNodes().get(1).getName() + " and " +iasi.getNodes().get(4).getName());
        System.out.print(" is : "+travelPlan.getShortestPathBetween(iasi.getNodes().get(1), iasi.getNodes().get(4)));

    }

    private static void runBonusTest(){

        City iasi = getACity();

        TravelPlan travelPlan = new TravelPlan(iasi);

        //System.out.print("\n"+travelPlan.createPlan(fenice));

    }

    public static void main(String[] args){

        runCompulsorytest();

        runOptionaltest();

        runBonusTest();

    }
}
