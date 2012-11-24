package net.simpleframework.mobile.mvc.component.ui.listview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.simpleframework.common.NotImplementedException;
import net.simpleframework.common.xml.AbstractElementBean;
import net.simpleframework.common.xml.XmlElement;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @title Item.java
 * @package net.simpleframework.mobile.mvc.component
 * @description TODO(列表项bean)
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-9-6 下午12:59:54
 * @version 0.0.1
 */

public class ItemBean extends AbstractElementBean {

	public static final String DIVIDER_ROLE = "list-divider";

	public ItemBean(final XmlElement beanElement) {
		super(beanElement);
		enableAttrEx();
		// TODO Auto-generated constructor stub
	}

	public ItemBean(final String text) {
		super(null);
		this.text = text;
		enableAttrEx();
		// TODO Auto-generated constructor stub
	}

	private String text;

	public Map<String, Object> attrEx;

	public String getText() {
		return text;
	}

	public ItemBean setText(final String text) {
		this.text = text;
		return this;
	}

	public ItemBean setAttrEx(final String key, final Object value) {
		// TODO Auto-generated method stub
		if (attrEx == null) {
			throw NotImplementedException.of(getClass(), "enableAttrEx");
		}
		if (value == null) {
			removeAttrEx(key);
		} else {
			attrEx.put(key, value);
		}
		return this;
	}

	public Object removeAttrEx(final String key) {
		return attrEx != null ? attrEx.remove(key) : null;
	}

	public void enableAttrEx() {
		attrEx = new ConcurrentHashMap<String, Object>();
	}

	public Map<String, Object> getAttrEx() {
		return attrEx;
	}

	public Object getAttrEx(final String key) {
		return attrEx != null ? attrEx.get(key) : null;
	}

	public static enum Divider {
		role, // list-divider
		filtertext, // 过滤字段

	}

	public static enum Button {

		href, // 超链接

		transition, // 转场效果

		bubble_Text, // 泡泡内容

		onclick, // 按钮事件

		icon, // 图标

		theme, // 样式

		imgsrc, // 图

		splithref, // 分隔导航

	}

}
