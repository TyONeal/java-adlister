USE adlister_db;

CREATE TABLE IF NOT EXISTS users(
                                    id INT AUTO_INCREMENT NOT NULL,
                                    username VARCHAR(30) NOT NULL UNIQUE,
                                    email VARCHAR (40) NOT NULL UNIQUE,
                                    password VARCHAR (16) NOT NULL,
                                    PRIMARY KEY(id)
)


;