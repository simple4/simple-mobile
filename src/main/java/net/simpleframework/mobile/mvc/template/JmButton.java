package net.simpleframework.mobile.mvc.template;

import net.simpleframework.common.StringUtils;

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
public class JmButton extends JmLink<JmButton> {

	/**
	 * @fields serialVersionUID
	 * @author shihb
	 * @update 2012-8-27 下午12:20:29
	 */

	private static final long serialVersionUID = 1L;

	private String icon;// 图标

	private String iconpos;// 导航图标方向

	private Boolean iconshadow;// 图标是否有圆角

	private String theme;// 样式

	private Boolean inline;// 是否内联的样式

	private Boolean shadow;// 按钮有阴影

	public JmButton(final String text, final String href) {
		super(text, href);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addattri(final StringBuilder sb) {
		// TODO Auto-generated method stub
		sb.append(" data-role=\"button\" ");
		super.addattri(sb);
		attri(sb, "icon").attri(sb, "iconpos").attri(sb, "iconshadow").attri(sb, "theme")
				.attri(sb, "inline").attri(sb, "shadow");
	}

	@Override
	protected JmButton attri(final StringBuilder sb, final String attri) {
		// TODO Auto-generated method stub
		if ("theme".equals(attri)) {
			final String theme = getTheme();
			if (StringUtils.hasText(theme)) {
				sb.append(" data-theme=\"").append(theme).append("\"");
			}
		} else if ("icon".equals(attri)) {
			final String icon = getIcon();
			if (StringUtils.hasText(icon)) {
				sb.append(" data-icon=\"").append(icon).append("\"");
			}
		} else if ("iconpos".equals(attri)) {
			final String iconpos = getIconpos();
			if (StringUtils.hasText(iconpos)) {
				sb.append(" data-iconpos=\"").append(iconpos).append("\"");
			}
		} else if ("iconshadow".equals(attri)) {
			final Boolean iconshadow = getIconshadow();
			if (iconshadow != null) {
				sb.append(" data-iconshadow=").append(iconshadow.booleanValue());
			}
		} else if ("inline".equals(attri)) {
			final Boolean inline = getInline();
			if (inline != null) {
				sb.append(" data-inline=").append(inline.booleanValue());
			}
		} else if ("shadow".equals(attri)) {
			final Boolean shadow = getShadow();
			if (shadow != null) {
				sb.append(" data-shadow=").append(shadow.booleanValue());
			}
		} else {
			super.attri(sb, attri);
		}

		return this;
	}

	public String getIcon() {
		return icon;
	}

	public JmButton setIcon(String icon) {
		if (icon != null && icon.indexOf("_") > -1) {
			icon = icon.replace("_", "-");
		}
		this.icon = icon;
		return this;
	}

	public String getIconpos() {
		return iconpos;
	}

	public JmButton setIconpos(final String iconpos) {
		this.iconpos = iconpos;
		return this;
	}

	public Boolean getIconshadow() {
		return iconshadow;
	}

	public JmButton setIconshadow(final Boolean iconshadow) {
		this.iconshadow = iconshadow;
		return this;
	}

	public String getTheme() {
		return theme;
	}

	public JmButton setTheme(final String theme) {
		this.theme = theme;
		return this;
	}

	public Boolean getInline() {
		return inline;
	}

	public JmButton setInline(final Boolean inline) {
		this.inline = inline;
		return this;
	}

	public Boolean getShadow() {
		return shadow;
	}

	public JmButton setShadow(final Boolean shadow) {
		this.shadow = shadow;
		return this;
	}

	/**
	 * 
	 * @description TODO(按钮图片类型)
	 * @version 4.0
	 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
	 *         http://code.google.com/p/simpleframework/
	 *         http://www.simpleframework.net
	 * @update 2012-8-27 下午2:56:19
	 */
	public static enum Icon {
		home, delete, plus, arrow_u, arrow_d, check, gear, grid, star, custom, arrow_r, arrow_l, minus, refresh, forward, back, alert, info, search

	}

	/**
	 * 
	 * @description TODO(导航图标)
	 * @version 4.0
	 * @author shihb(shihaibin.sea@gmail.com, 13466609192)
	 *         http://code.google.com/p/simpleframework/
	 *         http://www.simpleframework.net
	 * @update 2012-8-27 下午4:13:00
	 */
	public static enum Iconpos {
		left, right, top, bottom, notext
	}

}
