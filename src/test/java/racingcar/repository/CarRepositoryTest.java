package racingcar.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRepositoryTest {

    private CarRepository carRepository;

    @BeforeEach
    public void setUp() {
        this.carRepository = new CarRepository();
    }

    @Test
    @DisplayName("자동차 추가 검증 로직 테스트")
    public void save() throws Exception {
        //given
        String name = "one";
        Car car = new Car(name);


        //when
        carRepository.save(car);
        int currentSize = carRepository.findAll().size();
        Car foundCar = carRepository.findByName(name);

        //then
        assertEquals(1, currentSize, "추가한 만큼 크기가 증가해야 한다.");
        assertEquals(car.hashCode(), foundCar.hashCode(), "추가한 자동차와 꺼낸 자동차가 같아야 한다.");
    }

    @Test
    @DisplayName("모든 자동차 찾는 로직 검증 테스트")
    public void findAll() throws Exception {
        //given
        carRepository.save(new Car("one"));
        carRepository.save(new Car("two"));
        carRepository.save(new Car("three"));

        //when
        List<Car> cars = carRepository.findAll();

        //then
        assertEquals(3, cars.size(), "찾은 자동차의 수가 추가한 자동차의 수와 같아야 한다.");
    }

    @Test
    @DisplayName("모든 자동차의 이동범위 찾는 로직 검증 테스트")
    public void findAllMovementRange() throws Exception {
        //given
        Car one = new Car("one");
        one.move(5);
        Car two = new Car("two");
        two.move(1);
        carRepository.save(one);
        carRepository.save(two);

        //when
        Queue<Integer> movementRangeOfCars = carRepository.findAllMovementRange();

        //then
        assertEquals(2, movementRangeOfCars.size(), "찾은 이동범위의 수가 추가한 자동차의 수와 같아야 한다.");
        assertEquals(1, movementRangeOfCars.poll(), "move()에 4이상의 값이 들어갔다면 이동범위가 1 증가해야 한다.");
        assertEquals(0, movementRangeOfCars.poll(), "move()에 4미만의 값이 들어갔다면 이동범위가 증가하지 않아야 한다.");
    }

    @Test
    @DisplayName("자동차의 이름으로 자동차 찾는 로직 검증 테스트")
    public void findByName() throws Exception {
        //given
        String name = "one";
        Car car = new Car(name);
        carRepository.save(car);

        //when
        Car foundCar = carRepository.findByName(name);
        String foundName = foundCar.getName();

        //then
        assertEquals(name, foundName, "추가한 자동차와 찾은 자동차의 이름이 같아야 한다.");
        assertEquals(car.hashCode(), foundCar.hashCode(), "추가한 자동차와 찾은 자동차가 같아야 한다.");
    }
}