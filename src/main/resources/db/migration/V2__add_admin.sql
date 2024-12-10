-- Flyway migration to add admin user
INSERT INTO profile (
   id, name,surname,username,password,profile_status,profile_role,created_date)
VALUES('e1d3f7b0-83a4-43c8-bd2c-5e5b3d3c8a99','Admin', 'Adminjonov',  'admin','$2a$10$7Q0.y6Jc3iVvP/EsukW7Qu9D3zKv/8o0BzIfuyy7Z1WRdVub4FBCm', -- Parol: 1dan8gacha (bcryptlangan)
           'ACTIVE', 'ROLE_ADMIN',NOW());
