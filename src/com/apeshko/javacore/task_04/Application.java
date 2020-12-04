package com.apeshko.javacore.task_04;

import com.apeshko.javacore.task_01.model.*;
import com.apeshko.javacore.task_01.model.exception.NotEnoughDistanceException;
import com.apeshko.javacore.task_01.sevice.AirCompanySearchService;
import com.apeshko.javacore.task_01.sevice.AirCompanyService;
import com.apeshko.javacore.task_01.sevice.impl.AirCompanySearchServiceImpl;
import com.apeshko.javacore.task_01.sevice.impl.AirCompanyServiceImpl;
import com.apeshko.javacore.task_01.sevice.impl.FlightServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    private static List<AirCompany> airCompanies;

    private static void fillCompaniesData() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        airCompanies = Arrays.asList(
                AirCompany.class.getConstructor(String.class, List.class).newInstance(
                        "WizzAir",
                        Arrays.asList(
                                Airplane.Builder.class.getConstructor().newInstance()
                                        .withName("Sea")
                                        .withCapacity(120)
                                        .withType(AirplaneType.AIRBUS)
                                        .withHeight(1200)
                                        .withWidth(350)
                                        .withLength(24567.9)
                                        .withWeight(3400)
                                        .withDistance(6000)
                                        .build(),
                                Airplane.Builder.class.getConstructor().newInstance()
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
                AirCompany.class.getConstructor(String.class, List.class).newInstance(
                        "RyanAir",
                        Arrays.asList(
                                Airplane.Builder.class.getConstructor().newInstance()
                                        .withName("Rain")
                                        .withCapacity(100)
                                        .withType(AirplaneType.AIRBUS)
                                        .withHeight(1000)
                                        .withWidth(310)
                                        .withLength(23567.9)
                                        .withWeight(3000)
                                        .withDistance(7000)
                                        .build(),
                                Airplane.Builder.class.getConstructor().newInstance()
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
                AirCompany.class.getConstructor(String.class, List.class).newInstance(
                        "Air Ambulance",
                        Arrays.asList(
                                Helicopter.Builder.class.getConstructor().newInstance()
                                        .withName("Doctor Who")
                                        .withCapacity(2)
                                        .withType(HelicopterType.HEALTH)
                                        .withHeight(2000)
                                        .withWidth(300)
                                        .withLength(3567.9)
                                        .withWeight(1400)
                                        .withDistance(1000)
                                        .build(),
                                Helicopter.Builder.class.getConstructor().newInstance()
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
                AirCompany.class.getConstructor(String.class, List.class).newInstance(
                        "Military Services",
                        Arrays.asList(
                                Helicopter.Builder.class.getConstructor().newInstance()
                                        .withName("Warrior")
                                        .withCapacity(10)
                                        .withType(HelicopterType.MILITARY)
                                        .withHeight(3000)
                                        .withWidth(500)
                                        .withLength(4567.9)
                                        .withWeight(2400)
                                        .withDistance(3000)
                                        .build(),
                                Helicopter.Builder.class.getConstructor().newInstance()
                                        .withName("Axe")
                                        .withCapacity(6)
                                        .withType(HelicopterType.MILITARY)
                                        .withHeight(3200)
                                        .withWidth(600)
                                        .withLength(3567.9)
                                        .withWeight(2600)
                                        .withDistance(3000)
                                        .build(),
                                Helicopter.Builder.class.getConstructor().newInstance()
                                        .withName("Helper")
                                        .withCapacity(8)
                                        .withType(HelicopterType.MILITARY)
                                        .withHeight(3200)
                                        .withWidth(600)
                                        .withLength(3567.9)
                                        .withWeight(2800)
                                        .withDistance(2000)
                                        .build(),
                                Quadcopter.Builder.class.getConstructor().newInstance()
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
    }

    private static AirCompany getRandomAirCompany() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return airCompanies.get(Random.class.getConstructor().newInstance().nextInt(airCompanies.size()));
    }

    private static void calculateCapacityTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final AirCompanyService airCompanyService = AirCompanyServiceImpl.class.getConstructor().newInstance();
        final AirCompany airCompany = getRandomAirCompany();

        Method getCapacityMethod = AirCompanyServiceImpl.class.getMethod("getCapacity", AirCompany.class);
        Method getNameMethod = AirCompany.class.getMethod("getName");

        System.out.println("Capacity of the company " + getNameMethod.invoke(airCompany) + " equals " + getCapacityMethod.invoke(airCompanyService, airCompany));
    }

    private static void calculateWeightTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final AirCompanyService airCompanyService = AirCompanyServiceImpl.class.getConstructor().newInstance();
        final AirCompany airCompany = getRandomAirCompany();

        Method getWeightMethod = AirCompanyServiceImpl.class.getMethod("getWeight", AirCompany.class);
        Method getNameMethod = AirCompany.class.getMethod("getName");

        System.out.println("Carrying of the company " + getNameMethod.invoke(airCompany) + " equals " + getWeightMethod.invoke(airCompanyService, airCompany));
    }

    private static void sortByDistanceTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final AirCompanyService airCompanyService = AirCompanyServiceImpl.class.getConstructor().newInstance();
        final AirCompany airCompany = getRandomAirCompany();

        Method getMachinesSortByDistanceMethod = AirCompanyServiceImpl.class.getMethod("getMachinesSortByDistance", AirCompany.class);
        Method getNameMethod = AirCompany.class.getMethod("getName");

        List<FlyingMachine> flyingMachines = (List<FlyingMachine>) getMachinesSortByDistanceMethod.invoke(airCompanyService, airCompany);

        System.out.println("Flying machines of the company " + getNameMethod.invoke(airCompany) + " sorted by distance:");

        flyingMachines
                .forEach(flyingMachine -> {
                    System.out.println(" - " + flyingMachine.getName() + " " + flyingMachine.getDistance());
                });
    }

    private static void searchByCriteriaTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final AirCompanySearchService airCompanySearchService = AirCompanySearchServiceImpl.class.getConstructor().newInstance();
        final AirCompany airCompany = getRandomAirCompany();
        final FlyingMachineSearchCriteria flyingMachineSearchCriteria = FlyingMachineSearchCriteria.Builder.class.getConstructor().newInstance()
                .withCapacityStart(50)
                .withCapacityEnd(120)
                .build();

        Method searchMethod = AirCompanySearchServiceImpl.class.getMethod("search", AirCompany.class ,FlyingMachineSearchCriteria.class);
        Method getNameMethod = AirCompany.class.getMethod("getName");
        Method getFlyingMachineNameMethod = FlyingMachine.class.getMethod("getName");
        Method getFlyingMachineCapacityMethod = FlyingMachine.class.getMethod("getCapacity");

        List<FlyingMachine> flyingMachines = (List<FlyingMachine>) searchMethod.invoke(airCompanySearchService, airCompany, flyingMachineSearchCriteria);

        System.out.println("Flying machines of the company " + getNameMethod.invoke(airCompany) + " with capacity in a range [" + flyingMachineSearchCriteria.getCapacityStart() + ", " + flyingMachineSearchCriteria.getCapacityEnd() + "]:");
        flyingMachines
                .forEach(flyingMachine -> {
                    try {
                        System.out.println(" - " + getFlyingMachineNameMethod.invoke(flyingMachine) + " " + getFlyingMachineCapacityMethod.invoke(flyingMachine));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static void makeFlightSuccessTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final FlightServiceImpl flightService = FlightServiceImpl.class.getConstructor().newInstance();

        final Airport airportFrom = Airport.class.getConstructor(String.class, long.class, long.class).newInstance("Minsk", 1, 1);
        final Airport airportTo = Airport.class.getConstructor(String.class, long.class, long.class).newInstance("Antuan de Sent Exupery", 1000, 1000);
        final FlyingMachine airplane = Airplane.Builder.class.getConstructor().newInstance()
                .withName("Sea")
                .withCapacity(120)
                .withType(AirplaneType.AIRBUS)
                .withHeight(1200)
                .withWidth(350)
                .withLength(24567.9)
                .withWeight(3400)
                .withDistance(6000)
                .build();

        Method makeFlightMethod = FlightServiceImpl.class.getMethod("makeFlight", Airport.class, Airport.class, FlyingMachine.class);

        try {
            makeFlightMethod.invoke(flightService, airportFrom, airportTo, airplane);
        } catch (NotEnoughDistanceException e) {
            System.err.println(e);
        }
    }

    private static void makeFlightExceptionTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final FlightServiceImpl flightService = FlightServiceImpl.class.getConstructor().newInstance();

        final Airport airportFrom = Airport.class.getConstructor(String.class, long.class, long.class).newInstance("Minsk", 1, 1);
        final Airport airportTo = Airport.class.getConstructor(String.class, long.class, long.class).newInstance("Antuan de Sent Exupery", 1000, 1000);
        final FlyingMachine airplane = Quadcopter.Builder.class.getConstructor().newInstance()
                .withName("Mass Attack")
                .withCapacity(0)
                .withType(QuadcopterType.MILITARY)
                .withHeight(100)
                .withWidth(100)
                .withLength(100.9)
                .withWeight(20)
                .withDistance(500)
                .build();

        Method makeFlightMethod = FlightServiceImpl.class.getMethod("makeFlight", Airport.class, Airport.class, FlyingMachine.class);

        try {
            makeFlightMethod.invoke(flightService, airportFrom, airportTo, airplane);
        } catch (NotEnoughDistanceException e) {
            System.err.println(e);
        }
    }

    public static void main(String... args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        fillCompaniesData();
        calculateCapacityTest();
        calculateWeightTest();
        sortByDistanceTest();
        searchByCriteriaTest();
        makeFlightSuccessTest();
        makeFlightExceptionTest();
    }
}
