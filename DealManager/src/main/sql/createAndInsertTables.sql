--PostgreSQL

--*****Definition of sequences*****

CREATE SEQUENCE public.collection
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9999999999
    CACHE 1;

ALTER SEQUENCE public.collection
    OWNER TO postgres;

--*****Definition of table - systems*****

CREATE TABLE public.systems
(
    id bigint NOT NULL DEFAULT nextval('collection'::regclass),
    description_of_system character varying NOT NULL,
    description_of_technology character varying NOT NULL,
    system_name character varying NOT NULL,
    system_owner character varying NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.systems
    OWNER to postgres;


--*****Data to table - systems*****

INSERT INTO public.systems(
	description_of_system, description_of_technology, system_name, system_owner)
	VALUES ('System do selektowania PYR', 'Technologia manualna', 'PYRA', 'PYR OWNER');
INSERT INTO public.systems(
	description_of_system, description_of_technology, system_name, system_owner)
	VALUES ('System do selektowania ZiemniorÓW', 'Technologia rakietowa', 'ZiemnioR', 'ZiemniOR OWNER');
INSERT INTO public.systems(
	description_of_system, description_of_technology, system_name, system_owner)
	VALUES ('System do kreowania KLUCH', 'Technologia półautomatyczna', 'KLUCHA', 'KLUCHA OWNER');


--*****Definition of table - deal*****

CREATE TABLE public.deal
(
    id bigint NOT NULL DEFAULT nextval('collection'::regclass),
    order_number character varying NOT NULL,
    from_date date NOT NULL,
    to_date date NOT NULL,
    amount character varying NOT NULL,
    amount_period character varying NOT NULL,
    active integer NOT NULL,
    system_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT system_id FOREIGN KEY (system_id)
        REFERENCES public.systems (id) MATCH FULL
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        DEFERRABLE INITIALLY DEFERRED
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.deal
    OWNER to postgres;


--*****Data to table - deal*****

INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('1/2/2018', '20-02-2018', '31-12-2018', '3000', 'MONTH', 1, 1);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('2/2/2018', '21-02-2018', '31-12-2018', '3000', 'MONTH', 1, 1);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('13/2/2018', '22-02-2018', '31-12-2018', '4000', 'MONTH', 1, 2);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('1/3/2018', '01-03-2018', '31-12-2020', '8000', 'YEAR', 1, 1);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('2/3/2018', '10-03-2018', '31-12-2018', '5000', 'QUARTER', 1, 2);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('3/3/2018', '20-03-2018', '31-12-2018', '3000', 'YEAR', 1, 3);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('4/3/2018', '20-03-2018', '31-12-2020', '8000', 'YEAR', 1, 2);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('1/4/2018', '20-04-2018', '31-12-2018', '3000', 'MONTH', 1, 3);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('2/4/2018', '20-04-2018', '31-12-2021', '4000', 'YEAR', 1, 3);
INSERT INTO public.deal(
	order_number, from_date, to_date, amount, amount_period, active, system_id)
	VALUES ('1/5/2018', '21-04-2018', '31-12-2018', '3000', 'MONTH', 1, 1);