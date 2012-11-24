package net.simpleframework.mobile.mvc.template;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.ArrayUtils;
import net.simpleframework.common.html.element.AbstractElement;

/**
 * 
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @description TODO(jqmobile 按钮)
 * @version 4.0
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-27 下午12:19:10
 */
@SuppressWarnings("unchecked")
public class JmLink<T extends JmLink<T>> extends AbstractElement<T> {
	/**
	 * @fields serialVersionUID
	 * @author shihb
	 * @update 2012-8-27 下午12:20:29
	 */

	private static final long serialVersionUID = 1L;

	private boolean disabled;// 是否可用

	private String href;// 超链接

	private Boolean ajax;// 是否异步加载

	private String direction;// 转场效果

	private Boolean cache;// 是否缓存

	private Boolean prefetch;// 预提取

	private String rel; // 显示方式

	private String transition;// 转场过渡

	public JmLink(final String text, final String href) {
		setText(text);
		setHref(href);
	}

	protected String tagStart() {
		// TODO Auto-generated method stub
		final StringBuilder sb = new StringBuilder();
		sb.append("<a ");

		addattri(sb);

		sb.append(">");
		return sb.toString();
	}

	protected void addattri(final StringBuilder sb) {
		attri(sb, "id").attri(sb, "name").attri(sb, "className");
		if (!isDisabled()) {
			attri(sb, "onclick").attri(sb, "href").attri(sb, "ajax").attri(sb, "cache")
					.attri(sb, "prefetch").attri(sb, "direction").attri(sb, "transition")
					.attri(sb, "rel");
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		final StringBuilder sb = new StringBuilder();
		sb.append(tagStart());
		sb.append(getText());
		sb.append("</a>");
		return sb.toString();
	}

	@Override
	protected T attri(final StringBuilder sb, final String attri) {
		// TODO Auto-generated method stub
		if ("className".equals(attri)) {
			final String className = className();
			if (StringUtils.hasText(className)) {
				sb.append(" class=\"").append(className).append("\"");
			}
		} else if ("href".equals(attri)) {
			final String href = getHref();
			if (StringUtils.hasText(href)) {
				sb.append(" href=\"").append(href).append("\"");
			}
		} else if ("ajax".equals(attri)) {
			final Boolean ajax = getAjax();
			if (ajax != null) {
				sb.append(" data-ajax=").append(ajax.booleanValue());
			}
		} else if ("cache".equals(attri)) {
			final Boolean cache = getCache();
			if (cache != null) {
				sb.append(" data-dom-cache=").append(cache.booleanValue());
			}
		} else if ("prefetch".equals(attri)) {
			final Boolean prefetch = getPrefetch();
			if (prefetch != null) {
				sb.append(" data-prefetch=").append(prefetch.booleanValue());
			}
		} else if ("rel".endsWith(attri)) {
			final String rel = getRel();
			if (StringUtils.hasText(rel)) {
				sb.append(" data-rel=\"").append(rel).append("\"");
			}
		} else if ("direction".endsWith(attri)) {
			final String direction = getDirection();
			if (StringUtils.hasText(direction)) {
				sb.append(" data-direction=\"").append(direction).append("\"");
			}
		} else if ("transition".endsWith(attri)) {
			final String transition = getTransition();
			if (StringUtils.hasText(transition)) {
				sb.append(" data-transition=\"").append(transition).append("\"");
			}
		} else {
			super.attri(sb, attri);
		}

		return (T) this;
	}

	@Override
	public boolean isDisabled() {
		return disabled;
	}

	@Override
	public T setDisabled(final boolean disabled) {
		this.disabled = disabled;
		return (T) this;
	}

	public String getHref() {
		return href;
	}

	public T setHref(final String href) {
		this.href = href;
		return (T) this;
	}

	public String getTransition() {
		return transition;
	}

	public T setTransition(final String transition) {
		this.transition = transition;
		return (T) this;
	}

	public Boolean getAjax() {
		return ajax;
	}

	public T setAjax(final Boolean ajax) {
		this.ajax = ajax;
		return (T) this;
	}

	public String getDirection() {
		return direction;
	}

	public T setDirection(final String direction) {
		this.direction = direction;
		return (T) this;
	}

	public Boolean getCache() {
		return cache;
	}

	public T setCache(final Boolean cache) {
		this.cache = cache;
		return (T) this;
	}

	public Boolean getPrefetch() {
		return prefetch;
	}

	public T setPrefetch(final Boolean prefetch) {
		this.prefetch = prefetch;
		return (T) this;
	}

	public String getRel() {
		return rel;
	}

	public T setRel(final String rel) {
		this.rel = rel;
		return (T) this;
	}

	/**
	 * 
	 * @description TODO(转场过渡动画)
	 * @version 4.0
	 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
	 *         http://code.google.com/p/simpleframework/
	 *         http://www.simpleframework.net
	 * @update 2012-8-27 下午3:25:49
	 */
	public static enum Transition {
		none, fade, pop, flip, turn, flow, slidefade, slide, slideup, slidedown
	}

	/**
	 * 
	 * @description TODO(转场过渡)
	 * @version 4.0
	 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
	 *         http://code.google.com/p/simpleframework/
	 *         http://www.simpleframework.net
	 * @update 2012-8-27 下午6:00:33
	 */
	public static enum Direction {
		reverse// 翻转页面转场效果
	}

	/**
	 * 
	 * @description TODO(显示方式)
	 * @version 4.0
	 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
	 *         http://code.google.com/p/simpleframework/
	 *         http://www.simpleframework.net
	 * @update 2012-8-27 下午6:09:49
	 */
	public static enum rel {
		back, // 后退到上一个历史的记录的页面
		dialog, // 打开对话框，不记录进历史记录中
		external, // for linking to another domain
	}

	@Override
	protected String className(final String... classNames) {
		String[] nClassNames = classNames;
		if (isDisabled()) {
			nClassNames = nClassNames != null ? (String[]) ArrayUtils.add(nClassNames,
					"disabled_color") : new String[] { "disabled_color" };
		}
		return super.className(nClassNames);
	}

}
