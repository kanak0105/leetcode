SELECT ROUND(
    SUM(CASE WHEN a.player_id IS NOT NULL THEN 1 ELSE 0 END) / COUNT(*), 2
) AS fraction
FROM (
    SELECT player_id, MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
) AS f
LEFT JOIN Activity AS a
    ON f.player_id = a.player_id AND DATEDIFF(a.event_date, f.first_date) = 1;