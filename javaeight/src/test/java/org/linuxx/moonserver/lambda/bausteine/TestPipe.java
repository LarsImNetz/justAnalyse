package org.linuxx.moonserver.lambda.bausteine;

public class TestPipe {

	/*
	 * 
	 * Pipes & Filters als Grundmuster der Streams
	 * Die gezeigten funktionalen Interfaces Function, Consumer und Predicate sind die Bausteine für die neuen Streams in Java 8, die eine neue Nutzungssicht auf
	 * Java-Collections bieten. Statt wie bisher mit einer for-Schleife oder mit einem (externen) Iterator selbst auf den Collections zu operieren, bieten Streams
	 * eine höherwertige Sicht auf Daten-Collections. Streams halten dabei keine Daten, sondern erlauben den Zugriff auf Daten der unterliegenden Collection. Sie
	 * sind demnach eine Art "View" auf die Collection, vergleichbar dem altbekannten java.util.Iterator.
	 * 
	 * Das Grundmuster der Streams basiert auf dem Pattern "Pipes & Filters". Dabei handelt es sich um ein bewährtes EAI-Pattern (Enterprise Architecture
	 * Integration) [5], und das Grundprinzip kennt jeder, der schon mal Unix-Kommandos verknüpft hat:
	 * 
	 * ps -ef | grep login | cut -c 50- | head
	 * Die Ausgabe von ps wird mit der Pipe an grep zur Filterung weitergereicht. Dessen lange Ausgabe bildet cut auf einen Teilbereich der Ausgabe (nur Spalten >
	 * 50) ab. Abschließend gibt head die ersten Einträge aus. Streams in Java 8 arbeiten letztlich nach demselben Prinzip und verketten Teiloperatoren zu einem
	 * Gesamtkontrollfluss auf einer Java-Collection.
	 * Intermediate und terminale Operatoren – lazy und eager
	 * Betrachtet sei noch einmal das eingehende Beispiel:
	 * 
	 */
	
//	@Test
//	public void testPipe() throws Exception {
//		List<Integer> prices = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
//		return prices.stream()               // interne Iteration
//		  .filter(price -> price >= 42)      // Filter
//		  .mapToDouble(price -> price * 0.9) // Map: Rabatt 
//		  .sum();                            // Reduce: Gesamtsumme
//	}
}
