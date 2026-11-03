package com.ecommerce.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory =
            new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void shutdown() {
        factory.close();
    }
}