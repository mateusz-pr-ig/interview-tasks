package com.jmatt.interview.task3;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserMigrationTest {

    @Test
    void shouldMergeUsersFromDifferentSources() {
        UserMigrationService migrationService = new UserMigrationService();

        // Mock data sources
        List<User> csvUsers = List.of(
                new User("john@example.com", "John", "Doe", "1990-01-01"),
                new User("jane@example.com", "Jane", "Smith", null)
        );

        List<User> dbUsers = List.of(
                new User("john@example.com", "John", "Doe", "1990-01-15"),
                new User("mike@example.com", "Michael", "Brown", "1985-05-20")
        );

        List<User> result = migrationService.migrateUsers(csvUsers, dbUsers);

        assertEquals(3, result.size());

        // Verify merge - dobieranie najnowszej daty urodzenia
        Optional<User> john = result.stream()
                .filter(u -> u.email().equals("john@example.com"))
                .findFirst();

        assertTrue(john.isPresent());
        assertEquals("1990-01-15", john.get().birthDate());

        // Verify all users are present
        assertTrue(result.stream().anyMatch(u -> u.email().equals("jane@example.com")));
        assertTrue(result.stream().anyMatch(u -> u.email().equals("mike@example.com")));
    }

    @Test
    public void shouldHandleEmptySources() {
        UserMigrationService migrationService = new UserMigrationService();

        List<User> result = migrationService.migrateUsers(List.of(), List.of());

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldPrioritizeDbDataForConflicts() {
        UserMigrationService migrationService = new UserMigrationService();

        List<User> csvUsers = List.of(
                new User("user@test.com", "CSV", "Version", null)
        );

        List<User> dbUsers = List.of(
                new User("user@test.com", "DB", "Version", "2000-01-01")
        );

        List<User> result = migrationService.migrateUsers(csvUsers, dbUsers);

        assertEquals(1, result.size());
        assertEquals("DB", result.get(0).firstName());
        assertEquals("2000-01-01", result.get(0).birthDate());
    }
}