# Crypto Price Tracker (Spring Boot)

Small, production-ready backend that retrieves **crypto prices** via an external API (CoinGecko or CoinMarketCap), returns **normalized** results, and briefly **caches them in RAM** (Caffeine).

## Features
- `GET /api/prices?coins=<...>&vs=<...>` – Prices of multiple coins in multiple fiat currencies
- **In-memory cache** (Caffeine) with TTL (default: 60s)
- **Configuration** via `application.properties` and **ENV variables**
- Health check `GET /healthz`
- Clean layering: Controller → Service → HTTP client
- Optional **PRO** API with key (header is set automatically if available)

## Architecture (short)
- **Web**: `PriceController` (REST), `HelloController` (`/healthz`)
- **Service**: `PriceService` (caching & mapping)
- **Integration**: `CoinClient` *or* `CmcClient` (HTTP)
- **Config**: `HttpConfig`, `CacheConfig`
- **DTOs**: `PriceDto`, `PricesResponse`

## Requirements
- Java 17+ (tested with 23)
- Maven Wrapper (located in the repo)

## Quick Start

### 1) Build
```bash
./mvnw -DskipTests package          # Windows: .\mvnw.cmd -DskipTests package

# Crypto Price Tracker (Spring Boot)

Kleines, produktionsnahes Backend, das **Krypto-Preise** über eine externe API (CoinGecko oder CoinMarketCap) abruft, die Ergebnisse **normalisiert** zurückgibt und kurz **im RAM cached** (Caffeine).

## Features
- `GET /api/prices?coins=<...>&vs=<...>` – Preise mehrerer Coins in mehreren Fiat-Währungen
- **In-Memory Cache** (Caffeine) mit TTL (Default: 60s)
- **Konfiguration** via `application.properties` und **ENV-Variablen**
- Healthcheck `GET /healthz`
- Saubere Schichtung: Controller → Service → Http-Client
- Optionale **PRO**-API mit Key (Header wird automatisch gesetzt, wenn vorhanden)

## Architektur (Kurz)
- **Web**: `PriceController` (REST), `HelloController` (`/healthz`)
- **Service**: `PriceService` (Caching & Mapping)
- **Integration**: `CoinClient` *oder* `CmcClient` (HTTP)
- **Config**: `HttpConfig`, `CacheConfig`
- **DTOs**: `PriceDto`, `PricesResponse`

## Voraussetzungen
- Java 17+ (getestet mit 23)
- Maven Wrapper (liegt im Repo)

## Quick Start

### 1) Build
```bash
./mvnw -DskipTests package          # Windows: .\mvnw.cmd -DskipTests package

