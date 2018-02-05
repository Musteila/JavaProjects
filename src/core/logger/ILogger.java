package core.logger;

public interface ILogger {

	public enum Severity {
		Undefined,
		Informal,
		Anomaly,
		RecoverableException,
		UnrecoverableException
	}
	
	public enum Direction {
		Internal,
		Out,
		In
	}
	
	public void write(String text);
	public void write(String text, ILogger.Direction direction);
	public void write(String text, ILogger.Severity severity);
	public void write(String text, ILogger.Direction direction, ILogger.Severity severity);
}
