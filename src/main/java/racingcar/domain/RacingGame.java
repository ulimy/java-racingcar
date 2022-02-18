package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String MUST_BE_INTEGER = "[ERROR] 시도 횟수는 숫자만 허용됩니다.";
    private static final String MUST_BE_POSITIVE = "[ERROR] 1미만의 시도횟수는 허용되지 않습니다.";
    private final String SIGN_OF_CAR_NAME = ",";

    private CarRepository cars;
    private int totalAttempt = 0;

    public void initCarNames(String carNames) {
        String[] names = carNames.split(SIGN_OF_CAR_NAME);
        cars = new CarRepository(names);
    }

    public void initTotalAttempt(String attempt) {
        validateAttempt(attempt);
        totalAttempt = Integer.parseInt(attempt);
    }

    public List<List<CarDTO>> play() {
        List<List<CarDTO>> totalExecutionResult = new ArrayList<>();

        while (totalAttempt-- > 0) {
            cars.moveAllCars();
            totalExecutionResult.add(cars.getExecutionResult());
        }

        return totalExecutionResult;
    }

    public List<String> selectWinners() {
        return cars.selectWinners();
    }

    private void validateAttempt(String attempt) {
        int num = validateIntegerThenParse(attempt);
        validatePositive(num);
    }

    private int validateIntegerThenParse(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(MUST_BE_INTEGER);
        }
    }

    private void validatePositive(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(MUST_BE_POSITIVE);
        }
    }

}
