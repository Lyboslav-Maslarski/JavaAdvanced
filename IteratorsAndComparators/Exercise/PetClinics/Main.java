package IteratorsAndComparators.Exercise.PetClinics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] commandParts = scan.nextLine().split("\\s+");
            String command = commandParts[0];
            if (command.equals("Create")) {
                switch (commandParts[1]) {
                    case "Pet":
                        String namePet = commandParts[2];
                        int agePet = Integer.parseInt(commandParts[3]);
                        String kindPet = commandParts[4];
                        PetClinic.cretePet(namePet, agePet, kindPet);
                        break;
                    case "Clinic":
                        String nameClinic = commandParts[2];
                        int rooms = Integer.parseInt(commandParts[3]);
                        try {
                            PetClinic.createClinic(nameClinic, rooms);
                        } catch (Exception e) {
                            System.out.println("Invalid Operation!");
                        }
                        break;
                }
            } else if (command.equals("Add")) {
                String petName = commandParts[1];
                String clinicName = commandParts[2];
                System.out.println(PetClinic.add(petName, clinicName));
            } else if (command.equals("Release")) {
                String clinicName = commandParts[1];
                System.out.println(PetClinic.release(clinicName));
            } else if (command.equals("HasEmptyRooms")) {
                String clinicName = commandParts[1];
                System.out.println(PetClinic.hasEmptyRooms(clinicName));
            } else if (command.equals("Print")) {
                if (commandParts.length == 2) {
                    String clinicName = commandParts[1];
                    PetClinic.print(clinicName);
                } else if (commandParts.length == 3) {
                    String clinicName = commandParts[1];
                    int room = Integer.parseInt(commandParts[2]);
                    PetClinic.print(clinicName, room);
                }
            }
        }
    }
}
