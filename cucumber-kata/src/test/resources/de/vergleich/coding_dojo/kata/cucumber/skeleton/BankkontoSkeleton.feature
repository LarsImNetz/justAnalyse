# language: de
Funktionalität: Bankkonto anlegen
	Als Coding-Dojo-Teilnehmer möchte ich ein Bankkonto eröffnen.
	
	Grundlage: Bankkonto anlegen
		Angenommen ich lege ein Bankkonto an
		Dann habe ich ein Bankkonto
		Und es ist leer
			
	Szenario: In das Bankkonto einzahlen
		Wenn ich 100 Euro einzahle
		Dann beträgt der Kontostand 100 Euro
		
	Szenario: In das Bankkonto mehr einzahlen
		Wenn ich 100 Euro einzahle
		Und  ich 200 Euro einzahle
		Dann beträgt der Kontostand 300 Euro

	Szenario: In das Bankkonto einzahlen und auszahlen
		Wenn ich 100 Euro einzahle
		Und ich 50 Euro abhebe
		Dann beträgt der Kontostand 50 Euro

	Szenario: Einen Kontoauszug anfordern
		Wenn ich einen Kontoauszug anfordere
		Dann erhalte ich einen Kontoauszug
		