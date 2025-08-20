-- V1__create_table_topico.sql
CREATE TABLE IF NOT EXISTS topico (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  mensaje TEXT NOT NULL,
  autor VARCHAR(255) NOT NULL,
  fecha_creacion DATETIME
);
