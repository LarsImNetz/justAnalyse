package luceneFive;

import java.io.IOException;
import java.util.GregorianCalendar;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class LuceneUserNameSearch {

	public static void main(final String[] args) throws IOException, ParseException {
		System.out.println("Indexing...");
		index();
		System.out.println();

		System.out.println("Searching for Langhans");
		searchField("name", "Langhans");

		System.out.println("Searching for langhans");
		searchField("name", "langhans");
	
		System.out.println("Searching for lan*");
		searchField("name", "Lan*");

		System.out.println("Searching for lan*");
		searchField("name", "La*");

		System.out.println("Searching for Ber*");
		searchField("ort", "Ber*");

		System.out.println("Searching for Ham*");
		searchField("ort", "Ham*");
		
		System.out.println("Searching in Multiple fields for be*");
		searchMulti("be*");

		System.out.println("Searching in Multiple fields for *be*");
		searchMulti("*be*");

		System.out.println("Searching in Multiple fields for ben*");
		searchMulti("ben*");

		System.out.println("Searching in Multiple fields for ber*");
		searchMulti("ber*");

		System.out.println("Searching in Multiple fields for *der* or die*");
		searchMulti("*der* OR die*");
	}

	/**
	 * build the index
	 * 
	 * @see org.apache.lucene.analysis.standard.StandardAnalyzer
	 * @see org.apache.lucene.index.IndexWriterConfig.IndexWriterConfig
	 * @link
	 * 			http://lucene.apache.org/core/5_0_0/analyzers-common/org/apache/lucene
	 *       /analysis/standard/StandardAnalyzer.html
	 * @link http://lucene.apache.org/core/5_0_0/core/org/apache/lucene/index/
	 *       IndexWriterConfig.html
	 */

	private static Directory index;

	private static void index() throws IOException {
		// Directory dir = null;
		IndexWriter writer = null;

		try {
			/*
			 * 1. where to store our index files
			 */
			// dir = FSDirectory.open(Paths.get(PATH_TO_INDEX));
			/* use the following line instead, if you only want a ram index */
			index = new RAMDirectory();

			/*
			 * 2. get an instance of an analyzer, here we use the
			 * StandardAnalyer in earlier versions we had to add a version
			 * parameter, now this is no longer required nor possible
			 */
			final Analyzer analyzer = new StandardAnalyzer();

			/*
			 * 3. Create an index writer and its configuration object
			 */
			final IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
			iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// if we want to override an existent index we should use the
			// following line instead
			iwc.setOpenMode(OpenMode.CREATE);
			writer = new IndexWriter(index, iwc);

			addDoc(writer, "Lars","Langhans", "Lübeck", "23566");
			addDoc(writer, "Lisa","Langhans", "Lübeck", "23566");
			addDoc(writer, "Lucas","Langhans", "Lübeck", "23566");
			addDoc(writer, "Anja","Langhans", "Lübeck", "23566");
			addDoc(writer, "Ein","Langhans", "Langenfelde", "");

			addDoc(writer, "Gundula","Langhans", "Lübeck", "23560");
			addDoc(writer, "Christoph","Langhans", "Lübeck", "23560");
			addDoc(writer, "Tobias","Langhans", "Lübeck", "23560");

			addDoc(writer, "Christa","Scheel", "Lübeck", "23558");
			addDoc(writer, "Heinz","Scheel", "Lübeck", "23558");
			addDoc(writer, "Marina","Diekmann", "Lübeck Kücknitz", "23569");
			addDoc(writer, "Reiner","Diekmann", "Lübeck Kücknitz", "23569");
			addDoc(writer, "Stefan Andreas","Winkler", "Lübeck", "23500");

			addDoc(writer, "Lukas","Schmidt", "Lübeck", "23560");
			addDoc(writer, "Kristin","Albinski", "Lübeck", "23500");
			addDoc(writer, "Melissa","Richter", "Frankfurt", "50000");
			addDoc(writer, "Steffen","Kämpke", "Berkentin", "23400");
			addDoc(writer, "Florian","Kalis", "Lübeck", "23500");
			addDoc(writer, "Frank","Reder", "Lübeck", "23500");
			addDoc(writer, "Kathrin","Pohlmann", "Siebenbäumen", "22700");
			addDoc(writer, "Alexander","Buhr", "Lübeck", "23500");

			addDoc(writer, "Dirk","Diebel", "Berlin", "10000");
			addDoc(writer, "Frank","Rutkowski", "Berlin", "10000");
			addDoc(writer, "Andre","Männeke", "Berlin", "10000");

			addDoc(writer, "Steffen","Grund", "Hamburg", "20097");
			addDoc(writer, "Stefan","Wunderlich", "Ipswitch", "");
			addDoc(writer, "Vladimir","Glasonow", "Hamburg", "20097");
			addDoc(writer, "Christoph","Neumann", "Lüneburg", "21335");
			
			addDoc(writer, "Ralph","Weimann", "Bad Schwartau", "23611");
			addDoc(writer, "Elke","Weimann", "Bad Schwartau", "23611");
			addDoc(writer, "Christian","Lütgens", "Lübeck", "23500");
			addDoc(writer, "Kerstin","Lütgens", "Lübeck", "23500");
			addDoc(writer, "Manon","Lütgens", "Lübeck", "23500");

			addDoc(writer, "Michael","Jahnke", "Gleschendorf", "23650");
			addDoc(writer, "Nicole","Jahnke", "Gleschendorf", "23650");
			addDoc(writer, "Benjamin","Jahnke", "Gleschendorf", "23650");
			addDoc(writer, "Charlotte","Jahnke", "Gleschendorf", "23650");
			addDoc(writer, "Frederike","Jahnke", "Gleschendorf", "23650");
			addDoc(writer, "Andreas","Illi", "Bad Schwartau", "23611");
			addDoc(writer, "Stephan","Elsner", "Stockelsdorf", "23617");
			addDoc(writer, "Maike","Elsner", "Stockelsdorf", "23617");
			addDoc(writer, "Jan Luca","Riegel", "Lübeck", "23566");
			addDoc(writer, "Uli","Biester", "Lübeck", "23566");
			addDoc(writer, "Christiane","Riegel", "Lübeck", "23566");

			addDoc(writer, "Uschi","Kunze", "Lübeck", "23566");
			addDoc(writer, "Wolfgang","Kunze", "Lübeck", "23566");

			addDoc(writer, "Erdal","Biner", "Lübeck", "23566");
			addDoc(writer, "Jana","Biner", "Lübeck", "23566");
			addDoc(writer, "Deniz","Biner", "Lübeck", "23566");
			addDoc(writer, "Can","Biner", "Lübeck", "23566");

			addDoc(writer, "Uli","Langkabel", "Lübeck", "23566");
			addDoc(writer, "Ute","Langkabel", "Lübeck", "23566");
		}
		finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	private static void addDoc(final IndexWriter w, final String vorname, final String name, final String org, final String plz) throws IOException {
		final Document doc = new Document();
		doc.add(new StringField("id", "Apache Lucene 5.5.0", Field.Store.YES));

		doc.add(new TextField("vorname", vorname, Field.Store.YES));
		doc.add(new TextField("name", name, Field.Store.YES));

		doc.add(new TextField("ort", org, Field.Store.YES));
		doc.add(new StringField("plz", plz, Field.Store.YES));
		w.addDocument(doc);
	}

	private static void addDoc(final IndexWriter writer, final String text) throws IOException {
		/*
		 * 4. add a sample document to the index
		 */
		final Document doc = new Document();

		// We add  an id field that is searchable, but doesn't trigger tokenization of the content
		final Field idField = new StringField("id", "Apache Lucene 5.0.0", Field.Store.YES);
		doc.add(idField);

		// Add the last big lucene version birthday which we don't want to store but to be indexed nevertheless to be filterable
		doc.add(new LongField("lastVersionBirthday", new GregorianCalendar(2015, 1, 20).getTimeInMillis(), Field.Store.NO));

		// !! Please due to licensing use your copy of release notes and add it to the project root folder:
		// http://lucene.apache.org/core/5_0_0/changes/Changes.html

		// final File bigFile = new FileFinder("CHANGES.txt").getFile();
		// The version info content should be searchable also be tokens, this is why we use a TextField; as we use a reader, the content is not stored!
		doc.add(new TextField("text", text, Field.Store.YES));

		if (writer.getConfig().getOpenMode() == OpenMode.CREATE) {
			// New index
			System.out.println("adding current lucene version with changelog info");
			writer.addDocument(doc);
		}
		else {
			// Existing index 
			System.out.println("updating index with current lucene version with changelog info");
			writer.updateDocument(new Term("id", "Apache Lucene 5.0.0"), doc);
		}
	}

	/**
	 * search the index
	 */
	private static void search(final String field, final String value) throws IOException, ParseException {
		/*
		 * 1. build an index reader and index searcher
		 */
		// final IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(PATH_TO_INDEX)));
		final IndexReader reader = DirectoryReader.open(index);
		final IndexSearcher searcher = new IndexSearcher(reader);

		/*
		 * 2. build an analyzer again - use the same as in the indexing process
		 */
		final Analyzer analyzer = new StandardAnalyzer();

		/*
		 * 3. Build a query parser who will parse our query, written in Lucene Query Language
		 */
		final QueryParser parser = new QueryParser(field, analyzer);

		/*
		 * 4. we search the value in a given field, e.g. "versioninfo:LUCENE-5945"
		 */
		final Query query = parser.parse(field + ":" + value);

		/*
		 * 5. we trigger the search, interested in the 5 first matches
		 */
		final TopDocs results = searcher.search(query, 10);

		/*
		 * 6. We get the hit information via the scoreDocs attribute in the TopDocs object
		 */
		final ScoreDoc[] hits = results.scoreDocs;
		final int numTotalHits = results.totalHits;
		System.out.println(numTotalHits + " total matching documents");

		if (hits.length > 0) {
			/*
			 * Matching score for the first document
			 */
			System.out.println("Matching score for first document: " + hits[0].score);

			for (final ScoreDoc hit : hits) {
				final Document doc = searcher.doc(hit.doc);
				System.out.print(doc.get("id"));
				System.out.print(" " + hit.score);
				System.out.print(" " + doc.get("text"));
				System.out.println();
			}
			/*
			 * We load the document via the doc id to be found in the ScoreDoc.doc attribute
			 */
			final Document doc = searcher.doc(hits[0].doc);
			System.out.println("Id of the document: " + doc.get("id"));
			System.out.println();
		}
	}

	private static void searchField(final String field, final String value) throws IOException, ParseException {
		final IndexReader reader = DirectoryReader.open(index);
		final IndexSearcher searcher = new IndexSearcher(reader);
		final Analyzer analyzer = new StandardAnalyzer();
		final QueryParser parser = new QueryParser(field, analyzer);
		final Query query = parser.parse(field + ":" + value);
		final TopDocs results = searcher.search(query, 10);

		final ScoreDoc[] hits = results.scoreDocs;
		final int numTotalHits = results.totalHits;
		System.out.println(numTotalHits + " total matching documents");

		if (hits.length > 0) {
			System.out.println("Matching score for first document: " + hits[0].score);

			for (final ScoreDoc hit : hits) {
				final Document doc = searcher.doc(hit.doc);
				System.out.print("Score:" + hit.score);
				System.out.print(" Ort:" + doc.get("ort") + " Name:" + doc.get("vorname") + " " + doc.get("name"));
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private static void searchMulti(final String value) throws IOException, ParseException {
		final IndexReader reader = DirectoryReader.open(index);
		final IndexSearcher searcher = new IndexSearcher(reader);
		final Analyzer analyzer = new StandardAnalyzer();
		final String[] fields = {"vorname", "name", "ort"};
		final QueryParser parser = new MultiFieldQueryParser(fields, analyzer);
		parser.setAllowLeadingWildcard(true);
		final Query query = parser.parse(value);
		final TopDocs results = searcher.search(query, 30);

		final ScoreDoc[] hits = results.scoreDocs;
		final int numTotalHits = results.totalHits;
		System.out.println(numTotalHits + " total matching documents");

		if (hits.length > 0) {
			System.out.println("Matching score for first document: " + hits[0].score);

			for (final ScoreDoc hit : hits) {
				final Document doc = searcher.doc(hit.doc);
				System.out.print("Score:" + hit.score);
				System.out.print(" Ort:" + doc.get("ort") + " Name:" + doc.get("vorname") + " " + doc.get("name"));
				System.out.println();
			}
			System.out.println();
		}
	}
	
}
