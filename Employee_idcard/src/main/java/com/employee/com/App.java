package com.employee.com;

import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        // CREATE
        em.getTransaction().begin();

        Employee emp = new Employee();
        emp.setName("John");
        emp.setEmail("john@example.com");

        IDCard card = new IDCard();
        card.setCardNumber("IDC101");
        card.setIssueDate(LocalDate.of(2026, 2, 14));

        // Set relationship BOTH SIDES
        card.setEmployee(emp);
        emp.setIdCard(card);

        em.persist(emp); // Cascade saves IDCard

        em.getTransaction().commit();

        System.out.println("Employee Created Successfully");

        // RETRIEVE Employee
        Employee retrievedEmp = em.find(Employee.class, 1);

        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + retrievedEmp.getId());
        System.out.println("Name: " + retrievedEmp.getName());
        System.out.println("Email: " + retrievedEmp.getEmail());

        System.out.println("\nID Card Details:");
        System.out.println("Card Number: " +
                retrievedEmp.getIdCard().getCardNumber());
        System.out.println("Issue Date: " +
                retrievedEmp.getIdCard().getIssueDate());

        // RETRIEVE IDCard
        IDCard retrievedCard = em.find(IDCard.class, 1);

        System.out.println("\nEmployee from IDCard:");
        System.out.println(retrievedCard.getEmployee().getName());

        em.close();
        emf.close();
    }
}
