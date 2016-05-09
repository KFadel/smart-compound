--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.0
-- Started on 2016-05-07 04:12:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 198 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 198
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 33151)
-- Name: ng_nts_compounds; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_compounds (
    recid integer NOT NULL,
    compound_name text,
    lattitude numeric(12,2),
    longtude numeric(12,2),
    country text,
    city text,
    owner_name text
);


ALTER TABLE public.ng_nts_compounds OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 33149)
-- Name: ng_nts_compounds_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_compounds_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_compounds_recid_seq OWNER TO postgres;

--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 170
-- Name: ng_nts_compounds_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_compounds_recid_seq OWNED BY ng_nts_compounds.recid;


--
-- TOC entry 179 (class 1259 OID 33201)
-- Name: ng_nts_employees; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_employees (
    recid integer NOT NULL,
    salutation text,
    username text,
    password text,
    first_name text,
    middle_name text,
    last_name text,
    email text,
    job text,
    gender text,
    identification_type text,
    identification_number text,
    address text,
    phone_number1 text,
    phone_number2 text,
    mobile_number1 text,
    mobile_number2 text,
    status text,
    hire_date date,
    group_name text,
    compound_id integer,
    salutation_lookup_id integer,
    gender_lookup_id integer,
    status_lookup_id integer,
    group_id integer
);


ALTER TABLE public.ng_nts_employees OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 33199)
-- Name: ng_nts_employees_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_employees_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_employees_recid_seq OWNER TO postgres;

--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 178
-- Name: ng_nts_employees_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_employees_recid_seq OWNED BY ng_nts_employees.recid;


--
-- TOC entry 187 (class 1259 OID 33317)
-- Name: ng_nts_facilities; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_facilities (
    recid integer NOT NULL,
    facility_type text,
    block text,
    street text,
    building_number integer,
    floor_number integer,
    facility_number integer,
    lattitude numeric(12,2),
    longtude numeric(12,2),
    status text,
    is_for_rent integer,
    area numeric(12,2),
    description text,
    picture_url text,
    compound_id integer,
    tenant_id integer,
    facility_lookup_id integer
);


ALTER TABLE public.ng_nts_facilities OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 33315)
-- Name: ng_nts_facilities_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_facilities_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_facilities_recid_seq OWNER TO postgres;

--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 186
-- Name: ng_nts_facilities_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_facilities_recid_seq OWNED BY ng_nts_facilities.recid;


--
-- TOC entry 173 (class 1259 OID 33162)
-- Name: ng_nts_groups; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_groups (
    recid integer NOT NULL,
    group_name text
);


ALTER TABLE public.ng_nts_groups OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 33160)
-- Name: ng_nts_groups_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_groups_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_groups_recid_seq OWNER TO postgres;

--
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 172
-- Name: ng_nts_groups_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_groups_recid_seq OWNED BY ng_nts_groups.recid;


--
-- TOC entry 177 (class 1259 OID 33184)
-- Name: ng_nts_lookup; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_lookup (
    recid integer NOT NULL,
    lookup_name text,
    type_name text,
    type_id integer
);


ALTER TABLE public.ng_nts_lookup OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 33182)
-- Name: ng_nts_lookup_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_lookup_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_lookup_recid_seq OWNER TO postgres;

--
-- TOC entry 2149 (class 0 OID 0)
-- Dependencies: 176
-- Name: ng_nts_lookup_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_lookup_recid_seq OWNED BY ng_nts_lookup.recid;


--
-- TOC entry 175 (class 1259 OID 33173)
-- Name: ng_nts_lookup_types; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_lookup_types (
    recid integer NOT NULL,
    type_name text
);


ALTER TABLE public.ng_nts_lookup_types OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 33171)
-- Name: ng_nts_lookup_types_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_lookup_types_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_lookup_types_recid_seq OWNER TO postgres;

--
-- TOC entry 2150 (class 0 OID 0)
-- Dependencies: 174
-- Name: ng_nts_lookup_types_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_lookup_types_recid_seq OWNED BY ng_nts_lookup_types.recid;


--
-- TOC entry 191 (class 1259 OID 33372)
-- Name: ng_nts_orders; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_orders (
    recid integer NOT NULL,
    service_name text,
    request_date date,
    acceptence_date date,
    status text,
    channel text,
    notes text,
    service_location_lattitude numeric(12,2),
    service_location_longtude numeric(12,2),
    service_location_desc text,
    compound_id integer,
    tenant_id integer,
    service_id integer,
    facility_id integer,
    created_by integer,
    accepted_by integer,
    channel_lookup_id integer
);


ALTER TABLE public.ng_nts_orders OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 33370)
-- Name: ng_nts_orders_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_orders_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_orders_recid_seq OWNER TO postgres;

--
-- TOC entry 2151 (class 0 OID 0)
-- Dependencies: 190
-- Name: ng_nts_orders_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_orders_recid_seq OWNED BY ng_nts_orders.recid;


--
-- TOC entry 183 (class 1259 OID 33265)
-- Name: ng_nts_service_usage_rates; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_service_usage_rates (
    recid integer NOT NULL,
    usage_amount_from numeric(12,2),
    usage_amount_to numeric(12,2),
    unit_price numeric(12,2),
    service_name text,
    compound_id integer,
    service_id integer
);


ALTER TABLE public.ng_nts_service_usage_rates OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 33263)
-- Name: ng_nts_service_usage_rates_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_service_usage_rates_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_service_usage_rates_recid_seq OWNER TO postgres;

--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 182
-- Name: ng_nts_service_usage_rates_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_service_usage_rates_recid_seq OWNED BY ng_nts_service_usage_rates.recid;


--
-- TOC entry 181 (class 1259 OID 33242)
-- Name: ng_nts_services; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_services (
    recid integer NOT NULL,
    service_name text,
    description text,
    is_active integer,
    severity integer,
    flat_or_usage text,
    estimated_delivery_days integer,
    nrc integer,
    mrc integer,
    installation_price integer,
    is_prepaid integer,
    creation_date timestamp without time zone,
    measuring_unit text,
    compound_id integer,
    measuring_unit_lookup_id integer
);


ALTER TABLE public.ng_nts_services OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 33240)
-- Name: ng_nts_services_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_services_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_services_recid_seq OWNER TO postgres;

--
-- TOC entry 2153 (class 0 OID 0)
-- Dependencies: 180
-- Name: ng_nts_services_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_services_recid_seq OWNED BY ng_nts_services.recid;


--
-- TOC entry 197 (class 1259 OID 33514)
-- Name: ng_nts_system_configuration; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_system_configuration (
    id integer NOT NULL,
    key text,
    value text
);
ALTER TABLE ONLY ng_nts_system_configuration ALTER COLUMN key SET STATISTICS 0;
ALTER TABLE ONLY ng_nts_system_configuration ALTER COLUMN value SET STATISTICS 0;


ALTER TABLE public.ng_nts_system_configuration OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 33512)
-- Name: ng_nts_system_configuration_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_system_configuration_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_system_configuration_id_seq OWNER TO postgres;

--
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 196
-- Name: ng_nts_system_configuration_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_system_configuration_id_seq OWNED BY ng_nts_system_configuration.id;


--
-- TOC entry 189 (class 1259 OID 33346)
-- Name: ng_nts_tenant_facilities; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_tenant_facilities (
    recid integer NOT NULL,
    is_leased integer,
    leasing_or_ownership_start_date date,
    leasing_or_ownership_end_date date,
    compound_id integer,
    tenant_id integer,
    facility_id integer
);


ALTER TABLE public.ng_nts_tenant_facilities OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 33344)
-- Name: ng_nts_tenant_facilities_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_tenant_facilities_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_tenant_facilities_recid_seq OWNER TO postgres;

--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 188
-- Name: ng_nts_tenant_facilities_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_tenant_facilities_recid_seq OWNED BY ng_nts_tenant_facilities.recid;


--
-- TOC entry 185 (class 1259 OID 33288)
-- Name: ng_nts_tenants; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_tenants (
    recid integer NOT NULL,
    salutation text,
    username text,
    password text,
    first_name text,
    middle_name text,
    last_name text,
    email text,
    job text,
    gender text,
    nationality text,
    date_of_birth date,
    identification_type text,
    identification_number text,
    best_connection_method text,
    address text,
    country text,
    city text,
    postal_code text,
    phone_number1 text,
    phone_number2 text,
    mobile_number1 text,
    mobile_number2 text,
    facebook text,
    whatsapp text,
    compound_id integer,
    salutation_lookup_id integer,
    gender_lookup_id integer
);


ALTER TABLE public.ng_nts_tenants OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 33286)
-- Name: ng_nts_tenants_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_tenants_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_tenants_recid_seq OWNER TO postgres;

--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 184
-- Name: ng_nts_tenants_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_tenants_recid_seq OWNED BY ng_nts_tenants.recid;


--
-- TOC entry 193 (class 1259 OID 33425)
-- Name: ng_nts_tickets; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_tickets (
    recid integer NOT NULL,
    ticket_subject text,
    description text,
    problem_date timestamp without time zone,
    open_date timestamp without time zone,
    channel text,
    last_status text,
    severity integer,
    feedback text,
    rate integer,
    service_name text,
    compound_id integer,
    facility_id integer,
    service_id integer,
    related_tenant_id integer,
    assigned_group_id integer,
    opened_by integer,
    channel_lookup_id integer,
    group_name text
);


ALTER TABLE public.ng_nts_tickets OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 33478)
-- Name: ng_nts_tickets_histories; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ng_nts_tickets_histories (
    recid integer NOT NULL,
    action_date timestamp without time zone,
    is_completed integer,
    comment text,
    previous_status text,
    currenet_status text,
    compound_id integer,
    ticket_id integer,
    action_by integer,
    opened_by integer
);


ALTER TABLE public.ng_nts_tickets_histories OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 33476)
-- Name: ng_nts_tickets_histories_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_tickets_histories_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_tickets_histories_recid_seq OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 194
-- Name: ng_nts_tickets_histories_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_tickets_histories_recid_seq OWNED BY ng_nts_tickets_histories.recid;


--
-- TOC entry 192 (class 1259 OID 33423)
-- Name: ng_nts_tickets_recid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ng_nts_tickets_recid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ng_nts_tickets_recid_seq OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 192
-- Name: ng_nts_tickets_recid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ng_nts_tickets_recid_seq OWNED BY ng_nts_tickets.recid;


--
-- TOC entry 1914 (class 2604 OID 33154)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_compounds ALTER COLUMN recid SET DEFAULT nextval('ng_nts_compounds_recid_seq'::regclass);


--
-- TOC entry 1918 (class 2604 OID 33204)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_employees ALTER COLUMN recid SET DEFAULT nextval('ng_nts_employees_recid_seq'::regclass);


--
-- TOC entry 1922 (class 2604 OID 33320)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_facilities ALTER COLUMN recid SET DEFAULT nextval('ng_nts_facilities_recid_seq'::regclass);


--
-- TOC entry 1915 (class 2604 OID 33165)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_groups ALTER COLUMN recid SET DEFAULT nextval('ng_nts_groups_recid_seq'::regclass);


--
-- TOC entry 1917 (class 2604 OID 33187)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_lookup ALTER COLUMN recid SET DEFAULT nextval('ng_nts_lookup_recid_seq'::regclass);


--
-- TOC entry 1916 (class 2604 OID 33176)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_lookup_types ALTER COLUMN recid SET DEFAULT nextval('ng_nts_lookup_types_recid_seq'::regclass);


--
-- TOC entry 1924 (class 2604 OID 33375)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_orders ALTER COLUMN recid SET DEFAULT nextval('ng_nts_orders_recid_seq'::regclass);


--
-- TOC entry 1920 (class 2604 OID 33268)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_service_usage_rates ALTER COLUMN recid SET DEFAULT nextval('ng_nts_service_usage_rates_recid_seq'::regclass);


--
-- TOC entry 1919 (class 2604 OID 33245)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_services ALTER COLUMN recid SET DEFAULT nextval('ng_nts_services_recid_seq'::regclass);


--
-- TOC entry 1927 (class 2604 OID 33517)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_system_configuration ALTER COLUMN id SET DEFAULT nextval('ng_nts_system_configuration_id_seq'::regclass);


--
-- TOC entry 1923 (class 2604 OID 33349)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tenant_facilities ALTER COLUMN recid SET DEFAULT nextval('ng_nts_tenant_facilities_recid_seq'::regclass);


--
-- TOC entry 1921 (class 2604 OID 33291)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tenants ALTER COLUMN recid SET DEFAULT nextval('ng_nts_tenants_recid_seq'::regclass);


--
-- TOC entry 1925 (class 2604 OID 33428)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets ALTER COLUMN recid SET DEFAULT nextval('ng_nts_tickets_recid_seq'::regclass);


--
-- TOC entry 1926 (class 2604 OID 33481)
-- Name: recid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets_histories ALTER COLUMN recid SET DEFAULT nextval('ng_nts_tickets_histories_recid_seq'::regclass);


--
-- TOC entry 1929 (class 2606 OID 33159)
-- Name: ng_nts_compounds_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_compounds
    ADD CONSTRAINT ng_nts_compounds_pkey PRIMARY KEY (recid);


--
-- TOC entry 1943 (class 2606 OID 33209)
-- Name: ng_nts_employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_employees
    ADD CONSTRAINT ng_nts_employees_pkey PRIMARY KEY (recid);


--
-- TOC entry 1961 (class 2606 OID 33325)
-- Name: ng_nts_facilities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_facilities
    ADD CONSTRAINT ng_nts_facilities_pkey PRIMARY KEY (recid);


--
-- TOC entry 1931 (class 2606 OID 33170)
-- Name: ng_nts_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_groups
    ADD CONSTRAINT ng_nts_groups_pkey PRIMARY KEY (recid);


--
-- TOC entry 1936 (class 2606 OID 33192)
-- Name: ng_nts_lookup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_lookup
    ADD CONSTRAINT ng_nts_lookup_pkey PRIMARY KEY (recid);


--
-- TOC entry 1933 (class 2606 OID 33181)
-- Name: ng_nts_lookup_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_lookup_types
    ADD CONSTRAINT ng_nts_lookup_types_pkey PRIMARY KEY (recid);


--
-- TOC entry 1975 (class 2606 OID 33380)
-- Name: ng_nts_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_orders
    ADD CONSTRAINT ng_nts_orders_pkey PRIMARY KEY (recid);


--
-- TOC entry 1951 (class 2606 OID 33273)
-- Name: ng_nts_service_usage_rates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_service_usage_rates
    ADD CONSTRAINT ng_nts_service_usage_rates_pkey PRIMARY KEY (recid);


--
-- TOC entry 1947 (class 2606 OID 33250)
-- Name: ng_nts_services_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_services
    ADD CONSTRAINT ng_nts_services_pkey PRIMARY KEY (recid);


--
-- TOC entry 1992 (class 2606 OID 33522)
-- Name: ng_nts_system_configuration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_system_configuration
    ADD CONSTRAINT ng_nts_system_configuration_pkey PRIMARY KEY (id);


--
-- TOC entry 1966 (class 2606 OID 33351)
-- Name: ng_nts_tenant_facilities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_tenant_facilities
    ADD CONSTRAINT ng_nts_tenant_facilities_pkey PRIMARY KEY (recid);


--
-- TOC entry 1956 (class 2606 OID 33296)
-- Name: ng_nts_tenants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_tenants
    ADD CONSTRAINT ng_nts_tenants_pkey PRIMARY KEY (recid);


--
-- TOC entry 1990 (class 2606 OID 33486)
-- Name: ng_nts_tickets_histories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_tickets_histories
    ADD CONSTRAINT ng_nts_tickets_histories_pkey PRIMARY KEY (recid);


--
-- TOC entry 1984 (class 2606 OID 33433)
-- Name: ng_nts_tickets_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ng_nts_tickets
    ADD CONSTRAINT ng_nts_tickets_pkey PRIMARY KEY (recid);


--
-- TOC entry 1937 (class 1259 OID 33210)
-- Name: idx_ng_nts_employees__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_employees__compound_id ON ng_nts_employees USING btree (compound_id);


--
-- TOC entry 1938 (class 1259 OID 33211)
-- Name: idx_ng_nts_employees__gender_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_employees__gender_lookup_id ON ng_nts_employees USING btree (gender_lookup_id);


--
-- TOC entry 1939 (class 1259 OID 33212)
-- Name: idx_ng_nts_employees__group_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_employees__group_id ON ng_nts_employees USING btree (group_id);


--
-- TOC entry 1940 (class 1259 OID 33213)
-- Name: idx_ng_nts_employees__salutation_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_employees__salutation_lookup_id ON ng_nts_employees USING btree (salutation_lookup_id);


--
-- TOC entry 1941 (class 1259 OID 33214)
-- Name: idx_ng_nts_employees__status_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_employees__status_lookup_id ON ng_nts_employees USING btree (status_lookup_id);


--
-- TOC entry 1957 (class 1259 OID 33326)
-- Name: idx_ng_nts_facilities__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_facilities__compound_id ON ng_nts_facilities USING btree (compound_id);


--
-- TOC entry 1958 (class 1259 OID 33327)
-- Name: idx_ng_nts_facilities__facility_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_facilities__facility_lookup_id ON ng_nts_facilities USING btree (facility_lookup_id);


--
-- TOC entry 1959 (class 1259 OID 33328)
-- Name: idx_ng_nts_facilities__tenant_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_facilities__tenant_id ON ng_nts_facilities USING btree (tenant_id);


--
-- TOC entry 1934 (class 1259 OID 33193)
-- Name: idx_ng_nts_lookup__type_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_lookup__type_id ON ng_nts_lookup USING btree (type_id);


--
-- TOC entry 1967 (class 1259 OID 33381)
-- Name: idx_ng_nts_orders__accepted_by; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_orders__accepted_by ON ng_nts_orders USING btree (accepted_by);


--
-- TOC entry 1968 (class 1259 OID 33382)
-- Name: idx_ng_nts_orders__channel_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_orders__channel_lookup_id ON ng_nts_orders USING btree (channel_lookup_id);


--
-- TOC entry 1969 (class 1259 OID 33383)
-- Name: idx_ng_nts_orders__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_orders__compound_id ON ng_nts_orders USING btree (compound_id);


--
-- TOC entry 1970 (class 1259 OID 33384)
-- Name: idx_ng_nts_orders__created_by; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_orders__created_by ON ng_nts_orders USING btree (created_by);


--
-- TOC entry 1971 (class 1259 OID 33385)
-- Name: idx_ng_nts_orders__facility_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_orders__facility_id ON ng_nts_orders USING btree (facility_id);


--
-- TOC entry 1972 (class 1259 OID 33386)
-- Name: idx_ng_nts_orders__service_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_orders__service_id ON ng_nts_orders USING btree (service_id);


--
-- TOC entry 1973 (class 1259 OID 33387)
-- Name: idx_ng_nts_orders__tenant_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_orders__tenant_id ON ng_nts_orders USING btree (tenant_id);


--
-- TOC entry 1948 (class 1259 OID 33274)
-- Name: idx_ng_nts_service_usage_rates__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_service_usage_rates__compound_id ON ng_nts_service_usage_rates USING btree (compound_id);


--
-- TOC entry 1949 (class 1259 OID 33275)
-- Name: idx_ng_nts_service_usage_rates__service_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_service_usage_rates__service_id ON ng_nts_service_usage_rates USING btree (service_id);


--
-- TOC entry 1944 (class 1259 OID 33251)
-- Name: idx_ng_nts_services__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_services__compound_id ON ng_nts_services USING btree (compound_id);


--
-- TOC entry 1945 (class 1259 OID 33252)
-- Name: idx_ng_nts_services__measuring_unit_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_services__measuring_unit_lookup_id ON ng_nts_services USING btree (measuring_unit_lookup_id);


--
-- TOC entry 1962 (class 1259 OID 33352)
-- Name: idx_ng_nts_tenant_facilities__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tenant_facilities__compound_id ON ng_nts_tenant_facilities USING btree (compound_id);


--
-- TOC entry 1963 (class 1259 OID 33353)
-- Name: idx_ng_nts_tenant_facilities__facility_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tenant_facilities__facility_id ON ng_nts_tenant_facilities USING btree (facility_id);


--
-- TOC entry 1964 (class 1259 OID 33354)
-- Name: idx_ng_nts_tenant_facilities__tenant_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tenant_facilities__tenant_id ON ng_nts_tenant_facilities USING btree (tenant_id);


--
-- TOC entry 1952 (class 1259 OID 33297)
-- Name: idx_ng_nts_tenants__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tenants__compound_id ON ng_nts_tenants USING btree (compound_id);


--
-- TOC entry 1953 (class 1259 OID 33298)
-- Name: idx_ng_nts_tenants__gender_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tenants__gender_lookup_id ON ng_nts_tenants USING btree (gender_lookup_id);


--
-- TOC entry 1954 (class 1259 OID 33299)
-- Name: idx_ng_nts_tenants__salutation_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tenants__salutation_lookup_id ON ng_nts_tenants USING btree (salutation_lookup_id);


--
-- TOC entry 1976 (class 1259 OID 33434)
-- Name: idx_ng_nts_tickets__assigned_group_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets__assigned_group_id ON ng_nts_tickets USING btree (assigned_group_id);


--
-- TOC entry 1977 (class 1259 OID 33435)
-- Name: idx_ng_nts_tickets__channel_lookup_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets__channel_lookup_id ON ng_nts_tickets USING btree (channel_lookup_id);


--
-- TOC entry 1978 (class 1259 OID 33436)
-- Name: idx_ng_nts_tickets__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets__compound_id ON ng_nts_tickets USING btree (compound_id);


--
-- TOC entry 1979 (class 1259 OID 33437)
-- Name: idx_ng_nts_tickets__facility_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets__facility_id ON ng_nts_tickets USING btree (facility_id);


--
-- TOC entry 1980 (class 1259 OID 33438)
-- Name: idx_ng_nts_tickets__opened_by; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets__opened_by ON ng_nts_tickets USING btree (opened_by);


--
-- TOC entry 1981 (class 1259 OID 33439)
-- Name: idx_ng_nts_tickets__related_tenant_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets__related_tenant_id ON ng_nts_tickets USING btree (related_tenant_id);


--
-- TOC entry 1982 (class 1259 OID 33440)
-- Name: idx_ng_nts_tickets__service_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets__service_id ON ng_nts_tickets USING btree (service_id);


--
-- TOC entry 1985 (class 1259 OID 33487)
-- Name: idx_ng_nts_tickets_histories__action_by; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets_histories__action_by ON ng_nts_tickets_histories USING btree (action_by);


--
-- TOC entry 1986 (class 1259 OID 33488)
-- Name: idx_ng_nts_tickets_histories__compound_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets_histories__compound_id ON ng_nts_tickets_histories USING btree (compound_id);


--
-- TOC entry 1987 (class 1259 OID 33489)
-- Name: idx_ng_nts_tickets_histories__opened_by; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets_histories__opened_by ON ng_nts_tickets_histories USING btree (opened_by);


--
-- TOC entry 1988 (class 1259 OID 33490)
-- Name: idx_ng_nts_tickets_histories__ticket_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_ng_nts_tickets_histories__ticket_id ON ng_nts_tickets_histories USING btree (ticket_id);


--
-- TOC entry 1994 (class 2606 OID 33215)
-- Name: fk_ng_nts_employees__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_employees
    ADD CONSTRAINT fk_ng_nts_employees__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 1995 (class 2606 OID 33220)
-- Name: fk_ng_nts_employees__gender_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_employees
    ADD CONSTRAINT fk_ng_nts_employees__gender_lookup_id FOREIGN KEY (gender_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 1996 (class 2606 OID 33225)
-- Name: fk_ng_nts_employees__group_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_employees
    ADD CONSTRAINT fk_ng_nts_employees__group_id FOREIGN KEY (group_id) REFERENCES ng_nts_groups(recid);


--
-- TOC entry 1997 (class 2606 OID 33230)
-- Name: fk_ng_nts_employees__salutation_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_employees
    ADD CONSTRAINT fk_ng_nts_employees__salutation_lookup_id FOREIGN KEY (salutation_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 1998 (class 2606 OID 33235)
-- Name: fk_ng_nts_employees__status_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_employees
    ADD CONSTRAINT fk_ng_nts_employees__status_lookup_id FOREIGN KEY (status_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 2006 (class 2606 OID 33329)
-- Name: fk_ng_nts_facilities__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_facilities
    ADD CONSTRAINT fk_ng_nts_facilities__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 2007 (class 2606 OID 33334)
-- Name: fk_ng_nts_facilities__facility_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_facilities
    ADD CONSTRAINT fk_ng_nts_facilities__facility_lookup_id FOREIGN KEY (facility_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 2008 (class 2606 OID 33339)
-- Name: fk_ng_nts_facilities__tenant_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_facilities
    ADD CONSTRAINT fk_ng_nts_facilities__tenant_id FOREIGN KEY (tenant_id) REFERENCES ng_nts_tenants(recid);


--
-- TOC entry 1993 (class 2606 OID 33194)
-- Name: fk_ng_nts_lookup__type_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_lookup
    ADD CONSTRAINT fk_ng_nts_lookup__type_id FOREIGN KEY (type_id) REFERENCES ng_nts_lookup_types(recid);


--
-- TOC entry 2012 (class 2606 OID 33388)
-- Name: fk_ng_nts_orders__accepted_by; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_orders
    ADD CONSTRAINT fk_ng_nts_orders__accepted_by FOREIGN KEY (accepted_by) REFERENCES ng_nts_employees(recid);


--
-- TOC entry 2013 (class 2606 OID 33393)
-- Name: fk_ng_nts_orders__channel_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_orders
    ADD CONSTRAINT fk_ng_nts_orders__channel_lookup_id FOREIGN KEY (channel_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 2014 (class 2606 OID 33398)
-- Name: fk_ng_nts_orders__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_orders
    ADD CONSTRAINT fk_ng_nts_orders__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 2015 (class 2606 OID 33403)
-- Name: fk_ng_nts_orders__created_by; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_orders
    ADD CONSTRAINT fk_ng_nts_orders__created_by FOREIGN KEY (created_by) REFERENCES ng_nts_employees(recid);


--
-- TOC entry 2016 (class 2606 OID 33408)
-- Name: fk_ng_nts_orders__facility_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_orders
    ADD CONSTRAINT fk_ng_nts_orders__facility_id FOREIGN KEY (facility_id) REFERENCES ng_nts_facilities(recid);


--
-- TOC entry 2017 (class 2606 OID 33413)
-- Name: fk_ng_nts_orders__service_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_orders
    ADD CONSTRAINT fk_ng_nts_orders__service_id FOREIGN KEY (service_id) REFERENCES ng_nts_services(recid);


--
-- TOC entry 2018 (class 2606 OID 33418)
-- Name: fk_ng_nts_orders__tenant_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_orders
    ADD CONSTRAINT fk_ng_nts_orders__tenant_id FOREIGN KEY (tenant_id) REFERENCES ng_nts_tenants(recid);


--
-- TOC entry 2001 (class 2606 OID 33276)
-- Name: fk_ng_nts_service_usage_rates__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_service_usage_rates
    ADD CONSTRAINT fk_ng_nts_service_usage_rates__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 2002 (class 2606 OID 33281)
-- Name: fk_ng_nts_service_usage_rates__service_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_service_usage_rates
    ADD CONSTRAINT fk_ng_nts_service_usage_rates__service_id FOREIGN KEY (service_id) REFERENCES ng_nts_services(recid);


--
-- TOC entry 1999 (class 2606 OID 33253)
-- Name: fk_ng_nts_services__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_services
    ADD CONSTRAINT fk_ng_nts_services__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 2000 (class 2606 OID 33258)
-- Name: fk_ng_nts_services__measuring_unit_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_services
    ADD CONSTRAINT fk_ng_nts_services__measuring_unit_lookup_id FOREIGN KEY (measuring_unit_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 2009 (class 2606 OID 33355)
-- Name: fk_ng_nts_tenant_facilities__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tenant_facilities
    ADD CONSTRAINT fk_ng_nts_tenant_facilities__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 2010 (class 2606 OID 33360)
-- Name: fk_ng_nts_tenant_facilities__facility_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tenant_facilities
    ADD CONSTRAINT fk_ng_nts_tenant_facilities__facility_id FOREIGN KEY (facility_id) REFERENCES ng_nts_facilities(recid);


--
-- TOC entry 2011 (class 2606 OID 33365)
-- Name: fk_ng_nts_tenant_facilities__tenant_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tenant_facilities
    ADD CONSTRAINT fk_ng_nts_tenant_facilities__tenant_id FOREIGN KEY (tenant_id) REFERENCES ng_nts_tenants(recid);


--
-- TOC entry 2003 (class 2606 OID 33300)
-- Name: fk_ng_nts_tenants__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tenants
    ADD CONSTRAINT fk_ng_nts_tenants__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 2004 (class 2606 OID 33305)
-- Name: fk_ng_nts_tenants__gender_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tenants
    ADD CONSTRAINT fk_ng_nts_tenants__gender_lookup_id FOREIGN KEY (gender_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 2005 (class 2606 OID 33310)
-- Name: fk_ng_nts_tenants__salutation_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tenants
    ADD CONSTRAINT fk_ng_nts_tenants__salutation_lookup_id FOREIGN KEY (salutation_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 2019 (class 2606 OID 33441)
-- Name: fk_ng_nts_tickets__assigned_group_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets
    ADD CONSTRAINT fk_ng_nts_tickets__assigned_group_id FOREIGN KEY (assigned_group_id) REFERENCES ng_nts_groups(recid);


--
-- TOC entry 2020 (class 2606 OID 33446)
-- Name: fk_ng_nts_tickets__channel_lookup_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets
    ADD CONSTRAINT fk_ng_nts_tickets__channel_lookup_id FOREIGN KEY (channel_lookup_id) REFERENCES ng_nts_lookup(recid);


--
-- TOC entry 2021 (class 2606 OID 33451)
-- Name: fk_ng_nts_tickets__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets
    ADD CONSTRAINT fk_ng_nts_tickets__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 2022 (class 2606 OID 33456)
-- Name: fk_ng_nts_tickets__facility_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets
    ADD CONSTRAINT fk_ng_nts_tickets__facility_id FOREIGN KEY (facility_id) REFERENCES ng_nts_facilities(recid);


--
-- TOC entry 2023 (class 2606 OID 33461)
-- Name: fk_ng_nts_tickets__opened_by; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets
    ADD CONSTRAINT fk_ng_nts_tickets__opened_by FOREIGN KEY (opened_by) REFERENCES ng_nts_employees(recid);


--
-- TOC entry 2024 (class 2606 OID 33466)
-- Name: fk_ng_nts_tickets__related_tenant_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets
    ADD CONSTRAINT fk_ng_nts_tickets__related_tenant_id FOREIGN KEY (related_tenant_id) REFERENCES ng_nts_tenants(recid);


--
-- TOC entry 2025 (class 2606 OID 33471)
-- Name: fk_ng_nts_tickets__service_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets
    ADD CONSTRAINT fk_ng_nts_tickets__service_id FOREIGN KEY (service_id) REFERENCES ng_nts_services(recid);


--
-- TOC entry 2026 (class 2606 OID 33491)
-- Name: fk_ng_nts_tickets_histories__action_by; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets_histories
    ADD CONSTRAINT fk_ng_nts_tickets_histories__action_by FOREIGN KEY (action_by) REFERENCES ng_nts_employees(recid);


--
-- TOC entry 2027 (class 2606 OID 33496)
-- Name: fk_ng_nts_tickets_histories__compound_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets_histories
    ADD CONSTRAINT fk_ng_nts_tickets_histories__compound_id FOREIGN KEY (compound_id) REFERENCES ng_nts_compounds(recid);


--
-- TOC entry 2028 (class 2606 OID 33501)
-- Name: fk_ng_nts_tickets_histories__opened_by; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets_histories
    ADD CONSTRAINT fk_ng_nts_tickets_histories__opened_by FOREIGN KEY (opened_by) REFERENCES ng_nts_employees(recid);


--
-- TOC entry 2029 (class 2606 OID 33506)
-- Name: fk_ng_nts_tickets_histories__ticket_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ng_nts_tickets_histories
    ADD CONSTRAINT fk_ng_nts_tickets_histories__ticket_id FOREIGN KEY (ticket_id) REFERENCES ng_nts_tickets(recid);


--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-05-07 04:12:28

--
-- PostgreSQL database dump complete
--

