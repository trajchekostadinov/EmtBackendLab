CREATE MATERIALIZED VIEW books_stats_view AS
SELECT
    b.category AS category,
    COUNT(*) AS total_books,
    SUM(b.available_copies) AS total_available_copies,
    COUNT(*) FILTER (WHERE b.state != 'GOOD') AS not_good_condition_books
FROM books b
GROUP BY b.category;