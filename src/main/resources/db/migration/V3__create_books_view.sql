create view books_view as
select
    b.id as id,
    b.name as name,
    b.category as category,
    b.state as state,
    b.available_copies as available_copies,
    a.name || ' ' || a.surname as author_full_name,
    c.name as country_name
from books b
         join authors a on b.author_id = a.id
         join countries c on a.country_id = c.id;