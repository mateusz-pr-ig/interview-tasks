package com.infogain.interview.task3;// TODO: Implement below classes to make tests pass

import java.util.List;

record User(String email, String firstName, String lastName, String birthDate) {
    // TODO: Add any necessary methods
}

class UserMigrationService {

    public List<User> migrateUsers(List<User> csvUsers, List<User> dbUsers) {
        // TODO: Zaimplementuj logikę migracji która:
        // 1. Łączy użytkowników z obu źródeł (merge po emailu)
        // 2. W przypadku konfliktów preferuje dane z DB
        // 3. Dla daty urodzenia bierze najnowszą dostępną
        // 4. Zachowuje wszystkich unikalnych użytkowników

        return List.of();
    }
}