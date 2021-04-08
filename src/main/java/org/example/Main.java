package org.example;

import org.example.model.Entity;
import org.example.model.Type;
import org.example.service.Builder;
import org.example.service.Service;
import org.example.service.ServiceSort;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Builder bilder = Builder.getInstance();
        Service service = Service.getInstance();
        ServiceSort serviceSort = ServiceSort.getInstance();
        FileReader reader = new FileReader(new File("src/main/resources/text.txt"));
        Scanner scanner = new Scanner(reader);
        String[] s = scanner.nextLine().replace("{", "").replace("}", "").replace("\"", "").split(", ");
        Entity[] arr = new Entity[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = bilder.build(s[i]);
        }

        System.out.println("minRate: " + service.minRate(arr));
        System.out.println("maxRate: " + service.maxRate(arr));
        int allMileage = service.mileageCount(arr, null);
        int autoMileage = service.mileageCount(arr, Type.AUTO);
        int cargoMileage = service.mileageCount(arr, Type.CARGO);
        int passMileage = service.mileageCount(arr, Type.PASSANGER);
        int heavyMileage = service.mileageCount(arr, Type.HEAVY);
        System.out.println("res all: " + allMileage);
        System.out.println("res all AUTO: " + autoMileage);
        System.out.println("res all CARGO: " + cargoMileage);
        System.out.println("res all PASSANGER: " + passMileage);
        System.out.println("res all HEAVY: " + heavyMileage);
        Entity[] arrAutoSort = serviceSort.sortMileage(arr, Type.AUTO);
        serviceSort.print(arrAutoSort);
        Entity[] arrOptional = serviceSort.sortOptionParam(arr, Type.CARGO);
        serviceSort.print(arrOptional);
    }
}
