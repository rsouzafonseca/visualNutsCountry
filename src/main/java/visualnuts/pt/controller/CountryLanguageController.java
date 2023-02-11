package visualnuts.pt.controller;

import visualnuts.pt.dto.CountryLanguageDto;
import visualnuts.pt.response.CountryLanguageResponseDto;
import visualnuts.pt.service.LanguageByCountryService;

import java.util.List;

public class CountryLanguageController {

    private final LanguageByCountryService languageByCountryService;

    public CountryLanguageController() {
        this.languageByCountryService = new LanguageByCountryService();
    }

    public CountryLanguageResponseDto getCountryLanguageData(String countryListJson){

        CountryLanguageResponseDto countryLanguageResponseDto = new CountryLanguageResponseDto();

        List<CountryLanguageDto> countryLanguageDtoList = this.languageByCountryService
                .mapToCountryLanguageDtoList(countryListJson);

        countryLanguageResponseDto.setTotalCountries(this.languageByCountryService
                .calculateTotalCountries(countryLanguageDtoList));

        countryLanguageResponseDto.setMostOfficialLanguage(this.languageByCountryService
                .findMostCommonLanguage(countryLanguageDtoList));

        countryLanguageResponseDto.setCountryNameMoreLanguagesDe(this.languageByCountryService
                .findCountryMoreOfficialLanguagesDE(countryLanguageDtoList));

        countryLanguageResponseDto.setCountryNameMoreLanguages(this.languageByCountryService
                .findCountryWithMoreLanguages(countryLanguageDtoList));

        countryLanguageResponseDto.setTotalLanguageCount(this.languageByCountryService
                .calculateNumberOfficialLanguages(countryLanguageDtoList));

        return countryLanguageResponseDto;

  }
}
