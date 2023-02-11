package visualnuts.pt.response;

public class CountryLanguageResponseDto {

    /**
     * the number of countries in the world
     */
    private Long totalCountries;

    /**
     * the country with the highest number of official languages.
     */
    private String countryNameMoreLanguages;

    /**
     * the most common official language(s), of all countries.
     */
    private String mostOfficialLanguage;

    /**
     * the number all the official languages spoken in the listed countries.
     */
    private Long totalLanguageCount;


    /**
     * the country with the most official languages, where they officially speak German (de).
     */
    private String countryNameMoreLanguagesDe;

    public Long getTotalCountries() {
        return totalCountries;
    }

    public void setTotalCountries(Long totalCountries) {
        this.totalCountries = totalCountries;
    }

    public String getCountryNameMoreLanguages() {
        return countryNameMoreLanguages;
    }

    public void setCountryNameMoreLanguages(String countryNameMoreLanguages) {
        this.countryNameMoreLanguages = countryNameMoreLanguages;
    }

    public String getMostOfficialLanguage() {
        return mostOfficialLanguage;
    }

    public void setMostOfficialLanguage(String mostOfficialLanguage) {
        this.mostOfficialLanguage = mostOfficialLanguage;
    }

    public Long getTotalLanguageCount() {
        return totalLanguageCount;
    }

    public void setTotalLanguageCount(Long totalLanguageCount) {
        this.totalLanguageCount = totalLanguageCount;
    }

    public String getCountryNameMoreLanguagesDe() {
        return countryNameMoreLanguagesDe;
    }

    public void setCountryNameMoreLanguagesDe(String countryNameMoreLanguagesDe) {
        this.countryNameMoreLanguagesDe = countryNameMoreLanguagesDe;
    }
}
