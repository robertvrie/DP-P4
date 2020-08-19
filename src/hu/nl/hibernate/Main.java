package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
  private static SessionFactory factory;
  public static void main(String[] args) throws SQLException, ParseException {
      try {
        factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex);
      }

      Session session = factory.openSession();
      Transaction t = session.beginTransaction();

      //Leest k1 uit de database
      KlantDetails k1 = (KlantDetails)session.get(KlantDetails.class, 1);
      System.out.println(k1.getVoornaam());
      //Update het tussenvoegsel
      k1.setTussenvoegsel("van");
      session.update(k1);

      //Verwijderd k1 uit de database
      session.delete(k1);

      //Geeft k1 weer een tussenvoegsel en slaat k1 op in de database
      k1.setTussenvoegsel(null);
      System.out.println(session.save(k1));


      Log log = new Log(1,"Hibernate works!");

      session.save(log);
      t.commit();  
      System.out.println("successfully saved");    
      factory.close();  
      session.close();   
  }
}
