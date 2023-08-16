create sequence hibernate_sequence start with 100 increment by 50;

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
    category varchar
);

create table warships (
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
    ordinance text,
    bombs boolean,
    depth_charges boolean,
    rockets boolean,
    torpedoes boolean,
    pak_gun boolean,
    liegh_light boolean,
    sirene boolean
);

create table nations (
    id int primary key,
    name varchar
);

create table presences (
    id int primary key,
    type char(1),
    unit_id int,
    nation_id int,
    start int,
    end int
);
