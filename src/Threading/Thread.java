package Threading;

public abstract class Thread extends java.lang.Thread implements IThread {
	private Integer identifier;
	
	public Thread(String name) {
		super(name);
	}

	@Override
	public abstract void create(String[] arguments);
	
	@Override
	public abstract void initialize(String[] arguments);
	
	@Override
	public abstract void startup(String[] arguments);
	
	@Override
	public abstract void shutdown(String[] arguments);
	
	@Override
	public Integer getIdentifier() {
		return this.identifier;
	}
	
	@Override
	public void start() {}
}
