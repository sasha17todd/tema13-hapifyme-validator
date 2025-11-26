package com.qaschool.validators;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostValidatorTest {

    private PostValidator validator;

    @BeforeClass
    public void setup() {
        validator = new PostValidator();
    }

    @DataProvider(name = "postDataProvider")
    public Object[][] postDataProvider() {

        StringBuilder longPost = new StringBuilder();
        for (int i = 0; i < 260; i++) {
            longPost.append('a');
        }

        return new Object[][]{
                { "Acesta este un post valid.", "POST_VALID" },

                { null, "ERROR_EMPTY" },

                { "", "ERROR_EMPTY" },

                { "Acest post vorbește despre politică.", "ERROR_FORBIDDEN" },

                { longPost.toString(), "ERROR_TOO_LONG" }
        };
    }

    @Test(dataProvider = "postDataProvider")
    public void testPostValidationScenarios(String postBody, String expectedStatus) {

        String actualStatus = validator.getPostStatus(postBody);

        Assert.assertEquals(actualStatus, expectedStatus,
                "Status incorect pentru input: " + postBody);
    }
}
