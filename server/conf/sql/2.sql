
CREATE TABLE "company" (
    "id" SERIAL PRIMARY KEY,
    "name" VARCHAR NOT NULL,
    "email" VARCHAR NOT NULL,
    "phone" VARCHAR NOT NULL,
    "workers_count" INT NOT NULL,
    unique("name")
  );
