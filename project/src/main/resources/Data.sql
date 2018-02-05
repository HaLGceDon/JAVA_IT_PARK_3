INSERT INTO public.users
(id, login, name, age, surname, hash_password, email, registration_time, state, role)
  SELECT
    1,
    'admin',
    'admin',
    '1',
    'admin',
    '$2a$10$mMZ6ZTpZ4GMj386kVZqjP.436D6BbbZ7Va4K5.hXAp2oIpK4n33Iq',
    'admi@admin.com',
    '2018-01-01 21:25:57.990000',
    'CONFIRMED',
    'ADMIN'
  WHERE
    NOT EXISTS(
        SELECT id
        FROM users
        WHERE id = 1
);

INSERT INTO public.tickets
(id, name, adult_price, kids_price)
    SELECT
      1,
      'zooMain',
      '600',
      '300'
    WHERE
      NOT EXISTS(
          SELECT id
          FROM tickets
          WHERE id = 1
);

CREATE TABLE IF NOT EXISTS persistent_logins (
  username VARCHAR(64) NOT NULL,
  series VARCHAR(64) PRIMARY KEY NOT NULL,
  token VARCHAR(64) NOT NULL,
  last_used TIMESTAMP NOT NULL
)
