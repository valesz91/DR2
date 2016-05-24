
    create table Armor (
        id integer not null auto_increment,
        name varchar(240),
        atkMinus integer,
        defPlus integer,
        healthPlus integer,
        description varchar(800),
        weight double precision,
        value integer,
        type varchar(40),
        primary key (id)
    ) ENGINE=InnoDB;

    create table Item (
        id integer not null auto_increment,
        name varchar(240),
        description varchar(800),
        weight double precision,
        value integer,
        type varchar(40),
        playersCharacter integer,
        primary key (id)
    ) ENGINE=InnoDB;

    create table MapElement (
        id integer not null auto_increment,
        description varchar(800),
        type varchar(40),
        primary key (id)
    ) ENGINE=InnoDB;

    create table PlayersCharacter (
        id integer not null auto_increment,
        name varchar(240),
        password varchar(40),
        strength integer,
        dexterity integer,
        health integer,
        quickness integer,
        loadCapacity double precision,
        actualExp integer,
        attackPoints integer,
        defendPoints integer,
        healthPoint integer,
        gold integer,
        damagePoints integer,
        actualWeapon integer,
        actualShield integer,
        actualArmor integer,
        position integer,
        race varchar(40),
        primary key (id)
    ) ENGINE=InnoDB;

    create table Potion (
        id integer not null auto_increment,
        name varchar(240),
        atk integer,
        def integer,
        health integer,
        damage integer,
        durability integer,
        description varchar(800),
        weight double precision,
        value integer,
        type varchar(40),
        primary key (id)
    ) ENGINE=InnoDB;

    create table Shield (
        id integer not null auto_increment,
        name varchar(240),
        atkMinus integer,
        defPlus integer,
        description varchar(800),
        weight double precision,
        value integer,
        type varchar(40),
        primary key (id)
    ) ENGINE=InnoDB;

    create table Weapon (
        id integer not null auto_increment,
        name varchar(240),
        atk integer,
        def integer,
        damage integer,
        description varchar(800),
        weight double precision,
        value integer,
        type varchar(40),
        primary key (id)
    ) ENGINE=InnoDB;

    create table playersCharacter_armor (
        armor_id integer not null,
        playersCharacter_id integer not null
    ) ENGINE=InnoDB;

    create table playersCharacter_potion (
        potion_id integer not null,
        playersCharacter_id integer not null
    ) ENGINE=InnoDB;

    create table playersCharacter_shield (
        shield_id integer not null,
        playersCharacter_id integer not null
    ) ENGINE=InnoDB;

    create table playersCharacter_weapon (
        weapon_id integer not null,
        playersCharacter_id integer not null
    ) ENGINE=InnoDB;

    alter table Item 
        add index fk_itemPlayersCharacter (playersCharacter), 
        add constraint fk_itemPlayersCharacter 
        foreign key (playersCharacter) 
        references PlayersCharacter (id);

    alter table Item 
        add index FK22EF3320F15C39 (id), 
        add constraint FK22EF3320F15C39 
        foreign key (id) 
        references MapElement (id);

    alter table PlayersCharacter 
        add index fk_playersCharacterActualWeapon (actualWeapon), 
        add constraint fk_playersCharacterActualWeapon 
        foreign key (actualWeapon) 
        references Weapon (id);

    alter table PlayersCharacter 
        add index fk_playersCharacterMapElement (position), 
        add constraint fk_playersCharacterMapElement 
        foreign key (position) 
        references MapElement (id);

    alter table PlayersCharacter 
        add index fk_playersCharacterActualShield (actualShield), 
        add constraint fk_playersCharacterActualShield 
        foreign key (actualShield) 
        references Shield (id);

    alter table PlayersCharacter 
        add index fk_playersCharacterActualArmor (actualArmor), 
        add constraint fk_playersCharacterActualArmor 
        foreign key (actualArmor) 
        references Armor (id);

    alter table playersCharacter_armor 
        add index FK49FBD897F3417D7C (armor_id), 
        add constraint FK49FBD897F3417D7C 
        foreign key (armor_id) 
        references Armor (id);

    alter table playersCharacter_armor 
        add index FK49FBD8979ADB10D8 (playersCharacter_id), 
        add constraint FK49FBD8979ADB10D8 
        foreign key (playersCharacter_id) 
        references PlayersCharacter (id);

    alter table playersCharacter_potion 
        add index FKEF0BD3B9ADB10D8 (playersCharacter_id), 
        add constraint FKEF0BD3B9ADB10D8 
        foreign key (playersCharacter_id) 
        references PlayersCharacter (id);

    alter table playersCharacter_potion 
        add index FKEF0BD3B6EA9A0F8 (potion_id), 
        add constraint FKEF0BD3B6EA9A0F8 
        foreign key (potion_id) 
        references Potion (id);

    alter table playersCharacter_shield 
        add index FK13A79311C1EC938 (shield_id), 
        add constraint FK13A79311C1EC938 
        foreign key (shield_id) 
        references Shield (id);

    alter table playersCharacter_shield 
        add index FK13A793119ADB10D8 (playersCharacter_id), 
        add constraint FK13A793119ADB10D8 
        foreign key (playersCharacter_id) 
        references PlayersCharacter (id);

    alter table playersCharacter_weapon 
        add index FK1A4D35C49ADB10D8 (playersCharacter_id), 
        add constraint FK1A4D35C49ADB10D8 
        foreign key (playersCharacter_id) 
        references PlayersCharacter (id);

    alter table playersCharacter_weapon 
        add index FK1A4D35C497F4E858 (weapon_id), 
        add constraint FK1A4D35C497F4E858 
        foreign key (weapon_id) 
        references Weapon (id);
