package core.threading;

public abstract class Thread extends java.lang.Thread implements IThread {
	private Integer identifier;
	
	public Thread(String name) {
		super(name);
	}

	@Override
	public void create(String[] arguments) {
	}
	
	@Override
	public void initialize(String[] arguments) {
	}
	
	@Override
	public void startup(String[] arguments) {
		super.start();
	}
	
	@Override
	public void shutdown(String[] arguments) {
	}
	
	@Override
	public Integer getIdentifier() {
		return this.identifier;
	}
	
	@Override
	public void run()
	{
		running();
	}
	
	protected abstract void running();
	
	protected void suspend(Integer milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
