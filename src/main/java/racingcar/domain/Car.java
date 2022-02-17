package racingcar.domain;

public class Car {

    private final CarName name;
    private int position;

    private final int CONDITION_FOR_MOVE = 4;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void move(int target) {
        if (target >= CONDITION_FOR_MOVE) {
            position++;
        }
    }

    public boolean isSamePosition(int target) {
        return position == target;
    }

}
