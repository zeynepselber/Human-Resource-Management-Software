-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.activation_codes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying(50) NOT NULL,
    is_activated boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.cities
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.departments
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers
(
    company_name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    website character varying(255) NOT NULL,
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers_varification_by_system_personal
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_id integer NOT NULL,
    personal_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_advertisements
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    job_position_id integer NOT NULL,
    city_id integer NOT NULL,
    description text NOT NULL,
    min_salary double precision,
    max_salary double precision,
    open_position_count integer NOT NULL,
    is_active boolean NOT NULL,
    last_apply_date date NOT NULL,
    create_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    position_name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_seekers
(
    year_of_birth character varying NOT NULL,
    first_name character varying(255) NOT NULL,
    identification_number character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.languages
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.programing_languages
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_languages
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    language_id integer NOT NULL,
    level integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_programming_languages
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    programming_language_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_schools
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    school_id integer NOT NULL,
    department_id integer NOT NULL,
    start_date date NOT NULL,
    finish_date date,
    is_graduate boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.resume_work_experiences
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    resume_id integer NOT NULL,
    business_name character varying(255) NOT NULL,
    "position" character varying(255) NOT NULL,
    start_date date NOT NULL,
    finish_date date,
    still_working boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.resumes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_seeker_id integer NOT NULL,
    image text,
    github_address character varying(255),
    linkedin_address character varying(255),
    cover_letter text,
    PRIMARY KEY (id)
);

CREATE TABLE public.schools
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.system_personal
(
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    password_repeat character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.varification_by_email
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_id integer NOT NULL,
    activation_code_id integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.employers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers_varification_by_system_personal
    ADD FOREIGN KEY (personal_id)
    REFERENCES public.system_personal (id)
    NOT VALID;


ALTER TABLE public.employers_varification_by_system_personal
    ADD FOREIGN KEY (user_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (job_position_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.job_seekers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.resume_languages
    ADD FOREIGN KEY (language_id)
    REFERENCES public.languages (id)
    NOT VALID;


ALTER TABLE public.resume_languages
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.resume_programming_languages
    ADD FOREIGN KEY (programming_language_id)
    REFERENCES public.programing_languages (id)
    NOT VALID;


ALTER TABLE public.resume_programming_languages
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.resume_schools
    ADD FOREIGN KEY (department_id)
    REFERENCES public.departments (id)
    NOT VALID;


ALTER TABLE public.resume_schools
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.resume_schools
    ADD FOREIGN KEY (school_id)
    REFERENCES public.schools (id)
    NOT VALID;


ALTER TABLE public.resume_work_experiences
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.resumes
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seekers (id)
    NOT VALID;


ALTER TABLE public.system_personal
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.varification_by_email
    ADD FOREIGN KEY (activation_code_id)
    REFERENCES public.activation_codes (id)
    NOT VALID;


ALTER TABLE public.varification_by_email
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;

END;