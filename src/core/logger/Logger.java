package core.logger;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import core.threading.Thread;

public class Logger extends Thread implements ILogger {
	public class Entry {
		private Date timemstamp = null;
		private ILogger.Severity severity = ILogger.Severity.Informal;
		private ILogger.Direction direction = ILogger.Direction.Internal;
		private String text = "";
		
		public Entry(String text) {
			this.timemstamp = new Date();
			this.text = text;
		}
		
		public Entry(String text, ILogger.Severity severity) {
			this(text);
			this.severity = severity;
		}
		
		public Entry(String text, ILogger.Direction direction) {
			this(text);
			this.direction = direction;
		}
		
		public Entry(String text, ILogger.Direction direction, ILogger.Severity severity) {
			this(text, direction);
			this.severity = severity;
		}
		
		public Date getTimenstamp() {
			return this.timemstamp;
		}
		
		public String getText() {
			return this.text;
		}
		
		public ILogger.Direction getDirection() {
			return this.direction;
		}
		
		public ILogger.Severity getSeverity() {
			return this.severity;
		}
		
		@Override
		public String toString() {
			return this.timemstamp.toString() + "\t" + this.direction.toString() + "\t" + this.severity.toString() + "\t" + this.text;
		}
	}
	
	protected static Logger instance = null;
	protected Queue<Entry> queue = null;
	protected final Object mutex = new Object();
	
	public static Logger getInstance() {
		if (null == instance) {
			instance = new Logger("Logger");
		}
		return instance;
	}
	
	protected Logger(String name) {
		super("Logger");
	}
	
	public void create(String[] arguments) {
		this.queue = new LinkedList<Entry>();
	}
	
	public void initialize(String[] arguments) {
	}
	
	public void startup(String[] arguments) {
		super.start();
	}
	
	public void shutdown(String[] arguments) {
	}
	
	protected void running() {
		while (true) {
			synchronized (this.mutex) {
				while (!this.queue.isEmpty()) {
					Logger.Entry entry = this.queue.poll();
					System.out.println(entry.toString());
				}
			}
			super.suspend(200);
		}
	}
	
	@Override
	public void write(String text) {
		synchronized (this.mutex) {
			Logger.Entry entry = new Logger.Entry(text);
			this.queue.add(entry);
		}
	}
	
	@Override
	public void write(String text, ILogger.Direction direction) {
		synchronized (this.mutex) {
			Logger.Entry entry = new Logger.Entry(text, direction);
			this.queue.add(entry);
		}
	}
	
	@Override
	public void write(String text, ILogger.Severity severity) {
		synchronized (this.mutex) {
			Logger.Entry entry = new Logger.Entry(text, severity);
			this.queue.add(entry);
		}
	}
	
	public void write(String text, ILogger.Direction direction, ILogger.Severity severity) {
		synchronized (this.mutex) {
			Logger.Entry entry = new Logger.Entry(text, direction, severity);
			this.queue.add(entry);
		}
	}
}
