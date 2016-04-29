package privat.lla;

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

	public static void main(final String[] args) {

		/*
		 * MongoDB Example entnommen:
		 * http://www.mkyong.com/mongodb/java-mongodb-hello-world-example/
		 */

		/*
		 * 3. Mongo Connection
		 * Since 2.10.0, uses MongoClient
		 */
		MongoClient mongo = null;
		try {
			mongo = new MongoClient("solv262.hypoport.local", 27000);
			// final MongoClient mongo = new MongoClient("rzsolv163.rz-hypoport.local", 27000);

			/*
			 * Mongo Database
			 */
			final DB db = mongo.getDB("baushup-antrag-QA");

			// from interest:
			// {"bauobjekt": {"ort": {"plz": plz, "ort": ort}}}

			System.out.println("baugeld Content");
			final DBCollection baugeldCollection = db.getCollection("baugeld");
			final DBCursor cursor = baugeldCollection.find();

			while (cursor.hasNext()) {
				final DBObject next = cursor.next();
				show(next);
			}
			cursor.close();
			mongo.close();
		}
		catch (final Exception e) {

		}
		finally {
			mongo.close();
		}
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
