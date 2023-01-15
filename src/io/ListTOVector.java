package io;

import java.util.List;
import java.util.Vector;

//******Author：zhiminzhang
//******Data:2022/12/17 16:42
public class ListTOVector {
    public ListTOVector(List<String> list, Vector<Vector<Object>> vector) {
        for (String list1:list){
            Vector<Object> objects = new Vector<>();
            objects.add(list1);
            vector.add(objects);
        }

    }
}
