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
resources/application.conf - je to implenentácia knižnice lightbend/config

Configuration.remote = "http://127.0.0.1:4444/wd/hub";
Configuration.baseUrl = "https://tatrytec.eu";
Configuration.startMaximized = true;
Configuration.headless = true;
// SOFT assert sa väčšinou nastavuje pre každú triedu osobintne. https://github.com/lightbend/config
Configuration.assertionMode = AssertionMode.SOFT;  

POM.XML
=====================
- Pri volaní z Jenkinsu sa nastavujú premenné
    <category></category> - koli profilom(ketegóriám) testov
    <BUILD_URL>${BUILD_URL}</BUILD_URL> - kôli linkom na Selenide screenshot
