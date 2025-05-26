# Junior Software Engineer – Backend

## Stack
A program elkészítéséhez JavaSDK 21-et használtam és a REST API-t a SpringBoot keretrendszerrel valósítottam meg.

## Arhitektúra
A programhoz MVC arhitektúrát valósít meg. MVC arhitektúra megfelelően illeszkedik a REST API-hoz mert a, 
kéréseket ki lehet szervezni a Controller-be, míg a program belső működését, üzleti logikát a Model-be. Ezzel azt elérve,
hogy a program könnyen átlátható és bővíthető lesz. Jelen esetben a View-ra nincs szükség, mert a program nem nyújt felületet
a felhasználóknak.

## Osztályok
### Osztálydiagram
<img src="ClassDiagram.svg" alt="ClassDiagram" width="auto" height="auto">
(Megjegyzés: A fehérrombusz, az a kompozíció és a fekete pedig az aggregáció. Sötétmódban exportáltam ki,
emiatt az aggregáció és a kompozíció színei invertálódtak.) 

### Osztály leírások
### - Model
#### VehicleBase
VehicleBase absztrakt osztály felelőssége hogy a járművekhez tartozó közös tulajdonságokat és működéseket összefoglalja.<br>
Konstruktorában beállítja az összes attribútumát. Továbbá kiszámolja a jármű újratankolási költségét a paraméterben kapott távolság alapján.

#### GasolineVehicle
A GasolineVehicle leszármazik a VehicleBase ősosztályból. A konstruktorában a kapott paraméterekkel beállítja az ősének
megfelelő paramétereit és az ős maradék kettő attribútumát beleégetve beállítja a GasolineVehicle-re jellemző értékekkel.
#### HybridVehicle
A HybridVehicle leszármazik a VehicleBase ősosztályból. A konstruktorában a kapott paraméterekkel beállítja az ősének
megfelelő paramétereit és az ős maradék kettő attribútumát beleégetve beállítja a HybridVehicle-re jellemző értékekkel.
Felülírja az ősosztály azon függvényét, ami kiszámolja az újratankolási költéségét, mert a hibrid járművek több hajtással rendelkeznek.
#### ElectricVehicle
A ElectricVehicle leszármazik a VehicleBase ősosztályból. A konstruktorában a kapott paraméterekkel beállítja az ősének
megfelelő paramétereit és az ős maradék kettő attribútumát beleégetve beállítja a ElectricVehicle-re jellemző értékekkel.

#### Fleet
A Fleet osztály, egy wrapper a járművek tárolására. Átláthatóság miatt szerveztem ki a járművek tárolását, 
ezen felül, azért hogyha később bővíteni szeretnénk új üzleti logikával, akkor azt könnyen megtehetjük.

#### Trip
Trip felelőssége, hogy az adott utazáshoz tartozó adatokat összefogja. A konstruktorában beállítja az attribútumait, és
a távolság alapján eldönti hogy az utazás csak városban, vagy városon kívül is lesz.
Ezen felül kiszámolja az utazás időtartamát.

#### Dispatcher
A Dispatcher felelőssége, hogy kilistázza az adott utazáshoz megfelelő járműveket és kiszámolja a profitot hozzájuk.

#### VehicleSuggestion (record)
VehicleSuggestion egy adatszerkezetbe szervezi a járműveket és a hozzájuk tartozó profitot.

### - Controller

#### DispatcherController
A DispatcherController valósítsa meg a REST API-t. Ez az osztály, kezeli az adott utazáshoz kért javaslatokat.

## Tervezési döntések
- Ha egy utazás 50km alatt van, akkor az csak városban közlekedik, és ha a távolság nagyobb mint 50km,
akkor az 50km feletti távolság, az városon kívül lesz.
- Az elektromos járművekre nem volt megadva, a fogyasztása, ezért az elektromos járműveket,
lekorlátoztam, hogy csak városon belül közlekedhetnek és a fogyasztása megegyezik a gázolajjal hajtott járművével.
- Hibrid jármű rendelkezik gázolaj és elektromos hajtással is, ezért annak az újratankolási költsége egységenként a kettő összege
- A Template Method tervezési mintát alkalmaztam a járműveknél.
  Azért választotam ezt a tervezési mintát, mert így a SOLID alapelvek közül, nem sérül, a
  "Don't Repeat Yourself" és az "Open/Closed" elvek. Így olyan kódot eredményezve, amely könnyen bővíthető és átlátható.

## Teszt
A flotta tartalmaz egy PostContruct annótációval rendelkező init() függvényt, ami feltölti a flottát, három példa járművel, ami az alkalmazás indulásakor fog lefutni.

### Példa lekérdezés:
<code>
POST http://localhost:8080/suggestions<br>
Content-Type: application/json<br>
{<br>
"distance": 20,<br>
"passengerCount": 1<br>
}<br>
</code>
A fenti lekérdezésre a szerver visszaadja a flottában lévő, az adott utazásra alkalmas járműveket és a hozzájuk tartozó profitot.