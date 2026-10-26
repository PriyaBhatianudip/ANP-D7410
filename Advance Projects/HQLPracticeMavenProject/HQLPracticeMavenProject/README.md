# HQL Practice Maven Project

A menu-driven Hibernate + Maven project for practising common HQL queries with MySQL.

## Requirements
- JDK 17 or newer
- Maven 3.8+
- MySQL Server
- IDE such as IntelliJ IDEA or Eclipse

## Setup
1. Create/open this folder as a Maven project.
2. Open `src/main/resources/hibernate.cfg.xml`.
3. Replace `CHANGE_ME` with your local MySQL password.
4. The JDBC URL includes `createDatabaseIfNotExist=true`; the MySQL user must have permission to create the `hql_practice` database. Alternatively, create it manually:
   ```sql
   CREATE DATABASE hql_practice;
   ```
   Then you can remove `createDatabaseIfNotExist=true` from the JDBC URL if preferred.
5. Ensure the MySQL service is running.
6. Let Maven download dependencies.

Hibernate is configured with `hibernate.hbm2ddl.auto=update`, so it creates/updates the mapped tables. Use this only for practice, not production.

## Run the project
Run these classes in order:
1. `com.training.hql.SeedData` — inserts sample departments and students once.
2. `com.training.hql.HQLPracticeApp` — starts the interactive menu.

You can run either class from the IDE. From a terminal, use an IDE run configuration or configure an execution plugin.

## HQL topics covered in the menu
1. `FROM` and `ORDER BY`
2. `SELECT` projections
3. `WHERE` with named parameters
4. Case-insensitive filtering
5. `ORDER BY ASC/DESC`
6. `DISTINCT`
7. `COUNT`, `AVG`, `MIN`, `MAX`
8. `GROUP BY`
9. `HAVING`
10. `LIKE`
11. `LEFT JOIN`
12. `JOIN FETCH`
13. Pagination with `setFirstResult()` and `setMaxResults()`
14. Bulk `UPDATE`
15. Bulk `DELETE` with confirmation
16. Subquery with an aggregate function

## Data model
- `Department` has many `Student` records.
- `Student` belongs to one `Department` (the association is optional).

## Important notes
- HQL uses entity names (`Student`, `Department`) and Java property names (`marks`, `city`), not physical table/column names.
- Bulk update/delete operations are destructive and execute in a transaction. The delete option asks for confirmation.
- The LEFT JOIN example that finds students without a department returns no rows with the seeded data because every seeded student has a department. You can create a student without a department to practise that case.
- The project uses Hibernate 6.6 typed query APIs. API names may differ in older Hibernate versions.
- Do not put production credentials into a shared repository.
