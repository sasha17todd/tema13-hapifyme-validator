package com.qaschool.validators;

public class PostValidator {

    public String getPostStatus(String postBody) {

        // 1. EMPTY
        if (postBody == null || postBody.isEmpty()) {
            return "ERROR_EMPTY";
        }

        // 2. TOO_LONG
        if (postBody.length() > 250) {
            return "ERROR_TOO_LONG";
        }

        // 3. FORBIDDEN word "politică"
        if (postBody.contains("politică")) {
            return "ERROR_FORBIDDEN";
        }

        // 4. ALT caz -> valid
        return "POST_VALID";
    }
}
