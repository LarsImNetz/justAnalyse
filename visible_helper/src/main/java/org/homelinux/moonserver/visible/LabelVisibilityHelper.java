package org.homelinux.moonserver.visible;

import java.util.StringTokenizer;

import org.apache.wicket.Component;
import org.apache.wicket.Session;
import org.homelinux.moonserver.HomePage;
import org.homelinux.moonserver.bean.Bean;

public class LabelVisibilityHelper implements ILabelVisibilityHelper {

	@Override
	public boolean isVisible() {
		Bean bean = getBean();
		if (bean == null) {
			return false;
		}
		int countWords = countWords(bean.getA());
		if (countWords % 2 == 0) {
			return true;
		}
		return false;
	}

	public Bean getBean(/*Component component*/) {
//		if (component == null) {
//			throw new IllegalArgumentException("Componente nicht gegeben.");
//		}
		Session session = Session.get(); // component.getSession();
		if (session == null) {
			throw new IllegalArgumentException("Session nicht gegeben.");
		}
		Object object = session.getAttribute(HomePage.GLOBAL_BEAN);
		if (object instanceof Bean) {
			final Bean bean = (Bean) object;
			return bean;
		}
		return null;
	}

	public int countWords(String a) {
		if (a == null) {
			return 0;
		}
		StringTokenizer token = new StringTokenizer(a, " ");
		int count = token.countTokens();
		return count;
	}

}
