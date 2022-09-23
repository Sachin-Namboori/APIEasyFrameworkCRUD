package tests;


import Helper.PersonServiceHelper;
import model.PersonPOJO;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestGetPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void getAllPersons(){
        List<PersonPOJO> personPOJOList = personServiceHelper.getAllPerson();
        Assert.assertNotNull(personPOJOList,"is not null");
        Assert.assertFalse(personPOJOList.isEmpty(),"PersonPojoList is not true");

    }


}
