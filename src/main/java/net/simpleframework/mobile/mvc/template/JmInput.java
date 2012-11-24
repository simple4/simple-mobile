package net.simpleframework.mobile.mvc.template;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.html.element.AbstractElement;

@SuppressWarnings("unchecked")
public class JmInput<T extends JmInput<T>> extends AbstractElement<T> {
	private static final long serialVersionUID = 1L;

	private String value;
	private String type;

	public JmInput(final Type type, final String name) {
		this.setType(type.name());
		this.setName(name);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		final StringBuilder sb = new StringBuilder();
		sb.append("<input ");
		addattri(sb);
		sb.append(">");
		return sb.toString();
	}

	protected void addattri(final StringBuilder sb) {
		attri(sb, "id").attri(sb, "name").attri(sb, "className").attri(sb, "type").attri(sb, "value");
	}

	@Override
	protected T attri(final StringBuilder sb, final String attri) {
		if ("value".equals(attri)) {
			final String value = getValue();
			if (StringUtils.hasText(value)) {
				sb.append(" value=\"").append(value).append("\"");
			}
		} else if ("type".equals(attri)) {
			final String type = getType();
			if (StringUtils.hasText(type)) {
				sb.append(" type=\"").append(type).append("\"");
			}
		} else {
			super.attri(sb, attri);
		}
		return (T) this;
	}

	public T setType(final String type) {
		this.type = type;
		return (T) this;
	}

	public String getType() {
		return type;
	}

	public T setValue(final String value) {
		this.value = value;
		return (T) this;
	}

	public String getValue() {
		return value;
	}

	public static enum Type {
		text, password, radio, checkbox, search
	}
}
