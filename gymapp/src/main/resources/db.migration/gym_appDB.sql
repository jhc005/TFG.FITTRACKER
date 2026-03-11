-- 1. CREACIÓN DE LA BASE DE DATOS
CREATE DATABASE IF NOT EXISTS gimnasio_app DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE gimnasio_app;

-- 2. TABLA DE USUARIOS (Sincronizada con Firebase Auth)
CREATE TABLE IF NOT EXISTS usuarios (
    id VARCHAR(255) PRIMARY KEY, -- El UID que viene de Firebase
    nombre VARCHAR(100) NOT NULL,
    foto_url VARCHAR(255),
    rol ENUM('admin', 'usuario') DEFAULT 'usuario',
    peso FLOAT,
    altura FLOAT,
    edad INT,
    sexo ENUM('masculino', 'femenino', 'otro'),
    actividad_diaria ENUM('sedentario', 'ligero', 'moderado', 'activo', 'muy_activo'),
    objetivo ENUM('volumen', 'definicion'),
    calorias_objetivo INT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. TABLA DE EJERCICIOS (Catálogo general)
CREATE TABLE IF NOT EXISTS ejercicios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    video_url VARCHAR(255),
    descripcion TEXT
);

-- 4. TABLA DE RUTINAS
CREATE TABLE IF NOT EXISTS rutinas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nivel INT CHECK (nivel BETWEEN 1 AND 3),
    es_personalizada BOOLEAN DEFAULT FALSE,
    creado_por VARCHAR(255), 
    FOREIGN KEY (creado_por) REFERENCES usuarios(id) ON DELETE CASCADE
);

-- 5. RELACIÓN RUTINAS - EJERCICIOS (Contenido de cada rutina)
CREATE TABLE IF NOT EXISTS rutina_ejercicios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rutina_id INT,
    ejercicio_id INT,
    series INT DEFAULT 3,
    repeticiones INT DEFAULT 12,
    FOREIGN KEY (rutina_id) REFERENCES rutinas(id) ON DELETE CASCADE,
    FOREIGN KEY (ejercicio_id) REFERENCES ejercicios(id) ON DELETE CASCADE
);

-- 6. REGISTRO DE PESOS (Progreso del usuario) - CORREGIDO
CREATE TABLE IF NOT EXISTS registros_entrenamiento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id VARCHAR(255),
    ejercicio_id INT,
    peso_levantado FLOAT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (ejercicio_id) REFERENCES ejercicios(id) ON DELETE CASCADE
);

-- 7. TABLA DE RECETAS
CREATE TABLE IF NOT EXISTS recetas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('desayuno', 'comida', 'cena', 'snack'),
    objetivo_apto ENUM('volumen', 'definicion', 'ambos'),
    proteinas FLOAT,
    carbohidratos FLOAT,
    grasas FLOAT,
    calorias_totales INT,
    instrucciones TEXT,
    foto_url VARCHAR(255)
);

-- 8. TABLA "MI DIETA" (Planificación semanal personalizada)
CREATE TABLE IF NOT EXISTS mi_dieta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id VARCHAR(255),
    receta_id INT,
    dia_semana ENUM('lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo'),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (receta_id) REFERENCES recetas(id) ON DELETE CASCADE
);

-- 9. TABLA DE ACTIVIDAD DIARIA (Pasos y Calorías) - CORREGIDO
CREATE TABLE IF NOT EXISTS actividad_diaria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id VARCHAR(255),
    pasos INT DEFAULT 0,
    km_recorridos FLOAT DEFAULT 0,
    calorias_gastadas INT DEFAULT 0,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);