package org.lla.phrasendrescher;

/*
 * Etwas filigraner - jedoch wesentlich subtiler in der Anwendung - ist der
 * interaktive Phrasomat. Mit seiner Hilfe verleihen Sie jeder akademischen
 * Publikation eine entscheidende, von Fachwissen geprägte Autorität. Wer
 * allerdings überhaupt keine Ahnung hat nutzt die Zufallsfunktion.
 */

public class Phrase implements ISatz {

	AdjektivListe adjektivList1 = new AdjektivListe(
			"bilateralen koordinierten ambivalenten kategorischen retrograden zeitgemäßen progressiven intuitiven desintegrierten traditionellen belastbaren");
	AdjektivListe adjektivList1b = new AdjektivListe(
			"pathologischen funktionellen geordneten extrapolierten konvergenten kalzinierenden rechnergesteuerten terminologischen");
	SubstantivListe nomenList1 = new SubstantivListe(
			"Beziehungs Analyse Kooperations Unternehmens Universal Interdisziplinär Korrelations Emmetropie",
			"prozessen funktionen entscheidungen methoden einsichten kriterien stimuli hypothesen parameter konzeptionen phasen");

	AdjektivListe adjektivList2 = new AdjektivListe(
			"antiserielle immanente homogene scholastische dialektische traditionelle integrierte quasilineare kompensatorische syntaktische proportionale");
	SubstantivListe nomenList2 = new SubstantivListe(
			"Implikation Kooperation Problematik Konzeption Indoktrination Beurteilung Identität Politik Einsicht Semantik Polyandrie");

	AdjektivListe adjektivList3 = new AdjektivListe(
			"normativen langlebigen refrakturierten objektivierten konzentrierten informellen potentiellen graduierten zielgerichteten objektgesteuerten");
	SubstantivListe nomenList3 = new SubstantivListe(
			"Inhibitations- Fluktuations- Sozialisations- Interaktions- Organisations- Diskursions- Koalisations- Kommunikations- Interdependanz- Denudations- Induktanz- Kopulations-",
			"dogmen akzeptanz identität prämisse duktilität potenz problematik programmierung transparenz flexibilität parakme");

	AdjektivListe adjektivList4 = new AdjektivListe(
			"psychoanalytischen regressiven akademischen strukturellen kontraktären dubitativen konvexen humanistischen amorphen pragmatischen evokativen");
	SubstantivListe nomenList4 = new SubstantivListe(
			"Stimuli Kriterien Determinanten Ressourcen Einflußfaktoren Bezugsrahmen Isoquanten Technologien Nutzenfunktion Elastizität");

	AdjektivListe adjektivList5 = new AdjektivListe(
			"residualer synchroner definitionaler effizienter grammatikularischer strategischer pädagogischer bilateraler quantitativer materieller ideeller");
	SubstantivListe nomenList5 = new SubstantivListe(
			"Dehydriertheit Symbolistik Allokation Grundlagen Dephlegmation Orientiertheit Faktormengen Echinoderme Kolmation Kolorimerie Natalität");

	VerbListe verbList6 = new VerbListe(
			"abgeleitet normiert standardisiert funktionalisiert objektiviert relativiert pauschalisiert pauperisiert kujoniert konditioniert evangelisiert");
	SubstantivListe nomenList6 = new SubstantivListe(
			"Inkontinenz Transparenz Divergenz Relation Imputabilität Kommerzialisierung Probabilität Mastoptose Überbewertung Stichomantie Janusköpfigkeit");

	AdjektivListe adjektivList7 = new AdjektivListe(
			"formalhygienischen eprigonetischen bornierten wissenschaftlichen phlegmatischen saturierten funktionellen kategorischen qualifizierten systemorientierten subjektiven");
	SubstantivListe nomenList7 = new SubstantivListe(
			"Retroeffekts Konsens Intellekts Metazentrums Blickwinkels Forschungstriebes Imperativs Geistes Zeitgefühles Antriebs Kontextes");

	VerbListe verbList8 = new VerbListe(
			"invertiert maximiert subjektiviert optimiert intervallskaliert automatisiert ignoriert minimiert exagoriert individualisiert rationalisiert");

	public Phrase() {

	}

	@Override
	public String getSatz() {
		final StringBuilder satz = new StringBuilder();
		satz.append("Unter Zuhilfenahme von");
		satz.append(adjektivList1.getWort());
		satz.append(adjektivList1b.getWort());
		satz.append(nomenList1.getWort());

		satz.append(" kann die");
		satz.append(adjektivList2.getWort());
		satz.append(nomenList2.getWort());

		satz.append(" der");
		satz.append(adjektivList3.getWort());
		satz.append(nomenList3.getWort());

		satz.append(" unter Berücksichtigung der");
		satz.append(adjektivList4.getWort());
		satz.append(nomenList4.getWort());

		satz.append(" bei gleichzeitiger");
		satz.append(adjektivList5.getWort());
		satz.append(nomenList5.getWort());

		satz.append(" derart");
		satz.append(verbList6.getWort());

		satz.append(" werden, so daß eine");
		satz.append(nomenList6.getWort());

		satz.append(" des");
		satz.append(adjektivList7.getWort());
		satz.append(nomenList7.getWort());

		satz.append(" weitgehend");
		satz.append(verbList8.getWort());

		satz.append(" wird.");
		return satz.toString();
	}
}
