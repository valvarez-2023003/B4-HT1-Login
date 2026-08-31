DROP DATABASE IF EXISTS auditoria_usuario_producto_in4am;
CREATE DATABASE auditoria_usuario_producto_in4am;
USE auditoria_usuario_producto_in4am;

CREATE TABLE Users(
	name VARCHAR(50) NOT NULL CHECK(length(name)<=50),
    lastname varchar(50) not null check(length(lastname) <= 50),
	email varchar(50) not null check( length(email) <= 50 ),
	user varchar(25) not null check( length(user) <= 25),
	password varchar(35) not null check(length(password) <= 35),
    id_user varchar(36) not null,
	constraint pk_users primary key (id_user)
);

# Uso de contraint para validar estructura e informacion
DELIMITER $$
	CREATE PROCEDURE sp_create_users(IN name_p VARCHAR(50),
									 IN lastname_p VARCHAR(50),
                                     IN email_p VARCHAR(50),
                                     IN user_p VARCHAR(25),
                                     IN password_p VARCHAR(35))
	BEGIN
		INSERT INTO Users(name, lastname,email,user,password,id_user)
        VALUES(name_p,lastname_p,email_p,user_p,password_p,uuid());
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_login(
    IN user_or_email_p VARCHAR(50),
    IN password_p VARCHAR(35)
)
BEGIN
    SELECT 
        id_user AS idUser,
        name,
        lastname,
        email,
        user,
        password
    FROM Users
    WHERE (user = user_or_email_p OR email = user_or_email_p)
      AND password = password_p;
END$$
DELIMITER ;


CALL sp_create_users("a","a","a@","a","a123");
SELECT * FROM Users;