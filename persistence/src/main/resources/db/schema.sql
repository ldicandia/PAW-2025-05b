CREATE TABLE IF NOT EXISTS  users (
    userid SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS comprador (
                           id              BIGSERIAL PRIMARY KEY,
                           nombre          VARCHAR(120) NOT NULL,
                           email           VARCHAR(120) NOT NULL UNIQUE,
                           dni             VARCHAR(20) UNIQUE
);

DROP TABLE IF EXISTS vinilo CASCADE;
CREATE TABLE IF NOT EXISTS vinilo (
                        id                BIGSERIAL PRIMARY KEY,
                        nombre            VARCHAR(160) NOT NULL,
                        fecha_lanzamiento DATE,                      -- la "fecha" del pizarrón
                        genero            VARCHAR(80),
                        precio            NUMERIC(12,2) NOT NULL CHECK (precio >= 0),
                        condicion         vinyl_condition NOT NULL DEFAULT 'VG',
                        estado_publicacion publication_status NOT NULL DEFAULT 'activa',
                        creado_en         TIMESTAMPTZ NOT NULL DEFAULT now(),
                        stock               INTEGER NOT NULL CHECK (stock >=0) DEFAULT 1
);

DROP TABLE IF EXISTS cancion;
CREATE TABLE IF NOT EXISTS cancion (
                         id           BIGSERIAL PRIMARY KEY, -- ¿? ver si lo sacamos
                         vinilo_id    BIGINT NOT NULL REFERENCES vinilo(id) ON DELETE CASCADE,
                         titulo       VARCHAR(160) NOT NULL,
                         artista           VARCHAR(160) NOT NULL,
                         duracion_seg INTEGER CHECK (duracion_seg IS NULL OR duracion_seg > 0),
                         posicion     VARCHAR(10), --  opcional ¿? ver desp si lo dejamos
                         UNIQUE (vinilo_id, titulo)
);

CREATE TABLE IF NOT EXISTS compra (
                        id             BIGSERIAL PRIMARY KEY,
                        comprador_id   BIGINT NOT NULL REFERENCES comprador(id) ON DELETE RESTRICT,
                        vinilo_id      BIGINT NOT NULL REFERENCES vinilo(id) ON DELETE RESTRICT,
                        estado         purchase_status NOT NULL DEFAULT 'creada',
                        precio         NUMERIC(12,2) NOT NULL CHECK (precio >= 0),
                        creada_en      TIMESTAMPTZ NOT NULL DEFAULT now(),
                        pagada_en      TIMESTAMPTZ,
                        pago_recibido_en     TIMESTAMPTZ,
                        enviada_en    TIMESTAMPTZ,
                        entregada_en   TIMESTAMPTZ
);

-- CREATE TYPE publication_status AS ENUM (
--    'activa',
--    'pausada',
--    'vendida'
--   );

-- CREATE TYPE vinyl_condition AS ENUM (
--    'Nuevo',
--    'NM',    -- Near Mint
--    'VG+',   -- Very Good Plus
--    'VG',    -- Very Good
--    'G',     -- Good
--    'P'      -- Poor
--    );

-- CREATE TYPE purchase_status AS ENUM (
--    'creada',
--    'dinero_enviado',
--    'dinero_recibido',
--    'vinilo_enviado',
--    'vinilo_entregado'
--    );
