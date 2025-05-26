# Junior Software Engineer – Backend

## Stack
A program elkészítéséhez JavaSDK 21-et használtam és a REST API-t a SpringBoot keretrendszert használtam.

## Arhitektúra
A programhoz MVC arhitektúrát valósít meg. MVC arhitektúra megfelelően illeszkedik a feladathoz, mert a REST API-hoz
szükséges feladatokat ki lehet szervezni a Controller-be, míg a program belső működését, üzleti logikát a Model-be. Ezzel azt elérve,
hogy a program könnyen átlátható és bővíthető lesz. Jelen esetben a View-ra nincs szükség, mert a program nem nyújt felületet
a felhasználóknak.

## Osztályok
### Osztálydiagram
<img src="ClassDiagram.svg" alt="ClassDiagram" width="auto" height="auto">
(Megjegyzés: A fehérgyémánt, az a kompozíció és a fekete pedig az aggregáció. Sötétmódban konvertáltam ki,
emiatt az aggregáció és a kompozíció színei invertálódtak.) 

### Osztály leírások
### - Model
#### VehicleBase
VehicleBase absztrakt osztály felelőssége hogy a járművekhez tartozó közös tulajdonságokat és működéseket összefoglalja.<br>
Konstruktorában beállítja az összes attribútumát. Továbbá kiszámolja a jármű újratankolási költségét.
A Template Method tervezési mintát alkalmazom.<br>
Azért választotam ezt a tervezési mintát, mert így a SOLID alapelvek közül, nem sérül, a
"Don't Repeat Yourself" és az "Open/Closed" elvek. Így olyan kódot eredményezve, amely könnyen bővíthető és átlátható.<br>
#### GasolineVehicle
A GasolineVehicle leszármazik a VehicleBase ősosztályból. A konstruktorában a kapott paraméterekkel beállítja az ősének
megfelelő paramétereit és az ős maradék kettő attribútumát beleégetve beállítja a GasolineVehicle-re jellemző értékekkel.
#### HybridVehicle
A HybridVehicle leszármazik a VehicleBase ősosztályból. A konstruktorában a kapott paraméterekkel beállítja az ősének
megfelelő paramétereit és az ős maradék kettő attribútumát beleégetve beállítja a HybridVehicle-re jellemző értékekkel.
#### ElectricVehicle
A ElectricVehicle leszármazik a VehicleBase ősosztályból. A konstruktorában a kapott paraméterekkel beállítja az ősének
megfelelő paramétereit és az ős maradék kettő attribútumát beleégetve beállítja a ElectricVehicle-re jellemző értékekkel.

#### Fleet
A Fleet osztály, egy wrapper a VehicleBase-ek tárolására. Átláthatóság miatt szerveztem ki a VehicleBase-k tárolását, 
ezen felül, azért hogyha később plusz üzleti logikát szeretnénk a Fleet-be akkor azt könnyen megtehetjük.

#### Trip
Trip felelőssége, hogy az adott utazáshoz tartozó adatokat összefogja. A konstruktorában beállítja az attribútumait, és
a távolság alapján eldönti hogy az utazás csak városban, vagy azon kívül is lesz.
Ezen felül kiszámolja az utazás időtartamát.

#### Dispatcher
A Dispatcher felelőssége, hogy kilistázza az adott utazáshoz megfelelő járműveket és kiszámolja a profitot hozzájuk.

#### VehicleSuggestion (record)
VehicleSuggestion egy adatszerkezetbe szervezi a járműveket és a hozzájuk tartozó profitot.

### - Controller

#### DispatcherController
A DispatcherController valósítsa meg a REST API-t. Ez az osztály, kezeli az adott Triphez kért javaslatot.

## Tervezési döntések
- Ha egy utazás 50km alatt van, akkor az csak városban közlekedik, és ha a távolság nagyobb mint 50km,
akkor az 50km feletti távolság, az városon kívül lesz.
- Az elektromos járművekre nem volt megadva, hogy városon kívül a fogyasztása, ezért az elektromos járműveket,
lekorlátoztam, hogy csak városon belül közlekedhetnek.
- Hibrid jármű rendelkezik gázolaj és elektromos hajtással is, ezért annak az újratankolási költsége 2+1