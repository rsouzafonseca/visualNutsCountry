package visualnuts.pt.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import visualnuts.pt.dto.CountryLanguageDto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LanguageByCountryService {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * @param countryListJson a list of countries in json format
     * @return a list of CountryLanguageDto
     */
    public List<CountryLanguageDto> mapToCountryLanguageDtoList(String countryListJson) {

        try {
            return List.of(mapper.readValue(countryListJson, CountryLanguageDto[].class));

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing json");
        }
    }

    /**
     * return the number of countries in the world
     */
    public Long calculateTotalCountries(List<CountryLanguageDto> countryLanguageDtoList){

        return countryLanguageDtoList.stream().map(CountryLanguageDto::getCountry).distinct().count();

    }

    /**
     * return the country with the most official languages, where they officially speak German (de).
     */
    public String findCountryMoreOfficialLanguagesDE(List<CountryLanguageDto> countryLanguageDtoList){

        return countryLanguageDtoList
                .stream()
                .filter(oneCountry -> oneCountry.getLanguages()
                        .contains("de"))
                .max(Comparator.comparingInt(oneCountry -> oneCountry.getLanguages().size()))
                .map(CountryLanguageDto::getCountry).orElse(null);
    }

    /**
     * return the number all the official languages spoken in the listed countries.
     */
    public Long calculateNumberOfficialLanguages(List<CountryLanguageDto> countryLanguageDtoList){
        return countryLanguageDtoList.stream().flatMap(oneCountry ->
                oneCountry.getLanguages().stream()).distinct().count();
    }

    /**
     * return the country with the highest number of official languages.
     */
    public String findCountryWithMoreLanguages(List<CountryLanguageDto> countryLanguageDtoList){

        return countryLanguageDtoList
                .stream()
                .max(Comparator.comparingInt(oneCountry -> oneCountry.getLanguages().size()))
                .map(CountryLanguageDto::getCountry)
                .orElse(null);
    }

    /**
     * return the most common official language(s), of all countries
     */
    public String findMostCommonLanguage(List<CountryLanguageDto> countryLanguageDtoList){

        return countryLanguageDtoList
                .stream()
                .flatMap(oneCountry -> oneCountry.getLanguages().stream())
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt((a -> a.getValue().size())))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
