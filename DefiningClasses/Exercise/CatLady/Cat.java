package DefiningClasses.Exercise.CatLady;

public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    static class Siamese extends Cat {
        private String name;
        private double earSize;

        public Siamese(String name, double earSize) {
            this.name = name;
            this.earSize = earSize;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("Siamese %s %.2f", name, earSize);
        }
    }

    static class Cymric extends Cat {
        private String name;
        private double furLength;

        public Cymric(String name, double furLength) {
            this.name = name;
            this.furLength = furLength;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("Cymric %s %.2f", name, furLength);
        }
    }

    static class StreetExtraordinaire extends Cat {
        private String name;
        private double decibelsOfMeows;

        public StreetExtraordinaire(String name, double decibelsOfMeows) {
            this.name = name;
            this.decibelsOfMeows = decibelsOfMeows;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format("StreetExtraordinaire %s %.2f", name, decibelsOfMeows);
        }
    }
}
