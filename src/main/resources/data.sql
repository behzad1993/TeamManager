INSERT INTO team (name, sports)
VALUES ('Jungmaster', 'swimming'),
	   ('Kinder', 'swimming'),
	   ('Jugend', 'swimming');

INSERT INTO member (birthday, email, last_name, phone_nr, sur_name)
VALUES ('1993-03-16', 'karimi1993@live.de', 'Karimi', '0176 666 777 888', 'Behzad'),
	   ('1994-09-13', 'Clarissa@live.de', 'Lachmann', '0179 666 777 888', 'Clarissa'),
	   ('2000-11-10', 'Felix@live.de', 'Muchow', '0171 666 777 888', 'Felix'),
	   ('2000-01-12', 'Tim@live.de', 'Lindner', '0171 666 777 888', 'Tim'),
	   ('1988-06-11', 'Philip@live.de', 'Loche', '0172 666 777 888', 'Philip'),
	   ('1999-01-08', 'Ronja@live.de', 'Markgraf', '0173 666 777 888', 'Ronja'),
	   ('2002-12-27', 'Mia@live.de', 'Goericke', '0174 666 777 888', 'Mia');

INSERT INTO strokes (first, second, third, fourth)
VALUES ('butterfly', 'backstroke', 'breaststroke', 'freestyle'),
	   ('butterfly', 'backstroke', 'breaststroke', 'freestyle'),
	   ('butterfly', 'backstroke', 'breaststroke', 'freestyle'),
	   ('butterfly', 'backstroke', 'breaststroke', 'freestyle'),
	   ('butterfly', 'backstroke', 'breaststroke', 'freestyle'),
	   ('butterfly', 'backstroke', 'breaststroke', 'freestyle'),
	   ('butterfly', 'backstroke', 'breaststroke', 'freestyle');

INSERT INTO member_team (member_id, team_id)
VALUES (1, 1),
	   (1, 2),
	   (1, 3),
	   (2, 1),
	   (3, 2),
	   (4, 3),
	   (5, 2),
	   (6, 3),
	   (7, 1),
	   (7, 2),
	   (7, 3);

-- INSERT INTO member_stroke (member_id, stroke_id)
-- VALUES (1, 1),
-- 	   (2, 2),
-- 	   (3, 3),
-- 	   (4, 4),
-- 	   (5, 5),
-- 	   (6, 6),
-- 	   (7, 7);
