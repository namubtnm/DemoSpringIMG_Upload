/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Clothes;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MacBook
 */
public class ClothesModel {
     public List<Clothes> getAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Clothes> lst = new ArrayList<Clothes>();
        try {
            session.beginTransaction();
            lst = session.createCriteria(Clothes.class).list();
            for (Clothes c : lst) {
                System.out.println("Clothes"+ c.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
        
        return lst;
    }
    
     public void create(Clothes u) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
    }
}
