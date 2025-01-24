# Service and Repair App

## Описание

**Service and Repair App** — это микросервисное приложение для управления осмотрами и техническим обслуживанием оборудования. Проект включает следующие основные модули:

- **Auth Service**: Отвечает за аутентификацию и авторизацию пользователей.
- **Config Service**: Централизованное управление конфигурацией.
- **Inspection Service**: Управление данными осмотров оборудования.
- **Report Service**: Генерация и управление отчётами.
- **Discovery Service** (опционально): Регистрация и обнаружение сервисов (Eureka).

---

## Структура проекта

service_and_repair_app/ ├── auth_service/ # Модуль аутентификации ├── config_service/ # Модуль централизованной конфигурации ├── inspection_service/ # Модуль управления осмотрами ├── report_service/ # Модуль отчётов ├── discovery_service/ # Сервис Eureka (опционально) ├── docker-compose.yml # Конфигурация Docker Compose └── README.md # Основное описание проекта

yaml
Копировать
Редактировать

---

## Требования

- **Java**: версия 17
- **Maven**: версия 3.6 или выше
- **Docker**: версия 20.10 или выше
- **Docker Compose**: версия 2.0 или выше

---

## Установка и запуск

### 1. Клонирование репозитория

```bash
git clone https://github.com/your-repo/service_and_repair_app.git
cd service_and_repair_app
```
2. Сборка проекта
Перед запуском убедитесь, что проект скомпилирован:

```
mvn clean package
```
3. Запуск с помощью Docker Compose
Для запуска всех сервисов выполните:

```
docker-compose up --build
```
Сервисы будут доступны по следующим портам:

Auth Service: http://localhost:8081

Config Service: http://localhost:8888

Inspection Service: http://localhost:8082

Report Service: http://localhost:8083
4. Остановка сервисов
Чтобы остановить все контейнеры, выполните:

```
docker-compose down
```
Конфигурация
Основные настройки находятся в файлах application.properties внутри каждого сервиса.
```
Пример: auth_service/src/main/resources/application.properties
properties
```
server.port=8081

spring.application.name=auth-service

eureka.client.service-url.defaultZone=http://config-service:8761/eureka
### Тестирование
Для запуска тестов выполните:

```
mvn test
```
Возможные проблемы
1. Ошибка Eureka Client
Если auth-service не может подключиться к Eureka, убедитесь, что config-service работает.

2. Проблемы с Docker
Если Docker-контейнеры не запускаются, проверьте доступ к docker.sock и убедитесь, что все образы были успешно собраны.