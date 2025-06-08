INSERT INTO toilet_block
VALUES
(101, '123 Makers Street, Makers Valley, Johannesburg', 'Open', 0),
(202, '452 The Avenue, Makers Valley, Johannesburg', 'Closed', 0),
(303, '81 Apple Tree Road, Makers Valley, Johannesburg', 'Open', 0),
(404, '1 Walnut Close, Makers Valley, Johannesburg', 'Disabled', 0);

INSERT INTO toilet
VALUES
(9011, 101, 'Vacant'),
(9012, 101, 'Vacant'),
(9013, 101, 'Disabled'),
(9014, 101, 'Disabled'),
(9031, 303, 'Vacant'),
(9032, 303, 'Vacant'),
(9041, 404, 'Disabled');

INSERT INTO resident
VALUES
(1001, 'ThembaN12', 'themba.nkosi@gmail.com', 'mypassword1'),
(1002, 'Faina2131', 'faina.arkaha@gmail.com', '123456'),
(1003, 'XobileMawana', 'xobile.mawana@gmail.com', 'makersvalley-13');

INSERT INTO farmer
VALUES
(9991, 1001);
