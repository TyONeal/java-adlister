USE adlister_db;

CREATE TABLE IF NOT EXISTS ads(
                            id INT AUTO_INCREMENT NOT NULL,
                            user_id INT NOT NULL,
                            title VARCHAR(30) NOT NULL,
                            description VARCHAR(100) NOT NULL,
                            PRIMARY KEY (id),
                            CONSTRAINT user_id_id_ads_fk FOREIGN KEY (user_id) REFERENCES users(id)
)
;