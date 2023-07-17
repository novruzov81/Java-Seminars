
import java.util.*;

class Notebook {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}

public class Task1 {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Model1", 8, 512, "Windows", "Black"));
        notebooks.add(new Notebook("Model2", 16, 1024, "MacOS", "Silver"));
        notebooks.add(new Notebook("Model3", 8, 256, "Windows", "Red"));
        notebooks.add(new Notebook("Model4", 16, 512, "Linux", "Black"));

        Map<Integer, String> criteriaMap = new HashMap<>();
        criteriaMap.put(1, "ram");
        criteriaMap.put(2, "storage");
        criteriaMap.put(3, "os");
        criteriaMap.put(4, "color");

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();
        for (Map.Entry<Integer, String> entry : criteriaMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        String option = "y";
        while (!option.equalsIgnoreCase("n")) {
            System.out.println("Choose criteria to filter (Enter digit):");
            int criteria = scanner.nextInt();
            String selectedCriteria = criteriaMap.get(criteria);
            System.out.println("Enter minimum value for " + selectedCriteria + ":");
            Object minimumValue;
            if (selectedCriteria.equals("ram") || selectedCriteria.equals("storage")) {
                minimumValue = scanner.nextInt();
            } else {
                scanner.nextLine();
                minimumValue = scanner.nextLine();
            }
            filters.put(selectedCriteria, minimumValue);

            System.out.println("Do you want to add more filters? (y/n)");
            option = scanner.next();
        }
        scanner.close();

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);
        System.out.println("Filtered Notebooks: ");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook.getModel());
        }
    }

    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filters) {
        Set<Notebook> filteredNotebooks = new HashSet<>();
        for (Notebook notebook : notebooks) {
            boolean isValid = true;
            for (Map.Entry<String, Object> filter : filters.entrySet()) {
                String criteria = filter.getKey();
                Object minimumValue = filter.getValue();

                switch (criteria) {
                    case "ram":
                        if (notebook.getRam() < (int) minimumValue) {
                            isValid = false;
                        }
                        break;
                    case "storage":
                        if (notebook.getStorage() < (int) minimumValue) {
                            isValid = false;
                        }
                        break;
                    case "os":
                        if (!notebook.getOs().equalsIgnoreCase((String) minimumValue)) {
                            isValid = false;
                        }
                        break;
                    case "color":
                        if (!notebook.getColor().equalsIgnoreCase((String) minimumValue)) {
                            isValid = false;
                        }
                        break;
                }
                if (!isValid) {
                    break;
                }
            }
            if (isValid) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}




