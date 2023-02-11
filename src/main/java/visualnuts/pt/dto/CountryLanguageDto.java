package visualnuts.pt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CountryLanguageDto {

    @JsonProperty
    private String country;

    @JsonProperty
    private List<String> languages;

    public CountryLanguageDto() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
