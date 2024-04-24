INSERT INTO team (id, name)
VALUES (1, 'Jungmaster');
INSERT INTO team (id, name)
VALUES (2, 'Kinder');
INSERT INTO team (id, name)
VALUES (3, 'Jugend');

INSERT INTO member (birthday, id, email, last_name, phone_nr, sur_name)
VALUES ('1993-03-16', 1, 'karimi1993@live.de', 'Karimi', '0176 666 777 888', 'Behzad');
INSERT INTO member (birthday, id, email, last_name, phone_nr, sur_name)
VALUES ('1994-09-13', 2, 'Clarissa@live.de', 'Lachmann', '0179 666 777 888', 'Clarissa');
INSERT INTO member (birthday, id, email, last_name, phone_nr, sur_name)
VALUES ('2000-11-10', 3, 'Felix@live.de', 'Muchow', '0171 666 777 888', 'Felix');
INSERT INTO member (birthday, id, email, last_name, phone_nr, sur_name)
VALUES ('2000-01-12', 4, 'Tim@live.de', 'Lindner', '0171 666 777 888', 'Tim');
INSERT INTO member (birthday, id, email, last_name, phone_nr, sur_name)
VALUES ('1988-06-11', 5, 'Philip@live.de', 'Loche', '0172 666 777 888', 'Philip');
INSERT INTO member (birthday, id, email, last_name, phone_nr, sur_name)
VALUES ('1999-01-08', 6, 'Ronja@live.de', 'Markgraf', '0173 666 777 888', 'Ronja');
INSERT INTO member (birthday, id, email, last_name, phone_nr, sur_name)
VALUES ('2002-12-27', 7, 'Mia@live.de', 'Goericke', '0174 666 777 888', 'Mia');


INSERT INTO member_team (member_id, team_id)
VALUES (1, 1);
INSERT INTO member_team (member_id, team_id)
VALUES (1, 2);
INSERT INTO member_team (member_id, team_id)
VALUES (1, 3);
INSERT INTO member_team (member_id, team_id)
VALUES (2, 1);
INSERT INTO member_team (member_id, team_id)
VALUES (3, 2);
INSERT INTO member_team (member_id, team_id)
VALUES (4, 3);
INSERT INTO member_team (member_id, team_id)
VALUES (5, 2);
INSERT INTO member_team (member_id, team_id)
VALUES (6, 3);
INSERT INTO member_team (member_id, team_id)
VALUES (7, 1);
INSERT INTO member_team (member_id, team_id)
VALUES (7, 2);
INSERT INTO member_team (member_id, team_id)
VALUES (7, 3);