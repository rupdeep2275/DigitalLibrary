package com.example.digitallibrary.utils;

import java.util.HashMap;
import java.util.List;

public class AuthoritiesListProvider {

    private static HashMap<String, String> authoritiesMap;
    // student -> studentAuthorities
    // admin -> adminAuthorities


    public static String getAuthorities(String userType) {
        if (authoritiesMap == null) {
            authoritiesMap = new HashMap<>();
            List<String> studentAuthorities = List.of(
                    Constants.STUDENT_SELF_INFO_AUTHORITY
            );
            List<String> adminAuthorities = List.of(
                    Constants.CREATE_BOOK_AUTHORITY,
                    Constants.CREATE_ADMIN_AUTHORITY,
                    Constants.INITIATE_TRANSACTION_AUTHORITY
            );

            String studentAuthorititesAsString = String.join(Constants.DELIMITER, studentAuthorities);
            String adminAuthoritiesAsString = String.join(Constants.DELIMITER, adminAuthorities);
            authoritiesMap.put(Constants.STUDENT_USER, studentAuthorititesAsString);
            authoritiesMap.put(Constants.ADMIN_USER, adminAuthoritiesAsString);
        }

        return authoritiesMap.getOrDefault(userType, "");
    }
}
