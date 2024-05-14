INSERT INTO users (user_id, user_role, user_name, user_email, user_region, user_birth, user_gender)
SELECT 'admin_id',
       'admin',
       'Admin',
       'example.com',
       12,
       '1996-09-07 00:00:00.000000',
       '남성' WHERE NOT EXISTS (
    SELECT 'admin' FROM users WHERE user_id = 'admin_id'
);


INSERT INTO user_details (detail_id, user_id, answer, question, user_intro, user_mbti, user_style)
SELECT 'detail_id',
       'admin_id',
       null,
       null,
       null,
       null,
       NULL WHERE NOT EXISTS (
  SELECT 'detail_id' FROM user_details WHERE user_id = 'admin_id'
);

-- INSERT INTO users (user_id, user_role, user_name, user_email, user_region, user_birth, user_gender)
-- SELECT 'admin_id',
--        'admin',
--        'Admin',
--        'example.com',
--        12,
--        NULL,
--        NULL WHERE NOT EXISTS (
--     SELECT 'admin' FROM users WHERE user_id = 'admin_id'
-- );
