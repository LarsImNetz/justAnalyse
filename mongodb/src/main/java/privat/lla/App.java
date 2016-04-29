package privat.lla;

import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * Mongo Read Access
 *
 */
public class App {

	public static void main(final String[] args) throws Exception {

		/*
		 * MongoDB Example entnommen:
		 * http://www.mkyong.com/mongodb/java-mongodb-hello-world-example/
		 */
		/*
		 * 3. Mongo Connection
		 */
		// Old version, uses Mongo
		// final Mongo mongo = new Mongo("rzsolv163.rz-hypoport.local", 27000);

		// Since 2.10.0, uses MongoClient
		final MongoClient mongo = new MongoClient("solv262.hypoport.local", 27000);
		// final MongoClient mongo = new MongoClient("rzsolv163.rz-hypoport.local", 27000);

		/*
		 * Mongo Database
		 */
		final DB db = mongo.getDB("baushup-antrag-QA");

		/*
		 * List all Databases
		 */
		System.out.println("Zeige alle Datenbank-Namen");
		final List<String> dbs = mongo.getDatabaseNames();
		for (final String db1 : dbs) {
			System.out.println(db1);
		}
		/*
		 * Mongo Collection
		 */
		// final DB db2 = mongo.getDB("baushup-antrag-test");
		final DBCollection table = db.getCollection("user");
		/*
		 * Display all Collections
		 */
		// final DB db3 = mongo.getDB("testdb");
		final Set<String> tables = db.getCollectionNames();
		System.out.println("Collection Names");
		for (final String coll : tables) {
			System.out.println(coll);
		}

		// from interest:
		// {"bauobjekt": {"ort": {"plz": plz, "ort": ort}}}

		System.out.println("baugeld Content");
		final DBCollection baugeldCollection = db.getCollection("baugeld");
		final DBCursor cursor = baugeldCollection.find();
		// final List<DBObject> dbobjects = cursor.toArray();

		while (cursor.hasNext()) {
			final DBObject next = cursor.next();
			show(next);
			// System.out.println(next.toString());
		}
		cursor.close();
		mongo.close();
		/*
		 * DBCollection table = db.getCollection("user");
		 * BasicDBObject document = new BasicDBObject();
		 * // document.put("name", "mkyong");
		 * document.put("age", 30);
		 * document.put("createdDate", new Date());
		 * table.insert(document);
		 */
	}

	private static void show(final DBObject obj) {
		final boolean containsField = obj.containsField("bauobjekt");
		if (containsField) {
			System.out.println("enthält: bauobjekt");
			final BasicDBObject bauobjekt = (BasicDBObject) obj.get("bauobjekt");
			final DBObject ort = (DBObject) bauobjekt.get("ort");
			if (ort != null) {
				System.out.println(ort.toString());
			}
		}
	}
}
