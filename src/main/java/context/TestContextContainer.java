package context;

import static java.util.Optional.ofNullable;

public final class TestContextContainer {

	private static final ThreadLocal<Context> CONTEXT_PER_THREAD = new ThreadLocal<>();

	private TestContextContainer() {
	}

	public static Context get() {
		return CONTEXT_PER_THREAD.get();
	}

	public static void set(Context context) {
		ofNullable(context).ifPresent(ctx -> CONTEXT_PER_THREAD.set(context));

	}

	public static void remove() {
		CONTEXT_PER_THREAD.remove();
	}
}
