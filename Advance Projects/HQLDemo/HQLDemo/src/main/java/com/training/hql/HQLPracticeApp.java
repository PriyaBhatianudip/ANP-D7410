package com.training.hql;

import com.training.hql.entity.Student;
import com.training.hql.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLPracticeApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            boolean running = true;
            while (running) {
                printMenu();
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine().trim();

                try {
                    switch (choice) {
                        case "1" -> showAllStudents();
                        case "2" -> showSelectedColumns();
                        case "3" -> filterByMinimumMarks();
                        case "4" -> filterByCity();
                        case "5" -> sortByMarks();
                        case "6" -> showDistinctCities();
                        case "7" -> showAggregateStatistics();
                        case "8" -> showDepartmentStudentCounts();
                        case "9" -> showDepartmentsWithAverageAbove();
                        case "10" -> searchNames();
                        case "11" -> showStudentsWithoutDepartment();
                        case "12" -> showStudentsWithDepartment();
                        case "13" -> showFirstPage();
                        case "14" -> updateMarks();
                        case "15" -> deleteStudentsBelowMarks();
                        case "16" -> showStudentsUsingSubquery();
                        case "0" -> running = false;
                        default -> System.out.println("Invalid option. Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Operation failed: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } finally {
            HibernateUtil.shutdown();
            scanner.close();
        }
    }

    private static void printMenu() {
        System.out.println("\n========== HQL PRACTICE MENU ==========");
        System.out.println("1.  FROM: Show all students");
        System.out.println("2.  SELECT: Show selected properties");
        System.out.println("3.  WHERE + named parameter: Filter by minimum marks");
        System.out.println("4.  WHERE: Filter by city");
        System.out.println("5.  ORDER BY: Sort students by marks");
        System.out.println("6.  DISTINCT: Show unique cities");
        System.out.println("7.  Aggregate functions: COUNT, AVG, MIN, MAX");
        System.out.println("8.  GROUP BY: Count students by department");
        System.out.println("9.  HAVING: Departments with average marks above a value");
        System.out.println("10. LIKE: Search names by pattern");
        System.out.println("11. LEFT JOIN: Students without a department");
        System.out.println("12. JOIN FETCH: Students with departments");
        System.out.println("13. Pagination: Show first 3 students");
        System.out.println("14. UPDATE: Change marks for a student");
        System.out.println("15. DELETE: Delete students below a marks threshold");
        System.out.println("16. Subquery: Students scoring above overall average");
        System.out.println("0.  Exit");
        System.out.println("=======================================");
    }

    private static void showAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("FROM Student s ORDER BY s.id", Student.class)
                    .getResultList();
            students.forEach(System.out::println);
        }
    }

    private static void showSelectedColumns() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Object[]> rows = session.createQuery(
                    "SELECT s.name, s.marks FROM Student s ORDER BY s.name", Object[].class)
                    .getResultList();
            rows.forEach(row -> System.out.println("Name: " + row[0] + ", marks: " + row[1]));
        }
    }

    private static void filterByMinimumMarks() {
        double min = readDouble("Minimum marks: ");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> rows = session.createQuery(
                    "FROM Student s WHERE s.marks >= :min ORDER BY s.marks DESC", Student.class)
                    .setParameter("min", min)
                    .getResultList();
            rows.forEach(System.out::println);
        }
    }

    private static void filterByCity() {
        String city = readText("City: ");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> rows = session.createQuery(
                    "FROM Student s WHERE lower(s.city) = lower(:city)", Student.class)
                    .setParameter("city", city)
                    .getResultList();
            rows.forEach(System.out::println);
        }
    }

    private static void sortByMarks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> rows = session.createQuery(
                    "FROM Student s ORDER BY s.marks DESC, s.name ASC", Student.class)
                    .getResultList();
            rows.forEach(System.out::println);
        }
    }

    private static void showDistinctCities() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<String> cities = session.createQuery(
                    "SELECT DISTINCT s.city FROM Student s ORDER BY s.city", String.class)
                    .getResultList();
            cities.forEach(System.out::println);
        }
    }

    private static void showAggregateStatistics() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Object[] stats = session.createQuery(
                    "SELECT COUNT(s), AVG(s.marks), MIN(s.marks), MAX(s.marks) FROM Student s",
                    Object[].class).getSingleResult();
            System.out.println("Count = " + stats[0]);
            System.out.println("Average marks = " + stats[1]);
            System.out.println("Minimum marks = " + stats[2]);
            System.out.println("Maximum marks = " + stats[3]);
        }
    }

    private static void showDepartmentStudentCounts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Object[]> rows = session.createQuery(
                    "SELECT d.name, COUNT(s) FROM Department d LEFT JOIN d.students s " +
                            "GROUP BY d.name ORDER BY d.name", Object[].class)
                    .getResultList();
            rows.forEach(row -> System.out.println(row[0] + " -> " + row[1] + " students"));
        }
    }

    private static void showDepartmentsWithAverageAbove() {
        double average = readDouble("Minimum department average marks: ");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Object[]> rows = session.createQuery(
                    "SELECT d.name, AVG(s.marks) FROM Department d JOIN d.students s " +
                            "GROUP BY d.name HAVING AVG(s.marks) > :average ORDER BY AVG(s.marks) DESC",
                    Object[].class)
                    .setParameter("average", average)
                    .getResultList();
            rows.forEach(row -> System.out.println(row[0] + " -> average " + row[1]));
        }
    }

    private static void searchNames() {
        String prefix = readText("Enter name prefix (e.g. A): ");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> rows = session.createQuery(
                    "FROM Student s WHERE lower(s.name) LIKE lower(:pattern) ORDER BY s.name",
                    Student.class)
                    .setParameter("pattern", prefix + "%")
                    .getResultList();
            rows.forEach(System.out::println);
        }
    }

    private static void showStudentsWithoutDepartment() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> rows = session.createQuery(
                    "FROM Student s LEFT JOIN s.department d WHERE d IS NULL", Student.class)
                    .getResultList();
            if (rows.isEmpty()) System.out.println("No students without a department were found.");
            rows.forEach(System.out::println);
        }
    }

    private static void showStudentsWithDepartment() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> rows = session.createQuery(
                    "SELECT s FROM Student s JOIN FETCH s.department ORDER BY s.name", Student.class)
                    .getResultList();
            rows.forEach(s -> System.out.println(s + ", department=" + s.getDepartment().getName()));
        }
    }

    private static void showFirstPage() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> rows = session.createQuery(
                            "FROM Student s ORDER BY s.id", Student.class)
                    .setFirstResult(0)
                    .setMaxResults(3)
                    .getResultList();
            rows.forEach(System.out::println);
        }
    }

    private static void updateMarks() {
        long id = readLong("Student ID to update: ");
        double marks = readDouble("New marks: ");
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            int changed = session.createMutationQuery(
                            "UPDATE Student s SET s.marks = :marks WHERE s.id = :id")
                    .setParameter("marks", marks)
                    .setParameter("id", id)
                    .executeUpdate();
            tx.commit();
            System.out.println("Rows updated: " + changed);
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
    }

    private static void deleteStudentsBelowMarks() {
        double threshold = readDouble("Delete students below marks (this permanently removes matching rows): ");
        System.out.print("Type DELETE to confirm: ");
        if (!scanner.nextLine().trim().equals("DELETE")) {
            System.out.println("Delete cancelled.");
            return;
        }
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            int deleted = session.createMutationQuery(
                            "DELETE FROM Student s WHERE s.marks < :threshold")
                    .setParameter("threshold", threshold)
                    .executeUpdate();
            tx.commit();
            System.out.println("Rows deleted: " + deleted);
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
    }

    private static void showStudentsUsingSubquery() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> rows = session.createQuery(
                    "FROM Student s WHERE s.marks > (SELECT AVG(s2.marks) FROM Student s2) " +
                            "ORDER BY s.marks DESC", Student.class)
                    .getResultList();
            rows.forEach(System.out::println);
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readText(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(readText(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}
