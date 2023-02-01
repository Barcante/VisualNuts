import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryLanguages {

    public int getNumCountries(List<Map<String, Object>> countries) {
        return countries.size();
    }

    public String getCountryWithMostLanguages(List<Map<String, Object>> countries, String language) {
        int maxLanguages = 0;
        String countryWithMostLanguages = "";
        for (Map<String, Object> country : countries) {
            List<String> countryLanguages = (List<String>) country.get("languages");
            if (countryLanguages.contains(language)) {
                if (countryLanguages.size() > maxLanguages) {
                    maxLanguages = countryLanguages.size();
                    countryWithMostLanguages = (String) country.get("country");
                }
            }
        }
        return countryWithMostLanguages;
    }

    public int getTotalLanguages(List<Map<String, Object>> countries) {
        int totalLanguages = 0;
        for (Map<String, Object> country : countries) {
            totalLanguages += ((List<String>) country.get("languages")).size();
        }
        return totalLanguages;
    }

    public String getCountryWithMostOfficialLanguages(List<Map<String, Object>> countries) {
        int maxLanguages = 0;
        String countryWithMostLanguages = "";
        for (Map<String, Object> country : countries) {
            int numLanguages = ((List<String>) country.get("languages")).size();
            if (numLanguages > maxLanguages) {
                maxLanguages = numLanguages;
                countryWithMostLanguages = (String) country.get("country");
            }
        }
        return countryWithMostLanguages;
    }

    public List<String> getMostCommonLanguages(List<Map<String, Object>> countries) {
        Map<String, Integer> languageCounts = new HashMap<>();
        for (Map<String, Object> country : countries) {
            for (String language : (List<String>) country.get("languages")) {
                if (languageCounts.containsKey(language)) {
                    languageCounts.put(language, languageCounts.get(language) + 1);
                } else {
                    languageCounts.put(language, 1);
                }
            }
        }

        int maxCount = 0;
        List<String> mostCommonLanguages = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : languageCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonLanguages.clear();
                mostCommonLanguages.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                mostCommonLanguages.add(entry.getKey());
            }
        }

        return mostCommonLanguages;
    }
}