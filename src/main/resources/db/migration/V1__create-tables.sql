CREATE TABLE usuarios (
  id SERIAL PRIMARY KEY UNIQUE,  -- Corrected: Use PRIMARY KEY instead of pk
  nome TEXT,
  email TEXT UNIQUE,             -- Added UNIQUE constraint for email
  senha TEXT
);

CREATE TABLE servicos (
  id SERIAL PRIMARY KEY UNIQUE, -- Corrected: Use PRIMARY KEY instead of pk
  nome TEXT,
  descricao TEXT,
  disponibilidade JSONB
);

CREATE TABLE reservas (
  id SERIAL PRIMARY KEY UNIQUE, -- Corrected: Use PRIMARY KEY instead of pk
  usuario_id INTEGER REFERENCES usuarios(id) ON DELETE CASCADE, -- Foreign key constraint
  servico_id INTEGER REFERENCES servicos(id) ON DELETE CASCADE,  -- Foreign key constraint
  data_reserva TIMESTAMP,
  status_reserva BOOLEAN
);

CREATE TABLE disponibilidade (
  id SERIAL PRIMARY KEY UNIQUE, -- Corrected: Use PRIMARY KEY instead of pk
  servico_id INTEGER REFERENCES servicos(id) ON DELETE CASCADE,  -- Foreign key constraint
  data DATE,
  horario_inicio TIME,
  horario_fim TIME
);
