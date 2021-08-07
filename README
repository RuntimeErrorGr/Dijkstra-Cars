Lăbău Cristea Andrei Liviu 324CB

	In implementarea temei am grupat clasele in 2 pachete in functie de scop:

		1) "Cars" contine clasele referitoare la obiectele ce pot fi conduse:

			1.1) Vehicul - clasa abstracta ce ajuta la gruparea obiectelor de 
			tip vehicul. Atributele clasei au modificatorul de acces "private"
			pentru a nu putea fi modificate din afara clasei (costul
			si limita de gabarit al oricarui vehicul sunt initializate la 
			instantiere si nu mai sunt modificate pe parcursul programului).
			Constructorii au modificatorul de acces "protected" deoarece clasa
			Vehicul este abstracta si nu trebuie instantiata. Constructorii sunt 
		 	apelati numai in clasele derivate Mopped, Autovehicul si Autoutilitar.

		 		1.1.1) Mopped - clasa abstracta, extinde clasa Vehicul. Ajuta la
		 	gruparea obiectelor cu acelasi gabarit (gabaritul unui mopped este
		 	intotdeauna 1, dar costul este nedefinit). Constructorul are  
		 	modificatorul de acces "protected" deoarece clasa Mopped este 
		 	abstracta si nu trebuie instantiata. Constructorul este apelat 
		 	numai in clasele derivate Bicicleta si Motocicleta.

		 		1.1.1.1) Bicicleta - clasa instantiata la intalnirea comenzii
		 		drive cu primul parametru "b". Mosteneste clasa Mopped pentru
		 		ca gabaritul unei biciclete este intotdeauna 1. Constructorul
		 		are modificatorul de acces public, invoca constructorul 
		 		clasei parinte si actualizeaza costul bicicletei la 1.

		 		1.1.1.2) Motocicleta - clasa instantiata la intalnirea 
		 		comenzii drive cu primul parametru "m". Mosteneste clasa Mopped 
		 		pentru ca gabaritul unei motociclete este intotdeauna 1.
		 		Constructorul are modificatorul de acces public, invoca
		 		constructorul clasei parinte si actualizeaza costul 
		 		motocicletei la 2.

		 		1.1.2) Autovehicul - clasa abstracta, extinde clasa Vehicul.
		 	Ajuta la gruparea obiectelor cu acelasi gabarit (gabaritul unui 
		 	autovehicul este intotdeauna 2, dar costul este nedefinit). 
		 	Constructorul are modificatorul de acces "protected" deoarece clasa 
		 	Autovehicul este abstracta si nu trebuie instantiata. Constructorul
		 	este apelat numai in clasa derivata Autoturism.

		 		1.1.2.1) Autoturism - clasa instantiata la intalnirea comenzii 
		 		drive cu primul parametru "a". Mosteneste clasa Autovehicul 
		 		pentru ca gabaritul unei autoturism este intotdeauna 2.
		 		Constructorul are modificatorul de acces public, invoca
		 		constructorul clasei parinte si actualizeaza costul 
		 		autoturismului la 4.

		 		1.1.3) Autoutilitar - clasa abstracta, extinde clasa Vehicul.
		 	Ajuta la gruparea obiectelor cu acelasi gabarit (gabaritul unui
		 	autoutilitar este intotdeauna 3, dar costul este nedefinit). 
		 	Constructorul are modificatorul de acces "protected" deoarece 
		 	clasa Autoutilitar este abstracta si nu trebuie instantiata. 
		 	Constructorul este apelat numai in clasa derivata Camion.

		 		1.1.3.1) Camion - clasa instantiata la intalnirea comenzii drive 
		 		cu primul parametru "c". Mosteneste clasa Autoutilitar pentru ca 
		 		gabaritul unui camion este intotdeauna 3. Constructorul are 
		 		modificatorul de acces public, invoca constructorul clasei 
		 		parinte si actualizeaza costul camionului la 6.

		2) "Map" contine clasele referitoare la graful propriu-zis, componentele
		acestuia (strazile) si restrictii:

			2.1) Harta - clasa este instantiata o singura data (harta este unica
			in program) in functia main. Aceasta contine metodele de citire/
			scriere in fisier si executie a comenzilor citite.
			Majoritatea metodelor si atributelor clasei Harta au modificatorul
			de acces private deoarece acestea au exclusiv functionalitate
			interna in clasa (cu exceptia metodelor de get si set pentru atribute,
			constructorilor si a metodei executeCommands care trebuie apelata in main).
			La intrarea in fuctia main este creat un obiect de tip Harta. Prin
			intermediul constructorului ce primeste ca parametru un obiect de 
			tip Scanner este citit graful din fisierul "map.in" si stocat sub
			forma de lista de adiacenta: numarul de strazi (muchii), numarul de 
			noduri si apoi sunt citite si adaugate in lista de adiacenta atatea
			obiecte de tip strada cat indica numarul de strazi. Deci rolul
			metodei addStreet a acestei clase este de a crea un obiect de tip 
			strada pe baza randului curent citit din fisierul de intrare si de 
			a-l adauga (pe baza numelui nodului de start) in lista de adiacenta la 
			pozitia corespunzatoare. 
			Dupa ce graful a fost generat sunt citite si executate mai departe 
			comenzile din fisierul "map.in" si se pot intalni 2 cazuri:

				2.1.1) Este intalnita o comanda "trafic"/"blocaj"/"accident":
				In acest caz trebuie stiut faptul ca fiecare obiect de tip
				Strada din graf are o lista de obiecte de tip ambuteiaj (lista
				de restrictii). Aceasta lista poate fi vida sau nu la intalnirea
				unei comenzi "drive."
				La intalnirea "trafic"/"blocaj"/"accident", metoda addRestriction
				creeaza un ambuteiaj de tipul Trafic, Blocaj sau Ambuteiaj.
				In functie de numele nodului de start si numele nodului de stop
				este adaugat in lista de ambuteiaje a obiectului de tip Strada
				corespunzator din lista de adiacenta.

				2.1.2) Este intalnita o comanda "drive": in acest caz este 
				apelata metoda dijkstra ce aplica algoritmul Dijkstra asupra
				grafului in felul urmator: 
					- se pleaca de la nodul de start (al carui nume este dat
					ca parametru comenzii drive)
					- distantele minime de la nodul de start la toate celelalte
					noduri din graf vor fi retinute intr-un vector. Initial
					se considera ca distanta intre nodul de start si celelalte
					noduri este foarte mare (initializata cu valoarea maxima 
					a unui signed int).
					- nodul este adaugat intr-o coada de prioritati 
					- cat timp coada de prioritati nu este goala, este extras
					primul nod din coada si se itereaza prin toti vecinii lui
					- se verifica daca pentru vecinul curent este indeplinita
					restrictia de gabarit
					- daca da, este parcursa lista de restrictii a vecinului 
					curent si este calculat costul suplimentar generat de 
					restrictii sale
					- costul trecerii prin vecinul curent este calculat
					pe baza formulei cost_vehicul * cost_strada + cost_ambuteiaje
					- costul final este calculat ca suma intre costul initial
					din vector + costul calculat cu formula de mai sus
					- daca acest cost este mai bun decat cel anterior, vecinul
					curent este scos din coada, vectorul de costuri este 
					actualizat si nodul este reintrodus
					- procedeul se repeta pana cand nu mai este posibil sa se 
					gaseasca un cost mai mic decat cel deja existent in vectorul
					de costuri
					- de asemenea, pentru afisarea caii de cost minim intre
					punctele start si stop primite ca argumente ale comenzii drive
					metoda returneaza un vector ce pastreaza pe fiecare pozitie 
					numele nodului de stop precedent. Punctul de start are 
					intotdeauna precedentul null.
				Rezultatele comenzii drive sunt afisate in fisierul de iesire:
				daca s-a gasit un drum de cost minim este afisat drumul si costul
				respectiv, daca nu sunt afisate punctele de start si stop si
				null.

			2.2) Strada - graful este format practic din obiecte de tip Strada.
			Fiecare strada este identificata in mod unic de numele acesteia 
			(nume nod start + nume nod stop).
			In cadrul acestei clase este implementata functia compare din 
			interfata Comparator, necesara pentru implementarea algoritmului
			Dijkstra cu o coada de prioritati java.util.priorityqueue. 

			2.3) Ambuteiaj - clasa abstracta. Ajuta la gruparea obiectelor de 
			tip ambuteiaj (acestea se comporta practic la fel, singura diferenta
			intre ele fiind tipul (trafic/blocaj/accident)). Constructorul are  
		 	modificatorul de acces "protected" deoarece clasa Ambuteiaj este 
		 	abstracta si nu trebuie instantiata.

				2.3.1) Trafic -  clasa instantiata la intalnirea comenzii 
				addRestriction cu primul parametru "trafic".

				2.3.2) Blocaj - clasa instantiata la intalnirea comenzii
				addRestriction cu primul parametru "blocaj".

				2.3.3) Accident - clasa instantiata la intalnirea comenzii 
				addRestriction cu primul parametru "accident".

	Am utilizat conceptul de mostenire prin crearea unor superclase si a claselor
	derivate acolo unde a fost posibil (Vehicul cu Mopped, Autovehicul, Autoutili
	tar, Ambuteiaj cu Trafic, Blocaj, Accident) pe baza unor caracteristici
	comune (limita de viteza, limita de gabarit).
	Am utilizat conceptul de abstractizare prin crearea claselor abstracte cu
	scopul de a nu putea fi instantiate. Intotdeauna trebuie sa se lucreze cu 
	obiecte ale claselor lor derivate.
	Am utilizat conceptul de polimorfism ghidandu-ma dupa definita din Laborator
	2: "Polimorfismul se referă la faptul că un obiect din clasa derivată poate 
	fi folosita ca parametru al unei metode ce primește la definire un obiect al 
	clasei de bază.". Astfel metoda "drive" a clasei Harta asteapta ca parametru
	un obiect de tip Vehicul, dar este intotdeauna apelata cu obiecte de tip
	Bicicleta, Motocicleta, Autoturism sau Camion (clase care extind clasele
	Mopped, Autovehicul si Autoutilitar, care la randul lor extind clasa Vehicul). 
