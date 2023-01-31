# ClientToServerModParser

Программа копирует из клиентской сборки, серверные моды, удаляя клиентские из указанного списка.

1) Поместить 3 файла в папку вместе с `.minecraft`

![image](https://user-images.githubusercontent.com/50260829/215862066-290fedbe-08ad-407b-9de2-d5d3f10897a3.png)

2) Чтобы отсортировать клиентские моды в файле `ServerModsInjector.cfg` нужно ввести часть названия файла мода ([см. пример](https://github.com/GT-IMPACT/ClientToServerModParser/releases))

3) Запустить `StartInjector.bat`

4) Будет создана папка `SERVER`, куда скопируются папки: `scripts`, `configs`, `mods`.
