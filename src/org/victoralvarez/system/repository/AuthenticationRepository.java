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
 * @author victo
 */
public class AuthenticationRepository implements AuthenticationInterface {

    private CallableStatement callSP;
    private ResultSet resultSet;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    public AuthenticationRepository() {
    }

    @Override
    public Users login(String usernameOrEmail, String password) {
        Users userFound = null;
        try {
            callSP = conexionDB.getConnection().prepareCall("{call sp_login(?, ?)}");
            callSP.setString(1, usernameOrEmail);
            callSP.setString(2, password);

            resultSet = callSP.executeQuery();

            if (resultSet.next()) {
                userFound = new Users(
                    resultSet.getString("idUser"),
                    resultSet.getString("email"),
                    resultSet.getString("name"),
                    resultSet.getString("lastname"),
                    resultSet.getString("password"),
                    resultSet.getString("user")
                );
            }

            resultSet.close();
            callSP.close();
        } catch (Exception e) {
            System.out.println("ERROR AL AUTENTICAR USUARIO");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return userFound;
    }
}
