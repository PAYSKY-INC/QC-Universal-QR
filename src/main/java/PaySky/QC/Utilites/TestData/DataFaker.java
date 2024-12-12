package PaySky.QC.Utilites.TestData;

import PaySky.QC.Utilites.Selenium.DriverFactory;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;

public class DataFaker {
    private final Faker faker;
    public DataFaker() {
        faker = new Faker();
    }

  public  String MobileNumber(){
      return faker.number().digits(10);
  }
    public String name(){return faker.name().firstName();}
}
