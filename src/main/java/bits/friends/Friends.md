# Wspólni znajomi (Friends)

Limit pamięci: **256MB**  
Limit czasu: **10s C++ / 10s Java**

Bajtazar jest ciekawy, jak wygląda sieć znajomości między jego współpracownikami z firmy Bajtung. Jest to małe przedsiębiorstwo, zatem zgodnie z Bajtockim prawem zatrudnia 64 osoby.

Udało mu się zebrać już informacje o znajomościach. 
Teraz bada temat wspólnych znajomych. Bardzo pomógłby mu w tym program, który dla zadanej pary osób powie, czy mają wspólnych znajomych.

Zaimplementuj dwie funkcje:
```java
void addFriend(int a, int b);
boolean haveCommonFriend(int a, int b);
```

Funkcja `addFriend` dodaje znajomość między pracownikami `a` i `b`. Oczywiście jest to symetryczna relacja.
Funkcja `haveCommonFriend` zwraca `true`, jeśli `a` i `b` mają przynajmniej jednego wspólnego znajomego.

W obu funkcjach argumenty `a` i `b` to id pracowników, będące liczbami z zakresu 0-63.


Przykład:
![image](graf.png)  
```
addFriend(1, 0);
addFriend(4, 1);
addFriend(2, 1);
addFriend(1, 3);
addFriend(2, 0);

haveCommonFriend(1, 0) -> true (2)
haveCommonFriend(2, 0) -> true (1)
haveCommonFriend(3, 0) -> true (1)
haveCommonFriend(3, 1) -> false
haveCommonFriend(1, 2) -> true (0)
```
Dla zapytań podane są poprawne odpowiedzi, wraz z id wspólnego sąsiada. Przykład jest tożsamy z plikiem `0a.in`.
