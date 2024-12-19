import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Класс для представления дома
class House {
    private int houseNumber;
    private int yearBuilt;
    private int distanceFromStreet;

    public House(int houseNumber, int yearBuilt, int distanceFromStreet) {
        this.houseNumber = houseNumber;
        this.yearBuilt = yearBuilt;
        this.distanceFromStreet = distanceFromStreet;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public int getDistanceFromStreet() {
        return distanceFromStreet;
    }

    public void setDistanceFromStreet(int distanceFromStreet) {
        this.distanceFromStreet = distanceFromStreet;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseNumber=" + houseNumber +
                ", yearBuilt=" + yearBuilt +
                ", distanceFromStreet=" + distanceFromStreet +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем улицы и дома
        Map<String, List<House>> streets = new HashMap<>();
        streets.put("First Street", new ArrayList<>());
        streets.put("Second Street", new ArrayList<>());

        // Добавляем дома на улицы
        streets.get("First Street").add(new House(1, 1990, 10));
        streets.get("First Street").add(new House(2, 1985, 15));
        streets.get("Second Street").add(new House(1, 2000, 20));
        streets.get("Second Street").add(new House(2, 2010, 25));

        // Изменение: поменялся номер дома и расположение
        House houseToUpdate = streets.get("First Street").get(0);
        houseToUpdate.setHouseNumber(10);
        houseToUpdate.setDistanceFromStreet(12);

        // Удаление: снос здания
        streets.get("Second Street").remove(0);

        // Вывод домов на каждой улице
        System.out.println("Houses on First Street:");
        for (House house : streets.get("First Street")) {
            System.out.println(house);
        }

        System.out.println("Houses on Second Street:");
        for (House house : streets.get("Second Street")) {
            System.out.println(house);
        }

        // Создаем карту с номерами домов в качестве ключей
        Map<Integer, House> houseNumbers = new HashMap<>();
        for (House house : streets.get("First Street")) {
            houseNumbers.put(house.getHouseNumber(), house);
        }
        for (House house : streets.get("Second Street")) {
            houseNumbers.put(house.getHouseNumber(), house);
        }

        // Вывод домов по номерам
        System.out.println("Houses by number:");
        for (Map.Entry<Integer, House> entry : houseNumbers.entrySet()) {
            System.out.println("House number: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}