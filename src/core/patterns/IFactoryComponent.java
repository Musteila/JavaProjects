package core.patterns;

public interface IFactoryComponent {
	public void create(String[] arguments);
	public void initialize(String[] arguments);
	public void startup(String[] arguments);
	public void shutdown(String[] arguments);
}
