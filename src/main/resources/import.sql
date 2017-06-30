
    create table kpi (
       id integer not null,
        measure varchar(255),
        name varchar(255),
        primary key (id)
    ) type=MyISAM

    create table project (
       id integer not null,
        name varchar(255),
        project_type_id integer,
        primary key (id)
    ) type=MyISAM

    create table project_kpi_value (
       year integer not null,
        month integer not null,
        comment longtext,
        value varchar(255),
        project_id integer not null,
        kpi_id integer not null,
        primary key (year, project_id, month, kpi_id)
    ) type=MyISAM

    create table project_type (
       id integer not null,
        name integer,
        primary key (id)
    ) type=MyISAM

    create table project_type_kpi (
       project_type_id integer not null,
        kpi_id integer not null,
        primary key (project_type_id, kpi_id)
    ) type=MyISAM

    create table user (
       id integer not null,
        email varchar(255),
        firstname varchar(255),
        lastname varchar(255),
        password varchar(255),
        role integer,
        username varchar(255) not null,
        primary key (id)
    ) type=MyISAM

    create table user_project (
       user_id integer not null,
        project_id integer not null,
        primary key (user_id, project_id)
    ) type=MyISAM

    alter table project 
       add constraint PROJECT_TYPE_ID_FK 
       foreign key (project_type_id) 
       references project_type (id)

    alter table project_kpi_value 
       add constraint PROJECT_ID_FK 
       foreign key (project_id) 
       references project (id)

    alter table project_kpi_value 
       add constraint KPI_ID_FK 
       foreign key (kpi_id) 
       references kpi (id)

    alter table project_type_kpi 
       add constraint PROJECT_TYPE_ID_FK 
       foreign key (project_type_id) 
       references project_type (id)

    alter table project_type_kpi 
       add constraint KPI_ID_FK 
       foreign key (kpi_id) 
       references kpi (id)

    alter table user_project 
       add constraint USER_ID_FK 
       foreign key (user_id) 
       references user (id)

    alter table user_project 
       add constraint PROJECT_ID_FK 
       foreign key (project_id) 
       references project (id)
