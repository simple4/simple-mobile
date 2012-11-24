package net.simpleframework.mobile.mvc.template;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.html.element.AbstractElement;

/**
 * 
 * @author hwz
 * 
 * @param <T>
 */
public class JmImg extends AbstractElement<JmImg> {
	private static final long serialVersionUID = 1L;

	private String style;
	private String src;

	public JmImg(final String src) {
		this.setSrc(src);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		final StringBuilder sb = new StringBuilder();
		sb.append("<img ");
		addattri(sb);
		sb.append(">");
		return sb.toString();
	}

	protected void addattri(final StringBuilder sb) {
		attri(sb, "id").attri(sb, "name").attri(sb, "className").attri(sb, "style").attri(sb, "src");
	}

	@Override
	protected JmImg attri(final StringBuilder sb, final String attri) {
		if ("style".equals(attri)) {
			final String style = getStyle();
			if (StringUtils.hasText(style)) {
				sb.append(" style=\"").append(style).append("\"");
			}
		} else if ("src".equals(attri)) {
			final String src = getSrc();
			if (StringUtils.hasText(src)) {
				sb.append(" src=\"").append(src).append("\"");
			}
		} else {
			super.attri(sb, attri);
		}
		return this;
	}

	@Override
	public JmImg setStyle(final String style) {
		this.style = style;
		return this;
	}

	@Override
	public String getStyle() {
		return style;
	}

	public JmImg setSrc(final String src) {
		this.src = src;
		return this;
	}

	public String getSrc() {
		return src;
	}
}
