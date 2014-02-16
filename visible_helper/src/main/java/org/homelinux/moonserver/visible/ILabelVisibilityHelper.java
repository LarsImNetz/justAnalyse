package org.homelinux.moonserver.visible;

import org.apache.wicket.Component;
import org.homelinux.moonserver.bean.Bean;

public interface ILabelVisibilityHelper extends IVisibilityHelper {

	int countWords(String text);
	Bean getBean(Component component);
}
