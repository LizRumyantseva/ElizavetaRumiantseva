package hw6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw6.entities.MetalsAndColorsData;
//import hw6.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class TestDataFromJson {
    final String JSON_PATH = "src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "TestData")
    public Iterator<Object[]> getTestDataFromJson() throws FileNotFoundException {
        Type MetalsAndColorsMapType = new TypeToken<Map<String, MetalsAndColorsData>>() {}.getType();
        Map<String, MetalsAndColorsData> data = new Gson().fromJson(new FileReader(JSON_PATH), MetalsAndColorsMapType);

        return data.values().stream().map(data1 -> new Object[]{data1}).collect(Collectors.toList()).iterator();
    }
}
