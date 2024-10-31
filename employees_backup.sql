--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0 (Postgres.app)
-- Dumped by pg_dump version 17.0 (Postgres.app)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: employees; Type: TABLE; Schema: public; Owner: danivargass97
--

CREATE TABLE public.employees (
    id bigint NOT NULL,
    last_name character varying(20) NOT NULL,
    second_last_name character varying(20) NOT NULL,
    first_name character varying(20) NOT NULL,
    middle_names character varying(50),
    employment_country character varying(50) NOT NULL,
    identification_type character varying(50) NOT NULL,
    identification_number character varying(20) NOT NULL,
    email character varying(300) NOT NULL,
    hire_date date NOT NULL,
    area character varying(50) NOT NULL,
    status character varying(10) DEFAULT 'Active'::character varying,
    registration_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    employee_photo character varying(255),
    edit_timestamp timestamp without time zone
);


ALTER TABLE public.employees OWNER TO danivargass97;

--
-- Name: employees_id_seq; Type: SEQUENCE; Schema: public; Owner: danivargass97
--

CREATE SEQUENCE public.employees_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.employees_id_seq OWNER TO danivargass97;

--
-- Name: employees_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: danivargass97
--

ALTER SEQUENCE public.employees_id_seq OWNED BY public.employees.id;


--
-- Name: employees id; Type: DEFAULT; Schema: public; Owner: danivargass97
--

ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);


--
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: danivargass97
--

COPY public.employees (id, last_name, second_last_name, first_name, middle_names, employment_country, identification_type, identification_number, email, hire_date, area, status, registration_timestamp, employee_photo, edit_timestamp) FROM stdin;
12	VARGAS	PEREZ	AKAMARU	DANIEL	Colombia	Cédula de ciudadanía	12338927702	akamaru.vargas@tuarmi.com.co	2024-10-17	Compras	Activo	2024-10-31 13:02:03.413745	https://firebasestorage.googleapis.com/v0/b/employess-app-co.appspot.com/o/employee_photos%2F1730397609803?alt=media&token=48fde0df-40d4-49c2-9659-8de66db06440	\N
13	VARGAS	PEREZ	AKAMARU	DANIEL	Colombia	Cédula de extranjería	12338927702	akamaru.vargas.1@tuarmi.com.co	2024-10-17	Compras	Activo	2024-10-31 13:02:03.413745	https://firebasestorage.googleapis.com/v0/b/employess-app-co.appspot.com/o/employee_photos%2F1730397984214?alt=media&token=a6d8a471-ae2d-437d-9389-f268c394f51d	\N
14	VARGAS	PEREZ	AKAMARU	DANIEL	Colombia	Cédula de ciudadanía	13536778	akamaru.vargas.2@tuarmi.com.co	2024-10-31	Financiera	Activo	2024-10-31 13:02:03.413745	https://firebasestorage.googleapis.com/v0/b/employess-app-co.appspot.com/o/employee_photos%2F1730398034273?alt=media&token=5c30c605-f8fb-48ca-ab12-a7c9241fb38a	\N
15	MICHAEL	MELYSA	JOSE	PAOLA	Venezuela	Cédula de ciudadanía	3434333	jose.michael@armirene.com.ve	2024-10-31	Financiera	Activo	2024-10-31 13:02:03.413745	https://firebasestorage.googleapis.com/v0/b/employess-app-co.appspot.com/o/employee_photos%2F1730398110260?alt=media&token=60ac6467-b59f-4047-8363-e4c09fc2d558	\N
11	ORDONEZ	VANEGAS	MARIA	\N	Colombia	Cédula de ciudadanía	52622219	maria.ordonez@tuarmi.com.co	2024-09-30	Administración	Activo	2024-10-31 09:28:01.239441	https://firebasestorage.googleapis.com/v0/b/employess-app-co.appspot.com/o/employee_photos%2F1730407201191?alt=media&token=64060371-9d62-421d-bd69-c690063bfc16	2024-10-31 13:02:03.413745
10	DE LA CALLE	ORDONEZ	DANIEL	\N	Colombia	Cédula de ciudadanía	1233892770	daniel.delacalle.1@tuarmi.com.co	2024-09-30	Operación	Activo	2024-10-31 00:24:57.768565	https://firebasestorage.googleapis.com/v0/b/employess-app-co.appspot.com/o/employee_photos%2F1730407543610?alt=media&token=4283e6b3-3224-4ce1-b448-2283b3ec2b79	2024-10-31 13:02:03.413745
\.


--
-- Name: employees_id_seq; Type: SEQUENCE SET; Schema: public; Owner: danivargass97
--

SELECT pg_catalog.setval('public.employees_id_seq', 15, true);


--
-- Name: employees employees_email_key; Type: CONSTRAINT; Schema: public; Owner: danivargass97
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_email_key UNIQUE (email);


--
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: danivargass97
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- Name: employees unique_identification; Type: CONSTRAINT; Schema: public; Owner: danivargass97
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT unique_identification UNIQUE (identification_type, identification_number);


--
-- PostgreSQL database dump complete
--

