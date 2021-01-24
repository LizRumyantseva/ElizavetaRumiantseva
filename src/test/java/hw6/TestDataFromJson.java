package hw6;

import com.google.gson.Gson;
import hw6.entities.Data;
import hw6.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestDataFromJson {
    final String JSON_PATH = "src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "TestData")
    public Iterator<Object[]> getTestDataFromJson() throws FileNotFoundException {
        MetalsAndColorsData data = new Gson().fromJson(new FileReader(JSON_PATH), MetalsAndColorsData.class);
        List<Data> array_data = data.getData();
        return  array_data.stream().map(Mdata -> new Object[]{Mdata}).collect(Collectors.toList()).iterator();
    }
}
