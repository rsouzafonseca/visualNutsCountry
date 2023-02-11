package visualnuts.pt;

import visualnuts.pt.controller.CountryLanguageController;

public class Main {
    public static void main(String[] args) {

        String jsonParam = "[" +
                "{\"country\":\"US\",\"languages\":[\"en\"]}," +
                "{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]}," +
                "{\"country\":\"DE\",\"languages\":[\"de\"]}," +
                "{\"country\":\"ES\",\"languages\":[\"es\"]}," +
                "{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]}]";

        CountryLanguageController countryLanguageController = new CountryLanguageController();

        countryLanguageController.getCountryLanguageData(jsonParam);

    }
}