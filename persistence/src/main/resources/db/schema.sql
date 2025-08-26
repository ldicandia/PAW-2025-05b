DROP TABLE IF EXISTS vinyl CASCADE;
DROP TABLE IF EXISTS song CASCADE;
DROP TABLE IF EXISTS purchase CASCADE;
DROP TABLE IF EXISTS buyer CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE IF NOT EXISTS users (
                                     userId SERIAL PRIMARY KEY,
                                     userName VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS buyer (
                                     id BIGSERIAL PRIMARY KEY,
                                     name VARCHAR(120) NOT NULL,
                                     email VARCHAR(120) NOT NULL UNIQUE,
                                     dni VARCHAR(20) UNIQUE
);

CREATE TABLE IF NOT EXISTS vinyl (
                                     id BIGSERIAL PRIMARY KEY,
                                     title VARCHAR(160) NOT NULL,
                                     releaseDate DATE,
                                     genre VARCHAR(80),
                                     price NUMERIC(12,2) NOT NULL CHECK (price >= 0),
                                     condition VARCHAR(20) NOT NULL CHECK (condition IN ('MINT', 'NM', 'VG+', 'VG', 'G', 'P')),
                                     publicationStatus VARCHAR(20) NOT NULL CHECK (publicationStatus IN ('active', 'paused', 'sold')),
                                     createdAt TIMESTAMP NOT NULL DEFAULT now(),
                                     stock INTEGER NOT NULL CHECK (stock >= 0) DEFAULT 1
);

CREATE TABLE IF NOT EXISTS song (
                                    id BIGSERIAL PRIMARY KEY,
                                    vinylId BIGINT NOT NULL REFERENCES vinyl(id) ON DELETE CASCADE,
                                    title VARCHAR(160) NOT NULL,
                                    artist VARCHAR(160) NOT NULL,
                                    durationSec INTEGER CHECK (durationSec IS NULL OR durationSec > 0),
                                    position VARCHAR(10),
                                    UNIQUE (vinylId, title)
);

CREATE TABLE IF NOT EXISTS purchase (
                                        id BIGSERIAL PRIMARY KEY,
                                        buyerId BIGINT NOT NULL REFERENCES buyer(id) ON DELETE RESTRICT,
                                        vinylId BIGINT NOT NULL REFERENCES vinyl(id) ON DELETE RESTRICT,
                                        status VARCHAR(20) NOT NULL CHECK (status IN ('created', 'moneySent', 'moneyReceived', 'vinylSent', 'vinylDelivered')),
                                        price NUMERIC(12,2) NOT NULL CHECK (price >= 0),
                                        createdAt TIMESTAMP NOT NULL DEFAULT now(),
                                        paidAt TIMESTAMP,
                                        paymentReceivedAt TIMESTAMP,
                                        sentAt TIMESTAMP,
                                        deliveredAt TIMESTAMP
);