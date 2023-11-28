package ma.peps.sqli.core.container.container;


import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class TestRunner {

    private String path = "src/test/java/ma/peps/sqli/core/container/container/";

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "dev");
    }


    @Karate.Test
    Karate HappyBFtest() {
        return Karate.run( "ContainerHappyTest").relativeTo(getClass());
    }


    @Karate.Test
    Karate SadBFtest() {
        return Karate.run(path + "ContainerSadTest").relativeTo(getClass());
    }

}
