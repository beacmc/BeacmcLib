package com.beacmc.beacmclib.sql;


import com.beacmc.beacmclib.BeacmcLib;
import org.bukkit.Bukkit;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

    private static Connection connection;
    private static Statement statement;

    private static String urlConnection = null;

    public Connector(String type, String host, String database, String user, String password) {

        switch (type) {
            case "mysql": {
                urlConnection = "jdbc:mysql:" + host + "/" + database;
                break;
            }
            case "sqlite": {
                urlConnection = "jdbc:sqlite:" + BeacmcLib.getInstance().getDataFolder().getAbsolutePath() + "/database.db";
                break;
            }
            default: {
                Bukkit.getLogger().severe("Неизвестный тип базы данных. Плагин принудительно остановлен.");
                Bukkit.getPluginManager().disablePlugin(BeacmcLib.getInstance());
                return;
            }
        }


        try {
            if(urlConnection == null)
                return;

            connection = DriverManager.getConnection(urlConnection, user, password);

            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
