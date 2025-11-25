# Repository Guidelines

## Project Structure & Modules
- Core code lives in `src/main/java/com/fiap/banco`: `domain` (entities/enums), `repository` (Spring Data interfaces), `service` (business logic), `exception`, and the entry point `BankApplication`.
- Configuration and assets sit in `src/main/resources`: profile-specific properties (`application-h2.properties`, `application-postgres.properties`), SQL seeds/schemas for each profile, and a simple static landing page in `static/`.
- The default profile is `h2` (set in `application.properties`). Switch profiles rather than editing files directly.
- Docker support: `docker-compose.yml` boots Postgres plus the API container; `Dockerfile` builds the service image.

## Build, Run, and Test Commands
- `mvn clean verify` — compile, run unit tests, and generate JaCoCo coverage (`target/site/jacoco`).
- `mvn spring-boot:run` — start the API using the default H2 profile.
- `mvn spring-boot:run -Dspring-boot.run.profiles=postgres` — run against local Postgres (match credentials in `application-postgres.properties` or env vars).
- `docker compose up --build` — build the image and launch Postgres + API (profile `postgres` is injected via compose).
- `mvn package` — produce the runnable JAR in `target/`.

## Coding Style & Naming
- Java 17, Spring Boot 3.5.x; prefer 4-space indentation and braces on new lines as in existing classes.
- Classes/interfaces use `PascalCase`; methods/fields use `camelCase`; enums stay `UPPER_SNAKE_CASE`.
- Keep service/repository constructors light; avoid field injection when adding new beans (prefer constructor injection).
- When adding SQL assets, mirror the existing naming: `schema-<profile>.sql`, `data-<profile>.sql`.

## Testing Guidelines
- Testing stack: JUnit 5 with Mockito (already declared in `pom.xml`); place tests under `src/test/java/...` mirroring package names.
- Name test classes `*Test`; group behavior-focused methods with `@Nested` where helpful.
- Use the H2 profile for most tests; for integration tests requiring Postgres, load `postgres` via `@ActiveProfiles`.
- Run `mvn test` (or `mvn clean verify`) before opening a PR and check JaCoCo for obvious gaps.

## Commit & Pull Request Guidelines
- Use concise commits; Conventional Commits style is preferred (`feat:`, `fix:`, `chore:`, `test:`). Reference issue IDs when relevant.
- PRs should include: a short summary of the change, how to run/reproduce, the profile/db affected, and test evidence (command output or coverage note).
- Keep changes small and scoped (domain, service, and repository updates in the same PR are fine; avoid mixing infra tweaks unless required).
- If altering DB schema or seed data, call it out in the PR and update both H2 and Postgres scripts to keep profiles aligned.

## Security & Configuration Tips
- Never hard-code secrets; override datasource credentials via environment variables (`SPRING_DATASOURCE_*`) or compose overrides.
- The H2 console is enabled in dev (`/h2-console`); disable or protect it before promoting builds beyond local use.
- Validate inputs with Bean Validation (`spring-boot-starter-validation` is present); prefer annotations on DTOs/entities instead of manual checks.
