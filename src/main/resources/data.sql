INSERT INTO users (user_id, user_role, user_name, user_email, user_region, user_birth, user_gender)
SELECT 'admin_id', 'admin', 'Admin', 'example.com', 12, NULL, NULL
    WHERE NOT EXISTS (
    SELECT 'admin' FROM users WHERE user_id = 'admin_id'
);