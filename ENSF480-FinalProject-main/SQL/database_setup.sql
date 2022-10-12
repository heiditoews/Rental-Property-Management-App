drop database if exists 480Project;
create database 480Project;

use 480Project;

create table RegisteredRenter (
    Name varchar(100) NOT NULL,
    Email varchar(100) NOT NULL PRIMARY KEY,
    State varchar(30),
    Password varchar(20) NOT NULL
);

insert into RegisteredRenter (Name, Email, State, Password)
values ('Brian Parsons', 'brian.parsons@gmail.com', 'Searching', 'password'),
('Lauren Howard', 'lauren.howard@gmail.com', 'Searching', 'password'),
('Lillian Simpson', 'lillian.simpson@gmail.com', 'Searching', 'password'),
('Jonathan Alsop', 'jonathan.alsop@gmail.com', 'Searching', 'password'),
('Vanessa Morgan', 'vanessa.morgan@gmail.com', 'Searching', 'password'),
('David Rutherford', 'david.rutherford@gmail.com', 'Searching', 'password'),
('Steven Ellison', 'steven.ellison@gmail.com', 'Searching', 'password');

create table Landlord (
    Name varchar(100) NOT NULL,
    Email varchar(100) NOT NULL PRIMARY KEY,
    Password varchar(20) NOT NULL
);

insert into Landlord(Name, Email, Password) 
values ('Benjamin Greene', 'benjamin.greene@gmail.com', 'password'),
('Joe Campbell', 'joe.campbell@gmail.com', 'password'),
('Trevor Black', 'trevor.black@gmail.com', 'password'),
('Wanda Alsop', 'wanda.alsop@gmail.com', 'password'),
('Katherine Cornish', 'katherine.cornish@gmail.com', 'password');

create table Manager (
    Name varchar(100) NOT NULL,
    Email varchar(100) NOT NULL PRIMARY KEY,
    Password varchar(20) NOT NULL
);

insert into Manager(Name, Email, Password) 
values ('Deirdre Graham', 'deirdre.graham@gmail.com', 'password'),
('Claire Baker', 'claire.baker@gmail.com', 'password');

create table Property (
	Address varchar(255) NOT NULL PRIMARY KEY,
    Landlord varchar(100) NOT NULL,
    State varchar(50) NOT NULL,
    Type varchar(20),
    NoBedrooms int,
    NoBathrooms int,
    Furnished int,
    CityQuad varchar(2),
    Period int,
    ID int,
    FeePaid int,
    StartDate Date,
    EndDate Date
);

alter table Property 
add foreign key (Landlord) references Landlord(Email);

insert into Property(Address, Landlord, State, Type, NoBedrooms, NoBathrooms, Furnished, CityQuad, Period, ID, FeePaid, StartDate, EndDate)
values ('123 1st St', 'trevor.black@gmail.com', 'Active', 'Townhouse', 3, 2, 0, 'NE', 30, 1, 1, '2021-12-1', '2021-12-30'),
('321 5th Ave', 'benjamin.greene@gmail.com', 'Active', 'Detached House', 5, 3, 0, 'NW', 30, 2, 1, '2021-12-1', '2021-12-30'),
('Unit 5 444 67th Ave', 'wanda.alsop@gmail.com', 'Active', 'Apartment', 2, 2, 1, 'SE', 30, 3, 1, '2021-12-1', '2021-12-30'),
('Unit 3 444 67th Ave', 'wanda.alsop@gmail.com', 'Active', 'Apartment', 2, 2, 0, 'SE', 30, 4, 1, '2021-12-1', '2021-12-30'),
('111 1st St', 'trevor.black@gmail.com', 'Active', 'Attached House', 3, 2, 0, 'SW', 30, 5, 1, '2021-12-1', '2021-12-30'),
('222 2nd St', 'joe.campbell@gmail.com', 'Active', 'Detached House', 6, 4, 0, 'SE', 30, 6, 1, '2021-12-1', '2021-12-30'),
('333 3rd St', 'benjamin.greene@gmail.com', 'Active', 'Detached House', 6, 4, 0, 'SE', 30, 7, 1, '2021-12-1', '2021-12-30'),
('444 4th St', 'katherine.cornish@gmail.com', 'Active', 'Apartment', 4, 1, 1, 'NE', 30, 8, 1, '2021-12-1', '2021-12-30'),
('555 5th St', 'katherine.cornish@gmail.com', 'Active', 'Apartment', 4, 2, 1, 'NW', 30, 9, 1, '2021-12-1', '2021-12-30');


create table Fees (
	FeeID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Fee double(4,2) NOT NULL,
    Period int NOT NULL
);

insert into Fees(Fee, Period)
values (50.00, 30);

create table Messages (
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Sender varchar(100),
    Receiver varchar(100),
    Content text(1000),
    Viewed int
);

insert into Messages(Sender, Receiver, Content, Viewed)
values ('vanessa.morgan@gmail.com', 'wanda.alsop@gmail.com', 'Can I see more pictures of the kitchen at 444 67th Ave?', 0),
('jonathan.alsop@gmail.com', 'wanda.alsop@gmail.com', 'When can we meet up to view the property at 444 67th Ave?', 0),
('brian.parsons@gmail.com', 'benjamin.greene@gmail.com', 'I would like a list of the appliances that are provided at 321 5th Ave.', 0),
('steven.ellison@gmail.com', 'joe.campbell@gmail.com', 'Are all the bathrooms in 222 2nd St full bathrooms?', 1),
('joe.campbell@gmail.com', 'steven.ellison@gmail.com', 'Yes, all the bathrooms in 222 2nd St are full bathrooms.', 0),
('david.rutherford@gmail.com', 'trevor.black@gmail.com', 'When was the las time the furnace at 123 1st St was replaced?', 0),
('david.rutherford@gmail.com', 'katherine.cornish@gmail.com', 'When can I view 123 1st St?', 0);

create table RenterSubscription (
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Renter varchar(100),
    Type varchar(20) NOT NULL,
    NoBedrooms int NOT NULL,
    NoBathrooms int NOT NULL,
    Furnished int NOT NULL,
    CityQuad varchar(2) NOT NULL
);

alter table RenterSubscription
add foreign key (Renter) references RegisteredRenter(Email);

insert into RenterSubscription (Renter, Type, NoBedrooms, NoBathrooms, Furnished, CityQuad)
values ('lillian.simpson@gmail.com', 'Apartment', 2, 1, 0, 'SE'),
('steven.ellison@gmail.com', 'Townhouse', 4, 2, 0, 'NW'),
('david.rutherford@gmail.com', 'Apartment', 1, 1, 1, 'SW'),
('lauren.howard@gmail.com', 'Detached House', 5, 3, 0, 'SW');


insert into Messages(Sender, Receiver, Content, Viewed)
values ("et.ipsum@yahoo.edu","lobortis.quam.a@hotmail.ca","natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla","0"),
  ("molestie.pharetra.nibh@protonmail.edu","iaculis.quis.pede@protonmail.edu","penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod","1"),
  ("proin.non@outlook.com","enim.non@yahoo.com","malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor. Quisque tincidunt pede","1"),
  ("congue.elit@hotmail.edu","tincidunt.neque@aol.com","sit amet massa. Quisque porttitor eros nec tellus. Nunc lectus pede, ultrices a, auctor non,","1"),
  ("congue.in@protonmail.net","curabitur.dictum.phasellus@protonmail.couk","a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis convallis dolor. Quisque tincidunt","1"),
("molestie.tellus@yahoo.com","cras.dictum@protonmail.org","Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl.","0"),
  ("cras.lorem.lorem@protonmail.couk","mollis.dui@aol.edu","elit, pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida","1"),
  ("ipsum@hotmail.couk","amet.risus@yahoo.edu","cursus, diam at pretium aliquet, metus urna convallis erat, eget tincidunt dui augue eu tellus.","0"),
  ("id@outlook.com","ac.sem@yahoo.org","lacus. Nulla tincidunt, neque vitae semper egestas, urna justo faucibus lectus, a sollicitudin orci sem","1"),
  ("rutrum.lorem@protonmail.org","turpis.nec.mauris@aol.edu","mauris sit amet lorem semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus. In mi","1"),
  ("diam.duis.mi@outlook.com","ante.ipsum@protonmail.couk","est. Nunc laoreet lectus quis massa. Mauris vestibulum, neque sed dictum eleifend, nunc risus varius","0"),
  ("aptent.taciti@icloud.edu","orci.ut@protonmail.ca","Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim, sit amet ornare lectus justo","0"),
  ("et.eros.proin@protonmail.edu","pellentesque.eget@icloud.net","elit fermentum risus, at fringilla purus mauris a nunc. In at pede. Cras vulputate velit","0"),
  ("mauris.blandit.enim@hotmail.couk","luctus.sit@outlook.edu","sem, consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut, pellentesque eget,","1"),
  ("malesuada.fames.ac@yahoo.net","penatibus.et.magnis@protonmail.couk","bibendum. Donec felis orci, adipiscing non, luctus sit amet, faucibus ut, nulla. Cras eu tellus","1"),
("tellus@hotmail.couk","varius.et@aol.com","est ac facilisis facilisis, magna tellus faucibus leo, in lobortis tellus justo sit amet nulla.","0"),
  ("ornare.egestas@icloud.ca","sapien.nunc@aol.couk","aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum eu, placerat","0"),
  ("a@yahoo.net","est@protonmail.ca","cursus. Nunc mauris elit, dictum eu, eleifend nec, malesuada ut, sem. Nulla interdum. Curabitur dictum.","0"),
  ("erat.neque.non@yahoo.net","praesent.eu@hotmail.couk","urna. Vivamus molestie dapibus ligula. Aliquam erat volutpat. Nulla dignissim. Maecenas ornare egestas ligula. Nullam","0"),
  ("malesuada.augue@protonmail.com","ultricies.ornare@hotmail.com","Donec nibh. Quisque nonummy ipsum non arcu. Vivamus sit amet risus. Donec egestas. Aliquam nec","0"),
  ("pellentesque@yahoo.net","suspendisse.non@icloud.org","Mauris ut quam vel sapien imperdiet ornare. In faucibus. Morbi vehicula. Pellentesque tincidunt tempus risus.","1"),
  ("augue@yahoo.net","elit.curabitur.sed@aol.couk","Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis","0"),
  ("accumsan.laoreet@google.ca","tincidunt.aliquam.arcu@aol.com","convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem","1"),
  ("ac.metus@aol.couk","sed@icloud.org","ligula tortor, dictum eu, placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer","1"),
  ("sit.amet.consectetuer@google.couk","consectetuer@yahoo.edu","torquent per conubia nostra, per inceptos hymenaeos. Mauris ut quam vel sapien imperdiet ornare. In","1"),
("magna.et@google.couk","mauris.rhoncus@google.couk","metus. In lorem. Donec elementum, lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor","1"),
  ("eget.laoreet@yahoo.edu","viverra@outlook.ca","posuere cubilia Curae Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus.","0"),
  ("mi.pede.nonummy@protonmail.org","nascetur@icloud.ca","tellus. Nunc lectus pede, ultrices a, auctor non, feugiat nec, diam. Duis mi enim, condimentum","1"),
  ("et.rutrum.eu@aol.couk","tellus.aenean.egestas@yahoo.couk","feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet","1"),
  ("elementum.sem@google.edu","ut@google.com","pulvinar arcu et pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam","1"),
  ("consectetuer.rhoncus@hotmail.edu","tortor.nunc.commodo@outlook.couk","iaculis nec, eleifend non, dapibus rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin","1"),
  ("proin@yahoo.org","proin@aol.couk","ac, feugiat non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac,","0"),
  ("fermentum.metus@outlook.ca","porttitor@icloud.org","adipiscing non, luctus sit amet, faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum.","0"),
  ("velit.cras@aol.ca","vel.convallis@yahoo.org","tincidunt pede ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum.","0"),
  ("nisl.elementum@protonmail.ca","vitae.erat.vivamus@google.net","gravida nunc sed pede. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus","1"),
("pede.et@outlook.ca","eu.eleifend@icloud.edu","sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna","0"),
  ("urna.et.arcu@icloud.net","commodo@yahoo.org","scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia. Sed congue, elit sed consequat auctor,","1"),
  ("consequat.purus@icloud.com","et.euismod@yahoo.edu","faucibus leo, in lobortis tellus justo sit amet nulla. Donec non justo. Proin non massa","0"),
  ("dolor.sit.amet@aol.ca","tempus@google.ca","elit, dictum eu, eleifend nec, malesuada ut, sem. Nulla interdum. Curabitur dictum. Phasellus in felis.","0"),
  ("aenean@google.net","fusce.aliquam@yahoo.net","sit amet ornare lectus justo eu arcu. Morbi sit amet massa. Quisque porttitor eros nec","0"),
  ("scelerisque.scelerisque@google.net","integer@hotmail.org","posuere cubilia Curae Phasellus ornare. Fusce mollis. Duis sit amet diam eu dolor egestas rhoncus.","1"),
  ("tellus.lorem@yahoo.net","tincidunt@hotmail.ca","Duis elementum, dui quis accumsan convallis, ante lectus convallis est, vitae sodales nisi magna sed","1"),
  ("amet.faucibus@outlook.ca","quisque@outlook.couk","egestas ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas","1"),
  ("parturient@icloud.com","ac@yahoo.net","Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed dictum. Proin","0"),
  ("aliquet.odio@google.org","pellentesque.a@outlook.edu","Nam interdum enim non nisi. Aenean eget metus. In nec orci. Donec nibh. Quisque nonummy","0");