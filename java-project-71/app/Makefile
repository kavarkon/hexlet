.DEFAULT_GOAL := build-run
clean:
	./gradlew clean

build:
	./gradlew installDist

run-dist:
	./build/install/app/bin/app -f json src/test/resources/file1.json src/test/resources/file2.json

check:
	./gradlew checkstyleMain

check-test:
	./gradlew checkstyleTest

test:
	./gradlew test
	
report:
	./gradlew jacocoTestReport

run:
	./gradlew run

build-run: build run

.PHONY: build
