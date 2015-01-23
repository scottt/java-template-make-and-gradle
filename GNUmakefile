JAVA := java
JAVAC := javac
JAR := jar
GRADLE := gradle
JUNIT = $(JAVA) -classpath $(CLASSPATH) org.junit.runner.JUnitCore

JAVA_SOURCE := $(shell find src -name '*.java')
CLASS_FILES := $(patsubst src/%,build/%,$(JAVA_SOURCE:.java=.class))
TEST_CLASS_FILES := $(filter %Test.class,$(CLASS_FILES))
#$(error $(TEST_CLASS_FILES))

.PHONY: all
all: build/MyApp.jar

.deps-copied:
	$(GRADLE) copyDeps
	touch $@

$(CLASS_FILES): .deps-copied

build/MyApp.jar: $(CLASS_FILES)
	$(JAR) cf $@ $^

empty :=
space := $(empty) $(empty)

build/%.class: src/%.java
	$(eval CLASSPATH := build $(wildcard build/lib/*.jar))
	# Convert the spaces to colons.  This trick is from 
	# the make info file.
	$(eval CLASSPATH := $(subst $(space),:,$(CLASSPATH)))

	$(JAVAC) -classpath $(CLASSPATH) $< -d build

.PHONY: clean
clean:
	rm -rf .deps-copied build/* .gradle


.PHONY: check
check: $(CLASS_FILES)
	$(eval CLASSPATH := build $(wildcard build/lib/*.jar))
	@# Convert the spaces to colons.  This trick is from 
	@# the make info file.
	$(eval CLASSPATH := $(subst $(space),:,$(CLASSPATH)))
	$(JUNIT) $(patsubst build/%,%,$(patsubst %.class,%,$(TEST_CLASS_FILES)))
