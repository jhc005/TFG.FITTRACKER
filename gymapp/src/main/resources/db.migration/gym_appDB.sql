-- =========================
-- CREACIÓN BASE DE DATOS
-- =========================
DROP DATABASE IF EXISTS gym_app;
CREATE DATABASE gym_app;
USE gym_app;

-- =========================
-- USERS
-- =========================
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('admin','user') DEFAULT 'user',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- PROFILES
-- =========================
CREATE TABLE profiles (
    user_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    photo_url VARCHAR(255),
    weight DECIMAL(5,2),
    height DECIMAL(5,2),
    age INT,
    sex ENUM('male','female','other'),
    daily_activity_level TINYINT,
    goal ENUM('volumen','definicion'),
    daily_calories_target INT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- =========================
-- ROUTINES
-- =========================
CREATE TABLE routines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    level TINYINT,
    is_public BOOLEAN DEFAULT TRUE,
    created_by INT NULL,
    FOREIGN KEY (created_by) REFERENCES users(id) ON DELETE SET NULL
);

-- =========================
-- EXERCISES
-- =========================
CREATE TABLE exercises (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    video_url VARCHAR(255)
);

-- =========================
-- ROUTINE_EXERCISES
-- =========================
CREATE TABLE routine_exercises (
    routine_id INT,
    exercise_id INT,
    sets INT NOT NULL,
    reps INT NOT NULL,
    order_index INT,
    PRIMARY KEY (routine_id, exercise_id),
    FOREIGN KEY (routine_id) REFERENCES routines(id) ON DELETE CASCADE,
    FOREIGN KEY (exercise_id) REFERENCES exercises(id) ON DELETE CASCADE
);

-- =========================
-- WORKOUT_SESSIONS
-- =========================
CREATE TABLE workout_sessions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    routine_id INT,
    session_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (routine_id) REFERENCES routines(id)
);

CREATE INDEX idx_workout_user_date 
ON workout_sessions(user_id, session_date);

-- =========================
-- EXERCISE_LOGS
-- =========================
CREATE TABLE exercise_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    workout_session_id INT NOT NULL,
    exercise_id INT NOT NULL,
    set_number INT NOT NULL,
    weight DECIMAL(6,2),
    reps_done INT,
    FOREIGN KEY (workout_session_id) REFERENCES workout_sessions(id) ON DELETE CASCADE,
    FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

-- =========================
-- RECIPES
-- =========================
CREATE TABLE recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category ENUM('desayuno','comida','cena','snack'),
    goal ENUM('volumen','definicion'),
    calories INT,
    protein DECIMAL(6,2),
    carbs DECIMAL(6,2),
    fats DECIMAL(6,2),
    instructions TEXT
);

-- =========================
-- DIETS
-- =========================
CREATE TABLE diets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- =========================
-- DIET_PLANS
-- =========================
CREATE TABLE diet_plans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    diet_id INT NOT NULL,
    recipe_id INT NOT NULL,
    day_of_week TINYINT CHECK (day_of_week BETWEEN 1 AND 7),
    FOREIGN KEY (diet_id) REFERENCES diets(id) ON DELETE CASCADE,
    FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE
);

-- =========================
-- DAILY_ACTIVITY
-- =========================
CREATE TABLE daily_activity (
    user_id INT NOT NULL,
    activity_date DATE NOT NULL,
    steps INT DEFAULT 0,
    km DECIMAL(6,2),
    calories_burned INT,
    PRIMARY KEY (user_id, activity_date),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);