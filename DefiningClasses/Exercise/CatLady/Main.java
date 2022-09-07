package DefiningClasses.Exercise.CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Cat> catList = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double catParameter = Double.parseDouble(data[2]);
            if ("Siamese".equals(breed)) {
                Cat cat = new Cat.Siamese(name, catParameter);
                catList.add(cat);
            } else if ("Cymric".equals(breed)) {
                Cat cat = new Cat.Cymric(name, catParameter);
                catList.add(cat);
            } else if ("StreetExtraordinaire".equals(breed)) {
                Cat cat = new Cat.StreetExtraordinaire(name, catParameter);
                catList.add(cat);
            }
            input = scan.nextLine();
        }
        String searchCatName = scan.nextLine();
        Cat searchCat = catList.stream().filter(cat -> cat.getName().equals(searchCatName)).collect(Collectors.toList()).get(0);
        System.out.println(searchCat);
    }
}
