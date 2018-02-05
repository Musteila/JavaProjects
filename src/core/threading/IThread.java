package core.threading;
import core.patterns.IFactoryComponent;

public interface IThread extends IFactoryComponent {
	public String getName();
	public Integer getIdentifier();
	public void start();
	public void stop();
	public void suspend();
	public void resume();
}
