Sklonowanie projektu
1. Otwórz basha tam gdzie chcesz miec projekt
2. Wklej w basha: ```git clone https://github.com/Jakub137/system-zrr.git``` 
3. wpisz ```cd system-zrr```

Aktualizacja naszego brancha o najnowszego maina
Robić przed rozpoczęciem pracy nad branchem i po zakończeniu pracy nad branchem (przed stworzeniem pullrequesta)
To najbezpieczniej robić jak wszystkie zmiany na Twoim branchu są zacomitowane
1. ```git checkout main```
2. ```git pull```
3. ```git checkout nazwabrancha``` (dawidb, jakubj, jakubd, main)
4. ```git merge main``` (wkleja wszystkie zmiany z maina na Twojego brancha) 

Wysyłanie zmian do GitHuba 
po raz pierwszy: ```git push -u orgin nazwabrancha```
po raz n-ty: ```git push```

Tworzenie pullrequesta
1. wypushuj wszystkie zmiany na swojego brancha
2. Zaaktualizuj swojego brancha o najnowszego maina
3. wejdz na swojego brancha na GitHubie ```https://github.com/Jakub137/system-zrr/branches```
4. Kliknij create pull request (zwróć uwagę, aby targetowanym branchem był main)
