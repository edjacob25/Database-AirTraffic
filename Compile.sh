#!/bin/bash
rm *.class
javac -classpath .:mysql/mysql-connector.jar ProyectoIUG.java
java -classpath .:mysql/mysql-connector.jar ProyectoIUG
