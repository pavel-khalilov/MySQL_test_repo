import common.ProjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnvSecretsTest {
    @Test
    public void testEnvSecrets() {
        System.out.println("User: " + ProjectUtils.getUser());
        Assert.assertEquals(ProjectUtils.getUser(), "root");
    }
}
