
--Initialize default Admin
INSERT INTO role(id, name, description) VALUES (1, 'ADMIN', 'Administrator');
INSERT INTO role(id, name, description) VALUES (2, 'USER', 'User');

INSERT INTO user (id, username, email, firstname, lastname, password, role_id)
VALUES (1, 'admin', 'admin@kpi.org', 'Admin', 'Admin', '$2a$04$0VjCCNbL1eYLRGezRtQHp.pLfecRzSUipLGhyw9PKPaNnFgg9/djG', 1);

