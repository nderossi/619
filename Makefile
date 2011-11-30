JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	a9.java \
	Commander.java \
	Tour.java \
	Tours.java \
	Offering.java \
	Offerings.java \
	Reservation.java \
	Reservations.java \
	Event.java \
	Events.java \
	ActivityEvent.java \
	TravelEvent.java \
	Person.java \
	People.java \
	Solo.java \
	Single.java \
	Double.java \
	Provider.java \
	Providers.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
