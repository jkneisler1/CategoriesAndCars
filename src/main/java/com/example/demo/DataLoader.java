package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... strings) {
        Category category;        // Sports car, Sedan, Truck, Minivan, Sport Utility Vehicle (SUV), SuperCar/HyperCar
        Car car;                // Make, Model, VIN, Price, Color, Year

        // First category and their cars
        category = new Category("Sports Car", "Sports cars are designed to emphasise handling, performance or thrill of driving. Sports cars originated in Europe in the early 1900s, with one of the first recorded usages of the term \\\"sports car\\\" being in The Times newspaper in the UK in 1919.");
        categoryRepository.save(category);

        car = new Car("Chevrolet", "Corvette", "CC1001", 58900.0, "Red", 2020, category);
        carRepository.save(car);

        car = new Car("Mazda", "MX-5", "MX2150", 25730.0, "Red", 2020, category);
        carRepository.save(car);

        car = new Car("Porsche", "911", "<PCHE911>", 113300.0, "Red", 2020, category);
        carRepository.save(car);

        car = new Car("Ford", "Mustang", "<FM4875>", 26670.0, "Red", 2020, category);
        carRepository.save(car);

        car = new Car("Dodge", "Charger", "DC04857>", 29470.0, "Red", 2020, category);
        carRepository.save(car);


        // Second category and their cars
        category = new Category("Sedan", "Sedans are passenger cars separated into three distinct sections - engine, passenger, and cargo. Most sedans have them in that order from front to back. Sedans also have at least 33 cubic feet of rear interior volume.");
        categoryRepository.save(category);

        car = new Car("Toyota", "Camry", "TC4857", 24295.0, "Black", 2020, category);
        carRepository.save(car);

        car = new Car("Honda", "Accord", "HA1294", 23870.0, "Beige", 2020, category);
        carRepository.save(car);

        car = new Car("Nissan", "Altima", "NA0245", 24100.0, "Grey", 2020, category);
        carRepository.save(car);


        // Third category and their cars
        category = new Category("Truck", "Trucks are one of the oldest types of vehicles, appearing in the 1800s and have remained true to their original purpose: carrying heavy cargo loads. Most trucks today are actually light trucks, car-sized vehicles meant for personal and small business use.");
        categoryRepository.save(category);

        car = new Car("Ford", "F150", "FF0348", 30000.0, "Red", 2020, category);
        carRepository.save(car);

        car = new Car("Chevrolet", "Silverado", "CS02U3", 28000.0, "Red", 2020, category);
        carRepository.save(car);

        car = new Car("Dodge", "Ram", "DR0853", 28000.0, "Red", 2020, category);
        carRepository.save(car);


        // Fourth category and their cars
        category = new Category("Minivan", "Minivan is an American car classification for vehicles which are designed to transport passengers in the rear seating row(s), have reconfigurable seats in two or three rows. Minivans often have a high roof, a flat floor, and a sliding door.");
        categoryRepository.save(category);

        car = new Car("Dodge", "Grand Caravan", "DGC958", 35000.0, "Black", 2020, category);
        carRepository.save(car);

        car = new Car("Honda", "Odyssey", "HO0485", 37000.0, "Red", 2020, category);
        carRepository.save(car);

        car = new Car("Crysler", "Pacifica", "CP0324", 32000.0, "Blue", 2020, category);
        carRepository.save(car);


        // Fifth category and their cars
        category = new Category("Sport Utility Vehicle (SUV)", "Passenger vehicles with off-road capability or styling features are often categorised as either off-road vehicles, sports utility vehicles or crossover SUVs.");
        categoryRepository.save(category);

        car = new Car("Jeep", "Grand Cherokee", "JGC987", 34000.0, "Grey", 2020, category);
        carRepository.save(car);

        car = new Car("Subaru", "Outback", "SO8475", 29900.0, "Bronze", 2020, category);
        carRepository.save(car);

        car = new Car("Toyota", "4Runner", "T4R563", 42500.0, "White", 2020, category);
        carRepository.save(car);


        // Sixth category and their cars
        category = new Category("SuperCar-HyperCar", "A supercar – also called exotic car – is a loosely defined description of certain high-performance sportscars.  Since the 1990s or 2000s, the term - hypercar - has come into use for the highest performing supercars.");
        categoryRepository.save(category);

        car = new Car("McLaren", "P1", "MP1009", 1150000.0, "Orange", 2020, category);
        carRepository.save(car);

        car = new Car("Koenigsegg", "ONE-1", "KO4055>", 2850000.0, "White", 2020, category);
        carRepository.save(car);

        car = new Car("Bugatti", "Veyron 16.4", "BV1640", 1700000.0, "Red", 2020, category);
        carRepository.save(car);

        car = new Car("Bugatti", "La Voiture Noire", "BLVN01", 19000000.0, "Black", 2020, category);
        carRepository.save(car);

    }
}
