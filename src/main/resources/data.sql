INSERT INTO users (USER_ID, USER_NAME, USER_EMAIL, USER_PW, USER_REGION, USER_BIRTH, USER_GENDER, CREATED, MODIFIED)
VALUES
    ('user1', 'John Doe', 'john@example.com', 'password1', 'Region1', '1990-01-01', 'Male', CURRENT_TIMESTAMP, NULL),
    ('user2', 'Jane Smith', 'jane@example.com', 'password2', 'Region2', '1995-05-15', 'Female', CURRENT_TIMESTAMP, NULL),
    ('user3', 'Alice Lee', 'alice@example.com', 'password3', 'Region3', '1985-11-30', 'Female', CURRENT_TIMESTAMP, NULL);
