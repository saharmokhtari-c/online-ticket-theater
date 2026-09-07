
Insert into teatri(cod_Teatro,nome,indirizzo,citta,provincia,telefono,posti)
Values
('T001','Teatro Agorà','Via della Penitenza','ROMA','RM','06 6874167',265),
('T002','Teatro Argentina','Largo di Torrpostie Argentina, 52 ','ROMA','RM','06 6840 00314',405),
('T003','Teatro Ambra Jovinelli','Via Guglielmo Pepe 43','ROMA','RM','06 83082884',392);
Insert into clienti(cognome,nome,telefono,email)
Values
('ROSSI','GIADA','06/4328346','rossi@gmail.com'),
('BELLINELLU','SAMANTHA','06/79876658','bellinellu@yahho.it'),
('CORIZIO','CARLO','06/76547648','corizio@libero.it'),
('FRANCINI','CASSANDRA','06/76586548','francini@gmail.com'),
('MARTORANO','MARCO','06/543326565','martorano@yahho.it'),
('FIORULLO','ERIKA','06/98765762','fiorullo@hotmail.it'),
('GRASSO','IVAN','06/5483678','grasso@yahoo.it'),
('BERTUTTI','FABRIZIO','06/5367548','bertutti@gmail.com'),
('CERTORINI','GIANNA','06/53645872','certorini@libero.it'),
('RADERI','ANTONIO','06/78363459','raderi@yahoo.it'),
('PAGLINO','ALESSIO','06/67598721','paglino@tiscali.it'),
('RORESTI','VERONICA','06/3678465','roresti@tiscali.it'),
('VIONETTI','ARRIGO','06/34254367','vionetti@gmail.com'),
('SARTIRO','SIMONE','06/845673865','sartiro@yahoo.it');

Insert into spettacoli(cod_Spettacolo,titolo,autore,regista,prezzo,teatro_cod_teatro)
Values 
('S001','Cats','Andrew Lloyd Webber','Trevor Nunn',50.00,'T001'),
('S002','Titanic','Peter Stone','Maury Yeston',50.00,'T001'),
('S003','Peter Pan','Mark "Moose"','Charlap	Jerome Robbins','65.00','T002'),
('S004','Oliver!','Charles Dickens','Susan Stroman','65.00','T002'),
('S005','Anastasia','Terrence McNally','Darko Tresnjak','30.00','T003'),
('S006','Colazione da Tiffany','Truman Capote','Joseph Anthony','30.00','T003');


Insert into repliche(codreplica,spettacolo_cod_spettacolo,data_Replica)
Values
('R001','S001','5-ott-18'),
('R002','S001','6-ott-18'),
('R003','S001','7-ott-18'),
('R004','S001','8-ott-18'),
('R005','S001','9-ott-18'),
('R006','S002','12-nov-18'),
('R007','S002','13-nov-18'),
('R008','S002','14-nov-18'),
('R009','S002','15-nov-18'),
('R010','S002','16-nov-18'),
('R011','S003','5-gen-19'),
('R012','S003','6-gen-19'),
('R013','S003','7-gen-19'),
('R014','S003','8-gen-19'),
('R015','S003','9-gen-19'),
('R016','S004','12-gen-19'),
('R017','S004','13-gen-19'),
('R018','S004','14-gen-19'),
('R019','S004','15-gen-19'),
('R020','S004','16-gen-19'),
('R021','S005','5-nov-18'),
('R022','S005','6-nov-18'),
('R023','S005','7-nov-18'),
('R024','S005','18-nov-18'),
('R025','S005','19-nov-18'),
('R026','S006','12-dic-18'),
('R027','S006','13-dic-18'),
('R028','S006','14-dic-18'),
('R029','S006','15-dic-18'),
('R030','S006','16-dic-18');
