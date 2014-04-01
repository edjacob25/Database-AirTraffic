CREATE DATABASE AirTraffic;
USE AirTraffic;

CREATE TABLE Airport(
	airport_code varchar(3),
	name varchar(20),
	address varchar(60),
	PRIMARY KEY (airport_code)
);

CREATE TABLE Airline(
	airline_code varchar(5),
	name varchar(20),
	base varchar(3),
	FOREIGN KEY (base) REFERENCES Airport(airport_code),
	PRIMARY KEY (airline_code)
);

CREATE TABLE Airplane(
	plate varchar(8),
	owner varchar(5),
	model varchar(20),
	hours_on_flight int,
	FOREIGN KEY (owner) REFERENCES Airline(airline_code),
	PRIMARY KEY (plate)
);

CREATE TABLE Flight(
	flight_number int, 
	status varchar(20),
	plane varchar(8),
	origin varchar(3),
	destination varchar(3),
	departure datetime,
	arrival datetime,
	FOREIGN KEY (plane) REFERENCES Airplane(plate),
	FOREIGN KEY (origin) REFERENCES Airport(airport_code),
	FOREIGN KEY (destination) REFERENCES Airport(airport_code),
	PRIMARY KEY (flight_number)
);
