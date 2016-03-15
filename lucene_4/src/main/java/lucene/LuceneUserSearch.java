package lucene;

import java.io.IOException;
import java.text.ParseException;

import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public class LuceneUserSearch {

	public static void main(final String[] args) throws IOException, ParseException {
		// 0. Specify the analyzer for tokenizing text.
		//    The same analyzer should be used for indexing and searching
		final GermanAnalyzer analyzer = new GermanAnalyzer(Version.LUCENE_40);

		// 1. create the index
		final Directory index = new RAMDirectory();

		final IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);

		final IndexWriter w = new IndexWriter(index, config);
		addDoc(w, "Lars Langhans", "Lübeck", "23566");
		addDoc(w, "Anja Langhans", "Lübeck", "23566");
		addDoc(w, "Gundula Langhans", "Lübeck", "23560");
		addDoc(w, "Christa Scheel", "Lübeck", "23558");
		addDoc(w, "Marina Diekmann", "Lübeck Kücknitz", "23569");

		addDoc(w, "Steffen Grund", "Hamburg", "20097");
		addDoc(w, "Christoph Neumann", "Lüneburg", "21335");
		addDoc(w, "Andreas Illi", "Bad Schwartau", "23611");
		addDoc(w, "Stephan Elsner", "Stockelsdorf", "23617");
		w.close();

		// 2. query
		final String querystr = args.length > 0 ? args[0] : "lübeck";
		System.out.println("Querystring: " + querystr);
		// the "title" arg specifies the default field to use
		// when no field is explicitly specified in the query.
		Query qp = null;
		try {
			// q = new QueryParser(Version.LUCENE_40, "name", analyzer).parse(querystr);
			final String[] fields = {"name", "ort", "plz"};
			final String[] queries = {"<text>","<text>","<text>"};
			qp = MultiFieldQueryParser.parse(Version.LUCENE_40, queries, fields, analyzer);
		} catch (final Exception e) {
			e.printStackTrace();
		}

		// 3. search
		final int hitsPerPage = 10;
		final IndexReader reader = DirectoryReader.open(index);
		final IndexSearcher searcher = new IndexSearcher(reader);
		final TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
		try {
			// final Query q = qp.parse("<text>");
			searcher.search(qp, collector);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		final ScoreDoc[] hits = collector.topDocs().scoreDocs;

		// 4. display results
		System.out.println("Found " + hits.length + " hits.");
		for (int i = 0; i < hits.length; ++i) {
			final int docId = hits[i].doc;
			final Document document = searcher.doc(docId);
			System.out.println((i + 1) + ". " + document.get("ort") + "\t" + document.get("plz") +"\t" + document.get("name"));
		}

		// reader can only be closed when there
		// is no need to access the documents any more.
		reader.close();
	}

	private static void addDoc(final IndexWriter w, final String title, final String org, final String plz) throws IOException {
		final Document doc = new Document();
		doc.add(new TextField("name", title, Field.Store.YES));

		// use a string field for isbn because we don't want it tokenized
		doc.add(new StringField("ort", org, Field.Store.YES));
		doc.add(new StringField("plz", plz, Field.Store.YES));
		w.addDocument(doc);
	}
}