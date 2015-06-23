Object Oriented Programming

Part 1

Zadatak 1 Napraviti klasu Computer, koja je abstract. Klasa sadr�i ime i MAC adresu raeunara. Pored toga, napraviti i dva konstruktora, kao i dvije get metode. MAC adresa je objekat koju opisuje unutra�nja nestatiena klasa MACAddress. Objekat tog tipa treba sadr�avati niz karaktera adrese, ali bez ':'. Klasa treba imati toString metodu i konstruktor. Napraviti i equals i toString metode za Computer klasu.

Zadatak 2 Napisati klasu Network, koja je abstract. Network klasa sadr�i atribut imena mre�e, kao i spisak raeunara koji su u toj mre�i (niz raeunara). Klasa sadr�i konstruktor koji inicijalizira broj raeunara niza na 0, kao i metodu addComputer(Computer c) i removeComputer(Computer c), koje su abstract.

Zadatak 3 Napisati Server klasu koja sadr�i broj koji oznaeava koliko maksimalno drugih raeunara mo�e podnijeti a da ne do�ivi krah. Napraviti i jednu get metodu za taj limit. Napisati dodatni konstruktor koji inicijalizira ime, MAC adresu i spomenuti limit servera. Napraviti i equals i toString metode.

Zadatak 4 Napraviti interface Connectable koji sadr�i metode connect(Computer), connect(Network) i disconnect(). Client klasa sadr�i atribut tipa Computer koji oznaeava sa kojim je raeunarom dati klijent spojen. Pored toga, ima jo� jedan sliean atribut koji je tipa Network koji oznaeava sa kojom je mre�om klijent spojen. Konstruktor klijenta treba imati samo ime i MAC adresu. Klasa implementira Connectable interface. Metoda connect treba da postavi link na dati raeunar, odnosno na datu mre�u. Ukoliko link vea postoji onda baciti exception. Metoda disconnect postavlja oba linka na null. Napisati i get metodu za te link metode. Napraviti i equals i toString metode. Napomena: Client se nikada ne mo�e spojiti na drugu mre�u/raeunar ako mu oba atributa nisu null!

Zadatak 5 Napraviti demonstraciju svih klasa i metoda iz prija�nja eetiri zadatka. Napisati javadoc za sve metode (nije potrebno za equals i toString metode).

Part 2

Zadatak 1 Napraviti interface Functionable koji ima metodu boolean isFunctioning().

Zadatak 2 Napraviti klasu ArrayManipulation koja sadr�i static metodu extendArray(Computer[]) koja pro�iri dati niz za jedan index/element. Novi element treba biti null. Pored toga, tu se nalazi i metoda shrinkArray(Computer[], int) koja smanji dati niz za jedan tako �to �obri�e� dati index.

Zadatak 3 Napraviti klasu BusNetwork koja naslje?uje Network klasu i implementira Functionable interface. Metoda addComputer radi na principu tako �to pro�iri prvo niz raeunara za jedan, zatim stavi dati raeunar na to mjesto i povezuje raeunar preko njegove connect metode sa ovom mre�om. Metoda removeComputer radi na principu tako �to prvo prona?e dati raeunar (ako ga nema baciti exception) i obri�e ga (smanji niz). Pored toga, raeunar prekida svoju vizu sa mre�om preko svoje disconnect metode. Metoda isFunctioning treba vratiti true ukoliko ima barem dva raeunara spojena na mre�i (da nisu null). toString metoda treba imati broj raeunara u sebi, kao i dio koji govori da li mre�a funkcioni�e ili ne.

Zadatak 4 Napraviti klasu StarNetwork koja naslje?uje Network klasu i implementira Functionable interface. Klasa sadr�i jedan Server. Metoda addComputer radi na principu tako �to pro�iri prvo niz raeunara za jedan, zatim stavi raeunar na to mjesto. Pored toga, dati raeunar se povezuje preko connect metode sa serverom preko svoje connect metode. Metoda removeComputer radi na principu tako �to prvo prona?e dati raeunar (ako ga nema baciti exception) i obri�e ga (smanji niz). Pored toga, dati raeunar prekida link sa serverom preko svoje disconnect metode. Metoda isFunctioning treba vratiti true ukoliko server radi. Server pada ukoliko ima vi�e povezanih raeunara nego �to mo�e podnijeti. toString metoda treba imati broj spojenih raeunara na server u sebi, kao i dio koji govori da li mre�a funkcioni�e ili ne.

Zadatak 5 Napisati javadoc za sve metode osim toString i equals metode. Napisati demonstraciju svih metoda!