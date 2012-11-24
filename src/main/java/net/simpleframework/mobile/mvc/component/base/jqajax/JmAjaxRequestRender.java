package net.simpleframework.mobile.mvc.component.base.jqajax;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.simpleframework.common.ClassUtils;
import net.simpleframework.common.IoUtils;
import net.simpleframework.common.coll.KVMap;
import net.simpleframework.common.script.MVEL2Template;
import net.simpleframework.mvc.MVCContextFactory;
import net.simpleframework.mvc.component.AbstractComponentRender.ComponentJavascriptRender;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ComponentRenderUtils;
import net.simpleframework.mvc.component.ComponentUtils;
import net.simpleframework.mvc.component.IComponentRegistry;

/**
 * 
 * @description TODO(异步请求js渲染)
 * @version 0.0.1
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-23 下午3:48:48
 */
public class JmAjaxRequestRender extends ComponentJavascriptRender {
	public JmAjaxRequestRender(final IComponentRegistry componentRegistry) {
		super(componentRegistry);
	}

	@Override
	public String getJavascriptCode(final ComponentParameter compParameter) {
		try {
			return render(compParameter);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 渲染js
	 * 
	 * @param compParameter
	 * @return
	 */
	public String render(final ComponentParameter compParameter) throws IOException {
		final JmAjaxRequestBean jqajaxBean = (JmAjaxRequestBean) compParameter.componentBean;
		final KVMap variables = new KVMap();

		final InputStream inputStream = getRender(JmAjaxRequestRender.class, ".txt");
		variables.put("actionFunc", ComponentRenderUtils.actionFunc(compParameter));
		variables.put("ajaxRequestBean", jqajaxBean);
		variables.put("bean_id", AbstractRequestUtils.BEAN_ID);
		variables.put("hashId", jqajaxBean.hashId());
		variables
				.put("resourceHomePath", ComponentUtils.getResourceHomePath(JmAjaxRequestBean.class));
		final String js = inputStream == null ? "" : MVEL2Template.replace(variables,
				IoUtils.getStringFromInputStream(inputStream, MVCContextFactory.config().getCharset()));
		return trimblankline(js);
	}

	public static InputStream getRender(final Class<?> resourceClass, final String filename) {
		//
		return ClassUtils.getResourceAsStream(resourceClass,
				filename.startsWith(".") ? resourceClass.getSimpleName() + filename : filename);
		// return
		// ClassUtils.getResourceAsStream(DeployUtils.getResourcePath(resourceClass)+"/"+resourceClass.getSimpleName()+filename);
	}

	public static String trimblankline(final String str) {
		final Pattern p = Pattern.compile("\n[\\s| ]*\r");
		final Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
}
