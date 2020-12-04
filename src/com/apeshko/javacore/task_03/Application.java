package com.apeshko.javacore.task_03;

import com.apeshko.javacore.task_03.model.*;
import com.apeshko.javacore.task_03.model.exception.NotEnoughDistanceException;
import com.apeshko.javacore.task_03.sevice.AirCompanySearchService;
import com.apeshko.javacore.task_03.sevice.AirCompanyService;
import com.apeshko.javacore.task_03.sevice.impl.AirCompanySearchServiceImpl;
import com.apeshko.javacore.task_03.sevice.impl.AirCompanyServiceImpl;
import com.apeshko.javacore.task_03.sevice.impl.FlightServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    private final static List<AirCompany> airCompanies = Arrays.asList(
            new AirCompany(
                    "WizzAir",
                    Arrays.asList(
                            new Airplane.Builder()
                                    .withName("Sea")
                                    .withCapacity(120)
                                    .withType(AirplaneType.AIRBUS)
                                    .withHeight(1200)
                                    .withWidth(350)
                                    .withLength(24567.9)
                                    .withWeight(3400)
                                    .withDistance(6000)
                                    .build(),
                            new Airplane.Builder()
                                    .withName("Sun")
                                    .withCapacity(140)
                                    .withType(AirplaneType.BOEING)
                                    .withHeight(1000)
                                    .withWidth(300)
                                    .withLength(21567.9)
                                    .withWeight(3800)
                                    .withDistance(5000)
                                    .build()
                    )
            ),
            new AirCompany(
                    "RyanAir",
                    Arrays.asList(
                            new Airplane.Builder()
                                    .withName("Rain")
                                    .withCapacity(100)
                                    .withType(AirplaneType.AIRBUS)
                                    .withHeight(1000)
                                    .withWidth(310)
                                    .withLength(23567.9)
                                    .withWeight(3000)
                                    .withDistance(7000)
                                    .build(),
                            new Airplane.Builder()
                                    .withName("Sun")
                                    .withCapacity(170)
                                    .withType(AirplaneType.BOEING)
                                    .withHeight(2200)
                                    .withWidth(700)
                                    .withLength(31567.9)
                                    .withWeight(3200)
                                    .withDistance(5000)
                                    .build()
                    )
            ),
            new AirCompany(
                    "Air Ambulance",
                    Arrays.asList(
                            new Helicopter.Builder()
                                    .withName("Doctor Who")
                                    .withCapacity(2)
                                    .withType(HelicopterType.HEALTH)
                                    .withHeight(2000)
                                    .withWidth(300)
                                    .withLength(3567.9)
                                    .withWeight(1400)
                                    .withDistance(1000)
                                    .build(),
                            new Helicopter.Builder()
                                    .withName("Friend")
                                    .withCapacity(4)
                                    .withType(HelicopterType.HEALTH)
                                    .withHeight(2200)
                                    .withWidth(400)
                                    .withLength(2567.9)
                                    .withWeight(1400)
                                    .withDistance(2000)
                                    .build()
                    )
            ),
            new AirCompany(
                    "Military Services",
                    Arrays.asList(
                            new Helicopter.Builder()
                                    .withName("Warrior")
                                    .withCapacity(10)
                                    .withType(HelicopterType.MILITARY)
                                    .withHeight(3000)
                                    .withWidth(500)
                                    .withLength(4567.9)
                                    .withWeight(2400)
                                    .withDistance(3000)
                                    .build(),
                            new Helicopter.Builder()
                                    .withName("Axe")
                                    .withCapacity(6)
                                    .withType(HelicopterType.MILITARY)
                                    .withHeight(3200)
                                    .withWidth(600)
                                    .withLength(3567.9)
                                    .withWeight(2600)
                                    .withDistance(3000)
                                    .build(),
                            new Helicopter.Builder()
                                    .withName("Helper")
                                    .withCapacity(8)
                                    .withType(HelicopterType.MILITARY)
                                    .withHeight(3200)
                                    .withWidth(600)
                                    .withLength(3567.9)
                                    .withWeight(2800)
                                    .withDistance(2000)
                                    .build(),
                            new Quadcopter.Builder()
                                    .withName("Mass Attack")
                                    .withCapacity(0)
                                    .withType(QuadcopterType.MILITARY)
                                    .withHeight(100)
                                    .withWidth(100)
                                    .withLength(100.9)
                                    .withWeight(20)
                                    .withDistance(500)
                                    .build()
                    )
            )
    );

    private static AirCompany getRandomAirCompany() {
        return airCompanies.get(new Random().nextInt(airCompanies.size()));
    }

    private static void calculateCapacityTest() {
        final AirCompanyService airCompanyService = new AirCompanyServiceImpl();
        final AirCompany airCompany = getRandomAirCompany();

        System.out.println("Capacity of the company " + airCompany.getName() + " equals " + airCompanyService.getCapacity(airCompany));
    }

    private static void calculateWeightTest() {
        final AirCompanyService airCompanyService = new AirCompanyServiceImpl();
        final AirCompany airCompany = getRandomAirCompany();

        System.out.println("Carrying of the company " + airCompany.getName() + " equals " + airCompanyService.getWeight(airCompany));
    }

    private static void sortByDistanceTest() {
        final AirCompanyService airCompanyService = new AirCompanyServiceImpl();
        final AirCompany airCompany = getRandomAirCompany();

        List<FlyingMachine> flyingMachines = airCompanyService.getMachinesSortByDistance(airCompany);

        System.out.println("Flying machines of the company " + airCompany.getName() + " sorted by distance:");

        flyingMachines
                .forEach(flyingMachine -> {
                    System.out.println(" - " + flyingMachine.getName() + " " + flyingMachine.getDistance());
                });
    }

    private static void searchByCriteriaTest() {
        final AirCompanySearchService airCompanySearchService = new AirCompanySearchServiceImpl();
        final AirCompany airCompany = getRandomAirCompany();
        final FlyingMachineSearchCriteria flyingMachineSearchCriteria = new FlyingMachineSearchCriteria.Builder()
                .withCapacityStart(50)
                .withCapacityEnd(120)
                .build();

        List<FlyingMachine> flyingMachines = airCompanySearchService.search(airCompany, flyingMachineSearchCriteria);

        System.out.println("Flying machines of the company " + airCompany.getName() + " with capacity in a range [" + flyingMachineSearchCriteria.getCapacityStart() + ", " + flyingMachineSearchCriteria.getCapacityEnd() + "]:");
        flyingMachines
                .forEach(flyingMachine -> {
                    System.out.println(" - " + flyingMachine.getName() + " " + flyingMachine.getCapacity());
                });
    }

    private static void makeFlightSuccessTest() {
        final FlightServiceImpl flightService = new FlightServiceImpl();

        final Airport airportFrom = new Airport("Minsk", 1, 1);
        final Airport airportTo = new Airport("Antuan de Sent Exupery", 1000, 1000);
        final FlyingMachine airplane = new Airplane.Builder()
                .withName("Sea")
                .withCapacity(120)
                .withType(AirplaneType.AIRBUS)
                .withHeight(1200)
                .withWidth(350)
                .withLength(24567.9)
                .withWeight(3400)
                .withDistance(6000)
                .build();

        try {
            flightService.makeFlight(airportFrom, airportTo, airplane);
        } catch (NotEnoughDistanceException e) {
            System.err.println(e);
        }
    }

    private static void makeFlightExceptionTest() {
        final FlightServiceImpl flightService = new FlightServiceImpl();

        final Airport airportFrom = new Airport("Minsk", 1, 1);
        final Airport airportTo = new Airport("Antuan de Sent Exupery", 1000, 1000);
        final FlyingMachine airplane = new Quadcopter.Builder()
                .withName("Mass Attack")
                .withCapacity(0)
                .withType(QuadcopterType.MILITARY)
                .withHeight(100)
                .withWidth(100)
                .withLength(100.9)
                .withWeight(20)
                .withDistance(500)
                .build();

        try {
            flightService.makeFlight(airportFrom, airportTo, airplane);
        } catch (NotEnoughDistanceException e) {
            System.err.println(e);
        }
    }

    public static void main(String... args) {
        calculateCapacityTest();
        calculateWeightTest();
        sortByDistanceTest();
        searchByCriteriaTest();
        makeFlightSuccessTest();
        makeFlightExceptionTest();
    }
}
