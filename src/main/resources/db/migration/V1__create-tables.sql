CREATE TABLE users (
  id SERIAL PRIMARY KEY UNIQUE , 
  name TEXT,
  login TEXT UNIQUE,             
  password TEXT,
  role TEXT                       --perfi("admin ou cliente")
);

CREATE TABLE available_services (   --serviços disponiveis
  id SERIAL PRIMARY KEY UNIQUE, 
  name TEXT,
  description TEXT,
  availability JSONB              -- disponibilidade
);

CREATE TABLE reservas (
  id SERIAL PRIMARY KEY UNIQUE, 
  users_id INTEGER REFERENCES users(id) ON DELETE CASCADE, 
  services_id INTEGER REFERENCES available_services(id) ON DELETE CASCADE,  
  data_reserva TIMESTAMP,
  status_reserva BOOLEAN
);

CREATE TABLE availability (
  id SERIAL PRIMARY KEY UNIQUE, -- Corrected: Use PRIMARY KEY instead of pk
  services_id INTEGER REFERENCES available_services(id) ON DELETE CASCADE,  -- Foreign key constraint
  data DATE,
  horario_inicio TIME,
  horario_fim TIME
);
