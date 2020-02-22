CREATE DATABASE Store;

USE Store;

CREATE TABLE Product (
	ProdID VARCHAR(255) NOT NULL, 
	ProdDesc VARCHAR(255) NOT NULL, 
	ProdPrice DOUBLE(6,2) NOT NULL, 
	ProdQuant INT NULL, 
	ProdPictLocation VARCHAR(255) NULL, 
	PRIMARY KEY (ProdID)
);

INSERT INTO Product (ProdID, ProdDesc, ProdPrice, ProdQuant, ProdPictLocation) VALUES 
	("001", "Adidas Track Jacket", 79.99, 0, "./img/adidas-jacket.jpg"), 
	("002", "Fila Track Jacket", 99.99, 0, "./img/fila-jacket.jpg"), 
	("003", "Hugo Boss Track Jacket", 119.99, 0, "./img/boss-jacket.jpg"), 
	("004", "Hummel Track Jacket", 59.99, 0, "./img/hummel-jacket.jpg"), 
	("005", "Kappa Track Jacket", 69.99, 0, "./img/kappa-jacket.jpg"), 
	("006", "Lacoste Track Jacket", 79.99, 0, "./img/lacoste-jacket.jpg"), 
	("007", "Nike Track Jacket", 69.99, 0, "./img/nike-jacket.jpg"), 
	("008", "Puma Track Jacket", 79.99, 0, "./img/puma-jacket.jpg"), 
	("009", "Reebok Track Jacket", 69.99, 0, "./img/reebok-jacket.jpg"), 
	("010", "Umbro Track Jacket", 59.99, 0, "./img/umbro-jacket.jpg");
