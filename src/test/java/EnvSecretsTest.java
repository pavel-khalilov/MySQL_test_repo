import common.ProjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnvSecretsTest {
    @Test
    public void testEnvSecrets() {
        Assert.assertEquals(ProjectUtils.getUser(), "root");
    }
}
