CREATE TABLE IF NOT EXISTS menus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (250) NOT NULL,
    price INT DEFAULT 0,
    type VARCHAR(20) DEFAULT 'F',
    category VARCHAR(50) DEFAULT 'MAIN'
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    table_no VARCHAR (50) NOT NULL,
    total INT DEFAULT 1,
    price INT DEFAULT 0,
    total_price INT NOT NULL,
    menu_id INT NOT NULL,
    menu_name VARCHAR(250) DEFAULT '',
    chef_id int NOT NULL,
    waiter_id int NOT NULL,
    status VARCHAR(20) DEFAULT 'CREATED'
);

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    role VARCHAR (20) NOT NULL
);

INSERT INTO menus (name, price, type, category) VALUES
('Grill Chicken with Mushed Potatoes and Sautee Vegetables', 10000, 'F', 'MAIN'),
('Chicken Cordon Bleu', 100000, 'F', 'MAIN'),
('Fettuccine Carbonara', 100000, 'F', 'MAIN'),
('Seared Scallops With Brown Butter and Lemon Pan Sauce', 100000, 'F', 'MAIN'),
('Grilled Pizza', 50000, 'F', 'MAIN'),
('Smoked kipper pâté with melba toasts', 100000, 'F', 'STARTER'),
('Beetroot with herby tzatziki', 100000, 'F', 'STARTER'),
('Charred leek and goat''s cheese tartlets', 50000, 'F', 'STARTER'),
('Seared Scallops With Brown Butter and Lemon Pan Sauce', 100000, 'F', 'SIDE'),
('Grilled Pizza', 50000, 'F', 'SIDE'),
('Smoked kipper pâté with melba toasts', 100000, 'F', 'SIDE'),
('Beetroot with herby tzatziki', 100000, 'F', 'SIDE'),
('Charred leek and goat''s cheese tartlets', 50000, 'F', 'SIDE'),
('Seared Scallops With Brown Butter and Lemon Pan Sauce', 100000, 'F', 'SNACK'),
('Grilled Pizza', 50000, 'F', 'SNACK'),
('Smoked kipper pâté with melba toasts', 100000, 'D', NULL),
('Beetroot with herby tzatziki', 100000, 'D', NULL),
('Charred leek and goat''s cheese tartlets', 50000, 'D', NULL),
('Seared Scallops With Brown Butter and Lemon Pan Sauce', 100000, 'D', NULL),
('Grilled Pizza', 50000, 'D', NULL);

INSERT INTO users (name, role) VALUES
('chef', 'CHEF'),
('waiter', 'WAITER');