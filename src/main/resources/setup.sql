CREATE TABLE `Person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- Table: public.cuenta

-- DROP TABLE public.cuenta;

CREATE TABLE public.cuenta
(
    id integer NOT NULL DEFAULT nextval('cuentas_id_seq'::regclass),
    numerocuenta text COLLATE pg_catalog."default",
    id_person integer,
    CONSTRAINT cuentas_pkey PRIMARY KEY (id),
    CONSTRAINT "FK_cuenta_persona" FOREIGN KEY (id_person)
        REFERENCES public.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cuenta
    OWNER to "USER_OPOS";