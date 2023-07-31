-- DML
INSERT INTO todo_item_entity (id, description, complete)
VALUES (1, 'Go for a walk with a dog', false);
INSERT INTO todo_item_entity (id, description, complete)
VALUES (2, 'Play the piano', false);
INSERT INTO todo_item_entity (id, description, complete)
VALUES (3, 'Pay the phone bill', true);

INSERT INTO todo_item_entity_seq (next_val)
VALUES (1);