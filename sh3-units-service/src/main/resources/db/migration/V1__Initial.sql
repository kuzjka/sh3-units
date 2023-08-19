create sequence unit_sequence start with 100 increment by 50;

create table ships (
    id int primary key,
    type char(1),
    name varchar,
    displacement int,
    length int,
    beam int,
    draft int,
    mast int,
    speed int
);

create table merchants (
    id int primary key,
    category varchar
);

create table warships (
    id int primary key,
    category varchar,
    deck_gun boolean,
    aa_gun boolean,
    torpedoes boolean,
    depth_charges boolean
);

create table uboats (
    id int primary key,
    name varchar,
    displ_surf int,
    displ_subm int,
    speed_surf int,
    speed_subm int,
    diving_depth int,
    bow_tubes int,
    stern_tubes int
);

create table aircraft (
    id int primary key,
    name varchar,
    speed int,
    range int,
    length int,
    wingspan int,
    ordnance text,
    bombs boolean,
    depth_charges boolean,
    rockets boolean,
    torpedoes boolean,
    pak_gun boolean,
    leigh_light boolean,
    sirene boolean
);

create sequence nations_sequence start with 100 increment by 50;

create table nations (
    id int primary key,
    name varchar unique
);

create sequence precences_sequence start with 100 increment by 50;

create table presences (
    id int primary key,
    type char(1),
    unit_id int,
    nation_id int,
    start_year int,
    end_year int
);
