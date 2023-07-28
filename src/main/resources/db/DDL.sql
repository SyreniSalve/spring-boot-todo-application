-- DDL
CREATE TABLE `todo`.`todo_item_entity` (
    `id` BIGINT NOT NULL,
    `description` VARCHAR(250) NOT NULL,
    `complete` BOOLEAN NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

CREATE TABLE `todo`.`todo_item_entity_seq` (
    `next_val` BIGINT NOT NULL,
    PRIMARY KEY (`next_val`));