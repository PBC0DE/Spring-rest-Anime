DROP TABLE IF EXISTS anime;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS file;

CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY NOT NULL,
    username   VARCHAR(255) UNIQUE   NOT NULL,
    password   VARCHAR(255)          NOT NULL,
    created    TIMESTAMP             NOT NULL DEFAULT NOW(),
    updated    TIMESTAMP             NOT NULL DEFAULT NOW()
);

CREATE TABLE role
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE user_role
(
    user_id BIGINT REFERENCES users(id),
    role_id BIGINT REFERENCES role(id)
);

CREATE TABLE anime
(
    id           BIGSERIAL PRIMARY KEY NOT NULL,
    name         VARCHAR(255)          NOT NULL,
    image        VARCHAR(255)          NOT NULL,
    type         VARCHAR(255)          NOT NULL,
    score        DOUBLE                NOT NULL,
    chapters     Integer               NOT NULL,
    releasedate  VARCHAR(255)          NOT NULL,
    description  TEXT                  NOT NULL,
    created      TIMESTAMP             DEFAULT NOW(),
    updated      TIMESTAMP             DEFAULT NOW()
);
CREATE TABLE watchlist
(
    id           BIGSERIAL  PRIMARY KEY NOT NULL,
    animeid      BIGINT NOT NULL,
    userid       BIGINT NOT NULL
);

INSERT INTO users (username, password)
VALUES ('admin', '{bcrypt}$2a$10$WJvAKW5R1VM2SSaAWf0WYO/FBcovz6X3BpulRoS2FWdUbcCZPo8V2'),
       ('user', '{bcrypt}$2a$10$WJvAKW5R1VM2SSaAWf0WYO/FBcovz6X3BpulRoS2FWdUbcCZPo8V2');

INSERT INTO role (name)
VALUES ('USER'),
       ('ADMIN');

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 1);

INSERT INTO anime (name, image, type, score, chapters, releasedate, description)
VALUES ('Death Note', 'https://s4.anilist.co/file/anilistcdn/media/manga/cover/large/nx30021-qfGufBWpSX1z.jpg','Manga','8.4', '104', 'Dec 1, 2003', 'Light tests the boundaries of the Death Note''s powers as L and the police begin to close in. Luckily Light''s father is the head of the Japanese National Police Agency and leaves vital information about the case lying around the house. With access to his father''s files, Light can keep one step ahead of the authorities. But who is the strange man following him, and how can Light guard against enemies whose names he doesn''t know?'),
       ('DEVILMAN crybaby', 'https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/nx98460-WTidxsFZrHfv.jpg','Manga','8.1', '64', 'Jan 5, 2018', 'The protagonist Akira Fudou learns from his best friend, Ryou Asuka, that an ancient race of demons has returned to take back the world from humans. Ryou tells Akira that the only way to defeat the demons is to incorporate their supernatural powers, and suggests that he unite with a demon himself. Akira succeeds in transforming into Devilman, who possesses both the powers of a demon and the soul of a human. The battle of Devilman and Akira Fudou begins.'),
       ('Hellsing Ultimate', 'https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/nx777-wviqUSUoSXAl.jpg','Manga','7.6', '26', 'Feb 10, 2006', 'Hellsing, a secret organization of the British government, has long been battling supernatural threats to keep the people safe from creatures of the night. The current leader, Integra Wingates Hellsing controls her own personal army to eliminate the undead beings, but even her highly trained soldiers pale in comparison to her most trusted vampire exterminator, a man by the name of Alucard, who is actually a powerful vampire himself. Along with Integra''s mysterious butler and Alucard''s new vampire minion, Seras Victoria, The Hellsing Organization must face not only regular ghouls and vampires, but a rivaling secret organization from the Vatican, and Millennium, an enigmatic group of madmen spawned by a certain war over 50 years ago...
        A bloody battle between monsters is about to begin, the dead are dancing, and all hell is singing...'),
       ('Blood-C', 'https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx10490-Rqx4jlTOMFWx.jpg','Manga','7.7', '33', 'Dec 1, 2003', 'Ryuk, a god of death, drops his Death Note into the human world for personal pleasure. In Japan, prodigious high school student Light Yagami stumbles upon it. Inside the notebook, he finds a chilling message: those whose names are written in it shall die. Its nonsensical nature amuses Light; but when he tests its power by writing the name of a criminal in it, they suddenly meet their demise.
        Realizing the Death Note''s vast potential, Light commences a series of nefarious murders under the pseudonym "Kira," vowing to cleanse the world of corrupt individuals and create a perfect society where crime ceases to exist. However, the police quickly catch on, and they enlist the help of L—a mastermind detective—to uncover the culprit.
        Death Note tells the thrilling tale of Light and L as they clash in a great battle-of-minds, one that will determine the future of the world.'),
       ('Berserk 2', 'https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx97643-5s3MVIfTYIuQ.jpg','Manga','7.1', '28', 'Apr 7, 2017', 'Demons have now become commonplace around the kingdom of Midland, which has fallen into chaos. The swordsman Guts still cannot stay in one place for long due to his demonic brand. He could always manage to protect himself when he was alone, but now he has the added challenge of protecting former Commander Casca, a shell of her former self who neither remembers nor trusts him. They never have a moment''s rest with the constant threat of demons, and they need a place where Casca will be safe till they find a way to heal her. Their elf ally, Puck, tells of the mystical land of Elfhelm, which is supposed to be a safe haven from the demons that ravage the lands. Tired and with only a vague hope, they struggle on to find a place to live—and they still need to find those responsible for the madness they are forced to endure.'),
       ('Cowboy Bebop', 'https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx1-CXtrrkMpJ8Zq.png','Original','8', '24', 'Apr 3, 1998', 'Enter a world in the distant future, where Bounty Hunters roam the solar system. Spike and Jet, bounty hunting partners, set out on journeys in an ever struggling effort to win bounty rewards to survive. While traveling, they meet up with other very interesting people. Could Faye, the beautiful and ridiculously poor gambler, Edward, the computer genius, and Ein, the engineered dog be a good addition to the group?'),
       ('Kimetsu no Yaiba', 'https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx101922-PEn1CTc93blC.jpg','ETT','7','20', 'Apr 6, 2019', 'emons have now become commonplace around the kingdom of Midland, which has fallen into chaos. The swordsman Guts still cannot stay in one place for long due to his demonic brand'),
       ('Shingeki no Kyojin', 'https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx16498-m5ZMNtFioc7j.png','Manga','7','20', 'Apr 7, 2013', 'Several hundred years ago, humans were nearly exterminated by titans. Titans are typically several stories tall, seem to have no intelligence, devour human beings and, worst of all, seem to do it for the pleasure rather than as a food source. A small percentage of humanity survived by walling themselves in a city protected by extremely high walls, even taller than the biggest of titans.Flash forward to the present and the city has not seen a titan in over 100 years. Teenage boy Eren and his foster sister Mikasa witness something horrific as the city walls are destroyed by a colossal titan that appears out of thin air. As the smaller titans flood the city, the two kids watch in horror as their mother is eaten alive. Eren vows that he will murder every single titan and take revenge for all of mankind.'),
       ('Sword Art Online', 'https://s4.anilist.co/file/anilistcdn/media/anime/cover/large/bx124140-HNL0CpH6ig6y.png','Light Novel','0','0', 'Oct 30, 2021', '"There''s no way to beat this game. The only difference is when and where you die..."One month has passed since Akihiko Kayaba''s deadly game began, and the body count continues to rise. Two thousand players are already dead.irito and Asuna are two very different people, but they both desire to fight alone. Nonetheless, they find themselves drawn together to face challenges from both within and without. Given that the entire virtual world they now live in has been created as a deathtrap, the surviving players of Sword Art Online are starting to get desperate, and desperation makes them dangerous to loners like Kirito and Asuna. As it becomes clear that solitude equals suicide, will the two be able to overcome their differences to find the strength to believe in each other, and in doing so, survive?Sword Art Online: Progressive is a new version of the Sword Art Online tale that starts at the beginning of Kirito and Asuna''s epic adventure—on the very first level of the deadly world of Aincrad!');
