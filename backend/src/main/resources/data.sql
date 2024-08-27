-- Insert sample data into member table
INSERT INTO
  member (username, password, email, created_at)
VALUES
  ('Admin1', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin1@example.com', CURRENT_TIMESTAMP),
  ('User1', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user1@example.com', CURRENT_TIMESTAMP),
  ('Admin2', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin2@example.com', CURRENT_TIMESTAMP)
;

-- Insert sample data into role table
INSERT INTO
  role (name)
VALUES
  ('ADMIN'),
  ('USER')
;

-- Insert sample data into member_role table
INSERT INTO
  member_role (member_id, role_id)
VALUES
  (1, 1),
  (2, 2),
  (3, 1),
  (3, 2)
;