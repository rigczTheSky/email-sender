# email-sender

Aplikacja Email-sender służy do wysyłania wiadomości drogą mailową oraz zarządzania listą kontaktów użytkownika.
Dostępne opcje odnośnie wiadomości to:
  wysłanie wiadomości pod wskazany adres
w ysłanie wiadomości do wszystkich użytkowników dostępnych w bazie danych
Dostępne funkcje dla zarządzania kontaktami to podstawowe operacje CRUD:
  wyświetlenie wszystkich kontaktów
  wyświetlenie kontaktu dla danego id
  zaktualizowanie danych kontaktu dla danego id
  usunięcie kontaktu z danym id
W projekcie użyto bazy danych H2 i na niej odbywają się dedykowane dla aplikacji testy. 
Obejmują one operacje na bazie danych kontaktów dostępne dla użytkownika. 
Niestety funkcja wysyłki wiadomości do wszystkich oraz wybranego kontaktu była testowana tylko manualnie. 
 przyszłości można pokryć ją testami za pomocą bibloteki GreenMail. 
Dostępny jest niestety również tylko jeden plik logujący - znajdujący się w głównym folderze: spring.log.
