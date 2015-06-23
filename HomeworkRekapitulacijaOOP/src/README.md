Object Oriented Programming

Part 1

Zadatak 1 Napraviti klasu Computer, koja je abstract. Klasa sadrži ime i MAC adresu raeunara. Pored toga, napraviti i dva konstruktora, kao i dvije get metode. MAC adresa je objekat koju opisuje unutrašnja nestatiena klasa MACAddress. Objekat tog tipa treba sadržavati niz karaktera adrese, ali bez ':'. Klasa treba imati toString metodu i konstruktor. Napraviti i equals i toString metode za Computer klasu.

Zadatak 2 Napisati klasu Network, koja je abstract. Network klasa sadrži atribut imena mreže, kao i spisak raeunara koji su u toj mreži (niz raeunara). Klasa sadrži konstruktor koji inicijalizira broj raeunara niza na 0, kao i metodu addComputer(Computer c) i removeComputer(Computer c), koje su abstract.

Zadatak 3 Napisati Server klasu koja sadrži broj koji oznaeava koliko maksimalno drugih raeunara može podnijeti a da ne doživi krah. Napraviti i jednu get metodu za taj limit. Napisati dodatni konstruktor koji inicijalizira ime, MAC adresu i spomenuti limit servera. Napraviti i equals i toString metode.

Zadatak 4 Napraviti interface Connectable koji sadrži metode connect(Computer), connect(Network) i disconnect(). Client klasa sadrži atribut tipa Computer koji oznaeava sa kojim je raeunarom dati klijent spojen. Pored toga, ima još jedan sliean atribut koji je tipa Network koji oznaeava sa kojom je mrežom klijent spojen. Konstruktor klijenta treba imati samo ime i MAC adresu. Klasa implementira Connectable interface. Metoda connect treba da postavi link na dati raeunar, odnosno na datu mrežu. Ukoliko link vea postoji onda baciti exception. Metoda disconnect postavlja oba linka na null. Napisati i get metodu za te link metode. Napraviti i equals i toString metode. Napomena: Client se nikada ne može spojiti na drugu mrežu/raeunar ako mu oba atributa nisu null!

Zadatak 5 Napraviti demonstraciju svih klasa i metoda iz prijašnja eetiri zadatka. Napisati javadoc za sve metode (nije potrebno za equals i toString metode).

Part 2

Zadatak 1 Napraviti interface Functionable koji ima metodu boolean isFunctioning().

Zadatak 2 Napraviti klasu ArrayManipulation koja sadrži static metodu extendArray(Computer[]) koja proširi dati niz za jedan index/element. Novi element treba biti null. Pored toga, tu se nalazi i metoda shrinkArray(Computer[], int) koja smanji dati niz za jedan tako što „obriše“ dati index.

Zadatak 3 Napraviti klasu BusNetwork koja naslje?uje Network klasu i implementira Functionable interface. Metoda addComputer radi na principu tako što proširi prvo niz raeunara za jedan, zatim stavi dati raeunar na to mjesto i povezuje raeunar preko njegove connect metode sa ovom mrežom. Metoda removeComputer radi na principu tako što prvo prona?e dati raeunar (ako ga nema baciti exception) i obriše ga (smanji niz). Pored toga, raeunar prekida svoju vizu sa mrežom preko svoje disconnect metode. Metoda isFunctioning treba vratiti true ukoliko ima barem dva raeunara spojena na mreži (da nisu null). toString metoda treba imati broj raeunara u sebi, kao i dio koji govori da li mreža funkcioniše ili ne.

Zadatak 4 Napraviti klasu StarNetwork koja naslje?uje Network klasu i implementira Functionable interface. Klasa sadrži jedan Server. Metoda addComputer radi na principu tako što proširi prvo niz raeunara za jedan, zatim stavi raeunar na to mjesto. Pored toga, dati raeunar se povezuje preko connect metode sa serverom preko svoje connect metode. Metoda removeComputer radi na principu tako što prvo prona?e dati raeunar (ako ga nema baciti exception) i obriše ga (smanji niz). Pored toga, dati raeunar prekida link sa serverom preko svoje disconnect metode. Metoda isFunctioning treba vratiti true ukoliko server radi. Server pada ukoliko ima više povezanih raeunara nego što može podnijeti. toString metoda treba imati broj spojenih raeunara na server u sebi, kao i dio koji govori da li mreža funkcioniše ili ne.

Zadatak 5 Napisati javadoc za sve metode osim toString i equals metode. Napisati demonstraciju svih metoda!