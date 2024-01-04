import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        EventReporter eventReporter = new EventReporter();

        // Symulacja "koniec dnia"
        intersection.printIntersectionStatus();

        // Symulacja zmiany świateł na skrzyżowaniu
        intersection.setGreenLight();

        // Symulacja zdarzeń z losowością
        simulateRandomEvents(intersection, eventReporter);
    }

    private static void simulateRandomEvents(Intersection intersection, EventReporter eventReporter) {
        Random random = new Random();
        int numberOfRandomEvents = random.nextInt(5) + 1; // Generowanie losowej liczby zdarzeń (1-5)

        for (int i = 0; i < numberOfRandomEvents; i++) {
            int eventType = random.nextInt(2); // Generowanie losowego typu zdarzenia (0 - Accident, 1 - Traffic Violation)

            if (eventType == 0) {
                // Symulacja zdarzenia - wypadek
                String description = "Zderzenie na skrzyżowaniu";
                eventReporter.reportAccident(description);
            } else {
                // Symulacja zdarzenia - złamanie zasad ruchu
                String vehiclePlate = "DLE " + random.nextInt(10000);
                String violationType = getRandomViolationType();
                eventReporter.reportTrafficViolation(vehiclePlate, violationType);
            }
        }

        // Symulacja ruchu zgodnie z zasadami po wygenerowaniu zdarzeń
        intersection.followTrafficRules(intersection.getVehicles());
    }

    private static String getRandomViolationType() {
        String[] violationTypes = {"Nadmierna prędkość", "Naruszenie pierwszeństwa", "Nieprawidłowe parkowanie", "Jazda bez zapiętych pasów"};
        Random random = new Random();
        int index = random.nextInt(violationTypes.length);
        return violationTypes[index];
    }
}


class Intersection {
    private List<Vehicle> vehicles = new ArrayList<>();
    private TrafficLight trafficLight = new TrafficLight();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void allowEntry(Vehicle vehicle) {
    vehicle.proceed();
    vehicles.add(vehicle);
}

    public void printIntersectionStatus() {
    int numberOfVehicles = 10;
    System.out.println("Status Skrzyżowania:");
    
    if (numberOfVehicles > 0) {
        System.out.println("Liczba pojazdów na skrzyżowaniu: " + numberOfVehicles);
        System.out.println("Sygnalizacja świetlna jest teraz " + (trafficLight.isGreen() ? "zielona." : "czerwona."));
    } else {
        System.out.println("Brak pojazdów na skrzyżowaniu.");
    }
}


    public void setGreenLight() {
        trafficLight.setGreen();
    }

    public void followTrafficRules(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof TrafficRules) {
                ((TrafficRules) vehicle).followTrafficRules();
            }
        }
    }
}



class TrafficLight {
    private boolean isGreen;

    public void setGreen() {
        isGreen = true;
        System.out.println("Sygnalizacja świetlna jest teraz zielona.");
    }

    public void setRed() {
        isGreen = false;
        System.out.println("Sygnalizacja świetlna jest teraz czerwona.");
    }

    public boolean isGreen() {
        return isGreen;
    }
}

interface TrafficRules {
    void followTrafficRules();
}

class EventReporter {
    public void reportAccident(String description) {
        System.out.println("Zgłoszony wypadek: " + description);
    }

    public void reportTrafficViolation(String vehiclePlate, String violationType) {
        System.out.println("Zgłoszono naruszenie ruchu drogowego dla pojazdu " + vehiclePlate + ": " + violationType);
    }
}

abstract class Vehicle {
    abstract protected boolean checkIfCanRun();
    abstract protected void proceed();
    abstract protected String getPlateNumber(); // Dodana metoda getPlateNumber()

    protected String getCurrentDateTime() {
        return java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

class Dog extends Vehicle {
    protected boolean checkIfCanRun() {
        return false;
    }

    protected void proceed() {
        System.out.println("Pies wchodzi na skrzyżowanie: " + java.time.LocalDateTime.now());
    }

    protected String getPlateNumber() {
        return ""; 
    }
}