package net.simpleframework.mobile.mvc.component.ui.listview;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.simpleframework.common.coll.KVMap;
import net.simpleframework.common.script.MVEL2Template;
import net.simpleframework.mobile.mvc.component.base.jqajax.JmAjaxRequestBean;
import net.simpleframework.mvc.component.AbstractComponentRender.ComponentHtmlRender;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ComponentRenderUtils;
import net.simpleframework.mvc.component.ComponentUtils;
import net.simpleframework.mvc.component.IComponentRegistry;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @title Listview1Render.java
 * @package net.simpleframework.mobile.mvc.component.ui.listview
 * @description TODO(列表视图渲染类)
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-9-3 下午7:12:18
 * @version 0.0.1
 */

public class ListviewRender extends ComponentHtmlRender {

	public ListviewRender(final IComponentRegistry componentRegistry) {
		super(componentRegistry);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getHtmlJavascriptCode(final ComponentParameter cParameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHtml(final ComponentParameter cParameter) {
		// TODO Auto-generated method stub
		try {
			return render(cParameter, super.getHtml(cParameter));

		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (this.getResponseUrl(cParameter));
	}

	public static String render(final ComponentParameter cParameter, final String text)
			throws IOException {
		final ListviewBean listviewBean = (ListviewBean) cParameter.componentBean;
		final KVMap variables = new KVMap();

		if (cParameter.getComponentHandler() instanceof IListviewHandler) {
			final IListviewHandler lHandle = (IListviewHandler) cParameter.getComponentHandler();
			if (lHandle != null) {// 获得动态数据
				listviewBean.setItems(lHandle.getItems(cParameter));
			}
		}

		variables.put("actionFunc", ComponentRenderUtils.actionFunc(cParameter));
		variables.put("listviewBean", listviewBean);
		// variables.put("bean_id", AbstractRequestUtils.BEAN_ID);
		variables.put("hashId", listviewBean.hashId());
		variables
				.put("resourceHomePath", ComponentUtils.getResourceHomePath(JmAjaxRequestBean.class));
		String html = MVEL2Template.replace(variables, text);
		html = trimblankline(html);
		// System.out.println(html);
		return html;
	}

	public static String trimblankline(final String str) {
		final Pattern p = Pattern.compile("\n[\\s| ]*\r");
		final Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	@Override
	protected String getRelativePath(final ComponentParameter cParameter) {
		// TODO Auto-generated method stub
		return "/html/" + this.getClass().getSimpleName() + ".html";
	}

}
