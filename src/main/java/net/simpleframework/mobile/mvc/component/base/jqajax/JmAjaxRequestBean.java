package net.simpleframework.mobile.mvc.component.base.jqajax;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.xml.XmlElement;
import net.simpleframework.mvc.PageDocument;
import net.simpleframework.mvc.component.AbstractComponentBean;

/**
 * 
 * @description TODO(异步bean)
 * @version 0.0.1
 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 * @update 2012-8-23 下午3:49:56
 */
public class JmAjaxRequestBean extends AbstractComponentBean {

	private String handleMethod;// 后台操作方法

	private String encoding;// 编码

	private String updateContainerId; // html中需要一部更新部分的id,例如ajaxDemo1,

	private boolean updateContainerCache;// js是否缓存这部门更新内容

	private String confirmMessage;// 操作前提示方法 变了参数通过map.get(key)获得

	private EThrowException throwException;// 抛出异常

	private boolean showLoading = true, // 是否显示装载进度（右上角显示），默认为true 待处理

			parallel = false,// 后台开辟新线程

			disabledTriggerAction = true;// 当组件被调用时，是否禁止调用元素，默认为true，目的是防止被多次调用 待处理

	private String jsCompleteCallback;// 回调方法javascript内容

	private String cbDataName = "data";// 回调方法存放数据名称

	private String handleBefore;// 操作之前加入javascript操作

	private String urlForward;// 返回HTML，构造时需传递url地址

	private String ajaxRequestId;// 异步请求id如:$Actions['ajaxDemo2']

	// private String jobExecute; 权限待定

	private String formSelector;// 表单选择器

	private String role;// 角色

	public JmAjaxRequestBean(final PageDocument pageDocument, final XmlElement xmlElement) {
		super(pageDocument, xmlElement);
		setRunImmediately(false);
	}

	public String getHandleMethod() {
		return handleMethod;
	}

	public JmAjaxRequestBean setHandleMethod(final String handleMethod) {
		this.handleMethod = handleMethod;
		return this;
	}

	public boolean isUpdateContainerCache() {
		return updateContainerCache;
	}

	public JmAjaxRequestBean setUpdateContainerCache(final boolean updateContainerCache) {
		this.updateContainerCache = updateContainerCache;
		return this;
	}

	public String getEncoding() {
		return encoding;
	}

	public JmAjaxRequestBean setEncoding(final String encoding) {
		this.encoding = encoding;
		return this;
	}

	public boolean isShowLoading() {
		return showLoading;
	}

	public JmAjaxRequestBean setShowLoading(final boolean showLoading) {
		this.showLoading = showLoading;
		return this;
	}

	public boolean isParallel() {
		return parallel;
	}

	public JmAjaxRequestBean setParallel(final boolean parallel) {
		this.parallel = parallel;
		return this;
	}

	public boolean isDisabledTriggerAction() {
		return disabledTriggerAction;
	}

	public JmAjaxRequestBean setDisabledTriggerAction(final boolean disabledTriggerAction) {
		this.disabledTriggerAction = disabledTriggerAction;
		return this;
	}

	public String getUrlForward() {
		return urlForward;
	}

	public JmAjaxRequestBean setUrlForward(final String urlForward) {
		this.urlForward = urlForward;
		return this;
	}

	public String getConfirmMessage() {
		return confirmMessage;
	}

	public JmAjaxRequestBean setConfirmMessage(final String confirmMessage) {
		this.confirmMessage = confirmMessage;
		return this;
	}

	// public EThrowException getThrowException() {
	// return throwException == null ? EThrowException.window : throwException;
	// }

	public JmAjaxRequestBean setThrowException(final EThrowException throwException) {
		this.throwException = throwException;
		return this;
	}

	public String getUpdateContainerId() {
		return updateContainerId;
	}

	public JmAjaxRequestBean setUpdateContainerId(final String updateContainerId) {
		this.updateContainerId = updateContainerId;
		return this;
	}

	public String getJsCompleteCallback() {
		return jsCompleteCallback;
	}

	public JmAjaxRequestBean setJsCompleteCallback(final String jsCompleteCallback) {
		this.jsCompleteCallback = jsCompleteCallback;
		return this;
	}

	public String getAjaxRequestId() {
		return ajaxRequestId;
	}

	public JmAjaxRequestBean setAjaxRequestId(final String ajaxRequestId) {
		this.ajaxRequestId = ajaxRequestId;
		return this;
	}

	public String getRole() {
		return role;
	}

	public JmAjaxRequestBean setRole(final String role) {
		this.role = role;
		return this;
	}

	@Override
	public String getHandleClass() {
		final String handleClass = super.getHandleClass();
		if (StringUtils.hasText(getUrlForward())) {
			setHandleMethod("doUrlForward");
			if (!StringUtils.hasText(handleClass)) {
				return DefaultJmAjaxRequestHandler.class.getName();
			}
		}
		return handleClass;
	}

	@Override
	protected String[] elementAttributes() {
		return new String[] { "confirmMessage", "jsCompleteCallback", "urlForward" };
	}

	public String getCbDataName() {
		return cbDataName;
	}

	public JmAjaxRequestBean setCbDataName(final String cbDataName) {
		this.cbDataName = cbDataName;
		return this;
	}

	public String getHandleBefore() {
		return handleBefore;
	}

	public JmAjaxRequestBean setHandleBefore(final String handleBefore) {
		this.handleBefore = handleBefore;
		return this;
	}

	public String getFormSelector() {
		return formSelector;
	}

	public JmAjaxRequestBean setFormSelector(final String formSelector) {
		this.formSelector = formSelector;
		return this;
	}

}
