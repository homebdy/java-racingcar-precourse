package racingcar.controller;

import racingcar.domain.Names;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final CarService carService = new CarService();

    public void start() {
        carService.addCars(readNames());
        int tryCount = readTryCount();
        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            outputView.printRacingResult(carService.race());
        }
        outputView.printWinner(carService.getWinner());
    }

    private Names readNames() {
        outputView.printCarNames();
        return inputView.readNames();
    }

    private int readTryCount() {
        outputView.printTryCount();
        return inputView.readTryCount();
    }
}
