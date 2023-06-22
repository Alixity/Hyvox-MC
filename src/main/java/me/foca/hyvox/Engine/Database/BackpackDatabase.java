package me.foca.hyvox.Engine.Database;

import me.foca.hyvox.Engine.Log.Log;
import me.foca.hyvox.Engine.Models.BackpackData;
import org.bukkit.inventory.ItemStack;

import java.sql.*;

public class BackpackDatabase {


    private Connection connection;

    public Connection getConnection() throws SQLException{

        if (connection != null){
            return connection;
        }

        String url = "jdbc:mysql://localhost/Backpack";
        String user = "root";
        String password = "";

        Log.info("Connected to database 'Backpack'");


        this.connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public void initializeDatabase() throws SQLException {

        Statement statement = getConnection().createStatement();

        //Create the player_stats table
        String sql = "CREATE TABLE IF NOT EXISTS backpack_data (uuid varchar(36) primary key, items )";

        statement.execute(sql);

        statement.close();
    }

    public BackpackData findPlayerStatsByUUID(String uuid) throws SQLException {

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM backpack_data WHERE uuid = ?");
        statement.setString(1, uuid);

        ResultSet resultSet = statement.executeQuery();

        BackpackData backpackData;

        if(resultSet.next()){

            backpackData = new BackpackData(resultSet.getString("uuid"), new ItemStack[] {});

            statement.close();

            return backpackData;
        }

        statement.close();

        return null;
    }



}
