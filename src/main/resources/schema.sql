CREATE TABLE AUCTION_USER
(
    id       BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(20) NOT NULL,
    active   bool
);