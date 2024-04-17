package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarShopTests {
    private CarShop carShop;
    private Car bmw;
    private Car audi;
    private Car mercedes;
    @Before
    public void setUp(){
        this.carShop = new CarShop();
        bmw = new Car("530", 333, 10000);
        audi = new Car("a6", 313, 2000);
        mercedes = new Car("g", 450, 50000);
    }
    @Test(expected = NullPointerException.class)
    public void testCarAddingUnsucsessfull(){
        carShop.add(null);
    }
    @Test
    public void testAddCarCorrect(){
        carShop.add(bmw);
        Assert.assertEquals(1, carShop.getCount());
        carShop.add(audi);
        Assert.assertEquals(2, carShop.getCount());
    }
    @Test
    public void testRemoveCars(){
        carShop.add(bmw);
        carShop.add(audi);
        carShop.add(mercedes);
        Assert.assertEquals(3, carShop.getCount());
        carShop.remove(audi);
        Assert.assertEquals(2, carShop.getCount());
        carShop.remove(mercedes);
        Assert.assertEquals(1, carShop.getCount());
    }
    @Test
    public void testGetCars(){
        carShop.add(bmw);
        List<Car> cars = carShop.getCars();
        Assert.assertEquals(1, carShop.getCount());
        Assert.assertEquals(bmw.getModel(), cars.get(0).getModel());
    }
    @Test
    public void testPowerfulCar(){
        carShop.add(bmw);
        carShop.add(audi);
        carShop.add(mercedes);
        List<Car> cars = carShop.findAllCarsWithMaxHorsePower(400);
        Assert.assertEquals(mercedes.getModel(), cars.get(0).getModel());
    }
    @Test
    public void testMostLuxoryCar(){
        carShop.add(bmw);
        carShop.add(audi);
        carShop.add(mercedes);
        Car car = carShop.getTheMostLuxuryCar();
        Assert.assertEquals(mercedes.getModel(), car.getModel());
    }
    @Test
    public void testFindingByModel(){
        carShop.add(bmw);
        carShop.add(bmw);
        carShop.add(bmw);
        carShop.add(audi);
        carShop.add(mercedes);
        List<Car> cars = carShop.findAllCarByModel(bmw.getModel());
        Assert.assertEquals(3, cars.size());
    }

}

