package context;

public final class TestContext {

	private TestContext() {
	}

	public static Context get() {
		return (Context) TestContextContainer.get();
	}

	public static void set(Context context) {
		TestContextContainer.set(context);
	}

	public static void remove() {
		TestContextContainer.remove();
	}
}
