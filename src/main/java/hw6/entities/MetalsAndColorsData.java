package hw6.entities;

import java.util.ArrayList;
import java.util.List;

public class MetalsAndColorsData {
    private Data data_1;
    private Data data_2;
    private Data data_3;
    private Data data_4;
    private Data data_5;

    public List<Data> getData(){
        List<Data> data_list = new ArrayList<>();
        data_list.add(data_1);
        data_list.add(data_2);
        data_list.add(data_3);
        data_list.add(data_4);
        data_list.add(data_5);
        return data_list;
    }
}

