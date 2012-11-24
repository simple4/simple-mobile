package net.simpleframework.mobile.mvc.template;

public class JmPasswordInput extends JmTextInput<JmPasswordInput> {
	private static final long serialVersionUID = 1L;

	public JmPasswordInput(final String name) {
		super(Type.password, name, null);
	}

	public JmPasswordInput(final String name, final String label) {
		super(Type.password, name, label);
	}
}
