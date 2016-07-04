package org.lla.phrasendrescher;

/*
 * Etwas filigraner - jedoch wesentlich subtiler in der Anwendung - ist der
 * interaktive Phrasomat. Mit seiner Hilfe verleihen Sie jeder akademischen
 * Publikation eine entscheidende, von Fachwissen gepr�gte Autorit�t. Wer
 * allerdings �berhaupt keine Ahnung hat nutzt die Zufallsfunktion.
 */

public class Phrase implements ISatz {

	Adjektiv adjektiv1 = new Adjektiv(
			"bilateralen koordinierten ambivalenten kategorischen retrograden zeitgemäßen progressiven intuitiven desintegrierten traditionellen belastbaren");
	Adjektiv adjektiv1b = new Adjektiv("pathologischen funktionellen geordneten extrapolierten konvergenten kalzinierenden rechnergesteuerten terminologischen");
	Nomen nomen1 = new Nomen(
			"Beziehungs- Analyse- Kooperations- Unternehmens- Universal- Interdisziplinär- Korrelations- Emmetropie-",
			"prozessen funktionen entscheidungen methoden einsichten kriterien stimuli hypothesen parameter konzeptionen phasen");

	Adjektiv adjektiv2 = new Adjektiv(
			"antiserielle immanente homogene scholastische dialektische traditionelle integrierte quasilineare kompensatorische syntaktische proportionale");
	Nomen nomen2 = new Nomen("Implikation Kooperation Problematik Konzeption Indoktrination Beurteilung Identität Politik Einsicht Semantik Polyandrie");

	Adjektiv adjektiv3 = new Adjektiv(
			"normativen langlebigen refrakturierten objektivierten konzentrierten informellen potentiellen graduierten zielgerichteten objektgesteuerten");
	Nomen nomen3 = new Nomen(
			"Inhibitations- Fluktuations- Sozialisations- Interaktions- Organisations- Diskursions- Koalisations- Kommunikations- Interdependanz- Denudations- Induktanz- Kopulations-",
			"dogmen akzeptanz identität prämisse duktilität potenz problematik programmierung transparenz flexibilität parakme");

	Adjektiv adjektiv4 = new Adjektiv(
			"psychoanalytischen regressiven akademischen strukturellen kontraktären dubitativen konvexen humanistischen amorphen pragmatischen evokativen");
	Nomen nomen4 = new Nomen("Stimuli Kriterien Determinanten Ressourcen Einflußfaktoren Bezugsrahmen Isoquanten Technologien Nutzenfunktion Elastizität");

	Adjektiv adjektiv5 = new Adjektiv(
			"residualer synchroner definitionaler effizienter grammatikularischer strategischer pädagogischer bilateraler quantitativer materieller ideeller");
	Nomen nomen5 = new Nomen(
			"Dehydriertheit Symbolistik Allokation Grundlagen Dephlegmation Orientiertheit Faktormengen Echinoderme Kolmation Kolorimerie Natalität");

	Verb verb6 = new Verb(
			"abgeleitet normiert standardisiert funktionalisiert objektiviert relativiert pauschalisiert pauperisiert kujoniert konditioniert evangelisiert");
	Nomen nomen6 = new Nomen(
			"Inkontinenz Transparenz Divergenz Relation Imputabilität Kommerzialisierung Probabilität Mastoptose Überbewertung Stichomantie Janusköpfigkeit");

	Adjektiv adjektiv7 = new Adjektiv(
			"formalhygienischen eprigonetischen bornierten wissenschaftlichen phlegmatischen saturierten funktionellen kategorischen qualifizierten systemorientierten subjektiven");
	Nomen nomen7 = new Nomen("Retroeffekts Konsens Intellekts Metazentrums Blickwinkels Forschungstriebes Imperativs Geistes Zeitgefühles Antriebs Kontextes");

	Verb verb8 = new Verb(
			"invertiert maximiert subjektiviert optimiert intervallskaliert automatisiert ignoriert minimiert exagoriert individualisiert rationalisiert");

	public Phrase() {

	}

	@Override
	public String getSatz() {
		final StringBuilder satz = new StringBuilder();
		satz.append("Unter Zuhilfenahme von");
		satz.append(adjektiv1.getWort());
		satz.append(adjektiv1b.getWort());
		satz.append(nomen1.getWort());

		satz.append(" kann die");
		satz.append(adjektiv2.getWort());
		satz.append(nomen2.getWort());

		satz.append(" der");
		satz.append(adjektiv3.getWort());
		satz.append(nomen3.getWort());

		satz.append(" unter Berücksichtigung der");
		satz.append(adjektiv4.getWort());
		satz.append(nomen4.getWort());

		satz.append(" bei gleichzeitiger");
		satz.append(adjektiv5.getWort());
		satz.append(nomen5.getWort());

		satz.append(" derart");
		satz.append(verb6.getWort());

		satz.append(" werden, so daß eine");
		satz.append(nomen6.getWort());

		satz.append(" des");
		satz.append(adjektiv7.getWort());
		satz.append(nomen7.getWort());

		satz.append(" weitgehend");
		satz.append(verb8.getWort());

		satz.append(" wird.");
		return satz.toString();
	}
}
