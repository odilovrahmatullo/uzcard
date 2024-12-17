-- Flyway migration to add admin user
INSERT INTO profile (id, name,surname,username,password,profile_status,profile_role,created_date)
VALUES('e1d3f7b0-83a4-43c8-bd2c-5e5b3d3c8a99','Admin', 'Adminjonov',  'admin','$2b$12$GvQiQUSAx0BRfiOwL4T3cu25OSWijRTgaErebJMbcDXWPH.sNpjLC', -- Parol: 1dan8gacha (bcryptlangan)
           'ACTIVE', 'ROLE_ADMIN',NOW());
