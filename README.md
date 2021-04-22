# Lab01_AK
Repozytorium dotyczy ćwiczenia 1 oraz 12.

#Założenia projektowe.

Źródłem danych dotyczących klientów biura oraz wycieczek mogą być dowolne klasy implementujące interfejsy CustomerRepository oraz TripRepository. W przypadku tej aplikacji implementują je klasy CustomerData oraz TripData przechowujące dane za pomocą list.

Została dodana dodatkowa metoda removeCustomer(Customer customer), która pozwala na usunięcie konkretnego klienta oraz metoda getAll(), która w przypadku źródeł danych zwraca wszystkich klientów lub wszystkie wycieczki w postaci listy.