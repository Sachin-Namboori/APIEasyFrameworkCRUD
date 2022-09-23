package tests;

import Helper.PersonServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPostPerson {
    private PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testPostCreatePerson(){
        Integer id = personServiceHelper.createPerson().jsonPath().getInt("id");
        System.out.println(id);
        Assert.assertNotNull(id,"id is not null");
    }
}
