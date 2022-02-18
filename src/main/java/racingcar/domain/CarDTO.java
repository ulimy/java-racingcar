package racingcar.domain;

public class CarDTO {
    private final String name;
    private final int position;

    public CarDTO(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
