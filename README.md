# Server_API
Server-API

Сервер API (JSON HTTP API)

Функционал (контроллеры):

Загрузчик.
Передаем на сервер файл (картинка, формат JPG).
Сохраняем картинку в каталоге на сервере.
Ответ сервера - внутренний URI картинки {imageUri:"http://localhost/images/img.jpg"}.

Добавление нового пользователя.
Передаем на сервер персональные данные пользователя (URI картинки, имя пользователя, email и т.д.).
Сохраняем информацию в базе данных.
Ответ сервера - уникальный ID нового пользователя {userId: "идентификатор"}.

Удаление пользователя.
Передаем на сервер уникальный ID пользователя.
Удаляем информацию о пользователе из базе данных.
Ответ сервера - булевое значение в поле isDeeleted {isDeleted: true}.

Получение информации о пользователе.
Передаем на сервер уникальный ID пользователя.
Читаем информацию из базы данных.
Ответ сервера - персональные данные пользователя.

Изменение статуса пользователя (online, offline).
Передаем на сервер уникальный ID пользователя и новый статус (online, offline).
Изменяем статус пользователя.
Ответ сервера - уникальный ID пользователя, новый и предыдущий статус.
Примечание: на сервере выполняется запрос к внешнему API/базе данных. Так как это упрощенное тестовое задание необходимо реализовать "заглушку” с имитацией обращения и задержкой по времени 5-10 сек.

Статистика сервера.
Передаем параметры на сервер: 
1. статус клиентов (Online, Offline или отсутствует),
2. уникальный ID (timestamp) запроса (может отсутствовать)
Ответ сервера - список пользователей со статусами и URI картинки, а также уникальный ID (timestamp) запроса.
Примечание: Если в запросе есть параметры, то сервер должен фильтровать по ним свой ответ. Если в запросе есть уникальный ID (timestamp) запроса (полученный ранее), то сервер должен вернуть только пользователей, у которых изменились статусы после (по времени)этого уникального ID (timestamp).

Обязательные требования:
 обращение к БД черз ORM
 все данные в формате JSON.
 код размещать на github в публичном репозитории
