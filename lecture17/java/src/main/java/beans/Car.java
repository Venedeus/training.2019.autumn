package beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    private String model;

    @Autowired
    private Person driver;

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", driver=" + driver +
                '}';
    }
}
