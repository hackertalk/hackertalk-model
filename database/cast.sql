CREATE OR REPLACE FUNCTION boolean1(i smallint) RETURNS boolean AS $$
BEGIN
    RETURN (i::smallint)::int::bool;
END;
$$ LANGUAGE plpgsql;

CREATE CAST (smallint AS boolean) WITH FUNCTION boolean1(smallint) AS ASSIGNMENT;

-- ALTER TYPE smallint OWNER TO postgres;
