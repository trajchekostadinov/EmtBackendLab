CREATE TABLE book_copies (
                             id BIGSERIAL PRIMARY KEY,
                             book_id BIGINT NOT NULL,
                             state VARCHAR(50) NOT NULL,
                             available BOOLEAN NOT NULL,

                             CONSTRAINT fk_book
                                 FOREIGN KEY (book_id)
                                     REFERENCES book_copies(id)
                                     ON DELETE CASCADE
);
