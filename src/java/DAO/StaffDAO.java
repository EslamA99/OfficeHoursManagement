/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import models.Staff;
import models.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * CRUD database operations
 *
 * @author Ramesh Fadatare
 *
 */
public class StaffDAO {

    public static void saveStaff(Staff staff) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the staff object
            session.save(staff);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void updateStaff(Staff staff) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the staff object
            session.update(staff);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void deleteStaff(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            Staff staff = session.get(Staff.class, id);
            if (staff != null) {
                session.delete(staff);
                System.out.println("staff is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static Staff getStaff(String userName) {

        Transaction transaction = null;
        Staff staff = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            staff = (Staff) session.createQuery("FROM Staff U WHERE U.username = :userName").setParameter("userName", userName)
                    .uniqueResult();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return staff;
    }
    public static List< Staff> getStaffsWithName(String name) {

        Transaction transaction = null;
        List< Staff> listOfStaff = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            listOfStaff = session.createQuery("FROM Staff U WHERE U.name = :name").setParameter("name", name).getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStaff;
    }

    @SuppressWarnings("unchecked")
    public static List< Staff> getAllstaff() {

        Transaction transaction = null;
        List< Staff> listOfStaff = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            listOfStaff = session.createQuery("from Staff").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStaff;
    }
}
