
    alter table Item 
        drop 
        foreign key fk_itemPlayersCharacter;

    alter table Item 
        drop 
        foreign key FK22EF3320F15C39;

    alter table PlayersCharacter 
        drop 
        foreign key fk_playersCharacterActualWeapon;

    alter table PlayersCharacter 
        drop 
        foreign key fk_playersCharacterMapElement;

    alter table PlayersCharacter 
        drop 
        foreign key fk_playersCharacterActualShield;

    alter table PlayersCharacter 
        drop 
        foreign key fk_playersCharacterActualArmor;

    alter table playersCharacter_armor 
        drop 
        foreign key FK49FBD897F3417D7C;

    alter table playersCharacter_armor 
        drop 
        foreign key FK49FBD8979ADB10D8;

    alter table playersCharacter_potion 
        drop 
        foreign key FKEF0BD3B9ADB10D8;

    alter table playersCharacter_potion 
        drop 
        foreign key FKEF0BD3B6EA9A0F8;

    alter table playersCharacter_shield 
        drop 
        foreign key FK13A79311C1EC938;

    alter table playersCharacter_shield 
        drop 
        foreign key FK13A793119ADB10D8;

    alter table playersCharacter_weapon 
        drop 
        foreign key FK1A4D35C49ADB10D8;

    alter table playersCharacter_weapon 
        drop 
        foreign key FK1A4D35C497F4E858;

    drop table if exists Armor;

    drop table if exists Item;

    drop table if exists MapElement;

    drop table if exists PlayersCharacter;

    drop table if exists Potion;

    drop table if exists Shield;

    drop table if exists Weapon;

    drop table if exists playersCharacter_armor;

    drop table if exists playersCharacter_potion;

    drop table if exists playersCharacter_shield;

    drop table if exists playersCharacter_weapon;
