package visualnuts.pt.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import visualnuts.pt.response.CountryLanguageResponseDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountryLanguageControllerTest {

    String jsonParam = "[" +
            "{\"country\":\"US\",\"languages\":[\"en\"]}," +
            "{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]}," +
            "{\"country\":\"DE\",\"languages\":[\"de\"]}," +
            "{\"country\":\"ES\",\"languages\":[\"es\"]}," +
            "{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]}]";

    CountryLanguageController countryLanguageController = new CountryLanguageController();

    @Test
    public void getCountryLanguageData(){

        CountryLanguageResponseDto countryLanguageResponseDto = countryLanguageController
                .getCountryLanguageData(jsonParam);

        assertNotNull(countryLanguageResponseDto);
        assertEquals("BE", countryLanguageResponseDto.getCountryNameMoreLanguages());
        assertEquals("BE", countryLanguageResponseDto.getCountryNameMoreLanguagesDe());
        assertEquals(5L, countryLanguageResponseDto.getTotalCountries());
        assertEquals(6L, countryLanguageResponseDto.getTotalLanguageCount());
        assertEquals("de", countryLanguageResponseDto.getMostOfficialLanguage());
    }
}
