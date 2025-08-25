CREATE TABLE IF NOT EXISTS users (
                                     userid SERIAL PRIMARY KEY,
                                     username VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS comprador (
                                         id BIGSERIAL PRIMARY KEY,
                                         nombre VARCHAR(120) NOT NULL,
                                         email VARCHAR(120) NOT NULL UNIQUE,
                                         dni VARCHAR(20) UNIQUE
);

CREATE TABLE IF NOT EXISTS vinilo (
                                      id BIGSERIAL PRIMARY KEY,
                                      nombre VARCHAR(160) NOT NULL,
                                      fecha_lanzamiento DATE,
                                      genero VARCHAR(80),
                                      precio NUMERIC(12,2) NOT NULL CHECK (precio >= 0),
                                      condicion VARCHAR(20) NOT NULL CHECK (condicion IN ('Nuevo', 'NM', 'VG+', 'VG', 'G', 'P')),
                                      estado_publicacion VARCHAR(20) NOT NULL CHECK (estado_publicacion IN ('activa', 'pausada', 'vendida')),
                                      creado_en TIMESTAMP NOT NULL DEFAULT now(),
                                      stock INTEGER NOT NULL CHECK (stock >= 0) DEFAULT 1
);

CREATE TABLE IF NOT EXISTS cancion (
                                       id BIGSERIAL PRIMARY KEY,
                                       vinilo_id BIGINT NOT NULL REFERENCES vinilo(id) ON DELETE CASCADE,
                                       titulo VARCHAR(160) NOT NULL,
                                       artista VARCHAR(160) NOT NULL,
                                       duracion_seg INTEGER CHECK (duracion_seg IS NULL OR duracion_seg > 0),
                                       posicion VARCHAR(10),
                                       UNIQUE (vinilo_id, titulo)
);

CREATE TABLE IF NOT EXISTS compra (
                                      id BIGSERIAL PRIMARY KEY,
                                      comprador_id BIGINT NOT NULL REFERENCES comprador(id) ON DELETE RESTRICT,
                                      vinilo_id BIGINT NOT NULL REFERENCES vinilo(id) ON DELETE RESTRICT,
                                      estado VARCHAR(20) NOT NULL CHECK (estado IN ('creada', 'dinero_enviado', 'dinero_recibido', 'vinilo_enviado', 'vinilo_entregado')),
                                      precio NUMERIC(12,2) NOT NULL CHECK (precio >= 0),
                                      creada_en TIMESTAMP NOT NULL DEFAULT now(),
                                      pagada_en TIMESTAMP,
                                      pago_recibido_en TIMESTAMP,
                                      enviada_en TIMESTAMP,
                                      entregada_en TIMESTAMP
);