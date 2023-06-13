SELECT
    extract(hour from cast(DATETIME as timestamp)) as hour, count(*) as count 
    from ANIMAL_OUTS 
    where extract(hour from cast(DATETIME as timestamp)) 
    between 9 and 19 
    group by extract(hour from cast(DATETIME as timestamp)) 
    order by hour