import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        System.out.println("List of loaded JDBC drivers");

        for(Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements();) {
            Driver driver = e.nextElement();
            print(driver);
        }
    }

    public static void print(Driver driver) {
        String className = driver.getClass().getName();
        int majorVersion = driver.getMajorVersion();
        int miniorVersion = driver.getMinorVersion();


        System.out.println("------------------------");
        System.out.println("Name driver: " + className);
        System.out.println("Driver major version " + majorVersion);
        System.out.println("Driver minor version " + miniorVersion);
        System.out.println("------------------------");
    }
}
