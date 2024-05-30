### Чек-листы:
#### Чек-лист для эндпоинта `POST /user/create`
##### Требования (В исходном задании не было. Придумал сам. При работе на проекте - уточнил требования)

- Минимальная длина полей `username`, `email`, `password` — 2 символа.
- Максимальная длина полей `username`, `email`, `password` — 20 символов.

1. **Функциональные позитивные кейсы:**

    - [ ]  Запрос с корректными значениями для всех полей:

      `{     "username": "validUser",     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  Минимально допустимые значения для всех полей (2 символа):

      `{     "username": "ab",     "email": "a@b.c",     "password": "12" }`

    - [ ]  Максимально допустимые значения для всех полей (20 символов):

      `{     "username": "username1234567890",     "email": "email1234567890@ex.com",     "password": "password1234567890" }`
      - [ ]  `username` длиной 2 символа:

      `{     "username": "ab",     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  `username` длиной 20 символов:

      `{     "username": "username1234567890",     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  `email` длиной 2 символа:

      `{     "username": "validUser",     "email": "a@b",     "password": "ValidPassword" }`

    - [ ]  `email` длиной 20 символов:

      `{     "username": "validUser",     "email": "email1234567890@ex.com",     "password": "ValidPassword" }`

    - [ ]  `password` длиной 2 символа:

      `{     "username": "validUser",     "email": "valid@example.com",     "password": "12" }`

    - [ ]  `password` длиной 20 символов:

      `{     "username": "validUser",     "email": "valid@example.com",     "password": "password1234567890" }`

    - [ ]  Регистрация с уже существующим `username`:

      `{     "username": "existingUser",     "email": "new@example.com",     "password": "ValidPassword" }`

    - [ ]  Регистрация с уже существующим `email`:

      `{     "username": "newUser",     "email": "existing@example.com",     "password": "ValidPassword" }`


2. **Функциональные негативные кейсы:**

    - [ ]  Отсутствие поля `username`:

      `{     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  Отсутствие поля `email`:

      `{     "username": "validUser",     "password": "ValidPassword" }`

    - [ ]  Отсутствие поля `password`:

      `{     "username": "validUser",     "email": "valid@example.com" }`

    - [ ]  `username` меньше 2 символов:

      `{     "username": "a",     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  `username` больше 20 символов:

      `{     "username": "username123456789012345",     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  `email` без символа @:

      `{     "username": "validUser",     "email": "invalidemail.com",     "password": "ValidPassword" }`

    - [ ]  `email` без доменной части:

      `{     "username": "validUser",     "email": "example@",     "password": "ValidPassword" }`

    - [ ]  `password` меньше 2 символов:

      `{     "username": "validUser",     "email": "valid@example.com",     "password": "a" }`

    - [ ]  `password` больше 20 символов:

      `{     "username": "validUser",     "email": "valid@example.com",     "password": "password123456789012345" }`

    - [ ]  `username` содержит недопустимые символы (например, пробелы):

      `{     "username": "invalid user",     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  `email` содержит недопустимые символы (например, пробелы):

      `{     "username": "validUser",     "email": "invalid @example.com",     "password": "ValidPassword" }`

    - [ ]  `password` содержит недопустимые символы (например, пробелы):

      `{     "username": "validUser",     "email": "valid@example.com",     "password": "invalid password" }`

**Не функциональные кейсы:**
1. **Безопасность:**

    - [ ]  SQL Injection в `username`:

      `{     "username": "validUser'; DROP TABLE users; --",     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  SQL Injection в `email`:

      `{     "username": "validUser",     "email": "valid@example.com'; DROP TABLE users; --",     "password": "ValidPassword" }`

    - [ ]  SQL Injection в `password`:

      `{     "username": "validUser",     "email": "valid@example.com",     "password": "ValidPassword'; DROP TABLE users; --" }`

    - [ ]  XSS  в `username`:

      `{     "username": "<script>alert('XSS')</script>",     "email": "valid@example.com",     "password": "ValidPassword" }`

    - [ ]  XSS  в `email`:

      `{     "username": "validUser",     "email": "<script>alert('XSS')</script>@example.com",     "password": "ValidPassword" }`

    - [ ]  XSS в `password`:

      `{     "username": "validUser",     "email": "valid@example.com",     "password": "<script>alert('XSS')</script>" }`

    - [ ]  Проверка брутфорса.
    - [ ]  Проверка авторизации и аутентификации.

2. **Нагрузка:**
    - [ ]  Создание N пользователей за короткий период времени и проверка стабильности системы(согласно требованиям).
    - [ ]  Создание пользователей при пиковой нагрузке.

3. **Отказоустойчивость:**
    - [ ]  Симуляция сбоев в сети и проверка поведения API (например, отрубился микросервис).
    - [ ]  Восстановление после сбоев и проверка целостности данных(например, как сдек :) ).



#### Чек-лист для эндпоинта `GET /user/get`

1. **Функциональные кейсы:**

    - [ ]  Получение списка пользователей, когда в системе есть хотя бы один пользователь.
    - [ ]  Получение списка пользователей, когда в системе есть несколько пользователей.
    - [ ]  Получение списка пользователей, когда в системе нет ни одного пользователя.
    - [ ]  Проверка, что ответ на запрос содержит корректный формат данных (JSON).
    - [ ]  Проверка, что в случае отсутствия пользователей ответ корректен (например, пустой массив, уведомление об отсутствии пользователей).


**Не функциональные кейсы:**
1. **Безопасность:**

    - [ ]  SQL Injection в параметрах запроса (если применимо):

      `GET /user/get?param=' OR '1'='1'`

    - [ ]  XSS  в параметрах запроса (если применимо):

      `GET /user/get?param=<script>alert('XSS')</script>`

    - [ ]  Проверка брутфорса.
    - [ ]  Проверка авторизации и аутентификации.

2. **Нагрузка:**
    - [ ]  Создание N пользователей за короткий период времени и проверка стабильности системы(согласно требованиям).
    - [ ]  Создание пользователей при пиковой нагрузке.

3. **Отказоустойчивость:**
    - [ ]  Симуляция сбоев в сети и проверка поведения API (например, отрубился микросервис).
    - [ ]  Восстановление после сбоев и проверка целостности данных(например, как сдек :) ).



### Приоритизация:

#### Высокий приоритет

##### Для эндпоинта `POST /user/create`

**Функциональные позитивные кейсы:**

- Запрос с корректными значениями для всех полей
- Минимально допустимые значения для всех полей (2 символа)
- Максимально допустимые значения для всех полей (20 символов)
- Регистрация с уже существующим `username`
- Регистрация с уже существующим `email`

**Негативные тест-кейсы:**

- Отсутствие поля `username`
- Отсутствие поля `email`
- Отсутствие поля `password`
- `email` без символа @
- `password` меньше 2 символов

**Безопасность:**

- SQL Injection в `username`
- SQL Injection в `email`
- SQL Injection в `password`
- XSS в `username`
- XSS в `email`
- XSS в `password`

##### Чек-лист для эндпоинта `GET /user/get`

**Функциональные кейсы:**

- Получение списка пользователей, когда в системе есть хотя бы один пользователь
- Проверка, что ответ на запрос содержит корректный формат данных (JSON)

**Безопасность:**

- SQL Injection в параметрах запроса
- XSS в параметрах запроса
- Проверка авторизации и аутентификации

#### Средний приоритет

##### Чек-лист для эндпоинта `POST /user/create`

**Функциональные позитивные кейсы:**

- `username` длиной 2 символа
- `username` длиной 20 символов
- `email` длиной 2 символа
- `email` длиной 20 символов
- `password` длиной 2 символа
- `password` длиной 20 символов

**Негативные тест-кейсы:**

- `username` меньше 2 символов
- `username` больше 20 символов
- `email` без доменной части
- `password` больше 20 символов

**Нагрузка:**

- Создание N пользователей за короткий период времени и проверка стабильности системы
- Создание пользователей при пиковой нагрузке

##### Чек-лист для эндпоинта `GET /user/get`

**Функциональные кейсы:**

- Получение списка пользователей, когда в системе есть несколько пользователей
- Проверка, что в случае отсутствия пользователей ответ корректен

#### Низкий приоритет

##### Чек-лист для эндпоинта `POST /user/create`

**Негативные тест-кейсы:**

- `username` содержит недопустимые символы
- `email` содержит недопустимые символы
- `password` содержит недопустимые символы

**Отказоустойчивость:**

- Симуляция сбоев в сети и проверка поведения API
- Восстановление после сбоев и проверка целостности данных

##### Чек-лист для эндпоинта `GET /user/get`

**Функциональные кейсы:**

- Получение списка пользователей, когда в системе нет ни одного пользователя

**Отказоустойчивость:**

- Симуляция сбоев в сети и проверка поведения API
- Восстановление после сбоев и проверка целостности данных