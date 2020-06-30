import org.junit.Assert;
import org.junit.Test;


/**
 * Created by ilumer on 17-5-23.
 */
public class SameStringTest {
  @Test
  public void isSameString() throws Exception {
    SameString sameString = new SameString();
    Assert.assertTrue(sameString.isSameString("afd", "afd"));

  }
}