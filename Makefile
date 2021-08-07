JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Main.java \
	Cars/Autoturism.java \
	Cars/Autoutilitar.java \
	Cars/Autovehicul.java \
	Cars/Bicicleta.java \
	Cars/Camion.java \
	Cars/Mopped.java \
	Cars/Motocicleta.java \
	Cars/Vehicul.java \
	Map/Accident.java \
	Map/Ambuteiaj.java \
	Map/Blocaj.java \
	Map/Harta.java \
	Map/Strada.java \
	Map/Trafic.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
run:
	java Main