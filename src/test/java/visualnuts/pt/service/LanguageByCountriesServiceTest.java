package visualnuts.pt.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import visualnuts.pt.dto.CountryLanguageDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LanguageByCountriesServiceTest {


    private String jsonParam;
    private List<CountryLanguageDto> countryLanguageDtoList;
    private LanguageByCountryService languageByCountryService;

    @BeforeAll
    void setup (){

        languageByCountryService = new LanguageByCountryService();

        jsonParam = "[" +
                "{\"country\":\"US\",\"languages\":[\"en\"]}," +
                "{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]}," +
                "{\"country\":\"DE\",\"languages\":[\"de\"]}," +
                "{\"country\":\"ES\",\"languages\":[\"es\"]}," +
                "{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]}]";

        countryLanguageDtoList = this.languageByCountryService
                .mapToCountryLanguageDtoList(jsonParam);
    }

    @Test
    public void mapToCountryLanguageDtoListSuccess(){

        List<CountryLanguageDto> countryLanguageDtoList = this.languageByCountryService
                .mapToCountryLanguageDtoList(jsonParam);

        assertNotNull(countryLanguageDtoList);
        assertFalse(countryLanguageDtoList.isEmpty());
        assertEquals(5, countryLanguageDtoList.size());
    }

    @Test
    public void mapToCountryLanguageDtoListException(){

        Exception exception = assertThrows(RuntimeException.class, () ->
            this.languageByCountryService
                    .mapToCountryLanguageDtoList(""));

        String expectedMessage = "Error parsing json";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void calculateTotalCountriesTest(){

        Long count = this.languageByCountryService.calculateTotalCountries(this.countryLanguageDtoList);

        assertEquals(5L, count);
    }

    @Test
    public void findCountryWithMoreLanguagesTest() {

        String countryName =  this.languageByCountryService.findCountryWithMoreLanguages(this.countryLanguageDtoList);
        assertEquals("BE", countryName);
    }

    @Test
    public void calculateNumberOfficialLanguagesTest() {
      Long count =  this.languageByCountryService.calculateNumberOfficialLanguages(this.countryLanguageDtoList);
      assertEquals(6L, count);
    }
    @Test
    public void findCountryMoreOfficialLanguagesTest() {

        String countryName = this.languageByCountryService.findCountryMoreOfficialLanguagesDE(this.countryLanguageDtoList);
        assertEquals("BE", countryName);
    }

    @Test
    public void findMostCommonLanguage() {
        String countryName = this.languageByCountryService.findMostCommonLanguage(this.countryLanguageDtoList);
        assertEquals("de", countryName);
    }
}