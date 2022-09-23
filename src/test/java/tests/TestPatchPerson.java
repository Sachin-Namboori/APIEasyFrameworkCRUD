package tests;

import Helper.PersonServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPatchPerson {
    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testPatch(){
        String id = personServiceHelper.updatePerson(2).jsonPath().getString("id");
        System.out.println(id);
        Assert.assertNotNull(id,"updated");
    }
}
