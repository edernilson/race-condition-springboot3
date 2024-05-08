CREATE TABLE users (
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) NOT NULL
);

CREATE TABLE accounts (
    id    BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    balance  DOUBLE PRECISION NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(255) NOT NULL,
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (name, created_by, updated_by) VALUES ('eder', 'admin', 'admin');
INSERT INTO users (name, created_by, updated_by) VALUES ('maria', 'admin', 'admin');
INSERT INTO users (name, created_by, updated_by) VALUES ('jose', 'admin', 'admin');

INSERT INTO accounts (user_id, balance, created_by, updated_by) VALUES (1, 1000, 'admin', 'admin');
INSERT INTO accounts (user_id, balance, created_by, updated_by) VALUES (2, 2000, 'admin', 'admin');
INSERT INTO accounts (user_id, balance, created_by, updated_by) VALUES (3, 3000, 'admin', 'admin');