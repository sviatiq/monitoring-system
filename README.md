README
Создание проекта было невозможным без первоначального представления о том, как работает система, поэтому пришлось изучить предметную область.
Клиент прописывает URL, этот URL должен пройти проверки прежде чем будет внесен в базу данных(БД) и после этого отправлен в виде html страницы пользователю.
Реализация в Java следующая:
1. Было создано 3 основных класса, с которыми мы работаем.
* Client( класс с полями и методами, необходимыми для функциональности системы)
* Monitoring( класс, в котором реализованы основные методы по проверке всех данных)
* Server ( класс, который устанавливает соединение с БД и отправляет туда информацию про состояние клиентского приложения)
2. Некоторые поля Client должны быть не просто примитивными типами, а обьектами. Поэтому создано дополнительно несколько классов:
* HTTPResponse( класс с полями и методами, который расширяет функциональность Client, но не является его потомком.
* URLStatus( обычное перечисление, в котором есть 3 статуса: OK, WARNING и CRITICAL )
3. Создан класс SaveUserData для тестирования кода
4. Создана БД в resource/db.sql.
5. Для создания подключения создан класс ConnectionBuilder. По сути, он просто упрощает код путем вынесения отдельной реализации в дополнительный класс.
6. Для HTTPResponse создан интерфейс Checking, который создает контракт на обязательную проверку двух полей
7. Написаны тесты
8. Добавлен DictionaryDao для поиска последней записи пользователя с подальшим возвращением результата пользователю
Технологии, которые использовались: 
Сборка проекта - Maven 
Тестирование - JUnit 
Разработка велась на MacOS, с помощью IntelliJ IDEA