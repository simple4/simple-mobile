package net.simpleframework.mobile.mvc.template;

import java.util.ArrayList;
import java.util.List;

import net.simpleframework.common.html.element.AbstractElement;

@SuppressWarnings("unchecked")
public class JmFieldset extends AbstractElement<JmFieldset> {
	private static final long serialVersionUID = 1L;

	private List objects;

	public JmFieldset append(final Object obj) {
		if (null == objects) {
			objects = new ArrayList();
		}
		objects.add(obj);
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("<fieldset data-role=\"controlgroup\" ");
		addattri(sb);
		sb.append(">").append(Objects()).append("</fieldset>");
		return sb.toString();
	}

	protected void addattri(final StringBuilder sb) {
		attri(sb, "id").attri(sb, "className").attri(sb, "style");
	}

	private String Objects() {
		if (null == objects || objects.size() == 0) {
			return "";
		}
		final StringBuilder sb = new StringBuilder();
		final int n = objects.size();
		for (int i = 0; i < n; i++) {
			sb.append(objects.get(i));
		}
		return sb.toString();
	}
}
