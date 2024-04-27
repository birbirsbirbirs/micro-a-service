import co.pitam.aservice.AServiceApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class KSampleTest {

    @Karate.Test
    Karate testSample(){
        return Karate.run("classpath:sample/HelloWorld.feature").relativeTo(getClass());
    }
}
