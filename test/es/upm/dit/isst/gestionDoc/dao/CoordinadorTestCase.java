package es.upm.dit.isst.gestionDoc.dao;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CoordinadorTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	//Indicamos donde se encuentra el archivo con el driver de chrome
	System.setProperty( "webdriver.chrome.driver", "/home/isst/chromedriver");
	driver = new ChromeDriver();    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCoordinadorTestCase() throws Exception {
    driver.get("http://localhost:8080/sprint2/FormLogin.jsp");
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("juan@upm.es");
    driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputPassword")).sendKeys("juan");
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("root");
    driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputPassword")).sendKeys("root");
    driver.findElement(By.id("inputPassword")).sendKeys(Keys.ENTER);
    driver.findElement(By.name("codigo")).click();
    driver.findElement(By.name("codigo")).clear();
    driver.findElement(By.name("codigo")).sendKeys("1");
    driver.findElement(By.name("nombre")).clear();
    driver.findElement(By.name("nombre")).sendKeys("DIT");
    driver.findElement(By.name("acronimo")).clear();
    driver.findElement(By.name("acronimo")).sendKeys("dit");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Salir")).click();
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("juan@upm.es");
    driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputPassword")).sendKeys("juan");
    driver.findElement(By.linkText("Registrar profesor")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("juan@upm.es");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("juan");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("pepe@upm.es");
    driver.findElement(By.name("nombre")).clear();
    driver.findElement(By.name("nombre")).sendKeys("pepe");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("pepe");
    new Select(driver.findElement(By.name("departamento"))).selectByVisibleText("DIT");
    driver.findElement(By.name("departamento")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("juan@upm.es");
    driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputPassword")).sendKeys("juan");
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("root");
    driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputPassword")).sendKeys("root");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    new Select(driver.findElement(By.name("responsable"))).selectByVisibleText("pepe");
    driver.findElement(By.name("responsable")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    driver.findElement(By.linkText("Salir")).click();
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("juan@upm.es");
    driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputPassword")).sendKeys("juan");
    driver.findElement(By.id("inputEmail")).click();
    driver.findElement(By.id("inputEmail")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=inputEmail | ]]
    driver.findElement(By.id("inputEmail")).click();
    driver.findElement(By.id("inputEmail")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("pepe@upm.es");
    driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputPassword")).sendKeys("pepe");
    driver.findElement(By.id("inputPassword")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("RESPONSABLE")).click();
    driver.findElement(By.linkText("Planes de Estudios")).click();
    driver.findElement(By.linkText("Crear Plan")).click();
    driver.findElement(By.name("codigo")).click();
    driver.findElement(By.name("codigo")).clear();
    driver.findElement(By.name("codigo")).sendKeys("1");
    driver.findElement(By.name("nombre")).clear();
    driver.findElement(By.name("nombre")).sendKeys("Plan1");
    driver.findElement(By.name("acronimo")).clear();
    driver.findElement(By.name("acronimo")).sendKeys("p1");
    driver.findElement(By.xpath("//div[4]")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Asignaturas")).click();
    driver.findElement(By.linkText("Crear Asignatura")).click();
    driver.findElement(By.name("planEstudios")).click();
    new Select(driver.findElement(By.name("planEstudios"))).selectByVisibleText("p1");
    driver.findElement(By.name("planEstudios")).click();
    driver.findElement(By.name("codigo")).click();
    driver.findElement(By.name("codigo")).clear();
    driver.findElement(By.name("codigo")).sendKeys("1");
    driver.findElement(By.name("nombre")).clear();
    driver.findElement(By.name("nombre")).sendKeys("prueba");
    driver.findElement(By.name("acronimo")).clear();
    driver.findElement(By.name("acronimo")).sendKeys("pru");
    driver.findElement(By.name("creditos")).clear();
    driver.findElement(By.name("creditos")).sendKeys("4.5");
    driver.findElement(By.name("curso")).clear();
    driver.findElement(By.name("curso")).sendKeys("1");
    driver.findElement(By.name("semestre")).clear();
    driver.findElement(By.name("semestre")).sendKeys("1");
    driver.findElement(By.name("grupos")).clear();
    driver.findElement(By.name("grupos")).sendKeys("1");
    driver.findElement(By.name("horasTeoria")).clear();
    driver.findElement(By.name("horasTeoria")).sendKeys("40");
    driver.findElement(By.name("horasPractica")).clear();
    driver.findElement(By.name("horasPractica")).sendKeys("25");
    driver.findElement(By.name("horasLaboratorio")).clear();
    driver.findElement(By.name("horasLaboratorio")).sendKeys("25");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=lstBox1 | label=pepe]]
    driver.findElement(By.xpath("//option[@value='pepe@upm.es']")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //option[@value='pepe@upm.es'] | ]]
    driver.findElement(By.id("btnRight")).click();
    new Select(driver.findElement(By.id("coordinador"))).selectByVisibleText("pepe");
    driver.findElement(By.id("coordinador")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("PROFESOR")).click();
    driver.findElement(By.linkText("COORDINADOR")).click();
    driver.findElement(By.linkText("Asignaturas")).click();
    driver.findElement(By.linkText("pru")).click();
    driver.findElement(By.name("horasLaboratorio")).clear();
    driver.findElement(By.name("horasLaboratorio")).sendKeys("1");
    driver.findElement(By.name("horasLaboratorio")).click();
    driver.findElement(By.name("horasLaboratorio")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=horasLaboratorio | ]]
    driver.findElement(By.name("horasLaboratorio")).click();
    driver.findElement(By.name("horasLaboratorio")).click();
    driver.findElement(By.name("horasLaboratorio")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=horasLaboratorio | ]]
    driver.findElement(By.name("horasLaboratorio")).click();
    driver.findElement(By.name("horasLaboratorio")).click();
    driver.findElement(By.name("horasLaboratorio")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=horasLaboratorio | ]]
    driver.findElement(By.name("horasLaboratorio")).click();
    driver.findElement(By.name("horasLaboratorio")).click();
    driver.findElement(By.name("horasLaboratorio")).clear();
    driver.findElement(By.name("horasLaboratorio")).sendKeys("10");
    driver.findElement(By.name("horasPractica")).clear();
    driver.findElement(By.name("horasPractica")).sendKeys("1");
    driver.findElement(By.name("horasPractica")).click();
    driver.findElement(By.name("horasPractica")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=horasPractica | ]]
    driver.findElement(By.name("horasPractica")).click();
    driver.findElement(By.name("horasPractica")).click();
    driver.findElement(By.name("horasPractica")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=horasPractica | ]]
    driver.findElement(By.name("horasPractica")).click();
    driver.findElement(By.name("horasPractica")).click();
    driver.findElement(By.name("horasPractica")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=horasPractica | ]]
    driver.findElement(By.name("horasPractica")).click();
    driver.findElement(By.name("horasPractica")).clear();
    driver.findElement(By.name("horasPractica")).sendKeys("9");
    driver.findElement(By.name("horasTeoria")).clear();
    driver.findElement(By.name("horasTeoria")).sendKeys("1");
    driver.findElement(By.name("horasTeoria")).click();
    driver.findElement(By.name("horasTeoria")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=horasTeoria | ]]
    driver.findElement(By.name("horasTeoria")).click();
    driver.findElement(By.name("horasTeoria")).click();
    driver.findElement(By.name("horasTeoria")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=horasTeoria | ]]
    driver.findElement(By.name("horasTeoria")).click();
    driver.findElement(By.name("horasTeoria")).click();
    driver.findElement(By.name("horasTeoria")).clear();
    driver.findElement(By.name("horasTeoria")).sendKeys("7");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("PROFESOR")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
