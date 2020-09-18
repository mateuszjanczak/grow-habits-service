# grow-habits-service
Serwis do przechowywania nawyków

### Wymagania
* JDK 1.8 lub późniejsza

### Pierwsze kroki

#### Krok 1: Sklonuj repozytorium
`git clone git@github.com:mateuszjanczak/grow-habits-service.git`

#### Krok 2: Uruchom aplikację
`./mvnw spring-boot:run`

### Endpointy

#### Wyświetlanie tasków
```
GET http://localhost:8080/tasks

Response
[
    {
        "id": "1",
        "title": "daily eating fastfood",
        "cooldown": 86400,
        "lockTime": "2020-09-18T00:15:31.218+00:00",
        "optionList": [
            {
                "id": "1",
                "name": "yes",
                "power": 20.0,
                "color": "#8ac926"
            },
            {
                "id": "2",
                "name": "no",
                "power": 80.0,
                "color": "#e63946"
            }
        ]
    }, (...)
]
```

#### Dodawanie tasków
```
POST http://localhost:8080/tasks
Content-Type: application/json

Request
{
    "title": "daily eating fastfood",
    "cooldown": 86400,
    "optionRequestList": [
        {
            "name": "yes",
            "power": 20,
            "color": "#8ac926"
        },
        {
            "name": "no",
            "power": 80,
            "color": "#e63946"
        }
    ]
}
```

#### Pojedynczy task
```
GET http://localhost:8080/tasks/{id}

Response
{
    "id": "1",
    "title": "daily eating fastfood",
    "cooldown": 86400,
    "lockTime": "2020-09-18T00:15:31.218+00:00",
    "optionList": [
        {
            "id": "1",
            "name": "yes",
            "power": 20.0,
            "color": "#8ac926"
        },
        {
            "id": "2",
            "name": "no",
            "power": 80.0,
            "color": "#e63946"
        }
    ]
}
```

#### Zakręcenie kołem
```
POST http://localhost:8080/roll
Content-Type: application/json

Request
{"id": 1}

Response
{
    "id": "1",
    "option": {
        "id": "1",
        "name": "yes",
        "power": 20.0,
        "segment": 1
    },
    "lockTime": "2020-09-18T00:19:30.914+00:00"
}
```