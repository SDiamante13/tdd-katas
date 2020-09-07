package tech.pathtoptogramming.acronymgenerator;

public class AcronymGenerator {

    private AcronymGenerator() {
    }

    public static String generate(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            return "";
        }
        String[] names = fullName.split("[ \\-]");
        StringBuilder acronym = new StringBuilder();
        for (String name : names) {
            if (name.equalsIgnoreCase("von")) {
                acronym.append("v");
            } else {
                acronym.append(name.substring(0, 1).toUpperCase());
            }
        }
        return acronym.toString();
    }
}
