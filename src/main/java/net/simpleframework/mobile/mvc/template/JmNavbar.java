package net.simpleframework.mobile.mvc.template;

import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

import net.simpleframework.common.ObjectUtils;
import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.ArrayListEx;
import net.simpleframework.common.web.HttpUtils;
import net.simpleframework.mvc.PageRequestResponse;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @title JmNavbar.java
 * @package net.simpleframework.mobile.mvc.template
 * @description TODO(导航条)
 * @author shihb
 * @update 2012-8-28 下午12:00:33
 * @version 4.0
 */
public class JmNavbar extends ArrayListEx<JmNavbar, JmButton> {

	public static JmNavbar of(final JmButton... btns) {
		return of(0, btns);
	}

	public static JmNavbar of(final int defaultIndex, final JmButton... btns) {
		return new JmNavbar(defaultIndex).append(btns);
	}

	private int defaultIndex = 0;

	private String iconpos;

	private JmNavbar(final int defaultIndex) {
		this.defaultIndex = defaultIndex;
	}

	public String getIconpos() {
		return iconpos;
	}

	public JmNavbar setIconpos(final String iconpos) {
		this.iconpos = iconpos;
		return this;
	}

	public String toString(final PageRequestResponse rRequest) {
		final StringBuilder sb = new StringBuilder();
		sb.append("<div ").append(" data-role=\"navbar\" ");
		attri(sb, "id").attri(sb, "iconpos");
		sb.append("/>").append("<ul>");
		final String requestURI = HttpUtils.getRequestAndQueryStringUrl(rRequest.request);
		for (int i = 0; i < size(); i++) {
			final JmButton tab = get(i);
			final boolean match = match(rRequest, tab, requestURI);
			if (match) {
				defaultIndex = i;
				break;
			}
		}
		for (int i = 0; i < size(); i++) {
			final JmButton tab = get(i);
			tab.setClassName(i == defaultIndex ? "ui-btn-active ui-state-persist" : null);
			sb.append("<li>").append(tab).append("</li>");
		}
		sb.append("</ul></div>");
		return sb.toString();
	}

	protected JmNavbar attri(final StringBuilder sb, final String attri) {
		if ("id".equals(attri)) {
			final String id = UUID.randomUUID().toString();
			if (StringUtils.hasText(id)) {
				sb.append(" id=\"").append(id).append("\"");
			}
		} else if ("iconpos".equals(attri)) {
			final String iconpos = getIconpos();
			if (StringUtils.hasText(iconpos)) {
				sb.append(" data-iconpos=\"").append(iconpos).append("\"");
			}
		}
		return this;

	}

	/**
	 * 
	 * @param rRequest
	 * @param tab
	 * @param requestURI
	 * @return Blean
	 * @description TODO(是否是选中项)
	 * @author shihb
	 * @update 2012-8-28 下午2:22:32
	 */
	private boolean match(final PageRequestResponse rRequest, final JmButton tab, String requestURI) {
		Map<String, String> params = null, params2 = null;
		int pos = requestURI.indexOf("?");
		if (pos > -1) {
			params = HttpUtils.toQueryParams(requestURI.substring(pos + 1));
			requestURI = requestURI.substring(0, pos);
		}
		String href = tab.getHref();
		pos = href.indexOf("?");
		if (pos > -1) {
			params2 = HttpUtils.toQueryParams(href.substring(pos + 1));
			href = href.substring(0, pos);
		}
		if (params != null && params2 != null) {
			final HashSet<String> keys = new HashSet<String>();
			keys.addAll(params.keySet());
			keys.addAll(params2.keySet());
			for (final String key : keys) {
				// 如果两者都有相同的参数且不相等，则认为是不能匹配
				if (params.containsKey(key) && params2.containsKey(key)
						&& !ObjectUtils.objectEquals(params.get(key), params2.get(key))) {
					return false;
				}
			}
		}
		requestURI = HttpUtils.stripJSessionId(requestURI);
		requestURI = HttpUtils.stripContextPath(rRequest.request, requestURI);

		href = HttpUtils.stripContextPath(rRequest.request, href);

		return requestURI.equals(href);
	}

	/**
	 * @fields serialVersionUID
	 * @author shihb
	 * @update 2012-8-28 下午12:07:57
	 */

	private static final long serialVersionUID = -5041659479873430548L;

}
