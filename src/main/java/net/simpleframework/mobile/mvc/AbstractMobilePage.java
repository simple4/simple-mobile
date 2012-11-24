package net.simpleframework.mobile.mvc;

import net.simpleframework.common.ClassUtils;
import net.simpleframework.mobile.mvc.component.base.jqajax.DefaultJmAjaxRequestHandler;
import net.simpleframework.mobile.mvc.component.base.jqajax.JmAjaxRequestBean;
import net.simpleframework.mvc.AbstractMVCPage;
import net.simpleframework.mvc.AbstractMVELTemplatePage;
import net.simpleframework.mvc.IForward;
import net.simpleframework.mvc.IPageResourceProvider;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.PageResourceProviderRegistry;
import net.simpleframework.mvc.component.AbstractComponentBean;
import net.simpleframework.mvc.component.ComponentHandleException;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.IComponentHandler;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。 抽象手机页面类
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class AbstractMobilePage extends AbstractMVELTemplatePage {

	static {
		PageResourceProviderRegistry.get().registered(new MobilePageResourceProvider());
		System.setProperty(IPageResourceProvider.DEFAULT_PAGERESOURCE_PROVIDER,
				MobilePageResourceProvider.class.getName());
	}

	protected JmAjaxRequestBean addJqajaxRequest(final PageParameter pParameter, final String name) {
		return (JmAjaxRequestBean) addComponentBean(pParameter, name, JmAjaxRequestBean.class)
				.setHandleClass(getClass());
	}

	@Override
	public IComponentHandler createComponentHandler(final AbstractComponentBean componentBean) {
		if (componentBean instanceof JmAjaxRequestBean) {
			return new JmAjaxRequest();
		}
		return null;
	}

	public static class JmAjaxRequest extends DefaultJmAjaxRequestHandler {

		@Override
		@SuppressWarnings("unchecked")
		public IForward ajaxProcess(final ComponentParameter cParameter) {
			try {
				final JmAjaxRequestBean ajaxRequestBean = (JmAjaxRequestBean) cParameter.componentBean;
				final Class<AbstractMVCPage> handleClass = (Class<AbstractMVCPage>) ClassUtils
						.forName(ajaxRequestBean.getHandleClass());
				return (IForward) handleClass.getMethod(ajaxRequestBean.getHandleMethod(),
						ComponentParameter.class).invoke(AbstractMVCPage.get(cParameter), cParameter);
			} catch (final Exception e) {
				throw ComponentHandleException.of(e);
			}
		}
	}

}
