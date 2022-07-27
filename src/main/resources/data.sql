INSERT INTO player(number, name, lastname, position)
values
(31, 'Carey', 'Price', 'goaltender'),
(14, 'Nick', 'Suzuki', 'forward'),
(15, 'Jesperi', 'Kotkaniemi', 'forward'),
(71, 'Jake', 'Evans', 'forward'),
(27, 'Alexander', 'Romanov', 'defenseman'),
(6, 'Shea', 'Weber', 'goaltender'),
(11, 'Brendan', 'Gallagher', 'forward'),
(68, 'Mike', 'Hoffman', 'forward'),
(58, 'David', 'Savard', 'defenseman'),
(40, 'Joel', 'Edmundso,', 'defenseman');

INSERT INTO team(id, coach, year, captain)
values
(1, 'Dominique Ducharme', 2019, 31),
(2, 'Dominique Ducharme', 2020, 31),
(3, 'Dominique Ducharme', 2021, 6);

INSERT INTO team_player(team_id, player_id)
values
(1, 31), (1, 14), (1, 15), (1, 27), (1,58),
(2, 31), (2, 14), (2, 15), (2, 27), (2,40),
(3, 6), (3, 71), (3, 11), (3, 31), (3, 40);




