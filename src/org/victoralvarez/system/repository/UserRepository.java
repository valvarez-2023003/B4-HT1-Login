/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.victoralvarez.system.repository;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import org.victoralvarez.system.config.ConexionDB;
import org.victoralvarez.system.model.Users;

/**
 *
 * @author informatica
 */
public class UserRepository implements UserInterface {

    private CallableStatement callSP;
    private ResultSet resultSet;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    public UserRepository() {
    }

    @Override
    public void create(Users user) {
        try {
            callSP = conexionDB.getConnection().prepareCall("{call sp_create_users(?, ?, ?, ?, ?)}");
            callSP.setString(1, user.getName());
            callSP.setString(2, user.getLastname());
            callSP.setString(3, user.getEmail());
            callSP.setString(4, user.getUser());
            callSP.setString(5, user.getPassword());
            callSP.execute();
            callSP.close();
        } catch (Exception e) {
            System.out.println("ERROR AL CREAR USUARIO EN BD");
            e.printStackTrace();
        }
    }

    @Override
    public boolean existsUserOrEmail(String userOrEmail) {
        boolean exists = false;
        try {
            callSP = conexionDB.getConnection().prepareCall("SELECT COUNT(*) FROM Users WHERE user = ? OR email = ?");
            callSP.setString(1, userOrEmail);
            callSP.setString(2, userOrEmail);
            resultSet = callSP.executeQuery();

            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }

            resultSet.close();
            callSP.close();
        } catch (Exception e) {
            System.out.println("ERROR AL VERIFICAR EXISTENCIA DE USUARIO");
            e.printStackTrace();
        }
        return exists;
    }
}