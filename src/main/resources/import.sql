INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Mr. John', 'Doe', 'john.doe@bolsadeideas.com', '2018-01-02');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Linus', 'Torvalds', 'linus.torvalds@bolsadeideas.com', '2018-01-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Ramus', 'Lerdorf', 'rasmus.lerdorf@bolsadeideas.com', '2018-01-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Erich', 'Camma', 'erich.gamma@bolsadeideas.com', '2018-02-01');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Richard', 'Helm', 'richard.helm@bolsadeideas.com', '2018-02-10');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Ralph', 'Johnson', 'ralph.johnson@bolsadeideas.com', '2018-02-18');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('John', 'Vlissides', 'john.vlissides@bolsadeideas.com', '2018-02-26');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Dr. James', 'Gosling', 'james.gosling@bolsadeideas.com', '2018-03-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Magma', 'Lee', 'ralph.johnson@bolsadeideas.com', '2018-03-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Tornado', 'Roe', 'tornado.roe@bolsadeideas.com', '2018-03-05');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Jade', 'Doe', 'jade.doe@bolsadeideas.com', '2018-03-06');

INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('andres', '$2a$10$v4uG5SWGd9NvmP/gRCBhR.gmrtYfvGaUi0Ltu/gr.ebBXkd1qNVhm', 1, 'Andres', 'Guzman', 'andres@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$4vZw4LSYd/xl/4FyrmBn8.2UKzS1.kFVbjquR7ian2muotQmqo0ai', 1, 'John', 'Titor', 'john@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);

