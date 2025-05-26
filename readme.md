# Junior Software Engineer – Backend

## Stack
A program elkészítéséhez JavaSDK 21-et használtam és a REST API-t a SprintBoot keretrendszert használtam.

## Arhitektúra
A programhoz MVC arhitektúrát használtam. MVC arhitektúra megfelelően illeszkedik a feladathoz, mert a REST API-hoz
szükséges feladatokat ki lehet szervezni a Controller-be, míg a program belső működését, üzleti logikát a Model-be. Ezzel azt elérve,
hogy a program könnyen átlátható és bővíthető lesz. Jelen esetben a View-ra nincs szükség, mert a program nem nyújt felületet
a felhasználóknak.

## Osztályok
### Osztálydiagram
<img src="ClassDiagram.svg" alt="ClassDiagram" width="auto" height="auto">

### Osztály leírások
### - Model
#### VehicleBase
VehicleBase absztrakt osztály felelőssége hogy a járművekhez tartozó közös tulajdonságokat és működéseket összefoglalja.
Ez Template Method tervezési minta.<br>
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
A DispatcherController valósítsa meg a REST API-t. A Fleet-hez hozzá lehet adni új járműveket, és
le lehet kérni a megadott Trip-hez megfelelő járműveket.

#### VehicleRequest (record)
VehicleRequest egy adatszerekezetbe szervezi,