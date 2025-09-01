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
