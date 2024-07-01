CREATE TABLE users (
  id SERIAL PRIMARY KEY UNIQUE , 
  name TEXT,
  login TEXT UNIQUE,             
  password TEXT,
  role TEXT                       --perfi("admin ou cliente")
);

CREATE TABLE tables (   
  id SERIAL PRIMARY KEY UNIQUE, 
  num_table INTEGER,
  capacity INTEGER
);

CREATE TABLE reservas (
  id SERIAL PRIMARY KEY UNIQUE, 
  users_id INTEGER REFERENCES users(id) ON DELETE CASCADE, 
  table_id INTEGER REFERENCES tables(id) ON DELETE CASCADE,  
  dt_reserva DATE,
  hr_inicio TIME
);