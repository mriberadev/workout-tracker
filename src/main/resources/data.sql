CREATE TABLE IF NOT EXISTS exercise(
    id                  UUID            PRIMARY KEY,
    name                VARCHAR(255)    NOT NULL,
    image               VARCHAR(255),
    video               VARCHAR(255),
    creation_date       TIMESTAMP        NOT NULL,
    last_modification_date  TIMESTAMP        NOT NULL
);

INSERT INTO exercise (
    id,
    name,
    image,
    video,
    creation_date,
    last_modification_date
)
VALUES
    (
        '550e8400-e29b-41d4-a716-446655440000',
        'Sentadilla Goblet',
        'https://ejemplo.com/img/sentadilla.jpg',
        'https://ejemplo.com/video/sentadilla.mp4',
        '2024-01-15 12:32:01',
        '2024-01-15 17:45:02'
    ),
    (
        '6ba7b810-9dad-11d1-80b4-00c04fd430c8',
        'Press Militar con Mancuernas',
        'https://ejemplo.com/img/press_militar.jpg',
        'https://ejemplo.com/video/press_militar.mp4',
        '2024-02-10 17:45:02',
        '2024-02-10 17:45:02'
    ),
    (
        '8d5ae1fd-635d-4f1b-97ad-0931215222c1',
        'Peso Muerto Rumano',
        'https://ejemplo.com/img/peso_muerto.jpg',
        'https://ejemplo.com/video/peso_muerto.mp4',
        '2024-03-05 17:45:02',
        '2024-03-05 17:45:02'
    ),
    (
        'f47ac10b-58cc-4372-a567-0e02b2c3d479',
        'Dominadas supinas',
        'https://ejemplo.com/img/dominadas.jpg',
        NULL,
        '2024-03-20 17:45:02',
        '2024-03-20 17:45:02'
    ),
    (
        '123e4567-e89b-12d3-a456-426614174000',
        'Plancha Abdominal',
        NULL,
        'https://ejemplo.com/video/plancha.mp4',
        '2024-04-01 17:45:02',
        '2024-04-01 17:45:02'
    );