package com.codeup.adlister.dao;

import config.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Todos todosDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Todos getTodosDao() {
        if (todosDao == null) {
            todosDao = new MySQLTodosDao(config);
        }
        return todosDao;
    }
}
