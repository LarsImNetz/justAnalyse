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
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class LuceneClient {

	public static void main(final String[] args) throws IOException, ParseException {
		System.out.println("Indexing...");
		index();
		System.out.println();
		System.out.println("Searching for 'heute'");
		search("text", "heute");
		System.out.println("Searching with fuzzy 'meut~'");
		search("text", "meut~");
		System.out.println("Searching for \"heute gestern\" within 4 words");
		search("text", "\"heute gestern\"~4");
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

			addDoc(writer, "heute ist ein guter Tag");
			addDoc(writer, "heut nicht");
			addDoc(writer, "heute ist bescheidener Tag");
			addDoc(writer, "Ich habe heute nichts geschafft");
			addDoc(writer, "Lieber heute als morgen");
			addDoc(writer, "gestern ist heute morgen");
			addDoc(writer, "heute ist heute");
			addDoc(writer, "heute ist mir lieber als gestern");
			addDoc(writer, "heute sollte die Sonne scheinen");
			addDoc(writer, "heute ist eine Sendung im ZDF");
			addDoc(writer, "heute mal mit ganz viel Text, der völlig Sinnfrei ist, hauptsache viele Wörter mit heute.");
			addDoc(writer, "morgen ist gestern heute");
			addDoc(writer, "übermorgen ist morgen morgen");
			addDoc(writer, "vorgestern ist gestern gestern");
		}
		finally {
			if (writer != null) {
				writer.close();
			}
		}
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
}
