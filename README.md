TestWatcher
====================
// Neplatí ak sa použije SELENIDE miesto SELENIA
Prepisuje pôvodnú JUnit triedu TestWatcher, aby bolo možné
zachytiť udalosť failed() a finished()


Driver
====================
Selenide má vlastnú implementáciu drivera. 
Driver verzia sa dynamicky nastaví sáma podľa nainštalovaného brovsera.


Browser konfigurácia
====================
Nastavenia browsera je v triede BaseTest


Konfigurácia
====================
Configuration.remote = "http://127.0.0.1:4444/wd/hub";
Configuration.baseUrl = "https://tatrytec.eu";
Configuration.assertionMode = AssertionMode.SOFT;
Configuration.startMaximized = true;
Configuration.headless = true;
Configuration.assertionMode = AssertionMode.SOFT;  // Toto sa väčšinou nastavuje pre každú triedu osobintne.

