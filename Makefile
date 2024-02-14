RECURSIVE					= $(foreach d,	$(wildcard $(1:=/*)),$(call RECURSIVE,$d,$2) $(filter $(subst *,%,$2),$d))


SOURCES						= $(call		RECURSIVE,.,*.java)
CLASSES						= $(SOURCES:.java=.class)

all: $(CLASSES)

clean:
	rm -vf */*.class

$(CLASSES):	$(SOURCES)
	javac $(JAVA_FLAGS) $(@:.class=.java)