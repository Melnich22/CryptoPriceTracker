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
