package com.example.Voting_System.Config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static Map<String, String> getAuthoritiesForUser(){

        HashMap<String, String> authoritiesMap = new HashMap<>();

        List<String> voterAuthorities =
                Arrays.asList(
                        Constants.VOTER_INFO_SELF_AUTHORITY,
                        Constants.VOTE_AUTHORITY
                );

        List<String> adminAuthorities =
                Arrays.asList(
                        Constants.VOTER_INFO_AUTHORITY,
                        Constants.CREATE_ADMIN_AUTHORITY,
                        Constants.CREATE_CANDIDATE_AUTHORITY,
                        Constants.CREATE_VOTER_AUTHORITY,
                        Constants.SEE_CANDIDATES_AUTHORITY
                );

        String voterAuthoritiesAsString = String.join(Constants.DELIMITER, voterAuthorities);

        String adminAuthoritiesAsString = String.join(Constants.DELIMITER, adminAuthorities);

        authoritiesMap.put(Constants.VOTER_USER, voterAuthoritiesAsString);
        authoritiesMap.put(Constants.ADMIN_USER, adminAuthoritiesAsString);

        return authoritiesMap;

    }
}