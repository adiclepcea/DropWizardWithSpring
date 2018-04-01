.PHONY: build test start-db-docker stop-db-docker db-status db-dump-schema db-migrate-schema

build:
	mvn package

test:
	mvn test

db-status:
	java -jar target/gestiune-1.0-SNAPSHOT.jar db status configuration.yaml

db-dump-schema:
	java -jar target/gestiune-1.0-SNAPSHOT.jar db dump configuration.yaml

db-migrate-schema:
	java -jar target/gestiune-1.0-SNAPSHOT.jar db migrate configuration.yaml

start-db-docker:
	docker run --name pg_for_gestiune --rm -d -p 5439:5432 clepcea/postgresql:9.3

stop-db-docker:
	docker stop pg_for_gestiune
