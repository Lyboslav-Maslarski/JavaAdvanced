package IteratorsAndComparators.Exercise.PetClinics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetClinic {
    private static final Map<String, Clinic> clinicMap = new HashMap<>();
    private static final Map<String, Pet> petMap = new HashMap<>();

    public static class Pet {
        private final String name;
        private final int age;
        private final String kind;

        public Pet(String name, int age, String kind) {
            this.name = name;
            this.age = age;
            this.kind = kind;
        }
    }

    public static class Clinic {
        private final String name;
        private final List<Pet> petList;
        private final int indexForAdding;
        private int indexForRelease;
        private static int modifier = 0;
        private static boolean moveModifier = false;

        public Clinic(String name, int rooms) throws Exception {
            if (rooms % 2 == 0) {
                throw new Exception();
            } else {
                this.name = name;
                this.petList = new ArrayList<>();
                for (int i = 0; i < rooms; i++) {
                    petList.add(null);
                }
                this.indexForAdding = rooms / 2;
                this.indexForRelease = rooms / 2;
            }
        }

        private List<Pet> getPetList() {
            return petList;
        }

        private boolean add(Pet pet) {
            boolean foundPlaceForPet = false;
            if (modifier == 0) {
                this.petList.set(indexForAdding, pet);
                modifier++;
                foundPlaceForPet = true;
            } else {
                if (!moveModifier) {
                    if (indexForAdding - modifier >= 0) {
                        this.petList.set(indexForAdding - modifier, pet);
                        moveModifier = true;
                        foundPlaceForPet = true;
                    }
                } else {
                    if (indexForAdding + modifier < this.petList.size()) {
                        this.petList.set(indexForAdding + modifier, pet);
                        moveModifier = false;
                        modifier++;
                        foundPlaceForPet = true;
                    }
                }
            }
            return foundPlaceForPet;
        }

        private boolean release() {
            boolean foundPetForRelease = false;
            while (indexForRelease < petList.size()) {
                if (petList.get(indexForRelease) == null) {
                    indexForRelease++;
                } else {
                    petList.set(indexForRelease, null);
                    foundPetForRelease = true;
                    break;
                }
            }
            if (!foundPetForRelease) {
                indexForRelease = 0;
                while (indexForRelease < petList.size() / 2) {
                    if (petList.get(indexForRelease) == null) {
                        indexForRelease++;
                    } else {
                        petList.set(indexForRelease, null);
                        foundPetForRelease = true;
                        break;
                    }
                }
            }
            return foundPetForRelease;
        }

        public boolean hasEmptyRooms() {
            for (Pet pet : petList) {
                if (pet == null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void cretePet(String name, int age, String kind) {
        Pet pet = new Pet(name, age, kind);
        petMap.put(name, pet);
    }

    public static void createClinic(String name, int rooms) throws Exception {
        if (rooms % 2 == 0) {
            throw new Exception();
        } else {
            Clinic clinic = new Clinic(name, rooms);
            clinicMap.put(name, clinic);
        }
    }

    public static boolean add(String petName, String clinicName) {
        if (petMap.containsKey(petName) && clinicMap.containsKey(clinicName)) {
            Clinic clinic = clinicMap.get(clinicName);
            Pet pet = petMap.get(petName);
            return clinic.add(pet);
        }
        return false;
    }

    public static boolean release(String clinicName) {
        if (clinicMap.containsKey(clinicName)) {
            Clinic clinic = clinicMap.get(clinicName);
            return clinic.release();
        }
        return false;
    }

    public static boolean hasEmptyRooms(String clinicName) {
        Clinic clinic = clinicMap.get(clinicName);
        return clinic.hasEmptyRooms();
    }

    public static void print(String clinicName) {
        Clinic clinic = clinicMap.get(clinicName);
        clinic.getPetList().forEach(pet -> System.out.printf("%s%n", pet == null ? "Room empty" : pet.name + " " + pet.age + " " + pet.kind));
    }

    public static void print(String clinicName, int room) {
        Clinic clinic = clinicMap.get(clinicName);
        Pet pet = clinic.getPetList().get(room-1);
        if (pet == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(pet.name + " " + pet.age + " " + pet.kind);
        }
    }

}
