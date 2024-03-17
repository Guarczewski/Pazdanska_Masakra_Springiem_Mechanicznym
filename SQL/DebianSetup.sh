#To tylko dla osób którym wypierdoli się xampp
apt-get install mariadb-server
mysql_secure_installation

N -> N -> Y -> N -> Y -> Y

mysql

-> GRANT ALL ON *.* TO 'admin'@'%' IDENTIFIED BY 'password' WITH GRANT OPTION;
-> FLUSH PRIVILEGES;
-> exit

apt-get install apache2

apt-get install phpmyadmin
# Spacja na apache2 i enter

wget -P Downloads https://www.phpmyadmin.net/downloads/phpMyAdmin-latest-all-languages.tar.gz

mkdir /var/www/html/phpMyAdmin

cd Downloads

tar xvf phpMyAdmin-latest-all-languages.tar.gz --strip-components=1 -C /var/www/html/phpMyAdmin

cp /var/www/html/phpMyAdmin/config.sample.inc.php /var/www/html/phpMyAdmin/config.inc.php

nano /etc/mysql/mariadb.conf.d/ 50-server.cnf
-> bind-adress = 0.0.0.0

service mariadb restart

#Potem trzeba ip address zrobić i przeklepać ipv4 do application.properties