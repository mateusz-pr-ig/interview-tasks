package com.jmatt.interview.task3;// TODO: Implement below classes to make tests pass

import java.util.List;

record User(String email, String firstName, String lastName, String birthDate) {
    // TODO: Add any necessary methods
}

class UserMigrationService {

    public List<User> migrateUsers(List<User> csvUsers, List<User> dbUsers) {
        // TODO: Implement migration logic that:
        // 1. Merges users from both sources (merge by email)
        // 2. In case of conflicts, prefers data from the DB
        // 3. For date of birth, takes the most recent available
        // 4. Keeps all unique users

        return List.of();
    }
}