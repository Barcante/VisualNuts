
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;
public class Exercise2 {
    public static void main(String[] args) {
        String json = """
                [
                {
                country: "US",
                languages: [ "en" ]
                },
                {
                country: "BE",
                languages: [ "nl", "fr", "de" ]
                },
                {
                country: "NL",
                languages: [ "nl", "fy" ]
                },
                {
                country: "DE",
                languages: [ "de" ]
                },
                {
                country: "ES",
                languages: [ "es" ]
                }
                ]""";

        List<Map<String, Object>> countries = parseJson(json);

        CountryLanguages cl = new CountryLanguages();
        int numCountries = cl.getNumCountries(countries);
        String countryWithMostLanguages = cl.getCountryWithMostLanguages(countries, "de");
        int totalLanguages = cl.getTotalLanguages(countries);
        String countryWithMostOfficialLanguages = cl.getCountryWithMostOfficialLanguages(countries);
        List<String> mostCommonLanguages = cl.getMostCommonLanguages(countries);

        System.out.println("Number of countries: " + numCountries);
        System.out.println("Country with most languages: " + countryWithMostLanguages);
        System.out.println("Total languages: " + totalLanguages);
        System.out.println("Country with most official languages: " + countryWithMostOfficialLanguages);
        System.out.println("Most common languages: " + mostCommonLanguages);
    }

    private static List<Map<String, Object>> parseJson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}