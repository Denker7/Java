package org.example.service;

import org.example.model.Entity;
import org.example.model.Type;

import java.util.ArrayList;
import java.util.List;

import static org.example.model.Type.*;

public class ServiceSort {

    private static ServiceSort service;

    private ServiceSort() {
    }

    public static ServiceSort getInstance() {
        if (service == null) {
            service = new ServiceSort();
        }
        return service;
    }

    public Entity[] sortMileage(Entity[] arr, Type type) {
        List<Entity> list = new ArrayList();
        for (Entity e : arr) {
            if (e.getType().equals(type)) {
                if (list.isEmpty()) {
                    list.add(e);
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getMileage() > e.getMileage()) {
                            list.add(i, e);
                            break;
                        }
                        if (i == list.size() - 1) {
                            list.add(e);
                            break;
                        }
                    }
                }
            }
        }
        return toArr(list);
    }

    private Entity[] toArr(List<Entity> list) {
        Entity[] arr = new Entity[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public Entity[] sortOptionParam(Entity[] arr, Type type) {
        if (type.equals(AUTO)) {
            System.out.println("AUTO does not have an optional parameter");
            return null;
        }
        List<Entity> list = new ArrayList();
        for (Entity e : arr) {
            if (e.getType().equals(type)) {
                if (list.isEmpty()) {
                    list.add(e);
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getOptionalParam() > e.getOptionalParam()) {
                            list.add(i, e);
                            break;
                        }
                        if (i == list.size() - 1) {
                            list.add(e);
                            break;
                        }
                    }
                }
            }
        }
        return toArr(list);
    }

    public void print(Entity[] arr){
        for (Entity e: arr) {
            System.out.println(e.toString());
        }
    }
}
