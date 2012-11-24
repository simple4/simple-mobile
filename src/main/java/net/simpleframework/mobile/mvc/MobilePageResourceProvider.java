package net.simpleframework.mobile.mvc;

import net.simpleframework.mvc.IPageResourceProvider.AbstractPageResourceProvider;
import net.simpleframework.mvc.MVCUtils;
import net.simpleframework.mvc.PageParameter;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。 手机页面资源提供类
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class MobilePageResourceProvider extends AbstractPageResourceProvider {

	public final static String MOBILE_PAGE_RESOURCE_PROVIDER = "jq-mobile";

	@Override
	public String getName() {
		return MOBILE_PAGE_RESOURCE_PROVIDER;
	}

	@Override
	public String[] getCssPath(final PageParameter pParameter) {
		return new String[] { getCssResourceHomePath(pParameter)
				+ "/jquery.mobile-1.2.0-beta.1.min.css" };
	}

	@Override
	public String[] getJavascriptPath(final PageParameter pParameter) {
		final String rPath = getResourceHomePath();

		return new String[] { MVCUtils.getPageResourcePath() + "/js/core.js",
				rPath + "/js/jquery-1.8.1.min.js", rPath + "/js/jquery.mobile-1.2.0-beta.1.min.js" };
		// return new String[] { MVCUtils.getPageResourcePath() + "/js/core.js",
		// rPath + "/js/jquery-1.7.2.js", rPath + "/js/jquery.mobile-1.1.1.js",
		// rPath + "/js/jquery.nano.js" };
	}

	@Override
	public String getInitJavascriptCode(final PageParameter pParameter) {
		return null;
	}
}
