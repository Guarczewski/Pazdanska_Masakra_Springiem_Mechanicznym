
CREATE USER 'example'@'%' IDENTIFIED BY 'password';

DROP DATABASE examplebase;

CREATE DATABASE examplebase;

GRANT ALL ON examplebase.* TO 'example'@'%' WITH GRANT OPTION;

-- Jak tu coś zmienisz, to trzeba zmienić też w application.properties