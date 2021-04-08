package org.example.service;

import org.example.model.Entity;
import org.example.model.Type;

import static org.example.model.Type.*;

public class Service {

    private static Service service;

    private Service() {
    }

    public static Service getInstance() {
        if (service == null) {
            service = new Service();
        }
        return service;
    }

    public int mileageCount(Entity[] arr, Type type) {
        int r;
        if (type != null) {
            r = mileageCountType(arr, type);
        } else {
            r = mileageCount(arr);
        }
        return r;
    }

    private int mileageCountType(Entity[] arr, Type type) {
        int r = 0;
        for (Entity e : arr) {
            if (e.getType().equals(type)) {
                r = r + e.getMileage();
            }
        }
        return r;
    }

    private int mileageCount(Entity[] arr) {
        int r = 0;
        for (Entity e : arr) {
            r = r + e.getMileage();
        }
        return r;
    }

    public String minRate(Entity[] arr) {
        double[] arrRes = calculateArr(arr);
        return calculateResString(minRate(arrRes));
    }

    public String maxRate(Entity[] arr) {
        double[] arrRes = calculateArr(arr);
        return calculateResString(maxRate(arrRes));
    }

    private int maxRate(double[] arrDouble) {
        int r = 0;
        double max = arrDouble[0];
        for (int i = 1; i < arrDouble.length; i++) {
            if (max < arrDouble[i]) {
                max = arrDouble[i];
                r = i;
            }
        }
        return r;
    }

    private int minRate(double[] arrDouble) {
        int r = 0;
        double min = arrDouble[0];
        for (int i = 1; i < arrDouble.length; i++) {
            if (min > arrDouble[i]) {
                min = arrDouble[i];
                r = i;
            }
        }
        return r;
    }

    private String calculateResString(int index) {
        String res;
        switch (index) {
            case 0:
                res = AUTO.name();
                break;
            case 1:
                res = CARGO.name();
                break;
            case 2:
                res = PASSANGER.name();
                break;
            case 3:
                res = HEAVY.name();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }
        return res;
    }

    private double[] calculateArr(Entity[] arr) {
        double[] arrRes = new double[4];
        for (Entity entity : arr) {
            switch (entity.getType()) {
                case AUTO:
                    arrRes[0] = arrRes[0] + calculateRate(entity.getMileage(), AUTO);
                    break;
                case CARGO:
                    arrRes[1] = arrRes[1] + calculateRate(entity.getMileage(), CARGO);
                    break;
                case PASSANGER:
                    arrRes[2] = arrRes[2] + calculateRate(entity.getMileage(), PASSANGER);
                    break;
                case HEAVY:
                    arrRes[3] = arrRes[3] + calculateRate(entity.getMileage(), HEAVY);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + entity.getType());
            }
        }
        return arrRes;
    }

    private double calculateRate(int miles, Type type) {
        return miles / 100 * type.getFuel() * type.getRate();
    }
}
