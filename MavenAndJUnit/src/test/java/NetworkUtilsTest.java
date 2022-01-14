import org.junit.Test;

public class NetworkUtilsTest {
    @Test (timeout = 1000)//таймаут в милисекундах
    public void getConnectionShouldRReturnFasterThenOneSecond(){
        NetworkUtils.getConnection();
    }
}
