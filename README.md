# summer_practice_2022
My summer practice in 2022, I was need create an application that will communicate with DB, I used mySQL by xampp.

# Greetings
<p>Hello everyone, this is my project practice from summer 2022. </p>

# What this project do

<p>This project helping us to store the data toys shop in table SQL. It allows Create, Read, Update, Delete the data. Also there is search by columns and native sorting by JavaFX.</p>

# Features

<p> You can upload data with random from src/main/test/WorkWithData/AddData.java by execute it. It add 100 random records in SQL table.</p>

# Using

1. For use it you need first download all project. 

2. Also you need download xampp, create DB with name DataBaseStudy or change it on yours, but I not recommended it, because you need also change names in whole project. 

3. You need create table with name ToysShop and add there specific columns. 

<p>I insist on you to use this SQL commands</p>


    CREATE DATABASE DataBaseStudy;
    USE DataBaseStudy;
    CREATE TABLE ToysShop(id INT PRIMARY KEY NOT NULL, name VARCHAR(50) NOT NULL, articul INT NOT NULL, manufacture VARCHAR(50) NOT NULL, dateCome DATE NOT NULL, dateSell DATE NOT NULL, type VARCHAR(50) NOT NULL, price DOUBLE NOT NULL);
    
    
<p>You can  change GUI manualy in fxml files, but I recomended you Scene Builder. </p>
<p>Whole the project consist with russian language, enjoy</p>

# Notes

Project is working on JavaFX and communicate with MariaDB by xampp, it's mySQL.

From folder <i>src/main/test/WorkWithData</i> you can Add more data (100 records) or Delete all data or manually Update some position.

In folder <i>src/main/test/receivingData</i> you can Read data from console output. 

For this you need execute all listed files. 

In folder <i>src/main/resources/Frontend</i> exist fxml files which allows you to change GUI.

All logic are in <i>src/main/java/GUI/Backend</i>

Toys.java is model for work GUI and representation SQL records.

SQL folder allows you to work with SQL logic. 

Controllers folder allows you to work with GUI logic.

There are various checks for empty fields and logical calculations - for example, the sale date cannot be earlier than the date come

## This is how my program look
![изображение](https://user-images.githubusercontent.com/106434706/210998834-472ca88e-fe09-43a1-926b-d51fdba15282.png)

### Button "Создать" - modal window
![изображение](https://user-images.githubusercontent.com/106434706/210998887-833b89a1-8401-4b88-9cd9-76620e19c824.png)

### Button "Редактировать" - modal window
![изображение](https://user-images.githubusercontent.com/106434706/210998990-88bfe3fe-ee8c-4ac2-b474-cc354869d93b.png)

### Demonstration of search field
![изображение](https://user-images.githubusercontent.com/106434706/210999101-164a398c-5e9c-4f28-a53a-55a3b5af0f48.png)
